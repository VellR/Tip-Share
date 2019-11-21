package justthetip.ivellapplication.com.justthetip;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewSession extends BaseActivity {
    /* access modifiers changed from: private */
    public Boolean achievementState = Boolean.valueOf(false);
    private Bundle bundle;
    /* access modifiers changed from: private */
    public Float currentProgress = Float.valueOf(0.0f);
    /* access modifiers changed from: private */
    public Float currentTips = Float.valueOf(0.0f);
    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    /* access modifiers changed from: private */
    public Editor editor;
    /* access modifiers changed from: private */
    public Float goal = Float.valueOf(0.0f);
    /* access modifiers changed from: private */
    public FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private AuthStateListener mAuthListener;
    private DatabaseReference mDatabase;
    /* access modifiers changed from: private */
    public String mEmail;
    /* access modifiers changed from: private */
    public String mId;
    /* access modifiers changed from: private */
    public String mUserName;
    /* access modifiers changed from: private */
    public Float newTip = Float.valueOf(0.0f);
    /* access modifiers changed from: private */
    public Float oldProgress = Float.valueOf(0.0f);
    /* access modifiers changed from: private */
    public Float oldTips = Float.valueOf(0.0f);
    /* access modifiers changed from: private */
    public CircularProgressBar progressBar;
    /* access modifiers changed from: private */
    public TextView progressText;
    /* access modifiers changed from: private */
    public boolean sessionActive = false;
    private Button stopButton;
    /* access modifiers changed from: private */
    public final ArrayList<Integer> tableArr = new ArrayList<>();
    /* access modifiers changed from: private */
    public final ArrayList<String> timeArr = new ArrayList<>();
    /* access modifiers changed from: private */
    public SimpleDateFormat timeStyle = new SimpleDateFormat("yyyy MMM dd EEE HH:mm:ss a");
    /* access modifiers changed from: private */
    public final ArrayList<Double> tipsArr = new ArrayList<>();
    private Button updateButton;
    /* access modifiers changed from: private */
    public EditText updateEditText;
    /* access modifiers changed from: private */
    public EditText updateEditTextTable;
    /* access modifiers changed from: private */
    public Float updateProgress = Float.valueOf(0.0f);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_new_session);
        this.bundle = new Bundle();
        this.bundle = getIntent().getExtras();
        this.goal = Float.valueOf(this.bundle.getFloat("goalInputFloat"));
        this.currentProgress = Float.valueOf(this.bundle.getFloat("currentProgress"));
        this.oldTips = Float.valueOf(this.bundle.getFloat("oldTips"));
        this.currentTips = this.oldTips;
        this.updateButton = (Button) findViewById(R.id.new_session_updateButton);
        this.stopButton = (Button) findViewById(R.id.new_session_stopButton);
        this.progressBar = (CircularProgressBar) findViewById(R.id.new_sessions_circleProgress);
        this.updateEditText = (EditText) findViewById(R.id.new_session_updateEditText);
        this.updateEditTextTable = (EditText) findViewById(R.id.new_session_updateEditTextTable);
        this.progressText = (TextView) findViewById(R.id.new_session_updateTextView);
        this.mDatabase = FirebaseDatabase.getInstance().getReference();
        this.sessionActive = true;
        if (this.editor == null) {
            this.editor = getSharedPreferences("SessionPreference", 0).edit();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.progressBar.setProgressWithAnimation(this.currentProgress.floatValue());
        this.progressText.setText("$" + this.currentTips + "/" + "$" + this.goal);
        this.updateEditText.setText("");
        this.updateEditTextTable.setText("");
        this.mAuthListener = new AuthStateListener() {
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    NewSession.this.mId = NewSession.this.mAuth.getCurrentUser().getUid();
                    NewSession.this.mUserName = NewSession.this.mAuth.getCurrentUser().getEmail();
                    NewSession.this.mUserName = NewSession.this.mUserName.split("\\@")[0];
                    NewSession.this.mEmail = NewSession.this.mAuth.getCurrentUser().getEmail();
                    NewSession.this.writeNewUser(NewSession.this.mId, NewSession.this.mUserName, NewSession.this.mEmail);
                    return;
                }
                NewSession.this.startActivity(new Intent(NewSession.this, MainActivity.class));
                NewSession.this.finish();
            }
        };
        this.updateButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                float tipInput = Float.valueOf(String.valueOf(NewSession.this.updateEditText.getText())).floatValue();
                int tableInput = Integer.valueOf(NewSession.this.updateEditTextTable.getText().toString()).intValue();
                NewSession.this.updateEditText.setText("");
                NewSession.this.updateEditTextTable.setText("");
                if (NewSession.this.progressBar.getProgress() == 0.0f) {
                    NewSession.this.currentProgress = Float.valueOf(NewSession.this.calculateProgress(tipInput, NewSession.this.goal.floatValue()));
                    NewSession.this.progressBar.setProgressWithAnimation(NewSession.this.currentProgress.floatValue());
                    NewSession.this.oldProgress = NewSession.this.currentProgress;
                    NewSession.this.currentTips = Float.valueOf(tipInput);
                    NewSession.this.oldTips = NewSession.this.currentTips;
                    NewSession.this.progressText.setText("$" + NewSession.this.currentTips + "/" + "$" + NewSession.this.goal);
                    NewSession.this.timeArr.add(String.valueOf(NewSession.this.timeStyle.format(new Date())));
                    NewSession.this.tipsArr.add(Double.valueOf(NewSession.this.currentTips.toString()));
                    NewSession.this.tableArr.add(Integer.valueOf(tableInput));
                    ArrayList<Integer> table = new ArrayList<>();
                    ArrayList<Double> tip = new ArrayList<>();
                    table.add(Integer.valueOf(tableInput));
                    tip.add(Double.valueOf((double) tipInput));
                    new DBHandler().updateDatabase(tip, table);
                } else {
                    NewSession.this.currentTips = Float.valueOf(NewSession.this.oldTips.floatValue() + tipInput);
                    NewSession.this.newTip = Float.valueOf(tipInput);
                    NewSession.this.oldTips = NewSession.this.currentTips;
                    NewSession.this.currentProgress = Float.valueOf(NewSession.this.calculateProgress(NewSession.this.currentTips.floatValue(), NewSession.this.goal.floatValue()));
                    NewSession.this.progressBar.setProgressWithAnimation(NewSession.this.currentProgress.floatValue());
                    NewSession.this.progressText.setText("$" + NewSession.this.currentTips + "/" + "$" + NewSession.this.goal);
                    NewSession.this.updateProgress = Float.valueOf(NewSession.this.oldProgress.floatValue() + NewSession.this.currentProgress.floatValue());
                    NewSession.this.currentProgress = NewSession.this.updateProgress;
                    NewSession.this.timeArr.add(String.valueOf(NewSession.this.timeStyle.format(new Date())));
                    NewSession.this.tipsArr.add(Double.valueOf(NewSession.this.newTip.toString()));
                    NewSession.this.tableArr.add(Integer.valueOf(tableInput));
                    ArrayList<Integer> table2 = new ArrayList<>();
                    ArrayList<Double> tip2 = new ArrayList<>();
                    table2.add(Integer.valueOf(tableInput));
                    tip2.add(Double.valueOf((double) tipInput));
                    new DBHandler().updateDatabase(tip2, table2);
                }
                if (NewSession.this.currentTips.floatValue() >= NewSession.this.goal.floatValue() && !NewSession.this.achievementState.booleanValue()) {
                    Toast.makeText(NewSession.this, "Goal Achieved!", 0).show();
                    NewSession.this.achievementState = Boolean.valueOf(true);
                }
            }
        });
        this.stopButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                NewSession.this.sessionActive = false;
                NewSession.this.editor.putBoolean("sessionActive", NewSession.this.sessionActive);
                NewSession.this.editor.apply();
                NewSession.this.startActivity(new Intent(NewSession.this, StatsActivity.class));
                NewSession.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ArrayList<String> tipsHolder = new ArrayList<>();
        for (int inc = 0; inc != this.tipsArr.size(); inc++) {
            tipsHolder.add(String.valueOf(this.tipsArr.get(inc)));
        }
        outState.putStringArrayList("tipsArr", tipsHolder);
        outState.putIntegerArrayList("tableArr", this.tableArr);
        outState.putStringArrayList("timeArr", this.timeArr);
        outState.putFloat("goal", this.goal.floatValue());
        outState.putFloat("oldTips", this.oldTips.floatValue());
        outState.putFloat("currentProgress", this.currentProgress.floatValue());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Log.d("Caroline", "Session Destroyed");
        if (this.sessionActive) {
            this.editor.putBoolean("sessionActive", this.sessionActive);
            this.editor.putFloat("goal", this.goal.floatValue());
            this.editor.putFloat("oldTips", this.oldTips.floatValue());
            this.editor.putFloat("currentProgress", this.currentProgress.floatValue());
            this.editor.apply();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<String> tipsHolder = savedInstanceState.getStringArrayList("tipsArr");
        ArrayList<Integer> tableHolder = savedInstanceState.getIntegerArrayList("tableArr");
        ArrayList<String> timeHolder = savedInstanceState.getStringArrayList("timeArr");
        for (int inc = 0; inc != tipsHolder.size(); inc++) {
            this.tipsArr.add(Double.valueOf(Double.valueOf(String.valueOf(tipsHolder.get(inc))).doubleValue()));
        }
        for (int inc2 = 0; inc2 != tableHolder.size(); inc2++) {
            this.tableArr.add(Integer.valueOf(Integer.valueOf(String.valueOf(tipsHolder.get(inc2))).intValue()));
        }
        for (int inc3 = 0; inc3 != timeHolder.size(); inc3++) {
            this.timeArr.add(String.valueOf(tipsHolder.get(inc3)));
        }
    }

    public float calculateProgress(float oldEarned, float goal2) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        this.currentProgress = Float.valueOf((oldEarned / goal2) * 100.0f);
        return Float.parseFloat(formatter.format(this.currentProgress));
    }

    /* access modifiers changed from: private */
    public void writeNewUser(String userId, String name, String email) {
        this.mDatabase.child("users").child(userId).setValue(new User(name, email));
        this.mDatabase.child("users").child(userId).child("username").setValue(name);
    }
}
