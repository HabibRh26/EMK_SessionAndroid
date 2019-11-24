package demo.test.emk_session;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Intent intent1 = new Intent(Notification.this, MainActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // FLAG_ACTIVITY_CLEAR_TOP - removes others activities from stack

       if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel =
                    new NotificationChannel("myLoNotifications","ownLoNotifications", NotificationManager.IMPORTANCE_DEFAULT);
            // same channel id used in compatBuilder
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent1,
                PendingIntent.FLAG_ONE_SHOT);
       // FLAG_ONE_SHOT - Flag indicating that if the described PendingIntent already exists,
        // the current one should be canceled before generating a new one

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,"myLoNotifications")
                // any name you prefer as channel id(string)

                .setContentTitle("Notification Title")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText("Testing message")
                .setAutoCancel(true) // dismiss the notification after click
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

      /*  NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); */

        // for android oreo and afterwards-Noti manager,notificompat is for others
        NotificationManagerCompat noti_ManagerCompat = NotificationManagerCompat.from(this);
        noti_ManagerCompat.notify(0 /* ID of Notification */, notificationBuilder.build());
        // noti id can be used anything for unique identification
    }
}
