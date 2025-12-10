package com.buzzzapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class LocationForegroundService extends Service {
  public static final String CHANNEL_ID = "location_channel";

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    createNotificationChannel();
    Notification notification = buildNotification();
    startForeground(1, notification);
    return START_STICKY;
  }

  private void createNotificationChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      NotificationChannel serviceChannel = new NotificationChannel(
          CHANNEL_ID,
          "Location Service",
          NotificationManager.IMPORTANCE_LOW);
      NotificationManager manager = getSystemService(NotificationManager.class);
      if (manager != null) {
        manager.createNotificationChannel(serviceChannel);
      }
    }
  }

  private Notification buildNotification() {
    Intent notificationIntent = new Intent(this, MainActivity.class);
    PendingIntent pendingIntent = PendingIntent.getActivity(
        this,
        0,
        notificationIntent,
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
            ? PendingIntent.FLAG_IMMUTABLE
            : 0);

    return new NotificationCompat.Builder(this, CHANNEL_ID)
        .setContentTitle("BuzzzApp is using your location")
        .setContentText("Background location is active to keep your map updated.")
        .setSmallIcon(android.R.drawable.ic_menu_mylocation)
        .setContentIntent(pendingIntent)
        .build();
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }
}
