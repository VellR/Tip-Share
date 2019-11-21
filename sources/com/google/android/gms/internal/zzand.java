package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class zzand {
    public zzamy zza(Reader reader) throws zzamz, zzanh {
        try {
            zzaop zzaop = new zzaop(reader);
            zzamy zzh = zzh(zzaop);
            if (zzh.zzczp() || zzaop.h() == zzaoq.END_DOCUMENT) {
                return zzh;
            }
            throw new zzanh("Did not consume the entire document.");
        } catch (zzaos e) {
            throw new zzanh((Throwable) e);
        } catch (IOException e2) {
            throw new zzamz((Throwable) e2);
        } catch (NumberFormatException e3) {
            throw new zzanh((Throwable) e3);
        }
    }

    public zzamy zzh(zzaop zzaop) throws zzamz, zzanh {
        boolean isLenient = zzaop.isLenient();
        zzaop.setLenient(true);
        try {
            zzamy zzh = zzanz.zzh(zzaop);
            zzaop.setLenient(isLenient);
            return zzh;
        } catch (StackOverflowError e) {
            String valueOf = String.valueOf(zzaop);
            throw new zzanc(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed parsing JSON source: ").append(valueOf).append(" to Json").toString(), e);
        } catch (OutOfMemoryError e2) {
            String valueOf2 = String.valueOf(zzaop);
            throw new zzanc(new StringBuilder(String.valueOf(valueOf2).length() + 36).append("Failed parsing JSON source: ").append(valueOf2).append(" to Json").toString(), e2);
        } catch (Throwable th) {
            zzaop.setLenient(isLenient);
            throw th;
        }
    }

    public zzamy zzsy(String str) throws zzanh {
        return zza(new StringReader(str));
    }
}
