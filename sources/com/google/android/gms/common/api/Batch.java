package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.internal.zzpt;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zzpt<BatchResult> {
    /* access modifiers changed from: private */
    public final PendingResult<?>[] rA;
    /* access modifiers changed from: private */
    public int rx;
    /* access modifiers changed from: private */
    public boolean ry;
    /* access modifiers changed from: private */
    public boolean rz;
    /* access modifiers changed from: private */
    public final Object zzail;

    public static final class Builder {
        private GoogleApiClient hb;
        private List<PendingResult<?>> rC = new ArrayList();

        public Builder(GoogleApiClient googleApiClient) {
            this.hb = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.rC.size());
            this.rC.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.rC, this.hb);
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzail = new Object();
        this.rx = list.size();
        this.rA = new PendingResult[this.rx];
        if (list.isEmpty()) {
            zzc(new BatchResult(Status.sg, this.rA));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                PendingResult<?> pendingResult = (PendingResult) list.get(i2);
                this.rA[i2] = pendingResult;
                pendingResult.zza(new zza() {
                    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
                        return;
                     */
                    public void zzv(Status status) {
                        synchronized (Batch.this.zzail) {
                            if (!Batch.this.isCanceled()) {
                                if (status.isCanceled()) {
                                    Batch.this.rz = true;
                                } else if (!status.isSuccess()) {
                                    Batch.this.ry = true;
                                }
                                Batch.this.rx = Batch.this.rx - 1;
                                if (Batch.this.rx == 0) {
                                    if (Batch.this.rz) {
                                        Batch.super.cancel();
                                    } else {
                                        Batch.this.zzc(new BatchResult(Batch.this.ry ? new Status(13) : Status.sg, Batch.this.rA));
                                    }
                                }
                            }
                        }
                    }
                });
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void cancel() {
        super.cancel();
        for (PendingResult<?> cancel : this.rA) {
            cancel.cancel();
        }
    }

    /* renamed from: createFailedResult */
    public BatchResult zzc(Status status) {
        return new BatchResult(status, this.rA);
    }
}
