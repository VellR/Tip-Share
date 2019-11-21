package com.google.android.gms.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class zzans {
    private final Map<Type, zzamu<?>> ben;

    public zzans(Map<Type, zzamu<?>> map) {
        this.ben = map;
    }

    private <T> zzanx<T> zzc(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new zzanx<T>() {
                public T a() {
                    return new TreeSet();
                }
            } : EnumSet.class.isAssignableFrom(cls) ? new zzanx<T>() {
                public T a() {
                    if (type instanceof ParameterizedType) {
                        Type type = ((ParameterizedType) type).getActualTypeArguments()[0];
                        if (type instanceof Class) {
                            return EnumSet.noneOf((Class) type);
                        }
                        String str = "Invalid EnumSet type: ";
                        String valueOf = String.valueOf(type.toString());
                        throw new zzamz(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    }
                    String str2 = "Invalid EnumSet type: ";
                    String valueOf2 = String.valueOf(type.toString());
                    throw new zzamz(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
                }
            } : Set.class.isAssignableFrom(cls) ? new zzanx<T>() {
                public T a() {
                    return new LinkedHashSet();
                }
            } : Queue.class.isAssignableFrom(cls) ? new zzanx<T>() {
                public T a() {
                    return new LinkedList();
                }
            } : new zzanx<T>() {
                public T a() {
                    return new ArrayList();
                }
            };
        }
        if (Map.class.isAssignableFrom(cls)) {
            return SortedMap.class.isAssignableFrom(cls) ? new zzanx<T>() {
                public T a() {
                    return new TreeMap();
                }
            } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(zzaoo.zzl(((ParameterizedType) type).getActualTypeArguments()[0]).s())) ? new zzanx<T>() {
                public T a() {
                    return new zzanw();
                }
            } : new zzanx<T>() {
                public T a() {
                    return new LinkedHashMap();
                }
            };
        }
        return null;
    }

    private <T> zzanx<T> zzd(final Type type, final Class<? super T> cls) {
        return new zzanx<T>() {
            private final zzaoa beQ = zzaoa.f();

            public T a() {
                try {
                    return this.beQ.zzf(cls);
                } catch (Exception e) {
                    String valueOf = String.valueOf(type);
                    throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 116).append("Unable to invoke no-args constructor for ").append(valueOf).append(". ").append("Register an InstanceCreator with Gson for this type may fix this problem.").toString(), e);
                }
            }
        };
    }

    private <T> zzanx<T> zzl(Class<? super T> cls) {
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new zzanx<T>() {
                public T a() {
                    try {
                        return declaredConstructor.newInstance(null);
                    } catch (InstantiationException e) {
                        String valueOf = String.valueOf(declaredConstructor);
                        throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to invoke ").append(valueOf).append(" with no args").toString(), e);
                    } catch (InvocationTargetException e2) {
                        String valueOf2 = String.valueOf(declaredConstructor);
                        throw new RuntimeException(new StringBuilder(String.valueOf(valueOf2).length() + 30).append("Failed to invoke ").append(valueOf2).append(" with no args").toString(), e2.getTargetException());
                    } catch (IllegalAccessException e3) {
                        throw new AssertionError(e3);
                    }
                }
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public String toString() {
        return this.ben.toString();
    }

    public <T> zzanx<T> zzb(zzaoo<T> zzaoo) {
        final Type t = zzaoo.t();
        Class s = zzaoo.s();
        final zzamu zzamu = (zzamu) this.ben.get(t);
        if (zzamu != null) {
            return new zzanx<T>() {
                public T a() {
                    return zzamu.zza(t);
                }
            };
        }
        final zzamu zzamu2 = (zzamu) this.ben.get(s);
        if (zzamu2 != null) {
            return new zzanx<T>() {
                public T a() {
                    return zzamu2.zza(t);
                }
            };
        }
        zzanx<T> zzl = zzl(s);
        if (zzl != null) {
            return zzl;
        }
        zzanx<T> zzc = zzc(t, s);
        return zzc == null ? zzd(t, s) : zzc;
    }
}
