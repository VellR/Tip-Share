package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.zzc;
import java.util.Iterator;

public class zzpw extends zzps {
    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.common.util.zza, com.google.android.gms.internal.zzqh] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0, types: [com.google.android.gms.common.util.zza, com.google.android.gms.internal.zzqh]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
  uses: [com.google.android.gms.common.util.zza, com.google.android.gms.internal.zzqh]
  mth insns count: 11
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void onStop() {
        ? r2 = 0;
        super.onStop();
        Iterator it = r2.iterator();
        while (it.hasNext()) {
            ((zzc) it.next()).release();
        }
        r2.clear();
        r2.zza(this);
    }

    /* access modifiers changed from: protected */
    public void zza(ConnectionResult connectionResult, int i) {
        zzqh zzqh = null;
        zzqh.zza(connectionResult, i);
    }

    /* access modifiers changed from: protected */
    public void zzaol() {
        zzqh zzqh = null;
        zzqh.zzaol();
    }
}
