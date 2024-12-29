package salma.elbahlouli.elderhealthappmobile.model;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

import salma.elbahlouli.elderhealthappmobile.HomeActivity;
import salma.elbahlouli.elderhealthappmobile.R;

public class NotificationReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID = "medicine_reminder_channel";
    private static final String CHANNEL_NAME = "Medicine Reminders";

    @Override
    public void onReceive(Context context, Intent intent) {
        String medicineName = intent.getStringExtra("medicine_name");
        showNotification(context, medicineName);
    }

    private void showNotification(Context context, String medicineName) {
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Create notification channel for Android 8.0+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("Reminders for taking medicine");
            channel.enableVibration(true);
            notificationManager.createNotificationChannel(channel);
        }

        // Create intent for when notification is tapped
        Intent tapIntent = new Intent(context, HomeActivity.class);
        tapIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                0,
                tapIntent,
                PendingIntent.FLAG_IMMUTABLE
        );

        // Build notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.soleil)
                .setContentTitle("Time for Your Medicine")
                .setContentText("It's time to take " + medicineName)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setContentIntent(pendingIntent);

        // Show notification
        notificationManager.notify(medicineName.hashCode(), builder.build());


    }
}