package demo.tang.tony.usecase;

import io.reactivex.Scheduler;

public interface UIThread {
    public Scheduler getScheduler();
}
