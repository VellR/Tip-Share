package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzalr;
import com.google.android.gms.internal.zzals;
import com.google.android.gms.internal.zzalt;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class FirebaseApp {
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    private static final List<String> aML = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> aMM = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> aMN = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final Set<String> aMO = Collections.emptySet();
    static final Map<String, FirebaseApp> abO = new ArrayMap();
    private static final Object zzamp = new Object();
    private final FirebaseOptions aMP;
    private final AtomicBoolean aMQ = new AtomicBoolean(true);
    private final AtomicBoolean aMR = new AtomicBoolean();
    private final List<zza> aMS = new CopyOnWriteArrayList();
    private final List<zzb> aMT = new CopyOnWriteArrayList();
    private final List<Object> aMU = new CopyOnWriteArrayList();
    protected zzalt aMV;
    private final String mName;
    private final Context zzaqj;

    public interface zza {
        void zzb(@NonNull zzalt zzalt, @Nullable FirebaseUser firebaseUser);
    }

    public interface zzb {
        void zzck(boolean z);
    }

    protected FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.zzaqj = (Context) zzab.zzaa(context);
        this.mName = zzab.zzhs(str);
        this.aMP = (FirebaseOptions) zzab.zzaa(firebaseOptions);
    }

    public static List<FirebaseApp> getApps(Context context) {
        return new ArrayList(abO.values());
    }

    @Nullable
    public static FirebaseApp getInstance() {
        return getInstance(DEFAULT_APP_NAME);
    }

    public static FirebaseApp getInstance(@NonNull String str) {
        FirebaseApp firebaseApp;
        String str2;
        synchronized (zzamp) {
            firebaseApp = (FirebaseApp) abO.get(zzqk(str));
            if (firebaseApp == null) {
                List zzckd = zzckd();
                if (zzckd.isEmpty()) {
                    str2 = "";
                } else {
                    String str3 = "Available app names: ";
                    String valueOf = String.valueOf(zzy.zzhr(", ").zza(zzckd));
                    str2 = valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        zzals zzen = zzals.zzen(context);
        zzei(context);
        String zzqk = zzqk(str);
        Context applicationContext = context.getApplicationContext();
        synchronized (zzamp) {
            zzab.zza(!abO.containsKey(zzqk), (Object) new StringBuilder(String.valueOf(zzqk).length() + 33).append("FirebaseApp name ").append(zzqk).append(" already exists!").toString());
            zzab.zzb(applicationContext, (Object) "Application context cannot be null.");
            firebaseApp = new FirebaseApp(applicationContext, zzqk, firebaseOptions);
            abO.put(zzqk, firebaseApp);
        }
        zzen.zzf(firebaseApp);
        zza(FirebaseApp.class, firebaseApp, aML);
        if (firebaseApp.zzckb()) {
            zza(FirebaseApp.class, firebaseApp, aMM);
            zza(Context.class, firebaseApp.getApplicationContext(), aMN);
        }
        return firebaseApp;
    }

    private static <T> void zza(Class<T> cls, T t, Iterable<String> iterable) {
        for (String str : iterable) {
            try {
                Method method = Class.forName(str).getMethod("getInstance", new Class[]{cls});
                int modifiers = method.getModifiers();
                if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                    method.invoke(null, new Object[]{t});
                }
            } catch (ClassNotFoundException e) {
                if (aMO.contains(str)) {
                    throw new IllegalStateException(String.valueOf(str).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                }
                Log.d("FirebaseApp", String.valueOf(str).concat(" is not linked. Skipping initialization."));
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException(String.valueOf(str).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
            } catch (InvocationTargetException e3) {
                Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
            } catch (IllegalAccessException e4) {
                String str2 = "FirebaseApp";
                String str3 = "Failed to initialize ";
                String valueOf = String.valueOf(str);
                Log.wtf(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), e4);
            }
        }
    }

    public static void zzck(boolean z) {
        synchronized (zzamp) {
            Iterator it = new ArrayList(abO.values()).iterator();
            while (it.hasNext()) {
                FirebaseApp firebaseApp = (FirebaseApp) it.next();
                if (firebaseApp.aMQ.get()) {
                    firebaseApp.zzcl(z);
                }
            }
        }
    }

    private void zzcka() {
        zzab.zza(!this.aMR.get(), (Object) "FirebaseApp was deleted");
    }

    private static List<String> zzckd() {
        com.google.android.gms.common.util.zza zza2 = new com.google.android.gms.common.util.zza();
        synchronized (zzamp) {
            for (FirebaseApp name : abO.values()) {
                zza2.add(name.getName());
            }
            zzals zzcxe = zzals.zzcxe();
            if (zzcxe != null) {
                zza2.addAll(zzcxe.zzcxf());
            }
        }
        ArrayList arrayList = new ArrayList(zza2);
        Collections.sort(arrayList);
        return arrayList;
    }

    private void zzcl(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (zzb zzck : this.aMT) {
            zzck.zzck(z);
        }
    }

    public static FirebaseApp zzeh(Context context) {
        FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
        if (fromResource == null) {
            return null;
        }
        return initializeApp(context, fromResource);
    }

    @TargetApi(14)
    private static void zzei(Context context) {
        if (zzs.zzavm() && (context.getApplicationContext() instanceof Application)) {
            zzalr.zza((Application) context.getApplicationContext());
        }
    }

    private static String zzqk(@NonNull String str) {
        return str.trim();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.mName.equals(((FirebaseApp) obj).getName());
    }

    @NonNull
    public Context getApplicationContext() {
        zzcka();
        return this.zzaqj;
    }

    @NonNull
    public String getName() {
        zzcka();
        return this.mName;
    }

    @NonNull
    public FirebaseOptions getOptions() {
        zzcka();
        return this.aMP;
    }

    public Task<GetTokenResult> getToken(boolean z) {
        zzcka();
        return this.aMV == null ? Tasks.forException(new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.")) : this.aMV.zza(this.aMV.getCurrentUser(), z);
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public String toString() {
        return zzaa.zzz(this).zzg("name", this.mName).zzg("options", this.aMP).toString();
    }

    public void zza(@NonNull zzalt zzalt) {
        this.aMV = (zzalt) zzab.zzaa(zzalt);
    }

    @UiThread
    public void zza(zzalt zzalt, FirebaseUser firebaseUser) {
        Log.d("FirebaseApp", "Notifying auth state listeners.");
        int i = 0;
        for (zza zzb2 : this.aMS) {
            zzb2.zzb(zzalt, firebaseUser);
            i++;
        }
        Log.d("FirebaseApp", String.format("Notified %d auth state listeners.", new Object[]{Integer.valueOf(i)}));
    }

    public void zza(@NonNull zza zza2) {
        zzcka();
        zzab.zzaa(zza2);
        this.aMS.add(zza2);
    }

    public zzalt zzcjz() {
        zzcka();
        return this.aMV;
    }

    public boolean zzckb() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    public String zzckc() {
        String valueOf = String.valueOf(zzc.zzr(getName().getBytes()));
        String valueOf2 = String.valueOf(zzc.zzr(getOptions().getApplicationId().getBytes()));
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("+").append(valueOf2).toString();
    }
}
