package justthetip.ivellapplication.com.justthetip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class OnTheFlyActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public EditText newTableEditText;
    /* access modifiers changed from: private */
    public EditText newTipEditText;
    /* access modifiers changed from: private */
    public EditText newTipShareEditText;
    private Button quickTipSaveButton;
    private Button tipShareSaveButton;

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_fly);
        this.newTipEditText = (EditText) findViewById(R.id.activity_fly_newTipEditText);
        this.newTableEditText = (EditText) findViewById(R.id.activity_fly_newTableEditText);
        this.newTipShareEditText = (EditText) findViewById(R.id.activity_fly_newTipShareEditText);
        this.quickTipSaveButton = (Button) findViewById(R.id.activity_fly_quickTipSaveButton);
        this.tipShareSaveButton = (Button) findViewById(R.id.activity_fly_tipShareSaveButton);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.quickTipSaveButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                int tableInput = Integer.valueOf(OnTheFlyActivity.this.newTableEditText.getText().toString()).intValue();
                double tipInput = Double.valueOf(OnTheFlyActivity.this.newTipEditText.getText().toString()).doubleValue();
                ArrayList<Integer> table = new ArrayList<>();
                ArrayList<Double> tip = new ArrayList<>();
                table.add(Integer.valueOf(tableInput));
                tip.add(Double.valueOf(tipInput));
                OnTheFlyActivity.this.newTableEditText.setText("");
                OnTheFlyActivity.this.newTipEditText.setText("");
                new DBHandler().updateDatabase(tip, table);
            }
        });
        this.tipShareSaveButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                double tipShareInput = Double.valueOf(OnTheFlyActivity.this.newTipShareEditText.getText().toString()).doubleValue();
                OnTheFlyActivity.this.newTipShareEditText.setText("");
                new DBHandler().updateTipShare(tipShareInput);
            }
        });
    }
}
