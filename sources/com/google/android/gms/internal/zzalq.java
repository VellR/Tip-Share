package com.google.android.gms.internal;

import android.util.Log;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;
import com.google.firebase.database.ThrowOnExtraProperties;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class zzalq {
    private static final ConcurrentMap<Class<?>, zza<?>> bat = new ConcurrentHashMap();

    private static class zza<T> {
        private final Map<String, Method> baA;
        private final Map<String, Field> baB;
        /* access modifiers changed from: private */
        public final Class<T> bau;
        private final Constructor<T> bav;
        private final boolean baw;
        private final boolean bax;
        private final Map<String, String> bay;
        private final Map<String, Method> baz;

        public zza(Class<T> cls) {
            Constructor<T> constructor;
            Method[] declaredMethods;
            Field[] declaredFields;
            Method[] declaredMethods2;
            Field[] declaredFields2;
            this.bau = cls;
            this.baw = cls.isAnnotationPresent(ThrowOnExtraProperties.class);
            this.bax = !cls.isAnnotationPresent(IgnoreExtraProperties.class);
            this.bay = new HashMap();
            this.baA = new HashMap();
            this.baz = new HashMap();
            this.baB = new HashMap();
            try {
                constructor = cls.getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
            } catch (NoSuchMethodException e) {
                constructor = null;
            }
            this.bav = constructor;
            for (Method method : cls.getDeclaredMethods()) {
                if (zza(method)) {
                    String zzc = zzc(method);
                    zzsd(zzc);
                    method.setAccessible(true);
                    if (this.baz.containsKey(zzc)) {
                        String str = "Found conflicting getters for name: ";
                        String valueOf = String.valueOf(method.getName());
                        throw new DatabaseException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    }
                    this.baz.put(zzc, method);
                }
            }
            for (Field field : cls.getDeclaredFields()) {
                if (zza(field)) {
                    zzsd(zzb(field));
                }
            }
            for (Method method2 : cls.getDeclaredMethods()) {
                if (zzb(method2)) {
                    String zzc2 = zzc(method2);
                    String str2 = (String) this.bay.get(zzc2.toLowerCase());
                    if (str2 == null) {
                        continue;
                    } else if (!str2.equals(zzc2)) {
                        String str3 = "Found setter with invalid case-sensitive name: ";
                        String valueOf2 = String.valueOf(method2.getName());
                        throw new DatabaseException(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
                    } else if (this.baA.containsKey(zzc2)) {
                        String str4 = "Found two conflicting setters with name: ";
                        String valueOf3 = String.valueOf(method2.getName());
                        throw new DatabaseException(valueOf3.length() != 0 ? str4.concat(valueOf3) : new String(str4));
                    } else {
                        method2.setAccessible(true);
                        this.baA.put(zzc2, method2);
                    }
                }
            }
            for (Field field2 : cls.getDeclaredFields()) {
                String zzb = zzb(field2);
                if (this.bay.containsKey(zzb.toLowerCase())) {
                    field2.setAccessible(true);
                    this.baB.put(zzb, field2);
                }
            }
            if (this.bay.isEmpty()) {
                String str5 = "No properties to serialize found on class ";
                String valueOf4 = String.valueOf(cls.getName());
                throw new DatabaseException(valueOf4.length() != 0 ? str5.concat(valueOf4) : new String(str5));
            }
        }

        private static String zza(AccessibleObject accessibleObject) {
            if (accessibleObject.isAnnotationPresent(PropertyName.class)) {
                return ((PropertyName) accessibleObject.getAnnotation(PropertyName.class)).value();
            }
            return null;
        }

        private Type zza(Type type, Map<TypeVariable<Class<T>>, Type> map) {
            if (!(type instanceof TypeVariable)) {
                return type;
            }
            Type type2 = (Type) map.get(type);
            if (type2 != null) {
                return type2;
            }
            String valueOf = String.valueOf(type);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 23).append("Could not resolve type ").append(valueOf).toString());
        }

        private static boolean zza(Field field) {
            return Modifier.isPublic(field.getModifiers()) && !Modifier.isStatic(field.getModifiers()) && !Modifier.isTransient(field.getModifiers()) && !field.isAnnotationPresent(Exclude.class);
        }

        private static boolean zza(Method method) {
            return (method.getName().startsWith("get") || method.getName().startsWith("is")) && Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && !method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 0 && !method.isAnnotationPresent(Exclude.class);
        }

        private static String zzb(Field field) {
            String zza = zza((AccessibleObject) field);
            return zza != null ? zza : field.getName();
        }

        private static boolean zzb(Method method) {
            return method.getName().startsWith("set") && Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(Exclude.class);
        }

        private static String zzc(Method method) {
            String zza = zza((AccessibleObject) method);
            return zza != null ? zza : zzse(method.getName());
        }

        private void zzsd(String str) {
            String str2 = (String) this.bay.put(str.toLowerCase(), str);
            if (str2 != null && !str.equals(str2)) {
                String str3 = "Found two getters or fields with conflicting case sensitivity for property: ";
                String valueOf = String.valueOf(str.toLowerCase());
                throw new DatabaseException(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            }
        }

        private static String zzse(String str) {
            String[] strArr = {"get", "set", "is"};
            String str2 = null;
            int i = 0;
            while (i < 3) {
                String str3 = strArr[i];
                if (!str.startsWith(str3)) {
                    str3 = str2;
                }
                i++;
                str2 = str3;
            }
            if (str2 == null) {
                String str4 = "Unknown Bean prefix for method: ";
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
            }
            char[] charArray = str.substring(str2.length()).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && Character.isUpperCase(charArray[i2])) {
                charArray[i2] = Character.toLowerCase(charArray[i2]);
                i2++;
            }
            return new String(charArray);
        }

        public T zzcc(Map<String, Object> map) {
            return zze(map, Collections.emptyMap());
        }

        public Map<String, Object> zzcg(T t) {
            Object obj;
            if (!this.bau.isAssignableFrom(t.getClass())) {
                String valueOf = String.valueOf(t.getClass());
                String valueOf2 = String.valueOf(this.bau);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 59 + String.valueOf(valueOf2).length()).append("Can't serialize object of class ").append(valueOf).append(" with BeanMapper for class ").append(valueOf2).toString());
            }
            HashMap hashMap = new HashMap();
            for (String str : this.bay.values()) {
                if (this.baz.containsKey(str)) {
                    try {
                        obj = ((Method) this.baz.get(str)).invoke(t, new Object[0]);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException(e2);
                    }
                } else {
                    Field field = (Field) this.baB.get(str);
                    if (field == null) {
                        String str2 = "Bean property without field or getter:";
                        String valueOf3 = String.valueOf(str);
                        throw new IllegalStateException(valueOf3.length() != 0 ? str2.concat(valueOf3) : new String(str2));
                    }
                    try {
                        obj = field.get(t);
                    } catch (IllegalAccessException e3) {
                        throw new RuntimeException(e3);
                    }
                }
                hashMap.put(str, zzalq.zzby(obj));
            }
            return hashMap;
        }

        public T zze(Map<String, Object> map, Map<TypeVariable<Class<T>>, Type> map2) {
            if (this.bav == null) {
                String valueOf = String.valueOf(this.bau.getName());
                throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 49).append("Class ").append(valueOf).append(" is missing a constructor with no arguments").toString());
            }
            try {
                T newInstance = this.bav.newInstance(new Object[0]);
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (this.baA.containsKey(str)) {
                        Method method = (Method) this.baA.get(str);
                        Type[] genericParameterTypes = method.getGenericParameterTypes();
                        if (genericParameterTypes.length != 1) {
                            throw new IllegalStateException("Setter does not have exactly one parameter");
                        }
                        try {
                            method.invoke(newInstance, new Object[]{zzalq.zza(entry.getValue(), zza(genericParameterTypes[0], map2))});
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InvocationTargetException e2) {
                            throw new RuntimeException(e2);
                        }
                    } else if (this.baB.containsKey(str)) {
                        Field field = (Field) this.baB.get(str);
                        try {
                            field.set(newInstance, zzalq.zza(entry.getValue(), zza(field.getGenericType(), map2)));
                        } catch (IllegalAccessException e3) {
                            throw new RuntimeException(e3);
                        }
                    } else {
                        String valueOf2 = String.valueOf(this.bau.getName());
                        String sb = new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(valueOf2).length()).append("No setter/field for ").append(str).append(" found on class ").append(valueOf2).toString();
                        if (this.bay.containsKey(str.toLowerCase())) {
                            sb = String.valueOf(sb).concat(" (fields/setters are case sensitive!)");
                        }
                        if (this.baw) {
                            throw new DatabaseException(sb);
                        } else if (this.bax) {
                            Log.w("ClassMapper", sb);
                        }
                    }
                }
                return newInstance;
            } catch (InstantiationException e4) {
                throw new RuntimeException(e4);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException(e5);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException(e6);
            }
        }
    }

    public static <T> T zza(Object obj, GenericTypeIndicator<T> genericTypeIndicator) {
        Type genericSuperclass = genericTypeIndicator.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType().equals(GenericTypeIndicator.class)) {
                return zza(obj, parameterizedType.getActualTypeArguments()[0]);
            }
            String valueOf = String.valueOf(genericSuperclass);
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Not a direct subclass of GenericTypeIndicator: ").append(valueOf).toString());
        }
        String valueOf2 = String.valueOf(genericSuperclass);
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf2).length() + 47).append("Not a direct subclass of GenericTypeIndicator: ").append(valueOf2).toString());
    }

    public static <T> T zza(Object obj, Class<T> cls) {
        return zzb(obj, cls);
    }

    private static <T> T zza(Object obj, ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        if (List.class.isAssignableFrom(cls)) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                T arrayList = new ArrayList(list.size());
                for (Object zza2 : list) {
                    arrayList.add(zza(zza2, type));
                }
                return arrayList;
            }
            String valueOf = String.valueOf(obj.getClass());
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Expected a List while deserializing, but got a ").append(valueOf).toString());
        } else if (Map.class.isAssignableFrom(cls)) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (!type2.equals(String.class)) {
                String valueOf2 = String.valueOf(type2);
                throw new DatabaseException(new StringBuilder(String.valueOf(valueOf2).length() + 70).append("Only Maps with string keys are supported, but found Map with key type ").append(valueOf2).toString());
            }
            Map zzbz = zzbz(obj);
            HashMap hashMap = new HashMap();
            for (Entry entry : zzbz.entrySet()) {
                hashMap.put((String) entry.getKey(), zza(entry.getValue(), type3));
            }
            return hashMap;
        } else if (Collection.class.isAssignableFrom(cls)) {
            throw new DatabaseException("Collections are not supported, please use Lists instead");
        } else {
            Map zzbz2 = zzbz(obj);
            zza zzj = zzj(cls);
            HashMap hashMap2 = new HashMap();
            TypeVariable[] typeParameters = zzj.bau.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length != typeParameters.length) {
                throw new IllegalStateException("Mismatched lengths for type variables and actual types");
            }
            for (int i = 0; i < typeParameters.length; i++) {
                hashMap2.put(typeParameters[i], actualTypeArguments[i]);
            }
            return zzj.zze(zzbz2, hashMap2);
        }
    }

    /* access modifiers changed from: private */
    public static <T> T zza(Object obj, Type type) {
        if (obj == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return zza(obj, (ParameterizedType) type);
        }
        if (type instanceof Class) {
            return zzb(obj, (Class) type);
        }
        if (type instanceof WildcardType) {
            throw new DatabaseException("Generic wildcard types are not supported");
        } else if (type instanceof GenericArrayType) {
            throw new DatabaseException("Generic Arrays are not supported, please use Lists instead");
        } else {
            String valueOf = String.valueOf(type);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 26).append("Unknown type encountered: ").append(valueOf).toString());
        }
    }

    private static <T> T zzb(Object obj, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        if (cls.isPrimitive() || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls)) {
            return zzc(obj, cls);
        }
        if (String.class.isAssignableFrom(cls)) {
            return zzce(obj);
        }
        if (cls.isArray()) {
            throw new DatabaseException("Converting to Arrays is not supported, please use Listsinstead");
        } else if (cls.getTypeParameters().length <= 0) {
            return !cls.equals(Object.class) ? zzd(obj, cls) : obj;
        } else {
            String valueOf = String.valueOf(cls.getName());
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 75).append("Class ").append(valueOf).append(" has generic type parameters, please use GenericTypeIndicator instead").toString());
        }
    }

    public static Object zzbx(Object obj) {
        return zzby(obj);
    }

    /* access modifiers changed from: private */
    public static <T> Object zzby(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Number) {
            if (t instanceof Float) {
                return Double.valueOf(((Float) t).doubleValue());
            }
            if (t instanceof Short) {
                throw new DatabaseException("Shorts are not supported, please use int or long");
            } else if (!(t instanceof Byte)) {
                return t;
            } else {
                throw new DatabaseException("Bytes are not supported, please use int or long");
            }
        } else if ((t instanceof String) || (t instanceof Boolean)) {
            return t;
        } else {
            if (t instanceof Character) {
                throw new DatabaseException("Characters are not supported, please strings");
            } else if (t instanceof Map) {
                HashMap hashMap = new HashMap();
                for (Entry entry : ((Map) t).entrySet()) {
                    Object key = entry.getKey();
                    if (key instanceof String) {
                        hashMap.put((String) key, zzby(entry.getValue()));
                    } else {
                        throw new DatabaseException("Maps with non-string keys are not supported");
                    }
                }
                return hashMap;
            } else if (t instanceof Collection) {
                if (t instanceof List) {
                    List<Object> list = (List) t;
                    ArrayList arrayList = new ArrayList(list.size());
                    for (Object zzby : list) {
                        arrayList.add(zzby(zzby));
                    }
                    return arrayList;
                }
                throw new DatabaseException("Serializing Collections is not supported, please use Lists instead");
            } else if (!t.getClass().isArray()) {
                return zzj(t.getClass()).zzcg(t);
            } else {
                throw new DatabaseException("Serializing Arrays is not supported, please use Lists instead");
            }
        }
    }

    private static Map<String, Object> zzbz(Object obj) {
        if (obj instanceof Map) {
            return (Map) obj;
        }
        String valueOf = String.valueOf(obj.getClass());
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected a Map while deserializing, but got a ").append(valueOf).toString());
    }

    private static <T> T zzc(Object obj, Class<T> cls) {
        if (Integer.class.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls)) {
            return zzca(obj);
        }
        if (Boolean.class.isAssignableFrom(cls) || Boolean.TYPE.isAssignableFrom(cls)) {
            return zzcd(obj);
        }
        if (Double.class.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls)) {
            return zzcc(obj);
        }
        if (Long.class.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls)) {
            return zzcb(obj);
        }
        if (Float.class.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls)) {
            return Float.valueOf(zzcc(obj).floatValue());
        }
        if (Short.class.isAssignableFrom(cls) || Short.TYPE.isAssignableFrom(cls)) {
            throw new DatabaseException("Deserializing to shorts is not supported");
        } else if (Byte.class.isAssignableFrom(cls) || Byte.TYPE.isAssignableFrom(cls)) {
            throw new DatabaseException("Deserializing to bytes is not supported");
        } else if (Character.class.isAssignableFrom(cls) || Character.TYPE.isAssignableFrom(cls)) {
            throw new DatabaseException("Deserializing to char is not supported");
        } else {
            String valueOf = String.valueOf(cls);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Unknown primitive type: ").append(valueOf).toString());
        }
    }

    private static Integer zzca(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            double doubleValue = ((Number) obj).doubleValue();
            if (doubleValue >= -2.147483648E9d && doubleValue <= 2.147483647E9d) {
                return Integer.valueOf(((Number) obj).intValue());
            }
            throw new DatabaseException("Numeric value out of 32-bit integer range: " + doubleValue + ". Did you mean to use a long or double instead of an int?");
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 41).append("Failed to convert a value of type ").append(valueOf).append(" to int").toString());
    }

    private static Long zzcb(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.doubleValue() >= -9.223372036854776E18d && d.doubleValue() <= 9.223372036854776E18d) {
                return Long.valueOf(d.longValue());
            }
            String valueOf = String.valueOf(d);
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 89).append("Numeric value out of 64-bit long range: ").append(valueOf).append(". Did you mean to use a double instead of a long?").toString());
        }
        String valueOf2 = String.valueOf(obj.getClass().getName());
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf2).length() + 42).append("Failed to convert a value of type ").append(valueOf2).append(" to long").toString());
    }

    private static Double zzcc(Object obj) {
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        if (obj instanceof Long) {
            Long l = (Long) obj;
            Double valueOf = Double.valueOf(((Long) obj).doubleValue());
            if (valueOf.longValue() == l.longValue()) {
                return valueOf;
            }
            String valueOf2 = String.valueOf(obj);
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf2).length() + 97).append("Loss of precision while converting number to double: ").append(valueOf2).append(". Did you mean to use a 64-bit long instead?").toString());
        } else if (obj instanceof Double) {
            return (Double) obj;
        } else {
            String valueOf3 = String.valueOf(obj.getClass().getName());
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf3).length() + 44).append("Failed to convert a value of type ").append(valueOf3).append(" to double").toString());
        }
    }

    private static Boolean zzcd(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Failed to convert value of type ").append(valueOf).append(" to boolean").toString());
    }

    private static String zzce(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 42).append("Failed to convert value of type ").append(valueOf).append(" to String").toString());
    }

    private static <T> T zzd(Object obj, Class<T> cls) {
        zza zzj = zzj(cls);
        if (obj instanceof Map) {
            return zzj.zzcc(zzbz(obj));
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        String valueOf2 = String.valueOf(cls.getName());
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 38 + String.valueOf(valueOf2).length()).append("Can't convert object of type ").append(valueOf).append(" to type ").append(valueOf2).toString());
    }

    private static <T> zza<T> zzj(Class<T> cls) {
        zza<T> zza2 = (zza) bat.get(cls);
        if (zza2 != null) {
            return zza2;
        }
        zza<T> zza3 = new zza<>(cls);
        bat.put(cls, zza3);
        return zza3;
    }
}
