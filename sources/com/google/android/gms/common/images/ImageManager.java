package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzrh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    /* access modifiers changed from: private */
    public static final Object wf = new Object();
    /* access modifiers changed from: private */
    public static HashSet<Uri> wg = new HashSet<>();
    private static ImageManager wh;
    private static ImageManager wi;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final ExecutorService wj = Executors.newFixedThreadPool(4);
    /* access modifiers changed from: private */
    public final zzb wk;
    /* access modifiers changed from: private */
    public final zzrh wl;
    /* access modifiers changed from: private */
    public final Map<zza, ImageReceiver> wm;
    /* access modifiers changed from: private */
    public final Map<Uri, ImageReceiver> wn;
    /* access modifiers changed from: private */
    public final Map<Uri, Long> wo;

    @KeepName
    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        /* access modifiers changed from: private */
        public final ArrayList<zza> wp = new ArrayList<>();

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.wj.execute(new zzc(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzarl() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }

        public void zzb(zza zza) {
            com.google.android.gms.common.internal.zzb.zzhj("ImageReceiver.addImageRequest() must be called in the main thread");
            this.wp.add(zza);
        }

        public void zzc(zza zza) {
            com.google.android.gms.common.internal.zzb.zzhj("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.wp.remove(zza);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    @TargetApi(11)
    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private static final class zzb extends LruCache<C0007zza, Bitmap> {
        public zzb(Context context) {
            super(zzcc(context));
        }

        @TargetApi(11)
        private static int zzcc(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) (((float) (((!((context.getApplicationInfo().flags & 1048576) != 0) || !zzs.zzavj()) ? activityManager.getMemoryClass() : zza.zza(activityManager)) * 1048576)) * 0.33f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public int sizeOf(C0007zza zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public void entryRemoved(boolean z, C0007zza zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, zza, bitmap, bitmap2);
        }
    }

    private final class zzc implements Runnable {
        private final Uri mUri;
        private final ParcelFileDescriptor wr;

        public zzc(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.wr = parcelFileDescriptor;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzhk("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.wr != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.wr.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String valueOf = String.valueOf(this.mUri);
                    Log.e("ImageManager", new StringBuilder(String.valueOf(valueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf).toString(), e);
                    z = true;
                }
                try {
                    this.wr.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new zzf(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                String valueOf2 = String.valueOf(this.mUri);
                Log.w("ImageManager", new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Latch interrupted while posting ").append(valueOf2).toString());
            }
        }
    }

    private final class zzd implements Runnable {
        private final zza ws;

        public zzd(zza zza) {
            this.ws = zza;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzhj("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.wm.get(this.ws);
            if (imageReceiver != null) {
                ImageManager.this.wm.remove(this.ws);
                imageReceiver.zzc(this.ws);
            }
            C0007zza zza = this.ws.wu;
            if (zza.uri == null) {
                this.ws.zza(ImageManager.this.mContext, ImageManager.this.wl, true);
                return;
            }
            Bitmap zza2 = ImageManager.this.zza(zza);
            if (zza2 != null) {
                this.ws.zza(ImageManager.this.mContext, zza2, true);
                return;
            }
            Long l = (Long) ImageManager.this.wo.get(zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.ws.zza(ImageManager.this.mContext, ImageManager.this.wl, true);
                    return;
                }
                ImageManager.this.wo.remove(zza.uri);
            }
            this.ws.zza(ImageManager.this.mContext, ImageManager.this.wl);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.wn.get(zza.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(zza.uri);
                ImageManager.this.wn.put(zza.uri, imageReceiver2);
            }
            imageReceiver2.zzb(this.ws);
            if (!(this.ws instanceof com.google.android.gms.common.images.zza.zzc)) {
                ImageManager.this.wm.put(this.ws, imageReceiver2);
            }
            synchronized (ImageManager.wf) {
                if (!ImageManager.wg.contains(zza.uri)) {
                    ImageManager.wg.add(zza.uri);
                    imageReceiver2.zzarl();
                }
            }
        }
    }

    @TargetApi(14)
    private static final class zze implements ComponentCallbacks2 {
        private final zzb wk;

        public zze(zzb zzb) {
            this.wk = zzb;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
            this.wk.evictAll();
        }

        public void onTrimMemory(int i) {
            if (i >= 60) {
                this.wk.evictAll();
            } else if (i >= 20) {
                this.wk.trimToSize(this.wk.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private boolean wt;
        private final CountDownLatch zzalc;

        public zzf(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.wt = z;
            this.zzalc = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList zza = imageReceiver.wp;
            int size = zza.size();
            for (int i = 0; i < size; i++) {
                zza zza2 = (zza) zza.get(i);
                if (z) {
                    zza2.zza(ImageManager.this.mContext, this.mBitmap, false);
                } else {
                    ImageManager.this.wo.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zza2.zza(ImageManager.this.mContext, ImageManager.this.wl, false);
                }
                if (!(zza2 instanceof com.google.android.gms.common.images.zza.zzc)) {
                    ImageManager.this.wm.remove(zza2);
                }
            }
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzhj("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.wk != null) {
                if (this.wt) {
                    ImageManager.this.wk.evictAll();
                    System.gc();
                    this.wt = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.wk.put(new C0007zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.wn.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzalc.countDown();
            synchronized (ImageManager.wf) {
                ImageManager.wg.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        if (z) {
            this.wk = new zzb(this.mContext);
            if (zzs.zzavm()) {
                zzarj();
            }
        } else {
            this.wk = null;
        }
        this.wl = new zzrh();
        this.wm = new HashMap();
        this.wn = new HashMap();
        this.wo = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzg(context, false);
    }

    /* access modifiers changed from: private */
    public Bitmap zza(C0007zza zza2) {
        if (this.wk == null) {
            return null;
        }
        return (Bitmap) this.wk.get(zza2);
    }

    @TargetApi(14)
    private void zzarj() {
        this.mContext.registerComponentCallbacks(new zze(this.wk));
    }

    public static ImageManager zzg(Context context, boolean z) {
        if (z) {
            if (wi == null) {
                wi = new ImageManager(context, true);
            }
            return wi;
        }
        if (wh == null) {
            wh = new ImageManager(context, false);
        }
        return wh;
    }

    public void loadImage(ImageView imageView, int i) {
        zza((zza) new com.google.android.gms.common.images.zza.zzb(imageView, i));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza((zza) new com.google.android.gms.common.images.zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        com.google.android.gms.common.images.zza.zzb zzb2 = new com.google.android.gms.common.images.zza.zzb(imageView, uri);
        zzb2.zzfu(i);
        zza((zza) zzb2);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza((zza) new com.google.android.gms.common.images.zza.zzc(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        com.google.android.gms.common.images.zza.zzc zzc2 = new com.google.android.gms.common.images.zza.zzc(onImageLoadedListener, uri);
        zzc2.zzfu(i);
        zza((zza) zzc2);
    }

    public void zza(zza zza2) {
        com.google.android.gms.common.internal.zzb.zzhj("ImageManager.loadImage() must be called in the main thread");
        new zzd(zza2).run();
    }
}
