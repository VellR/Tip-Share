package justthetip.ivellapplication.com.justthetip;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MotivatedActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public Bundle extras;
    /* access modifiers changed from: private */
    public EditText goalInput;
    /* access modifiers changed from: private */
    public float goalInputFloat;
    /* access modifiers changed from: private */
    public Intent intent;
    private Button startSessionButton;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_goal);
        this.goalInput = (EditText) findViewById(R.id.goal_activity_goalInput);
        this.startSessionButton = (Button) findViewById(R.id.goal_activity_startSessionButton);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.intent = new Intent(this, NewSession.class);
        this.extras = new Bundle();
        SharedPreferences preferences = getSharedPreferences("SessionPreference", 0);
        boolean sessionActive = preferences.getBoolean("sessionActive", false);
        float goal = preferences.getFloat("goal", 0.0f);
        float currentProgress = preferences.getFloat("currentProgress", 0.0f);
        float oldTips = preferences.getFloat("oldTips", 0.0f);
        if (sessionActive) {
            this.extras.putFloat("goalInputFloat", goal);
            this.extras.putFloat("currentProgress", currentProgress);
            this.extras.putFloat("oldTips", oldTips);
            this.intent.putExtras(this.extras);
            startActivity(this.intent);
            finish();
        }
        this.startSessionButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (MotivatedActivity.this.goalInput.getText().toString().length() == 0) {
                    Toast.makeText(MotivatedActivity.this, "Please input a goal!", 0).show();
                    return;
                }
                MotivatedActivity.this.goalInputFloat = Float.valueOf(MotivatedActivity.this.goalInput.getText().toString()).floatValue();
                MotivatedActivity.this.extras.putFloat("goalInputFloat", MotivatedActivity.this.goalInputFloat);
                MotivatedActivity.this.intent.putExtras(MotivatedActivity.this.extras);
                MotivatedActivity.this.startActivity(MotivatedActivity.this.intent);
                MotivatedActivity.this.finish();
            }
        });
    }
}
