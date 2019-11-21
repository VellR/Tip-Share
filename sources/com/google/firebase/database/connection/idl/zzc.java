package com.google.firebase.database.connection.idl;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzagv;
import com.google.android.gms.internal.zzagy;
import com.google.android.gms.internal.zzagz;
import com.google.android.gms.internal.zzagz.zza;
import com.google.android.gms.internal.zzahc;
import java.util.List;
import java.util.Map;

public class zzc implements zzagz {
    private final zzh aSw;

    private zzc(zzh zzh) {
        this.aSw = zzh;
    }

    public static zzc zza(Context context, ConnectionConfig connectionConfig, zzagv zzagv, zza zza) {
        return new zzc(IPersistentConnectionImpl.loadDynamic(context, connectionConfig, zzagv.zzcob(), zzagv.zzcoc(), zza));
    }

    private static zzj zza(final zzahc zzahc) {
        return new zzj.zza() {
            public void zzbm(String str, String str2) throws RemoteException {
                zzahc.this.zzbm(str, str2);
            }
        };
    }

    public void initialize() {
        try {
            this.aSw.initialize();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void interrupt(String str) {
        try {
            this.aSw.interrupt(str);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isInterrupted(String str) {
        try {
            return this.aSw.isInterrupted(str);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void purgeOutstandingWrites() {
        try {
            this.aSw.purgeOutstandingWrites();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void refreshAuthToken() {
        try {
            this.aSw.refreshAuthToken();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void resume(String str) {
        try {
            this.aSw.resume(str);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void shutdown() {
        try {
            this.aSw.shutdown();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(List<String> list, zzahc zzahc) {
        try {
            this.aSw.onDisconnectCancel(list, zza(zzahc));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(List<String> list, Object obj, zzahc zzahc) {
        try {
            this.aSw.put(list, zze.zzae(obj), zza(zzahc));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(List<String> list, Object obj, String str, zzahc zzahc) {
        try {
            this.aSw.compareAndPut(list, zze.zzae(obj), str, zza(zzahc));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(List<String> list, Map<String, Object> map) {
        try {
            this.aSw.unlisten(list, zze.zzae(map));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(List<String> list, Map<String, Object> map, final zzagy zzagy, Long l, zzahc zzahc) {
        long j;
        AnonymousClass1 r3 = new zzg.zza() {
            public String zzcof() {
                return zzagy.zzcof();
            }

            public boolean zzcog() {
                return zzagy.zzcog();
            }

            public CompoundHashParcelable zzcpn() {
                return CompoundHashParcelable.zza(zzagy.zzcoh());
            }
        };
        if (l != null) {
            try {
                j = l.longValue();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        } else {
            j = -1;
        }
        this.aSw.listen(list, zze.zzae(map), r3, j, zza(zzahc));
    }

    public void zza(List<String> list, Map<String, Object> map, zzahc zzahc) {
        try {
            this.aSw.merge(list, zze.zzae(map), zza(zzahc));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void zzb(List<String> list, Object obj, zzahc zzahc) {
        try {
            this.aSw.onDisconnectPut(list, zze.zzae(obj), zza(zzahc));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void zzb(List<String> list, Map<String, Object> map, zzahc zzahc) {
        try {
            this.aSw.onDisconnectMerge(list, zze.zzae(map), zza(zzahc));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void zzra(String str) {
        try {
            this.aSw.refreshAuthToken2(str);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
