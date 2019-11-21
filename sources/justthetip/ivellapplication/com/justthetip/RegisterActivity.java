package justthetip.ivellapplication.com.justthetip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.auth.FirebaseUser;
import com.victor.loading.rotate.RotateLoading;

public class RegisterActivity extends Activity {
    private Button confirmButton;
    /* access modifiers changed from: private */
    public EditText email;
    /* access modifiers changed from: private */
    public String emailTxt;
    /* access modifiers changed from: private */
    public RotateLoading loading;
    private FirebaseAuth mAuth;
    private AuthStateListener mAuthListener;
    /* access modifiers changed from: private */
    public EditText password;
    /* access modifiers changed from: private */
    public EditText passwordConfirm;
    /* access modifiers changed from: private */
    public String passwordConfirmTxt;
    /* access modifiers changed from: private */
    public String passwordTxt;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        this.mAuth = FirebaseAuth.getInstance();
        this.password = (EditText) findViewById(R.id.register_activity_password_editText);
        this.passwordConfirm = (EditText) findViewById(R.id.register_activity_passwordConfirm_editText);
        this.email = (EditText) findViewById(R.id.register_activity_email_editText);
        this.confirmButton = (Button) findViewById(R.id.register_activity_confirm_button);
        this.loading = (RotateLoading) findViewById(R.id.rotateLoading);
        this.mAuthListener = new AuthStateListener() {
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d("TAG", "onAuthStateChanged:signed_in" + user.getUid());
                } else {
                    Log.d("TAG", "onAuthStateChanged:signed_out");
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mAuth.removeAuthStateListener(this.mAuthListener);
        this.confirmButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                RegisterActivity.this.passwordTxt = RegisterActivity.this.password.getText().toString();
                RegisterActivity.this.passwordConfirmTxt = RegisterActivity.this.passwordConfirm.getText().toString();
                RegisterActivity.this.emailTxt = RegisterActivity.this.email.getText().toString();
                if ((RegisterActivity.this.emailTxt.equals("") && RegisterActivity.this.passwordTxt.equals("")) || RegisterActivity.this.emailTxt.equals("") || RegisterActivity.this.passwordTxt.equals("")) {
                    Toast.makeText(RegisterActivity.this.getApplicationContext(), "Please complete the sign up form", 1).show();
                } else if (!RegisterActivity.this.passwordTxt.equals(RegisterActivity.this.passwordConfirmTxt)) {
                    Toast.makeText(RegisterActivity.this.getApplicationContext(), "Password doesn't match", 1).show();
                } else {
                    RegisterActivity.this.loading.start();
                    RegisterActivity.this.register(RegisterActivity.this.emailTxt, RegisterActivity.this.passwordConfirmTxt);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (this.mAuthListener != null) {
            this.mAuth.removeAuthStateListener(this.mAuthListener);
        }
    }

    public void register(String email2, String password2) {
        this.mAuth.createUserWithEmailAndPassword(email2, password2).addOnCompleteListener((Activity) this, (OnCompleteListener<TResult>) new OnCompleteListener<AuthResult>() {
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("TAG", "createUserWithEmail: onComplete:" + task.isSuccessful());
                if (task.isSuccessful()) {
                    RegisterActivity.this.loading.stop();
                    RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    RegisterActivity.this.finish();
                } else if (!task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Authentication failed.", 0).show();
                }
            }
        });
    }
}
