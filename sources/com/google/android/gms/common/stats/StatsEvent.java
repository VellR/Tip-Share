package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent extends AbstractSafeParcelable {
    public abstract int getEventType();

    public abstract long getTimeMillis();

    public String toString() {
        long timeMillis = getTimeMillis();
        String valueOf = String.valueOf("\t");
        int eventType = getEventType();
        String valueOf2 = String.valueOf("\t");
        long zzaup = zzaup();
        String valueOf3 = String.valueOf(zzaus());
        return new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append(timeMillis).append(valueOf).append(eventType).append(valueOf2).append(zzaup).append(valueOf3).toString();
    }

    public abstract long zzaup();

    public abstract String zzaus();
}
