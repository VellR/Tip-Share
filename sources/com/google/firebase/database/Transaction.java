package com.google.firebase.database;

import com.google.android.gms.internal.zzakm;

public class Transaction {

    public interface Handler {
        Result doTransaction(MutableData mutableData);

        void onComplete(DatabaseError databaseError, boolean z, DataSnapshot dataSnapshot);
    }

    public static class Result {
        private boolean aPJ;
        private zzakm aPK;

        private Result(boolean z, zzakm zzakm) {
            this.aPJ = z;
            this.aPK = zzakm;
        }

        public boolean isSuccess() {
            return this.aPJ;
        }

        public zzakm zzcmq() {
            return this.aPK;
        }
    }

    public static Result abort() {
        return new Result(false, null);
    }

    public static Result success(MutableData mutableData) {
        return new Result(true, mutableData.zzcmq());
    }
}
