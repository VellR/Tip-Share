package justthetip.ivellapplication.com.justthetip;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.BoomMenuButton.Builder;
import com.nightonke.boommenu.BoomMenuButton.OnSubButtonClickListener;
import com.nightonke.boommenu.Types.BoomType;
import com.nightonke.boommenu.Types.ButtonType;
import com.nightonke.boommenu.Types.PlaceType;
import com.nightonke.boommenu.Util;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class StatsActivity extends BaseActivity {
    private BoomMenuButton boomMenuButton;
    /* access modifiers changed from: private */
    public DBHandler dbHandler = new DBHandler();
    private boolean init = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_stats);
        this.boomMenuButton = (BoomMenuButton) findViewById(R.id.barCharts);
        Toast.makeText(this, "No chart selected", 1).show();
    }

    /* access modifiers changed from: private */
    public void switchGraph(Fragment fragment, ArrayList<Double> tips, ArrayList<Integer> tables, ArrayList<Integer> timeStat) {
        Bundle bundle = new Bundle();
        if (tips != null) {
            ArrayList<String> tipHolder = new ArrayList<>();
            for (int tipsInc = 0; tips.size() != tipsInc; tipsInc++) {
                tipHolder.add(String.valueOf(tips.get(tipsInc)));
            }
            bundle.putStringArrayList("tipsArr", tipHolder);
            bundle.putIntegerArrayList("tablesArr", tables);
            bundle.putIntegerArrayList("timeStat", timeStat);
            fragment.setArguments(bundle);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_stats_framelayout, fragment);
            transaction.commit();
            return;
        }
        Toast.makeText(this, "No available data!", 1).show();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.dbHandler.Day();
        this.dbHandler.Week();
        this.dbHandler.Month();
        this.dbHandler.Year();
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!this.init) {
            this.init = true;
            int[][] subButtonColors = (int[][]) Array.newInstance(Integer.TYPE, new int[]{3, 2});
            for (int i = 0; i < 3; i++) {
                subButtonColors[i][1] = ContextCompat.getColor(this, R.color.window_background);
                subButtonColors[i][0] = ContextCompat.getColor(this, R.color.primary_text_color);
            }
            new Builder().addSubButton(ContextCompat.getDrawable(this, R.drawable.main_bg), subButtonColors[0], "Today").addSubButton(ContextCompat.getDrawable(this, R.drawable.main_bg), subButtonColors[0], "Week").addSubButton(ContextCompat.getDrawable(this, R.drawable.main_bg), subButtonColors[0], "Month").addSubButton(ContextCompat.getDrawable(this, R.drawable.main_bg), subButtonColors[0], "Year").button(ButtonType.HAM).boom(BoomType.PARABOLA).place(PlaceType.HAM_4_1).subButtonTextColor(ContextCompat.getColor(this, R.color.window_background)).subButtonsShadow(Util.getInstance().dp2px(2.0f), Util.getInstance().dp2px(2.0f)).init(this.boomMenuButton).setOnSubButtonClickListener(new OnSubButtonClickListener() {
                public void onClick(int buttonIndex) {
                    if (buttonIndex == 0) {
                        StatsActivity.this.switchGraph(new TodayFragment(), StatsActivity.this.dbHandler.getDayTip(), StatsActivity.this.dbHandler.getDayTable(), StatsActivity.this.dbHandler.getDayTime());
                    } else if (buttonIndex == 1) {
                        StatsActivity.this.switchGraph(new WeekFragment(), StatsActivity.this.dbHandler.getWeekTip(), StatsActivity.this.dbHandler.getWeekTable(), StatsActivity.this.dbHandler.getWeekTime());
                    } else if (buttonIndex == 2) {
                        StatsActivity.this.switchGraph(new MonthFragment(), StatsActivity.this.dbHandler.getMonthTip(), StatsActivity.this.dbHandler.getMonthTable(), StatsActivity.this.dbHandler.getMonthTime());
                    } else if (buttonIndex == 3) {
                        StatsActivity.this.switchGraph(new YearFragment(), StatsActivity.this.dbHandler.getYearTip(), StatsActivity.this.dbHandler.getYearTable(), StatsActivity.this.dbHandler.getYearTime());
                    }
                }
            });
        }
    }
}
