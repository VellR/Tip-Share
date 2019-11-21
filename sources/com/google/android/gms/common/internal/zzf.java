package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzf {
    public static final zzf xC = zza((CharSequence) "\t\n\u000b\f\r     　 ᠎ ").zza(zza(8192, 8202));
    public static final zzf xD = zza((CharSequence) "\t\n\u000b\f\r     　").zza(zza(8192, 8198)).zza(zza(8200, 8202));
    public static final zzf xE = zza(0, 127);
    public static final zzf xF;
    public static final zzf xG = zza(9, 13).zza(zza(28, ' ')).zza(zzc(5760)).zza(zzc(6158)).zza(zza(8192, 8198)).zza(zza(8200, 8203)).zza(zza(8232, 8233)).zza(zzc(8287)).zza(zzc(12288));
    public static final zzf xH = new zzf() {
        public boolean zzd(char c) {
            return Character.isDigit(c);
        }
    };
    public static final zzf xI = new zzf() {
        public boolean zzd(char c) {
            return Character.isLetter(c);
        }
    };
    public static final zzf xJ = new zzf() {
        public boolean zzd(char c) {
            return Character.isLetterOrDigit(c);
        }
    };
    public static final zzf xK = new zzf() {
        public boolean zzd(char c) {
            return Character.isUpperCase(c);
        }
    };
    public static final zzf xL = new zzf() {
        public boolean zzd(char c) {
            return Character.isLowerCase(c);
        }
    };
    public static final zzf xM = zza(0, 31).zza(zza(127, 159));
    public static final zzf xN = zza(0, ' ').zza(zza(127, 160)).zza(zzc(173)).zza(zza(1536, 1539)).zza(zza((CharSequence) "۝܏ ឴឵᠎")).zza(zza(8192, 8207)).zza(zza(8232, 8239)).zza(zza(8287, 8292)).zza(zza(8298, 8303)).zza(zzc(12288)).zza(zza(55296, 63743)).zza(zza((CharSequence) "﻿￹￺￻"));
    public static final zzf xO = zza(0, 1273).zza(zzc(1470)).zza(zza(1488, 1514)).zza(zzc(1523)).zza(zzc(1524)).zza(zza(1536, 1791)).zza(zza(1872, 1919)).zza(zza(3584, 3711)).zza(zza(7680, 8367)).zza(zza(8448, 8506)).zza(zza(64336, 65023)).zza(zza(65136, 65279)).zza(zza(65377, 65500));
    public static final zzf xP = new zzf() {
        public zzf zza(zzf zzf) {
            zzab.zzaa(zzf);
            return this;
        }

        public boolean zzb(CharSequence charSequence) {
            zzab.zzaa(charSequence);
            return true;
        }

        public boolean zzd(char c) {
            return true;
        }
    };
    public static final zzf xQ = new zzf() {
        public zzf zza(zzf zzf) {
            return (zzf) zzab.zzaa(zzf);
        }

        public boolean zzb(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public boolean zzd(char c) {
            return false;
        }
    };

    private static class zza extends zzf {
        List<zzf> xX;

        zza(List<zzf> list) {
            this.xX = list;
        }

        public zzf zza(zzf zzf) {
            ArrayList arrayList = new ArrayList(this.xX);
            arrayList.add((zzf) zzab.zzaa(zzf));
            return new zza(arrayList);
        }

        public boolean zzd(char c) {
            for (zzf zzd : this.xX) {
                if (zzd.zzd(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        char[] charArray;
        zzf zza2 = zza('0', '9');
        zzf zzf = zza2;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            zzf = zzf.zza(zza(c, (char) (c + 9)));
        }
        xF = zzf;
    }

    public static zzf zza(final char c, final char c2) {
        zzab.zzbn(c2 >= c);
        return new zzf() {
            public boolean zzd(char c) {
                return c <= c && c <= c2;
            }
        };
    }

    public static zzf zza(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return xQ;
            case 1:
                return zzc(charSequence.charAt(0));
            case 2:
                final char charAt = charSequence.charAt(0);
                final char charAt2 = charSequence.charAt(1);
                return new zzf() {
                    public boolean zzd(char c) {
                        return c == charAt || c == charAt2;
                    }
                };
            default:
                final char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                return new zzf() {
                    public boolean zzd(char c) {
                        return Arrays.binarySearch(charArray, c) >= 0;
                    }
                };
        }
    }

    public static zzf zzc(final char c) {
        return new zzf() {
            public zzf zza(zzf zzf) {
                return zzf.zzd(c) ? zzf : zzf.super.zza(zzf);
            }

            public boolean zzd(char c) {
                return c == c;
            }
        };
    }

    public zzf zza(zzf zzf) {
        return new zza(Arrays.asList(new zzf[]{this, (zzf) zzab.zzaa(zzf)}));
    }

    public boolean zzb(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!zzd(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c);
}
