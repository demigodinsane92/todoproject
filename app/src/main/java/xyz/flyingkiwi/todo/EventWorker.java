package xyz.flyingkiwi.todo;


import android.app.NotificationManager;
import android.content.Context;

import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import static androidx.core.content.ContextCompat.getSystemService;

public class EventWorker extends Worker {

    private String CHANNEL_ID = "wtfIsChannelId";
    private Context mContext;


    public EventWorker(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
        this.mContext = context;
    }

    @Override
    public Result doWork() {
        // Do the work here--in this case, upload the images.
//        MainActivity activity = new MainActivity();
//        activity.triggerNotification();

        NotificationCompat.Builder notificationCompat = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                                                                            .setSmallIcon(R.mipmap.refresh)
                                                                            .setContentTitle("Seven Nation Army")
                                                                            .setContentText("We couldn't hold you back"+ Calendar.getInstance().getTime())
                                                                            .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManager notificationManager = (NotificationManager) mContext.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notificationCompat.build());

//        uploadImages();

        // Indicate whether the task finished successfully with the Result
        return Result.success();
    }



}
