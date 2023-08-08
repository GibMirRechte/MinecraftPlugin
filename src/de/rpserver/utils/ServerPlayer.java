package de.rpserver.utils;

import de.rpserver.handler.JobHandler;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ServerPlayer {

    private final UUID uuid;
    private long xp;
    private JobHandler.Jobs job;
    private long lastJobChange;

    public ServerPlayer(UUID uuid, long xp, JobHandler.Jobs job, long lastJobChange) {
        this.uuid = uuid;
        this.xp = xp;
        this.job = job;
        this.lastJobChange = lastJobChange;
    }

    public void changeJob(JobHandler.Jobs newJob) {
        this.lastJobChange = System.currentTimeMillis();
        this.job = newJob;
    }

    public void quitJob() {
        this.lastJobChange = System.currentTimeMillis();
        this.job = null;
    }

    public synchronized void addXP(long amount) {
        this.xp += amount;
    }

    public synchronized void setXP(long amount) {
        this.xp = amount;
    }

    public synchronized void removeXP(long amount) {
        if ((this.xp - amount) < 0) {
            this.xp = 0;
        } else {
            this.xp -= amount;
        }
    }

}
