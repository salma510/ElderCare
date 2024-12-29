package salma.elbahlouli.elderhealthappmobile.model;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MedicineNotificationWorker extends Worker {
    private static final String CHANNEL_ID = "MEDICINE_NOTIFICATIONS";
    private static final String CHANNEL_NAME = "Rappels de médicaments";

    public MedicineNotificationWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        String medicineName = getInputData().getString("medicine_name");
        String dosage = getInputData().getString("dosage");

        createNotificationChannel();
        showNotification(medicineName, dosage);

        return Result.success();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("Canal pour les rappels de médicaments");

            NotificationManager notificationManager = getApplicationContext()
                    .getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void showNotification(String medicineName, String dosage) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Rappel de médicament")
                .setContentText("C'est l'heure de prendre " + medicineName + " (" + dosage + ")")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager)
                getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(medicineName.hashCode(), builder.build());
    }
}
