package xyz.flyingkiwi.todo;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

public class EventViewModel extends AndroidViewModel{

    private WorkManager workManager;

    public EventViewModel(@NonNull Application application)
    {
        super(application);
        workManager = WorkManager.getInstance(application);
    }

    public void eventSchedule() {
        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(EventWorker.class, 15, TimeUnit.MINUTES)
                                                     .build();
        workManager.getInstance(getApplication().getApplicationContext()).enqueue(periodicWorkRequest);
    }

}
