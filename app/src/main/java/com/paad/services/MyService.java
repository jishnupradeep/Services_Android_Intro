package com.paad.services;

/**
 * Listing 9-1: A skeleton Service class
 */
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class MyService extends Service {
    String msg = "Android : ";
    int count1=0;
    int count2=0;
    int count3=0;


  @Override
  public void onCreate() {
    count1=count1+1;
      Log.i(msg,"OnCreate: "+count1);


  }

  @Override
  public IBinder onBind(Intent intent) {
    // TODO: Replace with service binding implementation.
    return null;
  }


  /**
   * Listing 9-3: Overriding Service restart behavior
   */
  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    startBackgroundTask(intent, startId);
      count2=count2+1;
      Log.d(msg,"onStartCommand: "+count2);
      return Service.START_NOT_STICKY;



  }
  
  private void  startBackgroundTask(Intent intent, int startId) {
    // Start a background thread and begin the processing.
    backgroundExecution();
  }
  
  /**
   * Listing 9-14: Moving processing to a background Thread
   */
  //This method is called on the main GUI thread.
  private void backgroundExecution() {
   // This moves the time consuming operation to a child thread.
   Thread thread = new Thread(null, doBackgroundThreadProcessing,
                              "Background");
   thread.start();
  }
  
  //Runnable that executes the background processing method.
  private Runnable doBackgroundThreadProcessing = new Runnable() {
   public void run() {
     backgroundThreadProcessing();
   }
  };
  
  //Method which does some processing in the background.
  private void backgroundThreadProcessing() {
   // [ ... Time consuming operations ... ]
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
      count3=count3+1;
      Log.d(msg,"onDestroy: "+count3);


  }
}