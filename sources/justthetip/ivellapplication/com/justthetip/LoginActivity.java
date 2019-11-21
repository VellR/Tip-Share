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
import com.victor.loading.rotate.RotateLoading;

public class LoginActivity extends Activity {
    /* access modifiers changed from: private */
    public EditText email;
    /* access modifiers changed from: private */
    public String emailTxt;
    /* access modifiers changed from: private */
    public RotateLoading loading;
    private Button loginButton;
    private FirebaseAuth mAuth;
    /* access modifiers changed from: private */
    public EditText password;
    /* access modifiers changed from: private */
    public String passwordTxt;
    private Button signUp;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mAuth = FirebaseAuth.getInstance();
        this.email = (EditText) findViewById(R.id.main_activity_email_editText);
        this.password = (EditText) findViewById(R.id.main_activity_password_editText);
        this.loginButton = (Button) findViewById(R.id.main_activity_login_button);
        this.signUp = (Button) findViewById(R.id.main_activity_register_button);
        this.loading = (RotateLoading) findViewById(R.id.rotateLoading);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.loginButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                LoginActivity.this.emailTxt = LoginActivity.this.email.getText().toString();
                LoginActivity.this.passwordTxt = LoginActivity.this.password.getText().toString();
                if (!LoginActivity.this.emailTxt.isEmpty() || !LoginActivity.this.passwordTxt.isEmpty()) {
                    LoginActivity.this.loading.start();
                    LoginActivity.this.signIn(LoginActivity.this.emailTxt, LoginActivity.this.passwordTxt);
                    return;
                }
                Toast.makeText(LoginActivity.this, "Please enter credentials.", 0).show();
            }
        });
        this.signUp.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    public void signIn(String email2, String password2) {
        this.mAuth.signInWithEmailAndPassword(email2, password2).addOnCompleteListener((Activity) this, (OnCompleteListener<TResult>) new OnCompleteListener<AuthResult>() {
            public void onComplete(@NonNull Task<AuthResult> task) {
                LoginActivity.this.loading.stop();
                Log.d("TAG", "signInWithEmail:onComplete:" + task.isSuccessful());
                if (task.isSuccessful()) {
                    LoginActivity.this.startActivity(new Intent(LoginActivity.this, WeekPeekActivity.class));
                    LoginActivity.this.finish();
                } else if (!task.isSuccessful()) {
                    Log.w("TAG", "signInWithEmail", task.getException());
                    Toast.makeText(LoginActivity.this, "Wrong Password or Username!", 0).show();
                }
            }
        });
    }
}
