package salma.elbahlouli.elderhealthappmobile.model;

import android.content.Context;
import androidx.work.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class NotificationScheduler {
    public static void scheduleMedicineNotification(Context context, Medicine medicine) {
        // Parser l'heure du médicament
        LocalTime medicineTime = LocalTime.parse(medicine.getHeure(), DateTimeFormatter.ofPattern("HH:mm"));
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime scheduleTime = now.with(medicineTime);

        // Si l'heure est déjà passée aujourd'hui, programmer pour demain
        if (now.toLocalTime().isAfter(medicineTime)) {
            scheduleTime = scheduleTime.plusDays(1);
        }

        // Préparer les données pour le Worker
        Data inputData = new Data.Builder()
                .putString("medicine_name", medicine.getNom())
                .putString("dosage", medicine.getDosage())
                .build();

        // Créer la requête de travail périodique
        PeriodicWorkRequest notificationWork = new PeriodicWorkRequest.Builder(
                MedicineNotificationWorker.class,
                24, TimeUnit.HOURS)
                .setInputData(inputData)
                .setInitialDelay(
                        java.time.Duration.between(now, scheduleTime).toMillis(),
                        TimeUnit.MILLISECONDS)
                .build();

        // Programmer le travail
        WorkManager.getInstance(context)
                .enqueueUniquePeriodicWork(
                        "medicine_" + medicine.getId(),
                        ExistingPeriodicWorkPolicy.REPLACE,
                        notificationWork
                );
    }
}