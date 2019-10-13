package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

@KeepName
public class SignInHubActivity extends FragmentActivity {
    private zzk eo;
    private SignInConfiguration ep;
    private boolean eq;
    /* access modifiers changed from: private */
    public int er;
    /* access modifiers changed from: private */
    public Intent es;

    private class zza implements LoaderCallbacks<Void> {
        private zza() {
        }

        public Loader<Void> onCreateLoader(int i, Bundle bundle) {
            return new zzb(SignInHubActivity.this, GoogleApiClient.zzaob());
        }

        public void onLoaderReset(Loader<Void> loader) {
        }

        /* renamed from: zza */
        public void onLoadFinished(Loader<Void> loader, Void voidR) {
            SignInHubActivity.this.setResult(SignInHubActivity.this.er, SignInHubActivity.this.es);
            SignInHubActivity.this.finish();
        }
    }

    private void zza(int i, Intent intent) {
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
            if (signInAccount != null && signInAccount.zzafw() != null) {
                GoogleSignInAccount zzafw = signInAccount.zzafw();
                this.eo.zzb(zzafw, this.ep.zzagh());
                intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                intent.putExtra("googleSignInAccount", zzafw);
                this.eq = true;
                this.er = i;
                this.es = intent;
                zzagi();
                return;
            } else if (intent.hasExtra("errorCode")) {
                zzde(intent.getIntExtra("errorCode", 8));
                return;
            }
        }
        zzde(8);
    }

    private void zzagi() {
        getSupportLoaderManager().initLoader(0, null, new zza());
    }

    private void zzde(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
    }

    private void zzj(Intent intent) {
        intent.setPackage("com.google.android.gms");
        intent.putExtra("config", this.ep);
        try {
            startActivityForResult(intent, 40962);
        } catch (ActivityNotFoundException e) {
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            zzde(8);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        setResult(0);
        switch (i) {
            case 40962:
                zza(i2, intent);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eo = zzk.zzbc(this);
        Intent intent = getIntent();
        if (!"com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(intent.getAction())) {
            String str = "AuthSignInClient";
            String str2 = "Unknown action: ";
            String valueOf = String.valueOf(intent.getAction());
            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            finish();
        }
        this.ep = (SignInConfiguration) intent.getParcelableExtra("config");
        if (this.ep == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
        } else if (bundle == null) {
            zzj(new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN"));
        } else {
            this.eq = bundle.getBoolean("signingInGoogleApiClients");
            if (this.eq) {
                this.er = bundle.getInt("signInResultCode");
                this.es = (Intent) bundle.getParcelable("signInResultData");
                zzagi();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.eq);
        if (this.eq) {
            bundle.putInt("signInResultCode", this.er);
            bundle.putParcelable("signInResultData", this.es);
        }
    }
}
