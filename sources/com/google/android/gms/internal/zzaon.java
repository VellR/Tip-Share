package com.google.android.gms.internal;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;

public final class zzaon {
    public static final zzanl bgA = zza(Character.TYPE, Character.class, bgz);
    public static final zzank<String> bgB = new zzank<String>() {
        public void zza(zzaor zzaor, String str) throws IOException {
            zzaor.zztb(str);
        }

        /* renamed from: zzq */
        public String zzb(zzaop zzaop) throws IOException {
            zzaoq h = zzaop.h();
            if (h != zzaoq.NULL) {
                return h == zzaoq.BOOLEAN ? Boolean.toString(zzaop.nextBoolean()) : zzaop.nextString();
            }
            zzaop.nextNull();
            return null;
        }
    };
    public static final zzank<BigDecimal> bgC = new zzank<BigDecimal>() {
        public void zza(zzaor zzaor, BigDecimal bigDecimal) throws IOException {
            zzaor.zza(bigDecimal);
        }

        /* renamed from: zzr */
        public BigDecimal zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            try {
                return new BigDecimal(zzaop.nextString());
            } catch (NumberFormatException e) {
                throw new zzanh((Throwable) e);
            }
        }
    };
    public static final zzank<BigInteger> bgD = new zzank<BigInteger>() {
        public void zza(zzaor zzaor, BigInteger bigInteger) throws IOException {
            zzaor.zza(bigInteger);
        }

        /* renamed from: zzs */
        public BigInteger zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            try {
                return new BigInteger(zzaop.nextString());
            } catch (NumberFormatException e) {
                throw new zzanh((Throwable) e);
            }
        }
    };
    public static final zzanl bgE = zza(String.class, bgB);
    public static final zzank<StringBuilder> bgF = new zzank<StringBuilder>() {
        public void zza(zzaor zzaor, StringBuilder sb) throws IOException {
            zzaor.zztb(sb == null ? null : sb.toString());
        }

        /* renamed from: zzt */
        public StringBuilder zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() != zzaoq.NULL) {
                return new StringBuilder(zzaop.nextString());
            }
            zzaop.nextNull();
            return null;
        }
    };
    public static final zzanl bgG = zza(StringBuilder.class, bgF);
    public static final zzank<StringBuffer> bgH = new zzank<StringBuffer>() {
        public void zza(zzaor zzaor, StringBuffer stringBuffer) throws IOException {
            zzaor.zztb(stringBuffer == null ? null : stringBuffer.toString());
        }

        /* renamed from: zzu */
        public StringBuffer zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() != zzaoq.NULL) {
                return new StringBuffer(zzaop.nextString());
            }
            zzaop.nextNull();
            return null;
        }
    };
    public static final zzanl bgI = zza(StringBuffer.class, bgH);
    public static final zzank<URL> bgJ = new zzank<URL>() {
        public void zza(zzaor zzaor, URL url) throws IOException {
            zzaor.zztb(url == null ? null : url.toExternalForm());
        }

        /* renamed from: zzv */
        public URL zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            String nextString = zzaop.nextString();
            if (!"null".equals(nextString)) {
                return new URL(nextString);
            }
            return null;
        }
    };
    public static final zzanl bgK = zza(URL.class, bgJ);
    public static final zzank<URI> bgL = new zzank<URI>() {
        public void zza(zzaor zzaor, URI uri) throws IOException {
            zzaor.zztb(uri == null ? null : uri.toASCIIString());
        }

        /* renamed from: zzw */
        public URI zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            try {
                String nextString = zzaop.nextString();
                if (!"null".equals(nextString)) {
                    return new URI(nextString);
                }
                return null;
            } catch (URISyntaxException e) {
                throw new zzamz((Throwable) e);
            }
        }
    };
    public static final zzanl bgM = zza(URI.class, bgL);
    public static final zzank<InetAddress> bgN = new zzank<InetAddress>() {
        public void zza(zzaor zzaor, InetAddress inetAddress) throws IOException {
            zzaor.zztb(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        /* renamed from: zzy */
        public InetAddress zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() != zzaoq.NULL) {
                return InetAddress.getByName(zzaop.nextString());
            }
            zzaop.nextNull();
            return null;
        }
    };
    public static final zzanl bgO = zzb(InetAddress.class, bgN);
    public static final zzank<UUID> bgP = new zzank<UUID>() {
        public void zza(zzaor zzaor, UUID uuid) throws IOException {
            zzaor.zztb(uuid == null ? null : uuid.toString());
        }

        /* renamed from: zzz */
        public UUID zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() != zzaoq.NULL) {
                return UUID.fromString(zzaop.nextString());
            }
            zzaop.nextNull();
            return null;
        }
    };
    public static final zzanl bgQ = zza(UUID.class, bgP);
    public static final zzanl bgR = new zzanl() {
        public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
            if (zzaoo.s() != Timestamp.class) {
                return null;
            }
            final zzank zzk = zzams.zzk(Date.class);
            return new zzank<Timestamp>() {
                public void zza(zzaor zzaor, Timestamp timestamp) throws IOException {
                    zzk.zza(zzaor, timestamp);
                }

                /* renamed from: zzaa */
                public Timestamp zzb(zzaop zzaop) throws IOException {
                    Date date = (Date) zzk.zzb(zzaop);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }
            };
        }
    };
    public static final zzank<Calendar> bgS = new zzank<Calendar>() {
        public void zza(zzaor zzaor, Calendar calendar) throws IOException {
            if (calendar == null) {
                zzaor.r();
                return;
            }
            zzaor.p();
            zzaor.zzta("year");
            zzaor.zzcp((long) calendar.get(1));
            zzaor.zzta("month");
            zzaor.zzcp((long) calendar.get(2));
            zzaor.zzta("dayOfMonth");
            zzaor.zzcp((long) calendar.get(5));
            zzaor.zzta("hourOfDay");
            zzaor.zzcp((long) calendar.get(11));
            zzaor.zzta("minute");
            zzaor.zzcp((long) calendar.get(12));
            zzaor.zzta("second");
            zzaor.zzcp((long) calendar.get(13));
            zzaor.q();
        }

        /* renamed from: zzab */
        public Calendar zzb(zzaop zzaop) throws IOException {
            int i = 0;
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            zzaop.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (zzaop.h() != zzaoq.END_OBJECT) {
                String nextName = zzaop.nextName();
                int nextInt = zzaop.nextInt();
                if ("year".equals(nextName)) {
                    i6 = nextInt;
                } else if ("month".equals(nextName)) {
                    i5 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i4 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i3 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i2 = nextInt;
                } else if ("second".equals(nextName)) {
                    i = nextInt;
                }
            }
            zzaop.endObject();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }
    };
    public static final zzanl bgT = zzb(Calendar.class, GregorianCalendar.class, bgS);
    public static final zzank<Locale> bgU = new zzank<Locale>() {
        public void zza(zzaor zzaor, Locale locale) throws IOException {
            zzaor.zztb(locale == null ? null : locale.toString());
        }

        /* renamed from: zzac */
        public Locale zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(zzaop.nextString(), "_");
            String str = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String str2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String str3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (str2 == null && str3 == null) ? new Locale(str) : str3 == null ? new Locale(str, str2) : new Locale(str, str2, str3);
        }
    };
    public static final zzanl bgV = zza(Locale.class, bgU);
    public static final zzank<zzamy> bgW = new zzank<zzamy>() {
        public void zza(zzaor zzaor, zzamy zzamy) throws IOException {
            if (zzamy == null || zzamy.zzczp()) {
                zzaor.r();
            } else if (zzamy.zzczo()) {
                zzane zzczs = zzamy.zzczs();
                if (zzczs.zzczv()) {
                    zzaor.zza(zzczs.zzczg());
                } else if (zzczs.zzczu()) {
                    zzaor.zzcz(zzczs.zzczl());
                } else {
                    zzaor.zztb(zzczs.zzczh());
                }
            } else if (zzamy.zzczm()) {
                zzaor.n();
                Iterator it = zzamy.zzczr().iterator();
                while (it.hasNext()) {
                    zza(zzaor, (zzamy) it.next());
                }
                zzaor.o();
            } else if (zzamy.zzczn()) {
                zzaor.p();
                for (Entry entry : zzamy.zzczq().entrySet()) {
                    zzaor.zzta((String) entry.getKey());
                    zza(zzaor, (zzamy) entry.getValue());
                }
                zzaor.q();
            } else {
                String valueOf = String.valueOf(zzamy.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 15).append("Couldn't write ").append(valueOf).toString());
            }
        }

        /* renamed from: zzad */
        public zzamy zzb(zzaop zzaop) throws IOException {
            switch (AnonymousClass26.bfU[zzaop.h().ordinal()]) {
                case 1:
                    return new zzane((Number) new zzanv(zzaop.nextString()));
                case 2:
                    return new zzane(Boolean.valueOf(zzaop.nextBoolean()));
                case 3:
                    return new zzane(zzaop.nextString());
                case 4:
                    zzaop.nextNull();
                    return zzana.bes;
                case 5:
                    zzamv zzamv = new zzamv();
                    zzaop.beginArray();
                    while (zzaop.hasNext()) {
                        zzamv.zzc((zzamy) zzb(zzaop));
                    }
                    zzaop.endArray();
                    return zzamv;
                case 6:
                    zzanb zzanb = new zzanb();
                    zzaop.beginObject();
                    while (zzaop.hasNext()) {
                        zzanb.zza(zzaop.nextName(), (zzamy) zzb(zzaop));
                    }
                    zzaop.endObject();
                    return zzanb;
                default:
                    throw new IllegalArgumentException();
            }
        }
    };
    public static final zzanl bgX = zzb(zzamy.class, bgW);
    public static final zzanl bgY = new zzanl() {
        public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
            Class<Enum> s = zzaoo.s();
            if (!Enum.class.isAssignableFrom(s) || s == Enum.class) {
                return null;
            }
            if (!s.isEnum()) {
                s = s.getSuperclass();
            }
            return new zza(s);
        }
    };
    public static final zzank<Class> bgh = new zzank<Class>() {
        public void zza(zzaor zzaor, Class cls) throws IOException {
            if (cls == null) {
                zzaor.r();
            } else {
                String valueOf = String.valueOf(cls.getName());
                throw new UnsupportedOperationException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Attempted to serialize java.lang.Class: ").append(valueOf).append(". Forgot to register a type adapter?").toString());
            }
        }

        /* renamed from: zzo */
        public Class zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    };
    public static final zzanl bgi = zza(Class.class, bgh);
    public static final zzank<BitSet> bgj = new zzank<BitSet>() {
        public void zza(zzaor zzaor, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                zzaor.r();
                return;
            }
            zzaor.n();
            for (int i = 0; i < bitSet.length(); i++) {
                zzaor.zzcp((long) (bitSet.get(i) ? 1 : 0));
            }
            zzaor.o();
        }

        /* renamed from: zzx */
        public BitSet zzb(zzaop zzaop) throws IOException {
            boolean z;
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            BitSet bitSet = new BitSet();
            zzaop.beginArray();
            zzaoq h = zzaop.h();
            int i = 0;
            while (h != zzaoq.END_ARRAY) {
                switch (AnonymousClass26.bfU[h.ordinal()]) {
                    case 1:
                        if (zzaop.nextInt() == 0) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    case 2:
                        z = zzaop.nextBoolean();
                        break;
                    case 3:
                        String nextString = zzaop.nextString();
                        try {
                            if (Integer.parseInt(nextString) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            String str = "Error: Expecting: bitset number value (1, 0), Found: ";
                            String valueOf = String.valueOf(nextString);
                            throw new zzanh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                        }
                    default:
                        String valueOf2 = String.valueOf(h);
                        throw new zzanh(new StringBuilder(String.valueOf(valueOf2).length() + 27).append("Invalid bitset value type: ").append(valueOf2).toString());
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                h = zzaop.h();
            }
            zzaop.endArray();
            return bitSet;
        }
    };
    public static final zzanl bgk = zza(BitSet.class, bgj);
    public static final zzank<Boolean> bgl = new zzank<Boolean>() {
        public void zza(zzaor zzaor, Boolean bool) throws IOException {
            if (bool == null) {
                zzaor.r();
            } else {
                zzaor.zzcz(bool.booleanValue());
            }
        }

        /* renamed from: zzae */
        public Boolean zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() != zzaoq.NULL) {
                return zzaop.h() == zzaoq.STRING ? Boolean.valueOf(Boolean.parseBoolean(zzaop.nextString())) : Boolean.valueOf(zzaop.nextBoolean());
            }
            zzaop.nextNull();
            return null;
        }
    };
    public static final zzank<Boolean> bgm = new zzank<Boolean>() {
        public void zza(zzaor zzaor, Boolean bool) throws IOException {
            zzaor.zztb(bool == null ? "null" : bool.toString());
        }

        /* renamed from: zzae */
        public Boolean zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() != zzaoq.NULL) {
                return Boolean.valueOf(zzaop.nextString());
            }
            zzaop.nextNull();
            return null;
        }
    };
    public static final zzanl bgn = zza(Boolean.TYPE, Boolean.class, bgl);
    public static final zzank<Number> bgo = new zzank<Number>() {
        public void zza(zzaor zzaor, Number number) throws IOException {
            zzaor.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) zzaop.nextInt());
            } catch (NumberFormatException e) {
                throw new zzanh((Throwable) e);
            }
        }
    };
    public static final zzanl bgp = zza(Byte.TYPE, Byte.class, bgo);
    public static final zzank<Number> bgq = new zzank<Number>() {
        public void zza(zzaor zzaor, Number number) throws IOException {
            zzaor.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) zzaop.nextInt());
            } catch (NumberFormatException e) {
                throw new zzanh((Throwable) e);
            }
        }
    };
    public static final zzanl bgr = zza(Short.TYPE, Short.class, bgq);
    public static final zzank<Number> bgs = new zzank<Number>() {
        public void zza(zzaor zzaor, Number number) throws IOException {
            zzaor.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(zzaop.nextInt());
            } catch (NumberFormatException e) {
                throw new zzanh((Throwable) e);
            }
        }
    };
    public static final zzanl bgt = zza(Integer.TYPE, Integer.class, bgs);
    public static final zzank<Number> bgu = new zzank<Number>() {
        public void zza(zzaor zzaor, Number number) throws IOException {
            zzaor.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            try {
                return Long.valueOf(zzaop.nextLong());
            } catch (NumberFormatException e) {
                throw new zzanh((Throwable) e);
            }
        }
    };
    public static final zzank<Number> bgv = new zzank<Number>() {
        public void zza(zzaor zzaor, Number number) throws IOException {
            zzaor.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() != zzaoq.NULL) {
                return Float.valueOf((float) zzaop.nextDouble());
            }
            zzaop.nextNull();
            return null;
        }
    };
    public static final zzank<Number> bgw = new zzank<Number>() {
        public void zza(zzaor zzaor, Number number) throws IOException {
            zzaor.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() != zzaoq.NULL) {
                return Double.valueOf(zzaop.nextDouble());
            }
            zzaop.nextNull();
            return null;
        }
    };
    public static final zzank<Number> bgx = new zzank<Number>() {
        public void zza(zzaor zzaor, Number number) throws IOException {
            zzaor.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzaop zzaop) throws IOException {
            zzaoq h = zzaop.h();
            switch (h) {
                case NUMBER:
                    return new zzanv(zzaop.nextString());
                case NULL:
                    zzaop.nextNull();
                    return null;
                default:
                    String valueOf = String.valueOf(h);
                    throw new zzanh(new StringBuilder(String.valueOf(valueOf).length() + 23).append("Expecting number, got: ").append(valueOf).toString());
            }
        }
    };
    public static final zzanl bgy = zza(Number.class, bgx);
    public static final zzank<Character> bgz = new zzank<Character>() {
        public void zza(zzaor zzaor, Character ch) throws IOException {
            zzaor.zztb(ch == null ? null : String.valueOf(ch));
        }

        /* renamed from: zzp */
        public Character zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() == zzaoq.NULL) {
                zzaop.nextNull();
                return null;
            }
            String nextString = zzaop.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            String str = "Expecting character, got: ";
            String valueOf = String.valueOf(nextString);
            throw new zzanh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    };

    private static final class zza<T extends Enum<T>> extends zzank<T> {
        private final Map<String, T> bhi = new HashMap();
        private final Map<T, String> bhj = new HashMap();

        public zza(Class<T> cls) {
            Enum[] enumArr;
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    zzann zzann = (zzann) cls.getField(name).getAnnotation(zzann.class);
                    if (zzann != null) {
                        name = zzann.value();
                        for (String put : zzann.zzczy()) {
                            this.bhi.put(put, enumR);
                        }
                    }
                    String str = name;
                    this.bhi.put(str, enumR);
                    this.bhj.put(enumR, str);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        public void zza(zzaor zzaor, T t) throws IOException {
            zzaor.zztb(t == null ? null : (String) this.bhj.get(t));
        }

        /* renamed from: zzaf */
        public T zzb(zzaop zzaop) throws IOException {
            if (zzaop.h() != zzaoq.NULL) {
                return (Enum) this.bhi.get(zzaop.nextString());
            }
            zzaop.nextNull();
            return null;
        }
    }

    public static <TT> zzanl zza(final zzaoo<TT> zzaoo, final zzank<TT> zzank) {
        return new zzanl() {
            public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
                if (zzaoo.equals(zzaoo)) {
                    return zzank;
                }
                return null;
            }
        };
    }

    public static <TT> zzanl zza(final Class<TT> cls, final zzank<TT> zzank) {
        return new zzanl() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(zzank);
                return new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length()).append("Factory[type=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
            }

            public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
                if (zzaoo.s() == cls) {
                    return zzank;
                }
                return null;
            }
        };
    }

    public static <TT> zzanl zza(final Class<TT> cls, final Class<TT> cls2, final zzank<? super TT> zzank) {
        return new zzanl() {
            public String toString() {
                String valueOf = String.valueOf(cls2.getName());
                String valueOf2 = String.valueOf(cls.getName());
                String valueOf3 = String.valueOf(zzank);
                return new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
            }

            public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
                Class s = zzaoo.s();
                if (s == cls || s == cls2) {
                    return zzank;
                }
                return null;
            }
        };
    }

    public static <TT> zzanl zzb(final Class<TT> cls, final zzank<TT> zzank) {
        return new zzanl() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(zzank);
                return new StringBuilder(String.valueOf(valueOf).length() + 32 + String.valueOf(valueOf2).length()).append("Factory[typeHierarchy=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
            }

            public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
                if (cls.isAssignableFrom(zzaoo.s())) {
                    return zzank;
                }
                return null;
            }
        };
    }

    public static <TT> zzanl zzb(final Class<TT> cls, final Class<? extends TT> cls2, final zzank<? super TT> zzank) {
        return new zzanl() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(cls2.getName());
                String valueOf3 = String.valueOf(zzank);
                return new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
            }

            public <T> zzank<T> zza(zzams zzams, zzaoo<T> zzaoo) {
                Class s = zzaoo.s();
                if (s == cls || s == cls2) {
                    return zzank;
                }
                return null;
            }
        };
    }
}
