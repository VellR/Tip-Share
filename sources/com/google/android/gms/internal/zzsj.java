package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.zzc;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.lang.reflect.Field;

public final class zzsj {
    private static zzsk Me;
    private static final zza Mf = new zza() {
        public int zzd(Context context, String str, boolean z) {
            return zzsj.zzd(context, str, z);
        }

        public int zzt(Context context, String str) {
            return zzsj.zzt(context, str);
        }
    };
    public static final zzb Mg = new zzb() {
        public C0044zzb zza(Context context, String str, zza zza) {
            C0044zzb zzb = new C0044zzb();
            zzb.Mo = zza.zzd(context, str, true);
            if (zzb.Mo != 0) {
                zzb.Mp = 1;
            } else {
                zzb.Mn = zza.zzt(context, str);
                if (zzb.Mn != 0) {
                    zzb.Mp = -1;
                }
            }
            return zzb;
        }
    };
    public static final zzb Mh = new zzb() {
        public C0044zzb zza(Context context, String str, zza zza) {
            C0044zzb zzb = new C0044zzb();
            zzb.Mn = zza.zzt(context, str);
            if (zzb.Mn != 0) {
                zzb.Mp = -1;
            } else {
                zzb.Mo = zza.zzd(context, str, true);
                if (zzb.Mo != 0) {
                    zzb.Mp = 1;
                }
            }
            return zzb;
        }
    };
    public static final zzb Mi = new zzb() {
        public C0044zzb zza(Context context, String str, zza zza) {
            C0044zzb zzb = new C0044zzb();
            zzb.Mn = zza.zzt(context, str);
            zzb.Mo = zza.zzd(context, str, true);
            if (zzb.Mn == 0 && zzb.Mo == 0) {
                zzb.Mp = 0;
            } else if (zzb.Mn >= zzb.Mo) {
                zzb.Mp = -1;
            } else {
                zzb.Mp = 1;
            }
            return zzb;
        }
    };
    public static final zzb Mj = new zzb() {
        public C0044zzb zza(Context context, String str, zza zza) {
            C0044zzb zzb = new C0044zzb();
            zzb.Mn = zza.zzt(context, str);
            zzb.Mo = zza.zzd(context, str, true);
            if (zzb.Mn == 0 && zzb.Mo == 0) {
                zzb.Mp = 0;
            } else if (zzb.Mo >= zzb.Mn) {
                zzb.Mp = 1;
            } else {
                zzb.Mp = -1;
            }
            return zzb;
        }
    };
    public static final zzb Mk = new zzb() {
        public C0044zzb zza(Context context, String str, zza zza) {
            C0044zzb zzb = new C0044zzb();
            zzb.Mn = zza.zzt(context, str);
            if (zzb.Mn != 0) {
                zzb.Mo = zza.zzd(context, str, false);
            } else {
                zzb.Mo = zza.zzd(context, str, true);
            }
            if (zzb.Mn == 0 && zzb.Mo == 0) {
                zzb.Mp = 0;
            } else if (zzb.Mo >= zzb.Mn) {
                zzb.Mp = 1;
            } else {
                zzb.Mp = -1;
            }
            return zzb;
        }
    };
    private final Context Ml;

    public static class zza extends Exception {
        private zza(String str) {
            super(str);
        }

        private zza(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface zzb {

        public interface zza {
            int zzd(Context context, String str, boolean z);

            int zzt(Context context, String str);
        }

        /* renamed from: com.google.android.gms.internal.zzsj$zzb$zzb reason: collision with other inner class name */
        public static class C0044zzb {
            public int Mn = 0;
            public int Mo = 0;
            public int Mp = 0;
        }

        C0044zzb zza(Context context, String str, zza zza2);
    }

    private zzsj(Context context) {
        this.Ml = (Context) zzab.zzaa(context);
    }

    public static zzsj zza(Context context, zzb zzb2, String str) throws zza {
        C0044zzb zza2 = zzb2.zza(context, str, Mf);
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(zza2.Mn).append(" and remote module ").append(str).append(":").append(zza2.Mo).toString());
        if (zza2.Mp == 0 || ((zza2.Mp == -1 && zza2.Mn == 0) || (zza2.Mp == 1 && zza2.Mo == 0))) {
            throw new zza("No acceptable module found. Local version is " + zza2.Mn + " and remote version is " + zza2.Mo + ".");
        } else if (zza2.Mp == -1) {
            return zzv(context, str);
        } else {
            if (zza2.Mp == 1) {
                try {
                    return zza(context, str, zza2.Mo);
                } catch (zza e) {
                    zza zza3 = e;
                    String str2 = "DynamiteModule";
                    String str3 = "Failed to load remote module: ";
                    String valueOf = String.valueOf(zza3.getMessage());
                    Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    if (zza2.Mn != 0) {
                        final int i = zza2.Mn;
                        if (zzb2.zza(context, str, new zza() {
                            public int zzd(Context context, String str, boolean z) {
                                return 0;
                            }

                            public int zzt(Context context, String str) {
                                return i;
                            }
                        }).Mp == -1) {
                            return zzv(context, str);
                        }
                    }
                    throw new zza("Remote load failed. No local fallback found.", zza3);
                }
            } else {
                throw new zza("VersionPolicy returned invalid code:" + zza2.Mp);
            }
        }
    }

    private static zzsj zza(Context context, String str, int i) throws zza {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        zzsk zzcs = zzcs(context);
        if (zzcs == null) {
            throw new zza("Failed to create IDynamiteLoader.");
        }
        try {
            zzd zza2 = zzcs.zza(zze.zzae(context), str, i);
            if (zze.zzad(zza2) != null) {
                return new zzsj((Context) zze.zzad(zza2));
            }
            throw new zza("Failed to load remote module.");
        } catch (RemoteException e) {
            throw new zza("Failed to load remote module.", e);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    private static zzsk zzcs(Context context) {
        synchronized (zzsj.class) {
            if (Me != null) {
                zzsk zzsk = Me;
                return zzsk;
            } else if (zzc.zzand().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    zzsk zzfd = com.google.android.gms.internal.zzsk.zza.zzfd((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (zzfd != null) {
                        Me = zzfd;
                        return zzfd;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    return null;
                }
            }
        }
    }

    public static int zzd(Context context, String str, boolean z) {
        zzsk zzcs = zzcs(context);
        if (zzcs == null) {
            return 0;
        }
        try {
            return zzcs.zza(zze.zzae(context), str, z);
        } catch (RemoteException e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return 0;
        }
    }

    public static int zzt(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            String valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            String valueOf2 = String.valueOf("ModuleDescriptor");
            Class loadClass = classLoader.loadClass(new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length() + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(".").append(valueOf2).toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            String valueOf3 = String.valueOf(declaredField.get(null));
            Log.e("DynamiteModule", new StringBuilder(String.valueOf(valueOf3).length() + 51 + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf3).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to load module descriptor class: ";
            String valueOf4 = String.valueOf(e2.getMessage());
            Log.e(str2, valueOf4.length() != 0 ? str3.concat(valueOf4) : new String(str3));
            return 0;
        }
    }

    public static int zzu(Context context, String str) {
        return zzd(context, str, false);
    }

    private static zzsj zzv(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        String valueOf = String.valueOf(str);
        Log.i(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        return new zzsj(context.getApplicationContext());
    }

    public Context zzbcw() {
        return this.Ml;
    }

    public IBinder zziv(String str) throws zza {
        try {
            return (IBinder) this.Ml.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String str2 = "Failed to instantiate module class: ";
            String valueOf = String.valueOf(str);
            throw new zza(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
        }
    }
}
