package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public class zzw extends zzaa {
    /* access modifiers changed from: private */
    public static final AtomicLong amf = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */
    public zzd alW;
    /* access modifiers changed from: private */
    public zzd alX;
    private final PriorityBlockingQueue<FutureTask<?>> alY = new PriorityBlockingQueue<>();
    private final BlockingQueue<FutureTask<?>> alZ = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler ama = new zzb("Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler amb = new zzb("Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object amc = new Object();
    /* access modifiers changed from: private */
    public final Semaphore amd = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean ame;

    static class zza extends RuntimeException {
    }

    private final class zzb implements UncaughtExceptionHandler {
        private final String amg;

        public zzb(String str) {
            zzab.zzaa(str);
            this.amg = str;
        }

        public synchronized void uncaughtException(Thread thread, Throwable th) {
            zzw.this.zzbsz().zzbtr().zzj(this.amg, th);
        }
    }

    private final class zzc<V> extends FutureTask<V> implements Comparable<zzc> {
        private final String amg;
        private final long ami = zzw.amf.getAndIncrement();
        private final boolean amj;

        zzc(Runnable runnable, boolean z, String str) {
            super(runnable, null);
            zzab.zzaa(str);
            this.amg = str;
            this.amj = z;
            if (this.ami == Long.MAX_VALUE) {
                zzw.this.zzbsz().zzbtr().log("Tasks index overflow");
            }
        }

        zzc(Callable<V> callable, boolean z, String str) {
            super(callable);
            zzab.zzaa(str);
            this.amg = str;
            this.amj = z;
            if (this.ami == Long.MAX_VALUE) {
                zzw.this.zzbsz().zzbtr().log("Tasks index overflow");
            }
        }

        /* access modifiers changed from: protected */
        public void setException(Throwable th) {
            zzw.this.zzbsz().zzbtr().zzj(this.amg, th);
            if (th instanceof zza) {
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
            }
            super.setException(th);
        }

        /* renamed from: zzb */
        public int compareTo(zzc zzc) {
            if (this.amj != zzc.amj) {
                return this.amj ? -1 : 1;
            }
            if (this.ami < zzc.ami) {
                return -1;
            }
            if (this.ami > zzc.ami) {
                return 1;
            }
            zzw.this.zzbsz().zzbts().zzj("Two tasks share the same index. index", Long.valueOf(this.ami));
            return 0;
        }
    }

    private final class zzd extends Thread {
        private final Object amk = new Object();
        private final BlockingQueue<FutureTask<?>> aml;

        public zzd(String str, BlockingQueue<FutureTask<?>> blockingQueue) {
            zzab.zzaa(str);
            zzab.zzaa(blockingQueue);
            this.aml = blockingQueue;
            setName(str);
        }

        private void zza(InterruptedException interruptedException) {
            zzw.this.zzbsz().zzbtt().zzj(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0078, code lost:
            r1 = com.google.android.gms.measurement.internal.zzw.zzc(r4.amh);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x007e, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            com.google.android.gms.measurement.internal.zzw.zza(r4.amh).release();
            com.google.android.gms.measurement.internal.zzw.zzc(r4.amh).notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0097, code lost:
            if (r4 != com.google.android.gms.measurement.internal.zzw.zzd(r4.amh)) goto L_0x00a9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0099, code lost:
            com.google.android.gms.measurement.internal.zzw.zza(r4.amh, null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x009f, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a0, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00af, code lost:
            if (r4 != com.google.android.gms.measurement.internal.zzw.zze(r4.amh)) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b1, code lost:
            com.google.android.gms.measurement.internal.zzw.zzb(r4.amh, null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            r4.amh.zzbsz().zzbtr().log("Current scheduler thread is neither worker nor network");
         */
        public void run() {
            boolean z = false;
            while (!z) {
                try {
                    zzw.this.amd.acquire();
                    z = true;
                } catch (InterruptedException e) {
                    zza(e);
                }
            }
            while (true) {
                try {
                    FutureTask futureTask = (FutureTask) this.aml.poll();
                    if (futureTask != null) {
                        futureTask.run();
                    } else {
                        synchronized (this.amk) {
                            if (this.aml.peek() == null && !zzw.this.ame) {
                                try {
                                    this.amk.wait(30000);
                                } catch (InterruptedException e2) {
                                    zza(e2);
                                }
                            }
                        }
                        synchronized (zzw.this.amc) {
                            if (this.aml.peek() == null) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    synchronized (zzw.this.amc) {
                        zzw.this.amd.release();
                        zzw.this.amc.notifyAll();
                        if (this == zzw.this.alW) {
                            zzw.this.alW = null;
                        } else if (this == zzw.this.alX) {
                            zzw.this.alX = null;
                        } else {
                            zzw.this.zzbsz().zzbtr().log("Current scheduler thread is neither worker nor network");
                        }
                        throw th;
                    }
                }
            }
        }

        public void zznm() {
            synchronized (this.amk) {
                this.amk.notifyAll();
            }
        }
    }

    zzw(zzx zzx) {
        super(zzx);
    }

    private void zza(zzc<?> zzc2) {
        synchronized (this.amc) {
            this.alY.add(zzc2);
            if (this.alW == null) {
                this.alW = new zzd("Measurement Worker", this.alY);
                this.alW.setUncaughtExceptionHandler(this.ama);
                this.alW.start();
            } else {
                this.alW.zznm();
            }
        }
    }

    private void zza(FutureTask<?> futureTask) {
        synchronized (this.amc) {
            this.alZ.add(futureTask);
            if (this.alX == null) {
                this.alX = new zzd("Measurement Network", this.alZ);
                this.alX.setUncaughtExceptionHandler(this.amb);
                this.alX.start();
            } else {
                this.alX.zznm();
            }
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void zzbso() {
        if (Thread.currentThread() != this.alX) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public /* bridge */ /* synthetic */ zzc zzbsp() {
        return super.zzbsp();
    }

    public /* bridge */ /* synthetic */ zzac zzbsq() {
        return super.zzbsq();
    }

    public /* bridge */ /* synthetic */ zzn zzbsr() {
        return super.zzbsr();
    }

    public /* bridge */ /* synthetic */ zzg zzbss() {
        return super.zzbss();
    }

    public /* bridge */ /* synthetic */ zzad zzbst() {
        return super.zzbst();
    }

    public /* bridge */ /* synthetic */ zze zzbsu() {
        return super.zzbsu();
    }

    public /* bridge */ /* synthetic */ zzal zzbsv() {
        return super.zzbsv();
    }

    public /* bridge */ /* synthetic */ zzv zzbsw() {
        return super.zzbsw();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsx() {
        return super.zzbsx();
    }

    public /* bridge */ /* synthetic */ zzw zzbsy() {
        return super.zzbsy();
    }

    public /* bridge */ /* synthetic */ zzp zzbsz() {
        return super.zzbsz();
    }

    public /* bridge */ /* synthetic */ zzt zzbta() {
        return super.zzbta();
    }

    public /* bridge */ /* synthetic */ zzd zzbtb() {
        return super.zzbtb();
    }

    public <V> Future<V> zzd(Callable<V> callable) throws IllegalStateException {
        zzzg();
        zzab.zzaa(callable);
        zzc zzc2 = new zzc(callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.alW) {
            zzc2.run();
        } else {
            zza(zzc2);
        }
        return zzc2;
    }

    public <V> Future<V> zze(Callable<V> callable) throws IllegalStateException {
        zzzg();
        zzab.zzaa(callable);
        zzc zzc2 = new zzc(callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.alW) {
            zzc2.run();
        } else {
            zza(zzc2);
        }
        return zzc2;
    }

    public void zzl(Runnable runnable) throws IllegalStateException {
        zzzg();
        zzab.zzaa(runnable);
        zza(new zzc<>(runnable, false, "Task exception on worker thread"));
    }

    public void zzm(Runnable runnable) throws IllegalStateException {
        zzzg();
        zzab.zzaa(runnable);
        zza((FutureTask<?>) new zzc<Object>(runnable, false, "Task exception on network thread"));
    }

    public void zzwu() {
        if (Thread.currentThread() != this.alW) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* access modifiers changed from: protected */
    public void zzwv() {
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
