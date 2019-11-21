package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    /* access modifiers changed from: private */
    public T LQ;
    /* access modifiers changed from: private */
    public Bundle LR;
    /* access modifiers changed from: private */
    public LinkedList<C0019zza> LS;
    private final zzf<T> LT = new zzf<T>() {
        public void zza(T t) {
            zza.this.LQ = t;
            Iterator it = zza.this.LS.iterator();
            while (it.hasNext()) {
                ((C0019zza) it.next()).zzb(zza.this.LQ);
            }
            zza.this.LS.clear();
            zza.this.LR = null;
        }
    };

    /* renamed from: com.google.android.gms.dynamic.zza$zza reason: collision with other inner class name */
    private interface C0019zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    private void zza(Bundle bundle, C0019zza zza) {
        if (this.LQ != null) {
            zza.zzb(this.LQ);
            return;
        }
        if (this.LS == null) {
            this.LS = new LinkedList<>();
        }
        this.LS.add(zza);
        if (bundle != null) {
            if (this.LR == null) {
                this.LR = (Bundle) bundle.clone();
            } else {
                this.LR.putAll(bundle);
            }
        }
        zza(this.LT);
    }

    public static void zzb(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String zzc = zzh.zzc(context, isGooglePlayServicesAvailable, GooglePlayServicesUtil.zzbv(context));
        String zzh = zzh.zzh(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(zzc);
        linearLayout.addView(textView);
        if (zzh != null) {
            Button button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(zzh);
            linearLayout.addView(button);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    context.startActivity(GooglePlayServicesUtil.zzfb(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void zzmz(int i) {
        while (!this.LS.isEmpty() && ((C0019zza) this.LS.getLast()).getState() >= i) {
            this.LS.removeLast();
        }
    }

    public void onCreate(final Bundle bundle) {
        zza(bundle, (C0019zza) new C0019zza() {
            public int getState() {
                return 1;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.LQ.onCreate(bundle);
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        final LayoutInflater layoutInflater2 = layoutInflater;
        final ViewGroup viewGroup2 = viewGroup;
        final Bundle bundle2 = bundle;
        zza(bundle, (C0019zza) new C0019zza() {
            public int getState() {
                return 2;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(zza.this.LQ.onCreateView(layoutInflater2, viewGroup2, bundle2));
            }
        });
        if (this.LQ == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.LQ != null) {
            this.LQ.onDestroy();
        } else {
            zzmz(1);
        }
    }

    public void onDestroyView() {
        if (this.LQ != null) {
            this.LQ.onDestroyView();
        } else {
            zzmz(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        zza(bundle2, (C0019zza) new C0019zza() {
            public int getState() {
                return 0;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.LQ.onInflate(activity, bundle, bundle2);
            }
        });
    }

    public void onLowMemory() {
        if (this.LQ != null) {
            this.LQ.onLowMemory();
        }
    }

    public void onPause() {
        if (this.LQ != null) {
            this.LQ.onPause();
        } else {
            zzmz(5);
        }
    }

    public void onResume() {
        zza((Bundle) null, (C0019zza) new C0019zza() {
            public int getState() {
                return 5;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.LQ.onResume();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.LQ != null) {
            this.LQ.onSaveInstanceState(bundle);
        } else if (this.LR != null) {
            bundle.putAll(this.LR);
        }
    }

    public void onStart() {
        zza((Bundle) null, (C0019zza) new C0019zza() {
            public int getState() {
                return 4;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.LQ.onStart();
            }
        });
    }

    public void onStop() {
        if (this.LQ != null) {
            this.LQ.onStop();
        } else {
            zzmz(4);
        }
    }

    /* access modifiers changed from: protected */
    public void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzf<T> zzf);

    public T zzbcr() {
        return this.LQ;
    }
}
