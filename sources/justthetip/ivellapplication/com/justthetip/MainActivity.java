package justthetip.ivellapplication.com.justthetip;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private AuthStateListener mAuthListener;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        this.mAuthListener = new AuthStateListener() {
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d("TAG", "onAuthStateChanged:signed_in:" + user.getUid());
                    MainActivity.this.startActivity(new Intent(MainActivity.this, WeekPeekActivity.class));
                    MainActivity.this.finish();
                    return;
                }
                Log.d("TAG", "onAuthStateChanged:signed_out");
                MainActivity.this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
                MainActivity.this.finish();
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mAuth.addAuthStateListener(this.mAuthListener);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (this.mAuthListener != null) {
            this.mAuth.removeAuthStateListener(this.mAuthListener);
        }
    }
}
