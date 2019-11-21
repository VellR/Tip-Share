package com.google.firebase.storage;

import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzame;
import com.google.android.gms.internal.zzami;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class StorageMetadata {
    /* access modifiers changed from: private */
    public StorageReference bbS;
    private FirebaseStorage bcj;
    /* access modifiers changed from: private */
    public String bck;
    /* access modifiers changed from: private */
    public String bcl;
    /* access modifiers changed from: private */
    public String bcm;
    /* access modifiers changed from: private */
    public String bcn;
    /* access modifiers changed from: private */
    public String bco;
    /* access modifiers changed from: private */
    public long bcp;
    /* access modifiers changed from: private */
    public String bcq;
    /* access modifiers changed from: private */
    public String bcr;
    /* access modifiers changed from: private */
    public String bcs;
    /* access modifiers changed from: private */
    public String bct;
    /* access modifiers changed from: private */
    public String bcu;
    /* access modifiers changed from: private */
    public Map<String, String> bcv;
    private String[] bcw;
    /* access modifiers changed from: private */
    public String hG;
    /* access modifiers changed from: private */
    public String mPath;

    public static class Builder {
        StorageMetadata bcx;
        boolean bcy;

        public Builder() {
            this.bcx = new StorageMetadata();
        }

        public Builder(StorageMetadata storageMetadata) {
            this.bcx = new StorageMetadata(false);
        }

        Builder(JSONObject jSONObject) throws JSONException {
            this.bcx = new StorageMetadata();
            if (jSONObject != null) {
                zzp(jSONObject);
                this.bcy = true;
            }
        }

        Builder(JSONObject jSONObject, StorageReference storageReference) throws JSONException {
            this(jSONObject);
            this.bcx.bbS = storageReference;
        }

        private void zzp(JSONObject jSONObject) throws JSONException {
            this.bcx.bcl = jSONObject.optString("generation");
            this.bcx.mPath = jSONObject.optString("name");
            this.bcx.bck = jSONObject.optString("bucket");
            this.bcx.bcm = jSONObject.optString("metageneration");
            this.bcx.bcn = jSONObject.optString("timeCreated");
            this.bcx.bco = jSONObject.optString("updated");
            this.bcx.bcp = jSONObject.optLong("size");
            this.bcx.bcq = jSONObject.optString("md5Hash");
            this.bcx.zzsn(jSONObject.optString("downloadTokens"));
            setContentType(jSONObject.optString("contentType"));
            if (jSONObject.has("metadata")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    setCustomMetadata(str, jSONObject2.getString(str));
                }
            }
            setCacheControl(jSONObject.optString("cacheControl"));
            setContentDisposition(jSONObject.optString("contentDisposition"));
            setContentEncoding(jSONObject.optString("'contentEncoding"));
            setContentLanguage(jSONObject.optString("'contentLanguage"));
        }

        public StorageMetadata build() {
            return new StorageMetadata(this.bcy);
        }

        public Builder setCacheControl(String str) {
            this.bcx.bcr = str;
            return this;
        }

        public Builder setContentDisposition(String str) {
            this.bcx.bcs = str;
            return this;
        }

        public Builder setContentEncoding(String str) {
            this.bcx.bct = str;
            return this;
        }

        public Builder setContentLanguage(String str) {
            this.bcx.bcu = str;
            return this;
        }

        public Builder setContentType(String str) {
            this.bcx.hG = str;
            return this;
        }

        public Builder setCustomMetadata(String str, String str2) {
            if (this.bcx.bcv == null) {
                this.bcx.bcv = new HashMap();
            }
            this.bcx.bcv.put(str, str2);
            return this;
        }
    }

    public StorageMetadata() {
        this.mPath = null;
        this.bcj = null;
        this.bbS = null;
        this.bck = null;
        this.bcl = null;
        this.hG = null;
        this.bcm = null;
        this.bcn = null;
        this.bco = null;
        this.bcq = null;
        this.bcr = null;
        this.bcs = null;
        this.bct = null;
        this.bcu = null;
        this.bcv = null;
        this.bcw = null;
    }

    private StorageMetadata(@NonNull StorageMetadata storageMetadata, boolean z) {
        this.mPath = null;
        this.bcj = null;
        this.bbS = null;
        this.bck = null;
        this.bcl = null;
        this.hG = null;
        this.bcm = null;
        this.bcn = null;
        this.bco = null;
        this.bcq = null;
        this.bcr = null;
        this.bcs = null;
        this.bct = null;
        this.bcu = null;
        this.bcv = null;
        this.bcw = null;
        zzab.zzaa(storageMetadata);
        this.mPath = storageMetadata.mPath;
        this.bcj = storageMetadata.bcj;
        this.bbS = storageMetadata.bbS;
        this.bck = storageMetadata.bck;
        this.hG = storageMetadata.hG;
        this.bcr = storageMetadata.bcr;
        this.bcs = storageMetadata.bcs;
        this.bct = storageMetadata.bct;
        this.bcu = storageMetadata.bcu;
        if (storageMetadata.bcv != null) {
            this.bcv = new HashMap(storageMetadata.bcv);
        }
        this.bcw = storageMetadata.bcw;
        if (z) {
            this.bcq = storageMetadata.bcq;
            this.bcp = storageMetadata.bcp;
            this.bco = storageMetadata.bco;
            this.bcn = storageMetadata.bcn;
            this.bcm = storageMetadata.bcm;
            this.bcl = storageMetadata.bcl;
        }
    }

    /* access modifiers changed from: private */
    public void zzsn(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bcw = str.split(",");
        }
    }

    @Nullable
    public String getBucket() {
        return this.bck;
    }

    @Nullable
    public String getCacheControl() {
        return this.bcr;
    }

    @Nullable
    public String getContentDisposition() {
        return this.bcs;
    }

    @Nullable
    public String getContentEncoding() {
        return this.bct;
    }

    @Nullable
    public String getContentLanguage() {
        return this.bcu;
    }

    public String getContentType() {
        return this.hG;
    }

    public long getCreationTimeMillis() {
        return zzami.zzsr(this.bcn);
    }

    public String getCustomMetadata(@NonNull String str) {
        if (this.bcv == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return (String) this.bcv.get(str);
    }

    @NonNull
    public Set<String> getCustomMetadataKeys() {
        return this.bcv == null ? Collections.emptySet() : this.bcv.keySet();
    }

    @Nullable
    public Uri getDownloadUrl() {
        List downloadUrls = getDownloadUrls();
        if (downloadUrls == null || downloadUrls.size() <= 0) {
            return null;
        }
        return (Uri) downloadUrls.get(0);
    }

    @Nullable
    public List<Uri> getDownloadUrls() {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        if (!(this.bcw == null || this.bbS == null)) {
            try {
                String zzy = this.bbS.zzcyb().zzy(this.bbS.zzcyc());
                if (!TextUtils.isEmpty(zzy)) {
                    for (String str : this.bcw) {
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(Uri.parse(new StringBuilder(String.valueOf(zzy).length() + 17 + String.valueOf(str).length()).append(zzy).append("?alt=media&token=").append(str).toString()));
                        }
                    }
                }
            } catch (RemoteException e) {
                Log.e("StorageMetadata", "Unexpected error getting DownloadUrls.", e);
            }
        }
        return arrayList;
    }

    @Nullable
    public String getGeneration() {
        return this.bcl;
    }

    @Nullable
    public String getMd5Hash() {
        return this.bcq;
    }

    @Nullable
    public String getMetadataGeneration() {
        return this.bcm;
    }

    @Nullable
    public String getName() {
        String path = getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        int lastIndexOf = path.lastIndexOf(47);
        return lastIndexOf != -1 ? path.substring(lastIndexOf + 1) : path;
    }

    @NonNull
    public String getPath() {
        return this.mPath != null ? this.mPath : "";
    }

    @Nullable
    public StorageReference getReference() {
        if (this.bbS != null || this.bcj == null) {
            return this.bbS;
        }
        String bucket = getBucket();
        String path = getPath();
        if (TextUtils.isEmpty(bucket) || TextUtils.isEmpty(path)) {
            return null;
        }
        try {
            return new StorageReference(new android.net.Uri.Builder().scheme("gs").authority(bucket).encodedPath(zzame.zzso(path)).build(), this.bcj);
        } catch (UnsupportedEncodingException e) {
            Log.e("StorageMetadata", new StringBuilder(String.valueOf(bucket).length() + 38 + String.valueOf(path).length()).append("Unable to create a valid default Uri. ").append(bucket).append(path).toString(), e);
            throw new IllegalStateException(e);
        }
    }

    public long getSizeBytes() {
        return this.bcp;
    }

    public long getUpdatedTimeMillis() {
        return zzami.zzsr(this.bco);
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    public JSONObject zzcya() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (getContentType() != null) {
            jSONObject.put("contentType", getContentType());
        }
        if (this.bcv != null) {
            jSONObject.put("metadata", new JSONObject(this.bcv));
        }
        if (getCacheControl() != null) {
            jSONObject.put("cacheControl", getCacheControl());
        }
        if (getContentDisposition() != null) {
            jSONObject.put("contentDisposition", getContentDisposition());
        }
        if (getContentEncoding() != null) {
            jSONObject.put("'contentEncoding", getContentEncoding());
        }
        if (getContentLanguage() != null) {
            jSONObject.put("'contentLanguage", getContentLanguage());
        }
        return jSONObject;
    }
}
