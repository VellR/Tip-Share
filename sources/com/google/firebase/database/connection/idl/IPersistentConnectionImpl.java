package com.google.firebase.database.connection.idl;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.firebase_database.ModuleDescriptor;
import com.google.android.gms.internal.zzags;
import com.google.android.gms.internal.zzagu;
import com.google.android.gms.internal.zzagv;
import com.google.android.gms.internal.zzagy;
import com.google.android.gms.internal.zzagz;
import com.google.android.gms.internal.zzaha;
import com.google.android.gms.internal.zzahb;
import com.google.android.gms.internal.zzahc;
import com.google.android.gms.internal.zzajv;
import com.google.android.gms.internal.zzsj;
import com.google.firebase.database.connection.idl.zzh.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

@DynamiteApi
public class IPersistentConnectionImpl extends zza {
    private zzagz aSA;

    public static zzh loadDynamic(Context context, ConnectionConfig connectionConfig, zzagu zzagu, ScheduledExecutorService scheduledExecutorService, zzagz.zza zza) {
        try {
            zzh asInterface = zza.asInterface(zzsj.zza(context, zzsj.Mj, ModuleDescriptor.MODULE_ID).zziv("com.google.firebase.database.connection.idl.IPersistentConnectionImpl"));
            asInterface.setup(connectionConfig, zza(zzagu), zze.zzae(scheduledExecutorService), zza(zza));
            return asInterface;
        } catch (zzsj.zza e) {
            throw new RuntimeException(e);
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: private */
    public static long zza(Long l) {
        if (l == null) {
            return -1;
        }
        if (l.longValue() != -1) {
            return l.longValue();
        }
        throw new IllegalArgumentException("Tag parameter clashed with NO_TAG value");
    }

    private static zzagu zza(final zze zze) {
        return new zzagu() {
            public void zza(boolean z, final zzagu.zza zza) {
                try {
                    zze.this.zza(z, new zzf.zza() {
                        public void onError(String str) throws RemoteException {
                            zza.onError(str);
                        }

                        public void zzqy(String str) throws RemoteException {
                            zza.zzqy(str);
                        }
                    });
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    private static zzagz.zza zza(final zzi zzi) {
        return new zzagz.zza() {
            public void onDisconnect() {
                try {
                    zzi.this.onDisconnect();
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            public void zza(List<String> list, Object obj, boolean z, Long l) {
                try {
                    zzi.this.zza(list, zze.zzae(obj), z, IPersistentConnectionImpl.zza(l));
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            public void zza(List<String> list, List<zzahb> list2, Long l) {
                ArrayList arrayList = new ArrayList(list2.size());
                ArrayList arrayList2 = new ArrayList(list2.size());
                for (zzahb zzahb : list2) {
                    arrayList.add(RangeParcelable.zza(zzahb));
                    arrayList2.add(zzahb.zzcpf());
                }
                try {
                    zzi.this.zza(list, (List<RangeParcelable>) arrayList, zze.zzae(arrayList2), IPersistentConnectionImpl.zza(l));
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            public void zzbt(Map<String, Object> map) {
                try {
                    zzi.this.zzap(zze.zzae(map));
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            public void zzcoi() {
                try {
                    zzi.this.zzcoi();
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            public void zzcq(boolean z) {
                try {
                    zzi.this.zzcq(z);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    private static zzahc zza(final zzj zzj) {
        return new zzahc() {
            public void zzbm(String str, String str2) {
                try {
                    zzj.this.zzbm(str, str2);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    private static zze zza(final zzagu zzagu) {
        return new zze.zza() {
            public void zza(boolean z, final zzf zzf) throws RemoteException {
                zzagu.this.zza(z, new zzagu.zza() {
                    public void onError(String str) {
                        try {
                            zzf.onError(str);
                        } catch (RemoteException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    public void zzqy(String str) {
                        try {
                            zzf.zzqy(str);
                        } catch (RemoteException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        };
    }

    private static zzi zza(final zzagz.zza zza) {
        return new zzi.zza() {
            public void onDisconnect() {
                zzagz.zza.this.onDisconnect();
            }

            public void zza(List<String> list, zzd zzd, boolean z, long j) {
                zzagz.zza.this.zza(list, zze.zzad(zzd), z, IPersistentConnectionImpl.zzcb(j));
            }

            public void zza(List<String> list, List<RangeParcelable> list2, zzd zzd, long j) {
                List list3 = (List) zze.zzad(zzd);
                ArrayList arrayList = new ArrayList(list2.size());
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < list2.size()) {
                        arrayList.add(RangeParcelable.zza((RangeParcelable) list2.get(i2), list3.get(i2)));
                        i = i2 + 1;
                    } else {
                        zzagz.zza.this.zza(list, arrayList, IPersistentConnectionImpl.zzcb(j));
                        return;
                    }
                }
            }

            public void zzap(zzd zzd) {
                zzagz.zza.this.zzbt((Map) zze.zzad(zzd));
            }

            public void zzcoi() {
                zzagz.zza.this.zzcoi();
            }

            public void zzcq(boolean z) {
                zzagz.zza.this.zzcq(z);
            }
        };
    }

    /* access modifiers changed from: private */
    public static Long zzcb(long j) {
        if (j == -1) {
            return null;
        }
        return Long.valueOf(j);
    }

    public void compareAndPut(List<String> list, zzd zzd, String str, zzj zzj) {
        this.aSA.zza(list, zze.zzad(zzd), str, zza(zzj));
    }

    public void initialize() {
        this.aSA.initialize();
    }

    public void interrupt(String str) {
        this.aSA.interrupt(str);
    }

    public boolean isInterrupted(String str) {
        return this.aSA.isInterrupted(str);
    }

    public void listen(List<String> list, zzd zzd, final zzg zzg, long j, zzj zzj) {
        Long zzcb = zzcb(j);
        List<String> list2 = list;
        this.aSA.zza(list2, (Map) zze.zzad(zzd), new zzagy() {
            public String zzcof() {
                try {
                    return zzg.zzcof();
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            public boolean zzcog() {
                try {
                    return zzg.zzcog();
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            public zzags zzcoh() {
                try {
                    return CompoundHashParcelable.zza(zzg.zzcpn());
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        }, zzcb, zza(zzj));
    }

    public void merge(List<String> list, zzd zzd, zzj zzj) {
        this.aSA.zza(list, (Map) zze.zzad(zzd), zza(zzj));
    }

    public void onDisconnectCancel(List<String> list, zzj zzj) {
        this.aSA.zza(list, zza(zzj));
    }

    public void onDisconnectMerge(List<String> list, zzd zzd, zzj zzj) {
        this.aSA.zzb(list, (Map) zze.zzad(zzd), zza(zzj));
    }

    public void onDisconnectPut(List<String> list, zzd zzd, zzj zzj) {
        this.aSA.zzb(list, zze.zzad(zzd), zza(zzj));
    }

    public void purgeOutstandingWrites() {
        this.aSA.purgeOutstandingWrites();
    }

    public void put(List<String> list, zzd zzd, zzj zzj) {
        this.aSA.zza(list, zze.zzad(zzd), zza(zzj));
    }

    public void refreshAuthToken() {
        this.aSA.refreshAuthToken();
    }

    public void refreshAuthToken2(String str) {
        this.aSA.zzra(str);
    }

    public void resume(String str) {
        this.aSA.resume(str);
    }

    public void setup(ConnectionConfig connectionConfig, zze zze, zzd zzd, zzi zzi) {
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) zze.zzad(zzd);
        this.aSA = new zzaha(new zzagv(new zzajv(connectionConfig.zzcpl(), connectionConfig.zzcpm()), zza(zze), scheduledExecutorService, connectionConfig.aRa, connectionConfig.aSu, connectionConfig.aRc), HostInfoParcelable.zza(connectionConfig.aSr), zza(zzi));
    }

    public void shutdown() {
        this.aSA.shutdown();
    }

    public void unlisten(List<String> list, zzd zzd) {
        this.aSA.zza(list, (Map) zze.zzad(zzd));
    }
}
