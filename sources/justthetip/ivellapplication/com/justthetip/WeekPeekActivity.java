package justthetip.ivellapplication.com.justthetip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.victor.loading.rotate.RotateLoading;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeekPeekActivity extends BaseActivity implements OnClickListener {
    /* access modifiers changed from: private */
    public Date date = new Date();
    /* access modifiers changed from: private */
    public DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    /* access modifiers changed from: private */
    public DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    /* access modifiers changed from: private */
    public TextView focusedDayTextView;
    /* access modifiers changed from: private */
    public DateFormat formatDayOfTheWeek = new SimpleDateFormat("EEE");
    /* access modifiers changed from: private */
    public ArrayList<String> friHoursEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double friSum = 0.0d;
    /* access modifiers changed from: private */
    public double friSumEst = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Integer> friTables = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Integer> friTablesEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double friTipShare = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Double> friTips = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Double> friTipsEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double friTot = 0.0d;
    /* access modifiers changed from: private */
    public String friWorkHours;
    /* access modifiers changed from: private */
    public String friWorkHoursEst;
    /* access modifiers changed from: private */
    public List<Integer> friWorkTables = new ArrayList();
    /* access modifiers changed from: private */
    public List<Integer> friWorkTablesEst = new ArrayList();
    private RelativeLayout fridayLayout;
    private TextView fridayTextView;
    /* access modifiers changed from: private */
    public TextView fridayTipTextView;
    RotateLoading loadingIcon;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference mIdRef = this.mPostRef.child(this.mAuth.getCurrentUser().getUid());
    private DatabaseReference mMonthRef = this.mIdRef.child(this.year + "/" + this.month);
    private DatabaseReference mPostRef = this.mRootRef.child("user-posts");
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference mWeekRef = this.mIdRef.child(this.year + "/" + this.month + "/" + this.week);
    /* access modifiers changed from: private */
    public ArrayList<String> monHoursEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double monSum = 0.0d;
    /* access modifiers changed from: private */
    public double monSumEst = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Integer> monTables = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Integer> monTablesEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double monTipShare = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Double> monTips = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Double> monTipsEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double monTot = 0.0d;
    /* access modifiers changed from: private */
    public String monWorkHours;
    /* access modifiers changed from: private */
    public String monWorkHoursEst;
    /* access modifiers changed from: private */
    public List<Integer> monWorkTables = new ArrayList();
    /* access modifiers changed from: private */
    public List<Integer> monWorkTablesEst = new ArrayList();
    private RelativeLayout mondayLayout;
    private TextView mondayTextView;
    /* access modifiers changed from: private */
    public TextView mondayTipTextView;
    /* access modifiers changed from: private */
    public String month = new SimpleDateFormat("MM").format(this.date);
    /* access modifiers changed from: private */
    public ArrayList<String> satHoursEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double satSum = 0.0d;
    /* access modifiers changed from: private */
    public double satSumEst = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Integer> satTables = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Integer> satTablesEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double satTipShare = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Double> satTips = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Double> satTipsEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double satTot = 0.0d;
    /* access modifiers changed from: private */
    public String satWorkHours;
    /* access modifiers changed from: private */
    public String satWorkHoursEst;
    /* access modifiers changed from: private */
    public List<Integer> satWorkTables = new ArrayList();
    /* access modifiers changed from: private */
    public List<Integer> satWorkTablesEst = new ArrayList();
    private RelativeLayout saturdayLayout;
    private TextView saturdayTextView;
    /* access modifiers changed from: private */
    public TextView saturdayTipTextView;
    /* access modifiers changed from: private */
    public ArrayList<String> sunHoursEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double sunSum = 0.0d;
    /* access modifiers changed from: private */
    public double sunSumEst = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Integer> sunTables = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Integer> sunTablesEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double sunTipShare = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Double> sunTips = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Double> sunTipsEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double sunTot = 0.0d;
    /* access modifiers changed from: private */
    public String sunWorkHours;
    /* access modifiers changed from: private */
    public String sunWorkHoursEst;
    /* access modifiers changed from: private */
    public List<Integer> sunWorkTables = new ArrayList();
    /* access modifiers changed from: private */
    public List<Integer> sunWorkTablesEst = new ArrayList();
    private RelativeLayout sundayLayout;
    private TextView sundayTextView;
    /* access modifiers changed from: private */
    public TextView sundayTipTextView;
    /* access modifiers changed from: private */
    public TextView tablesActualTextView;
    /* access modifiers changed from: private */
    public TextView tablesEstTextView;
    /* access modifiers changed from: private */
    public ArrayList<String> thuHoursEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double thuSum = 0.0d;
    /* access modifiers changed from: private */
    public double thuSumEst = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Integer> thuTables = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Integer> thuTablesEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double thuTipShare = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Double> thuTips = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Double> thuTipsEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double thuTot = 0.0d;
    /* access modifiers changed from: private */
    public String thuWorkHours;
    /* access modifiers changed from: private */
    public String thuWorkHoursEst;
    /* access modifiers changed from: private */
    public List<Integer> thuWorkTables = new ArrayList();
    /* access modifiers changed from: private */
    public List<Integer> thuWorkTablesEst = new ArrayList();
    private RelativeLayout thursdayLayout;
    private TextView thursdayTextView;
    /* access modifiers changed from: private */
    public TextView thursdayTipTextView;
    /* access modifiers changed from: private */
    public TextView timesActualTextView;
    /* access modifiers changed from: private */
    public TextView timesEstTextView;
    /* access modifiers changed from: private */
    public TextView tipsActualTextView;
    /* access modifiers changed from: private */
    public TextView tipsEstTextView;
    /* access modifiers changed from: private */
    public ArrayList<String> tueHoursEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double tueSum = 0.0d;
    /* access modifiers changed from: private */
    public double tueSumEst = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Integer> tueTables = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Integer> tueTablesEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double tueTipShare = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Double> tueTips = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Double> tueTipsEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double tueTot = 0.0d;
    /* access modifiers changed from: private */
    public String tueWorkHours;
    /* access modifiers changed from: private */
    public String tueWorkHoursEst;
    /* access modifiers changed from: private */
    public List<Integer> tueWorkTables = new ArrayList();
    /* access modifiers changed from: private */
    public List<Integer> tueWorkTablesEst = new ArrayList();
    private RelativeLayout tuesdayLayout;
    private TextView tuesdayTextView;
    /* access modifiers changed from: private */
    public TextView tuesdayTipTextView;
    /* access modifiers changed from: private */
    public ArrayList<String> wedHoursEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double wedSum = 0.0d;
    /* access modifiers changed from: private */
    public double wedSumEst = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Integer> wedTables = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Integer> wedTablesEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double wedTipShare = 0.0d;
    /* access modifiers changed from: private */
    public ArrayList<Double> wedTips = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Double> wedTipsEst = new ArrayList<>();
    /* access modifiers changed from: private */
    public double wedTot = 0.0d;
    /* access modifiers changed from: private */
    public String wedWorkHours;
    /* access modifiers changed from: private */
    public String wedWorkHoursEst;
    /* access modifiers changed from: private */
    public List<Integer> wedWorkTables = new ArrayList();
    /* access modifiers changed from: private */
    public List<Integer> wedWorkTablesEst = new ArrayList();
    private RelativeLayout wednesdayLayout;
    private TextView wednesdayTextView;
    /* access modifiers changed from: private */
    public TextView wednesdayTipTextView;
    private String week = new SimpleDateFormat("W").format(this.date);
    private double weekSum = 0.0d;
    /* access modifiers changed from: private */
    public double weekSumEst = 0.0d;
    /* access modifiers changed from: private */
    public double weekTipShare = 0.0d;
    /* access modifiers changed from: private */
    public double weekTot = 0.0d;
    /* access modifiers changed from: private */
    public String weekWorkHours;
    /* access modifiers changed from: private */
    public String weekWorkHoursEst;
    /* access modifiers changed from: private */
    public List<Integer> weekWorkTables = new ArrayList();
    /* access modifiers changed from: private */
    public List<Integer> weekWorkTablesEst = new ArrayList();
    /* access modifiers changed from: private */
    public String year = new SimpleDateFormat("yyyy").format(this.date);

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_week_peek);
        this.sundayTextView = (TextView) findViewById(R.id.day_item_sunday);
        this.mondayTextView = (TextView) findViewById(R.id.day_item_monday);
        this.tuesdayTextView = (TextView) findViewById(R.id.day_item_tuesday);
        this.wednesdayTextView = (TextView) findViewById(R.id.day_item_wednesday);
        this.thursdayTextView = (TextView) findViewById(R.id.day_item_thursday);
        this.fridayTextView = (TextView) findViewById(R.id.day_item_friday);
        this.saturdayTextView = (TextView) findViewById(R.id.day_item_saturday);
        this.focusedDayTextView = (TextView) findViewById(R.id.week_peek_focusDay);
        this.sundayTipTextView = (TextView) findViewById(R.id.day_item_tip_sunday);
        this.mondayTipTextView = (TextView) findViewById(R.id.day_item_tip_monday);
        this.tuesdayTipTextView = (TextView) findViewById(R.id.day_item_tip_tuesday);
        this.wednesdayTipTextView = (TextView) findViewById(R.id.day_item_tip_wednesday);
        this.thursdayTipTextView = (TextView) findViewById(R.id.day_item_tip_thursday);
        this.fridayTipTextView = (TextView) findViewById(R.id.day_item_tip_friday);
        this.saturdayTipTextView = (TextView) findViewById(R.id.day_item_tip_saturday);
        this.sundayLayout = (RelativeLayout) findViewById(R.id.week_peek_sunday);
        this.mondayLayout = (RelativeLayout) findViewById(R.id.week_peek_monday);
        this.tuesdayLayout = (RelativeLayout) findViewById(R.id.week_peek_tuesday);
        this.wednesdayLayout = (RelativeLayout) findViewById(R.id.week_peek_wednesday);
        this.thursdayLayout = (RelativeLayout) findViewById(R.id.week_peek_thursday);
        this.fridayLayout = (RelativeLayout) findViewById(R.id.week_peek_friday);
        this.saturdayLayout = (RelativeLayout) findViewById(R.id.week_peek_saturday);
        this.tipsActualTextView = (TextView) findViewById(R.id.week_peek_actual_tips);
        this.tablesActualTextView = (TextView) findViewById(R.id.week_peek_actual_tables);
        this.timesActualTextView = (TextView) findViewById(R.id.week_peek_actual_times);
        this.tipsEstTextView = (TextView) findViewById(R.id.week_peek_projected_tips);
        this.tablesEstTextView = (TextView) findViewById(R.id.week_peek_projected_tables);
        this.timesEstTextView = (TextView) findViewById(R.id.week_peek_projected_times);
        this.loadingIcon = (RotateLoading) findViewById(R.id.loadingRotate);
        this.sundayLayout.setOnClickListener(this);
        this.mondayLayout.setOnClickListener(this);
        this.tuesdayLayout.setOnClickListener(this);
        this.wednesdayLayout.setOnClickListener(this);
        this.thursdayLayout.setOnClickListener(this);
        this.fridayLayout.setOnClickListener(this);
        this.saturdayLayout.setOnClickListener(this);
        changeFocus();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.loadingIcon.start();
        this.mWeekRef.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (int dayInc = 0; dayInc <= 9; dayInc++) {
                    if (dataSnapshot.child("0" + dayInc).exists()) {
                        try {
                            WeekPeekActivity.this.date = WeekPeekActivity.this.dateFormat.parse(WeekPeekActivity.this.year + "-" + WeekPeekActivity.this.month + "-" + "0" + dayInc);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        String day = WeekPeekActivity.this.formatDayOfTheWeek.format(WeekPeekActivity.this.date);
                        if (day.equals("Sun")) {
                            ArrayList<Double> tipHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tips").getValue();
                            ArrayList<Integer> tableHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").exists()) {
                                WeekPeekActivity.this.sunTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.sunTips.addAll(tipHolder);
                            WeekPeekActivity.this.sunTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder = new ArrayList<>();
                            for (int timeInc = 0; timeInc <= 9; timeInc++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("0" + timeInc).exists()) {
                                    timeHolder.add(Integer.valueOf(timeInc));
                                }
                            }
                            for (int timeInc2 = 10; timeInc2 <= 24; timeInc2++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child(String.valueOf(timeInc2)).exists()) {
                                    timeHolder.add(Integer.valueOf(timeInc2));
                                }
                            }
                            String startHour = WeekPeekActivity.this.hourConverter(((Integer) timeHolder.get(0)).intValue());
                            String endHour = "";
                            if (timeHolder.size() > 1) {
                                endHour = WeekPeekActivity.this.hourConverter(((Integer) timeHolder.get(timeHolder.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.sunWorkHours = startHour + "-" + endHour;
                            WeekPeekActivity.this.sunTables.addAll(tableHolder);
                        } else if (day.equals("Mon")) {
                            ArrayList<Double> tipHolder2 = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tips").getValue();
                            ArrayList<Integer> tableHolder2 = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").exists()) {
                                WeekPeekActivity.this.monTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.monTips.addAll(tipHolder2);
                            WeekPeekActivity.this.monTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder2 = new ArrayList<>();
                            for (int timeInc3 = 0; timeInc3 <= 9; timeInc3++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("0" + timeInc3).exists()) {
                                    timeHolder2.add(Integer.valueOf(timeInc3));
                                }
                            }
                            for (int timeInc4 = 10; timeInc4 <= 24; timeInc4++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child(String.valueOf(timeInc4)).exists()) {
                                    timeHolder2.add(Integer.valueOf(timeInc4));
                                }
                            }
                            String startHour2 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder2.get(0)).intValue());
                            String endHour2 = "";
                            if (timeHolder2.size() > 1) {
                                endHour2 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder2.get(timeHolder2.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.monWorkHours = startHour2 + "-" + endHour2;
                            WeekPeekActivity.this.monTables.addAll(tableHolder2);
                        } else if (day.equals("Tue")) {
                            ArrayList<Double> tipHolder3 = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tips").getValue();
                            ArrayList<Integer> tableHolder3 = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").exists()) {
                                WeekPeekActivity.this.tueTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.tueTips.addAll(tipHolder3);
                            WeekPeekActivity.this.tueTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder3 = new ArrayList<>();
                            for (int timeInc5 = 0; timeInc5 <= 9; timeInc5++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("0" + timeInc5).exists()) {
                                    timeHolder3.add(Integer.valueOf(timeInc5));
                                }
                            }
                            for (int timeInc6 = 10; timeInc6 <= 24; timeInc6++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child(String.valueOf(timeInc6)).exists()) {
                                    timeHolder3.add(Integer.valueOf(timeInc6));
                                }
                            }
                            String startHour3 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder3.get(0)).intValue());
                            String endHour3 = "";
                            if (timeHolder3.size() > 1) {
                                endHour3 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder3.get(timeHolder3.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.tueWorkHours = startHour3 + "-" + endHour3;
                            WeekPeekActivity.this.tueTables.addAll(tableHolder3);
                        } else if (day.equals("Wed")) {
                            ArrayList<Double> tipHolder4 = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tips").getValue();
                            ArrayList<Integer> tableHolder4 = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").exists()) {
                                WeekPeekActivity.this.wedTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.wedTips.addAll(tipHolder4);
                            WeekPeekActivity.this.wedTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder4 = new ArrayList<>();
                            for (int timeInc7 = 0; timeInc7 <= 9; timeInc7++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("0" + timeInc7).exists()) {
                                    timeHolder4.add(Integer.valueOf(timeInc7));
                                }
                            }
                            for (int timeInc8 = 10; timeInc8 <= 24; timeInc8++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child(String.valueOf(timeInc8)).exists()) {
                                    timeHolder4.add(Integer.valueOf(timeInc8));
                                }
                            }
                            String startHour4 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder4.get(0)).intValue());
                            String endHour4 = "";
                            if (timeHolder4.size() > 1) {
                                endHour4 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder4.get(timeHolder4.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.wedWorkHours = startHour4 + "-" + endHour4;
                            WeekPeekActivity.this.wedTables.addAll(tableHolder4);
                        } else if (day.equals("Thu")) {
                            ArrayList<Double> tipHolder5 = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tips").getValue();
                            ArrayList<Integer> tableHolder5 = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").exists()) {
                                WeekPeekActivity.this.thuTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.thuTips.addAll(tipHolder5);
                            WeekPeekActivity.this.thuTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder5 = new ArrayList<>();
                            for (int timeInc9 = 0; timeInc9 <= 9; timeInc9++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("0" + timeInc9).exists()) {
                                    timeHolder5.add(Integer.valueOf(timeInc9));
                                }
                            }
                            for (int timeInc10 = 10; timeInc10 <= 24; timeInc10++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child(String.valueOf(timeInc10)).exists()) {
                                    timeHolder5.add(Integer.valueOf(timeInc10));
                                }
                            }
                            String startHour5 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder5.get(0)).intValue());
                            String endHour5 = "";
                            if (timeHolder5.size() > 1) {
                                endHour5 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder5.get(timeHolder5.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.thuWorkHours = startHour5 + "-" + endHour5;
                            WeekPeekActivity.this.thuTables.addAll(tableHolder5);
                        } else if (day.equals("Fri")) {
                            ArrayList<Double> tipHolder6 = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tips").getValue();
                            ArrayList<Integer> tableHolder6 = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").exists()) {
                                WeekPeekActivity.this.friTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.friTips.addAll(tipHolder6);
                            WeekPeekActivity.this.friTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder6 = new ArrayList<>();
                            for (int timeInc11 = 0; timeInc11 <= 9; timeInc11++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("0" + timeInc11).exists()) {
                                    timeHolder6.add(Integer.valueOf(timeInc11));
                                }
                            }
                            for (int timeInc12 = 10; timeInc12 <= 24; timeInc12++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child(String.valueOf(timeInc12)).exists()) {
                                    timeHolder6.add(Integer.valueOf(timeInc12));
                                }
                            }
                            String startHour6 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder6.get(0)).intValue());
                            String endHour6 = "";
                            if (timeHolder6.size() > 1) {
                                endHour6 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder6.get(timeHolder6.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.friWorkHours = startHour6 + "-" + endHour6;
                            WeekPeekActivity.this.friTables.addAll(tableHolder6);
                        } else if (day.equals("Sat")) {
                            ArrayList<Double> tipHolder7 = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tips").getValue();
                            ArrayList<Integer> tableHolder7 = (ArrayList) dataSnapshot.child(String.valueOf("0" + dayInc)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").exists()) {
                                WeekPeekActivity.this.satTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.satTips.addAll(tipHolder7);
                            WeekPeekActivity.this.satTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder7 = new ArrayList<>();
                            for (int timeInc13 = 0; timeInc13 <= 9; timeInc13++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child("0" + timeInc13).exists()) {
                                    timeHolder7.add(Integer.valueOf(timeInc13));
                                }
                            }
                            for (int timeInc14 = 10; timeInc14 >= 24; timeInc14++) {
                                if (dataSnapshot.child(String.valueOf("0" + dayInc)).child(String.valueOf(timeInc14)).exists()) {
                                    timeHolder7.add(Integer.valueOf(timeInc14));
                                }
                            }
                            String startHour7 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder7.get(0)).intValue());
                            String endHour7 = "";
                            if (timeHolder7.size() > 1) {
                                endHour7 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder7.get(timeHolder7.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.satWorkHours = startHour7 + "-" + endHour7;
                            WeekPeekActivity.this.satTables.addAll(tableHolder7);
                        }
                    }
                }
                for (int dayInc2 = 10; dayInc2 <= 32; dayInc2++) {
                    if (dataSnapshot.child(String.valueOf(dayInc2)).exists()) {
                        try {
                            WeekPeekActivity.this.date = WeekPeekActivity.this.dateFormat.parse(WeekPeekActivity.this.year + "-" + WeekPeekActivity.this.month + "-" + dayInc2);
                        } catch (ParseException e2) {
                            e2.printStackTrace();
                        }
                        String day2 = WeekPeekActivity.this.formatDayOfTheWeek.format(WeekPeekActivity.this.date);
                        if (day2.equals("Sun")) {
                            ArrayList<Double> tipHolder8 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tips").getValue();
                            ArrayList<Integer> tableHolder8 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").exists()) {
                                WeekPeekActivity.this.sunTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.sunTips.addAll(tipHolder8);
                            WeekPeekActivity.this.sunTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder8 = new ArrayList<>();
                            for (int timeInc15 = 0; timeInc15 <= 9; timeInc15++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child("0" + timeInc15).exists()) {
                                    timeHolder8.add(Integer.valueOf(timeInc15));
                                }
                            }
                            for (int timeInc16 = 10; timeInc16 <= 24; timeInc16++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child(String.valueOf(timeInc16)).exists()) {
                                    timeHolder8.add(Integer.valueOf(timeInc16));
                                }
                            }
                            String startHour8 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder8.get(0)).intValue());
                            String endHour8 = "";
                            if (timeHolder8.size() > 1) {
                                endHour8 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder8.get(timeHolder8.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.sunWorkHours = startHour8 + "-" + endHour8;
                            WeekPeekActivity.this.sunTables.addAll(tableHolder8);
                        } else if (day2.equals("Mon")) {
                            ArrayList<Double> tipHolder9 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tips").getValue();
                            ArrayList<Integer> tableHolder9 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").exists()) {
                                WeekPeekActivity.this.monTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.monTips.addAll(tipHolder9);
                            WeekPeekActivity.this.monTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder9 = new ArrayList<>();
                            for (int timeInc17 = 0; timeInc17 <= 9; timeInc17++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child("0" + timeInc17).exists()) {
                                    timeHolder9.add(Integer.valueOf(timeInc17));
                                }
                            }
                            for (int timeInc18 = 10; timeInc18 <= 24; timeInc18++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child(String.valueOf(timeInc18)).exists()) {
                                    timeHolder9.add(Integer.valueOf(timeInc18));
                                }
                            }
                            String startHour9 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder9.get(0)).intValue());
                            String endHour9 = "";
                            if (timeHolder9.size() > 1) {
                                endHour9 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder9.get(timeHolder9.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.monWorkHours = startHour9 + "-" + endHour9;
                            WeekPeekActivity.this.monTables.addAll(tableHolder9);
                        } else if (day2.equals("Tue")) {
                            ArrayList<Double> tipHolder10 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tips").getValue();
                            ArrayList<Integer> tableHolder10 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").exists()) {
                                WeekPeekActivity.this.tueTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.tueTips.addAll(tipHolder10);
                            WeekPeekActivity.this.tueTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder10 = new ArrayList<>();
                            for (int timeInc19 = 0; timeInc19 <= 9; timeInc19++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child("0" + timeInc19).exists()) {
                                    timeHolder10.add(Integer.valueOf(timeInc19));
                                }
                            }
                            for (int timeInc20 = 10; timeInc20 <= 24; timeInc20++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child(String.valueOf(timeInc20)).exists()) {
                                    timeHolder10.add(Integer.valueOf(timeInc20));
                                }
                            }
                            String startHour10 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder10.get(0)).intValue());
                            String endHour10 = "";
                            if (timeHolder10.size() > 1) {
                                endHour10 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder10.get(timeHolder10.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.tueWorkHours = startHour10 + "-" + endHour10;
                            WeekPeekActivity.this.tueTables.addAll(tableHolder10);
                        } else if (day2.equals("Wed")) {
                            ArrayList<Double> tipHolder11 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tips").getValue();
                            ArrayList<Integer> tableHolder11 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").exists()) {
                                WeekPeekActivity.this.wedTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.wedTips.addAll(tipHolder11);
                            WeekPeekActivity.this.wedTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder11 = new ArrayList<>();
                            for (int timeInc21 = 0; timeInc21 <= 9; timeInc21++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child("0" + timeInc21).exists()) {
                                    timeHolder11.add(Integer.valueOf(timeInc21));
                                }
                            }
                            for (int timeInc22 = 10; timeInc22 <= 24; timeInc22++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child(String.valueOf(timeInc22)).exists()) {
                                    timeHolder11.add(Integer.valueOf(timeInc22));
                                }
                            }
                            String startHour11 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder11.get(0)).intValue());
                            String endHour11 = "";
                            if (timeHolder11.size() > 1) {
                                endHour11 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder11.get(timeHolder11.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.wedWorkHours = startHour11 + "-" + endHour11;
                            WeekPeekActivity.this.wedTables.addAll(tableHolder11);
                        } else if (day2.equals("Thu")) {
                            ArrayList<Double> tipHolder12 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tips").getValue();
                            ArrayList<Integer> tableHolder12 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").exists()) {
                                WeekPeekActivity.this.thuTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.thuTips.addAll(tipHolder12);
                            WeekPeekActivity.this.thuTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder12 = new ArrayList<>();
                            for (int timeInc23 = 0; timeInc23 <= 9; timeInc23++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child("0" + timeInc23).exists()) {
                                    timeHolder12.add(Integer.valueOf(timeInc23));
                                }
                            }
                            for (int timeInc24 = 10; timeInc24 <= 24; timeInc24++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child(String.valueOf(timeInc24)).exists()) {
                                    timeHolder12.add(Integer.valueOf(timeInc24));
                                }
                            }
                            String startHour12 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder12.get(0)).intValue());
                            String endHour12 = "";
                            if (timeHolder12.size() > 1) {
                                endHour12 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder12.get(timeHolder12.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.thuWorkHours = startHour12 + "-" + endHour12;
                            WeekPeekActivity.this.thuTables.addAll(tableHolder12);
                        } else if (day2.equals("Fri")) {
                            ArrayList<Double> tipHolder13 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tips").getValue();
                            ArrayList<Integer> tableHolder13 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").exists()) {
                                WeekPeekActivity.this.friTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.friTips.addAll(tipHolder13);
                            WeekPeekActivity.this.friTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder13 = new ArrayList<>();
                            for (int timeInc25 = 0; timeInc25 <= 9; timeInc25++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child("0" + timeInc25).exists()) {
                                    timeHolder13.add(Integer.valueOf(timeInc25));
                                }
                            }
                            for (int timeInc26 = 10; timeInc26 <= 24; timeInc26++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child(String.valueOf(timeInc26)).exists()) {
                                    timeHolder13.add(Integer.valueOf(timeInc26));
                                }
                            }
                            String startHour13 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder13.get(0)).intValue());
                            String endHour13 = "";
                            if (timeHolder13.size() > 1) {
                                endHour13 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder13.get(timeHolder13.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.friWorkHours = startHour13 + "-" + endHour13;
                            WeekPeekActivity.this.friTables.addAll(tableHolder13);
                        } else if (day2.equals("Sat")) {
                            ArrayList<Double> tipHolder14 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tips").getValue();
                            ArrayList<Integer> tableHolder14 = (ArrayList) dataSnapshot.child(String.valueOf(dayInc2)).child("tables").getValue();
                            if (dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").exists()) {
                                WeekPeekActivity.this.satTipShare = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child("tipShare").getValue())).doubleValue();
                            }
                            WeekPeekActivity.this.satTips.addAll(tipHolder14);
                            WeekPeekActivity.this.satTot = Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue();
                            ArrayList<Integer> timeHolder14 = new ArrayList<>();
                            for (int timeInc27 = 0; timeInc27 <= 9; timeInc27++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child("0" + timeInc27).exists()) {
                                    timeHolder14.add(Integer.valueOf(timeInc27));
                                }
                            }
                            for (int timeInc28 = 10; timeInc28 <= 24; timeInc28++) {
                                if (dataSnapshot.child(String.valueOf(dayInc2)).child(String.valueOf(timeInc28)).exists()) {
                                    timeHolder14.add(Integer.valueOf(timeInc28));
                                }
                            }
                            String startHour14 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder14.get(0)).intValue());
                            String endHour14 = "";
                            if (timeHolder14.size() > 1) {
                                endHour14 = WeekPeekActivity.this.hourConverter(((Integer) timeHolder14.get(timeHolder14.size() - 1)).intValue());
                            }
                            WeekPeekActivity.this.satWorkHours = startHour14 + "-" + endHour14;
                            WeekPeekActivity.this.satTables.addAll(tableHolder14);
                        }
                    }
                }
                WeekPeekActivity.this.weekTot = WeekPeekActivity.this.sunTot + WeekPeekActivity.this.monTot + WeekPeekActivity.this.tueTot + WeekPeekActivity.this.wedTot + WeekPeekActivity.this.thuTot + WeekPeekActivity.this.friTot + WeekPeekActivity.this.satTot;
                WeekPeekActivity.this.sundayTipTextView.setText("$" + String.valueOf(WeekPeekActivity.this.decimalFormat.format(WeekPeekActivity.this.sunTot - WeekPeekActivity.this.sunTipShare)));
                WeekPeekActivity.this.mondayTipTextView.setText("$" + String.valueOf(WeekPeekActivity.this.decimalFormat.format(WeekPeekActivity.this.monTot - WeekPeekActivity.this.monTipShare)));
                WeekPeekActivity.this.tuesdayTipTextView.setText("$" + String.valueOf(WeekPeekActivity.this.decimalFormat.format(WeekPeekActivity.this.tueTot - WeekPeekActivity.this.tueTipShare)));
                WeekPeekActivity.this.wednesdayTipTextView.setText("$" + String.valueOf(WeekPeekActivity.this.decimalFormat.format(WeekPeekActivity.this.wedTot - WeekPeekActivity.this.wedTipShare)));
                WeekPeekActivity.this.thursdayTipTextView.setText("$" + String.valueOf(WeekPeekActivity.this.decimalFormat.format(WeekPeekActivity.this.thuTot - WeekPeekActivity.this.thuTipShare)));
                WeekPeekActivity.this.fridayTipTextView.setText("$" + String.valueOf(WeekPeekActivity.this.decimalFormat.format(WeekPeekActivity.this.friTot - WeekPeekActivity.this.friTipShare)));
                WeekPeekActivity.this.saturdayTipTextView.setText("$" + String.valueOf(WeekPeekActivity.this.decimalFormat.format(WeekPeekActivity.this.satTot - WeekPeekActivity.this.satTipShare)));
                if (WeekPeekActivity.this.sunTables != null) {
                    ArrayList<Integer> bestTablesHolder = new ArrayList<>();
                    int max = 0;
                    if (WeekPeekActivity.this.sunTables.size() >= 4) {
                        max = 4;
                    }
                    if (WeekPeekActivity.this.sunTables.size() < 4) {
                        max = WeekPeekActivity.this.sunTables.size();
                    }
                    for (int inc = 0; inc != WeekPeekActivity.this.sunTips.size(); inc++) {
                        for (int tipsInc = 1; tipsInc != WeekPeekActivity.this.sunTips.size(); tipsInc++) {
                            if (bestTablesHolder.size() != max) {
                                if (Double.valueOf(String.valueOf(WeekPeekActivity.this.sunTips.get(inc))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.sunTips.get(tipsInc))).doubleValue()) {
                                    bestTablesHolder.add(WeekPeekActivity.this.sunTables.get(tipsInc));
                                } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.sunTips.get(inc))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.sunTips.get(tipsInc))).doubleValue()) {
                                    bestTablesHolder.add(WeekPeekActivity.this.sunTables.get(tipsInc));
                                }
                            }
                        }
                    }
                    WeekPeekActivity.this.sunWorkTables = bestTablesHolder;
                }
                if (WeekPeekActivity.this.monTables != null) {
                    ArrayList<Integer> bestTablesHolder2 = new ArrayList<>();
                    int max2 = 0;
                    if (WeekPeekActivity.this.monTables.size() >= 4) {
                        max2 = 4;
                    }
                    if (WeekPeekActivity.this.monTables.size() < 4) {
                        max2 = WeekPeekActivity.this.monTables.size();
                    }
                    for (int inc2 = 0; inc2 != WeekPeekActivity.this.monTips.size(); inc2++) {
                        for (int tipsInc2 = 1; tipsInc2 != WeekPeekActivity.this.monTips.size(); tipsInc2++) {
                            if (bestTablesHolder2.size() != max2) {
                                if (Double.valueOf(String.valueOf(WeekPeekActivity.this.monTips.get(inc2))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.monTips.get(tipsInc2))).doubleValue()) {
                                    bestTablesHolder2.add(WeekPeekActivity.this.monTables.get(tipsInc2));
                                } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.monTips.get(inc2))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.monTips.get(tipsInc2))).doubleValue()) {
                                    bestTablesHolder2.add(WeekPeekActivity.this.monTables.get(tipsInc2));
                                }
                            }
                        }
                    }
                    WeekPeekActivity.this.monWorkTables = bestTablesHolder2;
                }
                if (WeekPeekActivity.this.tueTables != null) {
                    ArrayList<Integer> bestTablesHolder3 = new ArrayList<>();
                    int max3 = 0;
                    if (WeekPeekActivity.this.tueTables.size() >= 4) {
                        max3 = 4;
                    }
                    if (WeekPeekActivity.this.tueTables.size() < 4) {
                        max3 = WeekPeekActivity.this.tueTables.size();
                    }
                    for (int inc3 = 0; inc3 != WeekPeekActivity.this.tueTips.size(); inc3++) {
                        for (int tipsInc3 = 1; tipsInc3 != WeekPeekActivity.this.tueTips.size(); tipsInc3++) {
                            if (bestTablesHolder3.size() != max3) {
                                if (Double.valueOf(String.valueOf(WeekPeekActivity.this.tueTips.get(inc3))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.tueTips.get(tipsInc3))).doubleValue()) {
                                    bestTablesHolder3.add(WeekPeekActivity.this.tueTables.get(tipsInc3));
                                } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.tueTips.get(inc3))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.tueTips.get(tipsInc3))).doubleValue()) {
                                    bestTablesHolder3.add(WeekPeekActivity.this.tueTables.get(tipsInc3));
                                }
                            }
                        }
                    }
                    WeekPeekActivity.this.tueWorkTables = bestTablesHolder3;
                }
                if (WeekPeekActivity.this.wedTables != null) {
                    ArrayList<Integer> bestTablesHolder4 = new ArrayList<>();
                    int max4 = 0;
                    if (WeekPeekActivity.this.wedTables.size() >= 4) {
                        max4 = 4;
                    }
                    if (WeekPeekActivity.this.wedTables.size() < 4) {
                        max4 = WeekPeekActivity.this.wedTables.size();
                    }
                    for (int inc4 = 0; inc4 != WeekPeekActivity.this.wedTips.size(); inc4++) {
                        for (int tipsInc4 = 1; tipsInc4 != WeekPeekActivity.this.wedTips.size(); tipsInc4++) {
                            if (bestTablesHolder4.size() != max4) {
                                if (Double.valueOf(String.valueOf(WeekPeekActivity.this.wedTips.get(inc4))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.wedTips.get(tipsInc4))).doubleValue()) {
                                    bestTablesHolder4.add(WeekPeekActivity.this.wedTables.get(tipsInc4));
                                } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.wedTips.get(inc4))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.wedTips.get(tipsInc4))).doubleValue()) {
                                    bestTablesHolder4.add(WeekPeekActivity.this.wedTables.get(tipsInc4));
                                }
                            }
                        }
                    }
                    WeekPeekActivity.this.wedWorkTables = bestTablesHolder4;
                }
                if (WeekPeekActivity.this.thuTables != null) {
                    ArrayList<Integer> bestTablesHolder5 = new ArrayList<>();
                    int max5 = 0;
                    if (WeekPeekActivity.this.thuTables.size() >= 4) {
                        max5 = 4;
                    }
                    if (WeekPeekActivity.this.thuTables.size() < 4) {
                        max5 = WeekPeekActivity.this.thuTables.size();
                    }
                    for (int inc5 = 0; inc5 != WeekPeekActivity.this.thuTips.size(); inc5++) {
                        for (int tipsInc5 = 1; tipsInc5 != WeekPeekActivity.this.thuTips.size(); tipsInc5++) {
                            if (bestTablesHolder5.size() != max5) {
                                if (Double.valueOf(String.valueOf(WeekPeekActivity.this.thuTips.get(inc5))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.thuTips.get(tipsInc5))).doubleValue()) {
                                    bestTablesHolder5.add(WeekPeekActivity.this.thuTables.get(tipsInc5));
                                } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.thuTips.get(inc5))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.thuTips.get(tipsInc5))).doubleValue()) {
                                    bestTablesHolder5.add(WeekPeekActivity.this.thuTables.get(tipsInc5));
                                }
                            }
                        }
                    }
                    WeekPeekActivity.this.thuWorkTables = bestTablesHolder5;
                }
                if (WeekPeekActivity.this.friTables != null) {
                    ArrayList<Integer> bestTablesHolder6 = new ArrayList<>();
                    int max6 = 0;
                    if (WeekPeekActivity.this.friTables.size() >= 4) {
                        max6 = 4;
                    }
                    if (WeekPeekActivity.this.friTables.size() < 4) {
                        max6 = WeekPeekActivity.this.friTables.size();
                    }
                    for (int inc6 = 0; inc6 != WeekPeekActivity.this.friTips.size(); inc6++) {
                        for (int tipsInc6 = 1; tipsInc6 != WeekPeekActivity.this.friTips.size(); tipsInc6++) {
                            if (bestTablesHolder6.size() != max6) {
                                if (Double.valueOf(String.valueOf(WeekPeekActivity.this.friTips.get(inc6))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.friTips.get(tipsInc6))).doubleValue()) {
                                    bestTablesHolder6.add(WeekPeekActivity.this.friTables.get(tipsInc6));
                                } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.friTips.get(inc6))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.friTips.get(tipsInc6))).doubleValue()) {
                                    bestTablesHolder6.add(WeekPeekActivity.this.friTables.get(tipsInc6));
                                }
                            }
                        }
                    }
                    WeekPeekActivity.this.friWorkTables = bestTablesHolder6;
                }
                if (WeekPeekActivity.this.satTables != null) {
                    ArrayList<Integer> bestTablesHolder7 = new ArrayList<>();
                    int max7 = 0;
                    if (WeekPeekActivity.this.satTables.size() >= 4) {
                        max7 = 4;
                    }
                    if (WeekPeekActivity.this.satTables.size() < 4) {
                        max7 = WeekPeekActivity.this.satTables.size();
                    }
                    for (int inc7 = 0; inc7 != WeekPeekActivity.this.satTips.size(); inc7++) {
                        for (int tipsInc7 = 1; tipsInc7 != WeekPeekActivity.this.satTips.size(); tipsInc7++) {
                            if (bestTablesHolder7.size() != max7) {
                                if (Double.valueOf(String.valueOf(WeekPeekActivity.this.satTips.get(inc7))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.satTips.get(tipsInc7))).doubleValue()) {
                                    bestTablesHolder7.add(WeekPeekActivity.this.satTables.get(tipsInc7));
                                } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.satTips.get(inc7))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.satTips.get(tipsInc7))).doubleValue()) {
                                    bestTablesHolder7.add(WeekPeekActivity.this.satTables.get(tipsInc7));
                                }
                            }
                        }
                    }
                    WeekPeekActivity.this.satWorkTables = bestTablesHolder7;
                }
                ArrayList<Integer> allTablesForTheWeek = (ArrayList) dataSnapshot.child("tables").getValue();
                ArrayList<Double> allTipsForTheWeek = (ArrayList) dataSnapshot.child("tips").getValue();
                ArrayList<Integer> bestTablesHolder8 = new ArrayList<>();
                int max8 = 0;
                if (allTipsForTheWeek != null) {
                    if (allTablesForTheWeek.size() >= 4) {
                        max8 = 4;
                    }
                    if (allTablesForTheWeek.size() < 4) {
                        max8 = allTablesForTheWeek.size();
                    }
                    for (int inc8 = 0; inc8 != allTipsForTheWeek.size(); inc8++) {
                        for (int tipsInc8 = 1; tipsInc8 != allTipsForTheWeek.size(); tipsInc8++) {
                            if (bestTablesHolder8.size() != max8) {
                                if (Double.valueOf(String.valueOf(allTipsForTheWeek.get(inc8))).doubleValue() > Double.valueOf(String.valueOf(allTipsForTheWeek.get(tipsInc8))).doubleValue()) {
                                    bestTablesHolder8.add(allTablesForTheWeek.get(tipsInc8));
                                } else if (Double.valueOf(String.valueOf(allTipsForTheWeek.get(inc8))).doubleValue() < Double.valueOf(String.valueOf(allTipsForTheWeek.get(tipsInc8))).doubleValue()) {
                                    bestTablesHolder8.add(allTablesForTheWeek.get(tipsInc8));
                                }
                            }
                        }
                    }
                    WeekPeekActivity.this.weekWorkTables = bestTablesHolder8;
                }
                if (WeekPeekActivity.this.sunSum > WeekPeekActivity.this.monSum) {
                    WeekPeekActivity.this.weekWorkHours = WeekPeekActivity.this.sunWorkHours;
                }
                if (WeekPeekActivity.this.monSum > WeekPeekActivity.this.tueSum) {
                    WeekPeekActivity.this.weekWorkHours = WeekPeekActivity.this.monWorkHours;
                }
                if (WeekPeekActivity.this.tueSum > WeekPeekActivity.this.wedSum) {
                    WeekPeekActivity.this.weekWorkHours = WeekPeekActivity.this.tueWorkHours;
                }
                if (WeekPeekActivity.this.wedSum > WeekPeekActivity.this.thuSum) {
                    WeekPeekActivity.this.weekWorkHours = WeekPeekActivity.this.wedWorkHours;
                }
                if (WeekPeekActivity.this.thuSum > WeekPeekActivity.this.friSum) {
                    WeekPeekActivity.this.weekWorkHours = WeekPeekActivity.this.thuWorkHours;
                }
                if (WeekPeekActivity.this.friSum > WeekPeekActivity.this.satSum) {
                    WeekPeekActivity.this.weekWorkHours = WeekPeekActivity.this.friWorkHours;
                }
                if (WeekPeekActivity.this.satSum > WeekPeekActivity.this.sunSum) {
                    WeekPeekActivity.this.weekWorkHours = WeekPeekActivity.this.satWorkHours;
                }
                WeekPeekActivity.this.weekTipShare = WeekPeekActivity.this.sunTipShare + WeekPeekActivity.this.monTipShare + WeekPeekActivity.this.tueTipShare + WeekPeekActivity.this.wedTipShare + WeekPeekActivity.this.thuTipShare + WeekPeekActivity.this.friTipShare + WeekPeekActivity.this.satTipShare;
                WeekPeekActivity.this.changeFocus();
                WeekPeekActivity.this.focusedDayTextView.setText("Week");
                WeekPeekActivity.this.tipsActualTextView.setText("$" + String.valueOf(WeekPeekActivity.this.decimalFormat.format(WeekPeekActivity.this.weekTot - WeekPeekActivity.this.weekTipShare)));
                if (WeekPeekActivity.this.weekWorkTables.size() != 0) {
                    WeekPeekActivity.this.tablesActualTextView.setText(String.valueOf(WeekPeekActivity.this.weekWorkTables).replace("[", "").replace("]", ""));
                } else {
                    WeekPeekActivity.this.tablesActualTextView.setText("no tables");
                }
                if (WeekPeekActivity.this.weekWorkHours != null) {
                    WeekPeekActivity.this.timesActualTextView.setText(WeekPeekActivity.this.weekWorkHours);
                } else {
                    WeekPeekActivity.this.timesActualTextView.setText("no hours");
                }
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
        this.mMonthRef.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Integer> monthTablesHolder = new ArrayList<>();
                ArrayList<Double> monthTipsHolder = new ArrayList<>();
                ArrayList<Double> tipsForMonth = new ArrayList<>();
                int numberOfWeeks = 0;
                for (int weekInc = 0; weekInc <= 6; weekInc++) {
                    if (dataSnapshot.child(String.valueOf(weekInc)).exists()) {
                        numberOfWeeks++;
                        monthTipsHolder = (ArrayList) dataSnapshot.child(String.valueOf(weekInc)).child("tips").getValue();
                        monthTablesHolder = (ArrayList) dataSnapshot.child(String.valueOf(weekInc)).child("tables").getValue();
                        for (int x = 0; monthTipsHolder.size() != x; x++) {
                            tipsForMonth.add(Double.valueOf(Double.valueOf(String.valueOf(monthTipsHolder.get(x))).doubleValue()));
                        }
                    }
                }
                double tip = 0.0d;
                for (int tipsInc = 0; tipsInc != tipsForMonth.size(); tipsInc++) {
                    tip += ((Double) tipsForMonth.get(tipsInc)).doubleValue();
                }
                WeekPeekActivity.this.weekSumEst = tip / ((double) numberOfWeeks);
                ArrayList<Integer> bestTablesHolder = new ArrayList<>();
                int max = 0;
                if (monthTablesHolder.size() >= 4) {
                    max = 4;
                }
                if (monthTablesHolder.size() < 4) {
                    max = monthTablesHolder.size();
                }
                for (int inc = 0; inc != monthTipsHolder.size(); inc++) {
                    for (int tipsInc2 = 1; tipsInc2 != monthTipsHolder.size(); tipsInc2++) {
                        if (bestTablesHolder.size() != max) {
                            if (Double.valueOf(String.valueOf(monthTipsHolder.get(inc))).doubleValue() > Double.valueOf(String.valueOf(monthTipsHolder.get(tipsInc2))).doubleValue()) {
                                bestTablesHolder.add(monthTablesHolder.get(tipsInc2));
                            } else if (Double.valueOf(String.valueOf(monthTipsHolder.get(inc))).doubleValue() < Double.valueOf(String.valueOf(monthTipsHolder.get(tipsInc2))).doubleValue()) {
                                bestTablesHolder.add(monthTablesHolder.get(tipsInc2));
                            }
                        }
                    }
                }
                WeekPeekActivity.this.weekWorkTablesEst = bestTablesHolder;
                int xSun = 0;
                int xMon = 0;
                int xTue = 0;
                int xWed = 0;
                int xThu = 0;
                int xFri = 0;
                int xSat = 0;
                for (int weekInc2 = 0; weekInc2 != 5; weekInc2++) {
                    for (int dayInc = 0; dayInc <= 9; dayInc++) {
                        if (dataSnapshot.child(String.valueOf(weekInc2)).child("0" + dayInc).exists()) {
                            try {
                                WeekPeekActivity.this.date = WeekPeekActivity.this.dateFormat.parse(WeekPeekActivity.this.year + "-" + WeekPeekActivity.this.month + "-" + "0" + dayInc);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            String day = WeekPeekActivity.this.formatDayOfTheWeek.format(WeekPeekActivity.this.date);
                            if (day.equals("Sun")) {
                                ArrayList<Integer> tablesHolder = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child("tables").getValue();
                                ArrayList<String> timesHolder = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("times").getValue();
                                WeekPeekActivity.this.sunTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.sunTablesEst.addAll(tablesHolder);
                                WeekPeekActivity.this.sunHoursEst.addAll(timesHolder);
                                xSun++;
                            } else if (day.equals("Mon")) {
                                ArrayList<Integer> tablesHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child("tables").getValue();
                                ArrayList<String> timesHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("times").getValue();
                                WeekPeekActivity.this.monTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.monTablesEst.addAll(tablesHolder2);
                                WeekPeekActivity.this.monHoursEst.addAll(timesHolder2);
                                xMon++;
                            } else if (day.equals("Tue")) {
                                ArrayList<Integer> tablesHolder3 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child("tables").getValue();
                                ArrayList<String> timesHolder3 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("times").getValue();
                                WeekPeekActivity.this.tueTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.tueTablesEst.addAll(tablesHolder3);
                                WeekPeekActivity.this.tueHoursEst.addAll(timesHolder3);
                                xTue++;
                            } else if (day.equals("Wed")) {
                                ArrayList<Integer> tablesHolder4 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child("tables").getValue();
                                ArrayList<String> timesHolder4 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("times").getValue();
                                WeekPeekActivity.this.wedTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.wedTablesEst.addAll(tablesHolder4);
                                WeekPeekActivity.this.wedHoursEst.addAll(timesHolder4);
                                xWed++;
                            } else if (day.equals("Thu")) {
                                ArrayList<Integer> tablesHolder5 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child("tables").getValue();
                                ArrayList<String> timesHolder5 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("times").getValue();
                                WeekPeekActivity.this.thuTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.thuTablesEst.addAll(tablesHolder5);
                                WeekPeekActivity.this.thuHoursEst.addAll(timesHolder5);
                                xThu++;
                            } else if (day.equals("Fri")) {
                                ArrayList<Integer> tablesHolder6 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child("tables").getValue();
                                ArrayList<String> timesHolder6 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("times").getValue();
                                WeekPeekActivity.this.friTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.friTablesEst.addAll(tablesHolder6);
                                WeekPeekActivity.this.friHoursEst.addAll(timesHolder6);
                                xFri++;
                            } else if (day.equals("Sat")) {
                                ArrayList<Integer> tablesHolder7 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child("tables").getValue();
                                ArrayList<String> timesHolder7 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("times").getValue();
                                WeekPeekActivity.this.satTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf("0" + dayInc)).child(day).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.satTablesEst.addAll(tablesHolder7);
                                WeekPeekActivity.this.satHoursEst.addAll(timesHolder7);
                                xSat++;
                            }
                        }
                    }
                    for (int dayInc2 = 9; dayInc2 <= 32; dayInc2++) {
                        if (dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).exists()) {
                            try {
                                WeekPeekActivity.this.date = WeekPeekActivity.this.dateFormat.parse(WeekPeekActivity.this.year + "-" + WeekPeekActivity.this.month + "-" + dayInc2);
                            } catch (ParseException e2) {
                                e2.printStackTrace();
                            }
                            String day2 = WeekPeekActivity.this.formatDayOfTheWeek.format(WeekPeekActivity.this.date);
                            if (day2.equals("Sun")) {
                                ArrayList<Integer> tablesHolder8 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child("tables").getValue();
                                ArrayList<String> timesHolder8 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("times").getValue();
                                WeekPeekActivity.this.sunTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.sunTablesEst.addAll(tablesHolder8);
                                WeekPeekActivity.this.sunHoursEst.addAll(timesHolder8);
                                xSun++;
                            } else if (day2.equals("Mon")) {
                                ArrayList<Integer> tablesHolder9 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child("tables").getValue();
                                ArrayList<String> timesHolder9 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("times").getValue();
                                WeekPeekActivity.this.monTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.monTablesEst.addAll(tablesHolder9);
                                WeekPeekActivity.this.monHoursEst.addAll(timesHolder9);
                                xMon++;
                            } else if (day2.equals("Tue")) {
                                ArrayList<Integer> tablesHolder10 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child("tables").getValue();
                                ArrayList<String> timesHolder10 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("times").getValue();
                                WeekPeekActivity.this.tueTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.tueTablesEst.addAll(tablesHolder10);
                                WeekPeekActivity.this.tueHoursEst.addAll(timesHolder10);
                                xTue++;
                            } else if (day2.equals("Wed")) {
                                ArrayList<Integer> tablesHolder11 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child("tables").getValue();
                                ArrayList<String> timesHolder11 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("times").getValue();
                                WeekPeekActivity.this.wedTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.wedTablesEst.addAll(tablesHolder11);
                                WeekPeekActivity.this.wedHoursEst.addAll(timesHolder11);
                                xWed++;
                            } else if (day2.equals("Thu")) {
                                ArrayList<Integer> tablesHolder12 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child("tables").getValue();
                                ArrayList<String> timesHolder12 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("times").getValue();
                                WeekPeekActivity.this.thuTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.thuTablesEst.addAll(tablesHolder12);
                                WeekPeekActivity.this.thuHoursEst.addAll(timesHolder12);
                                xThu++;
                            } else if (day2.equals("Fri")) {
                                ArrayList<Integer> tablesHolder13 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child("tables").getValue();
                                ArrayList<String> timesHolder13 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("times").getValue();
                                WeekPeekActivity.this.friTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.friTablesEst.addAll(tablesHolder13);
                                WeekPeekActivity.this.friHoursEst.addAll(timesHolder13);
                                xFri++;
                            } else if (day2.equals("Sat")) {
                                ArrayList<Integer> tablesHolder14 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child("tables").getValue();
                                ArrayList<String> timesHolder14 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("times").getValue();
                                WeekPeekActivity.this.satTipsEst.add(Double.valueOf(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(weekInc2)).child(String.valueOf(dayInc2)).child(day2).child("total").getValue())).doubleValue()));
                                WeekPeekActivity.this.satTablesEst.addAll(tablesHolder14);
                                WeekPeekActivity.this.satHoursEst.addAll(timesHolder14);
                                xSat++;
                            }
                        }
                    }
                }
                if (WeekPeekActivity.this.sunTipsEst.size() != 0) {
                    WeekPeekActivity.this.sunSumEst = WeekPeekActivity.this.sumEst(WeekPeekActivity.this.sunTipsEst) / ((double) xSun);
                }
                if (WeekPeekActivity.this.monTipsEst.size() != 0) {
                    WeekPeekActivity.this.monSumEst = WeekPeekActivity.this.sumEst(WeekPeekActivity.this.monTipsEst) / ((double) xMon);
                }
                if (WeekPeekActivity.this.tueTipsEst.size() != 0) {
                    WeekPeekActivity.this.tueSumEst = WeekPeekActivity.this.sumEst(WeekPeekActivity.this.tueTipsEst) / ((double) xTue);
                }
                if (WeekPeekActivity.this.wedTipsEst.size() != 0) {
                    WeekPeekActivity.this.wedSumEst = WeekPeekActivity.this.sumEst(WeekPeekActivity.this.wedTipsEst) / ((double) xWed);
                }
                if (WeekPeekActivity.this.thuTipsEst.size() != 0) {
                    WeekPeekActivity.this.thuSumEst = WeekPeekActivity.this.sumEst(WeekPeekActivity.this.thuTipsEst) / ((double) xThu);
                }
                if (WeekPeekActivity.this.friTipsEst.size() != 0) {
                    WeekPeekActivity.this.friSumEst = WeekPeekActivity.this.sumEst(WeekPeekActivity.this.friTipsEst) / ((double) xFri);
                }
                if (WeekPeekActivity.this.satTipsEst.size() != 0) {
                    WeekPeekActivity.this.satSumEst = WeekPeekActivity.this.sumEst(WeekPeekActivity.this.satTipsEst) / ((double) xSat);
                }
                if (WeekPeekActivity.this.sunTablesEst.size() >= 4) {
                    max = 4;
                }
                if (WeekPeekActivity.this.sunTablesEst.size() < 4) {
                    max = WeekPeekActivity.this.sunTablesEst.size();
                }
                ArrayList<Integer> bestTablesHolder2 = new ArrayList<>();
                for (int inc2 = 0; inc2 != WeekPeekActivity.this.sunTipsEst.size(); inc2++) {
                    for (int tipsInc3 = 1; tipsInc3 != WeekPeekActivity.this.sunTipsEst.size(); tipsInc3++) {
                        if (bestTablesHolder2.size() != max) {
                            if (Double.valueOf(String.valueOf(WeekPeekActivity.this.sunTipsEst.get(inc2))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.sunTipsEst.get(tipsInc3))).doubleValue()) {
                                bestTablesHolder2.add(WeekPeekActivity.this.sunTablesEst.get(tipsInc3));
                            } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.sunTipsEst.get(inc2))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.sunTipsEst.get(tipsInc3))).doubleValue()) {
                                bestTablesHolder2.add(WeekPeekActivity.this.sunTablesEst.get(tipsInc3));
                            }
                        }
                    }
                }
                WeekPeekActivity.this.sunWorkTablesEst = bestTablesHolder2;
                if (WeekPeekActivity.this.monTablesEst.size() >= 4) {
                    max = 4;
                }
                if (WeekPeekActivity.this.monTablesEst.size() < 4) {
                    max = WeekPeekActivity.this.monTablesEst.size();
                }
                ArrayList<Integer> bestTablesHolder3 = new ArrayList<>();
                for (int inc3 = 0; inc3 != WeekPeekActivity.this.monTipsEst.size(); inc3++) {
                    for (int tipsInc4 = 1; tipsInc4 != WeekPeekActivity.this.monTipsEst.size(); tipsInc4++) {
                        if (bestTablesHolder3.size() != max) {
                            if (Double.valueOf(String.valueOf(WeekPeekActivity.this.monTipsEst.get(inc3))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.monTipsEst.get(tipsInc4))).doubleValue()) {
                                bestTablesHolder3.add(WeekPeekActivity.this.monTablesEst.get(tipsInc4));
                            } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.monTipsEst.get(inc3))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.monTipsEst.get(tipsInc4))).doubleValue()) {
                                bestTablesHolder3.add(WeekPeekActivity.this.monTablesEst.get(tipsInc4));
                            }
                        }
                    }
                }
                WeekPeekActivity.this.monWorkTablesEst = bestTablesHolder3;
                if (WeekPeekActivity.this.tueTablesEst.size() >= 4) {
                    max = 4;
                }
                if (WeekPeekActivity.this.tueTablesEst.size() < 4) {
                    max = WeekPeekActivity.this.tueTablesEst.size();
                }
                ArrayList<Integer> bestTablesHolder4 = new ArrayList<>();
                for (int inc4 = 0; inc4 != WeekPeekActivity.this.tueTipsEst.size(); inc4++) {
                    for (int tipsInc5 = 1; tipsInc5 != WeekPeekActivity.this.tueTipsEst.size(); tipsInc5++) {
                        if (bestTablesHolder4.size() != max) {
                            if (Double.valueOf(String.valueOf(WeekPeekActivity.this.tueTipsEst.get(inc4))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.tueTipsEst.get(tipsInc5))).doubleValue()) {
                                bestTablesHolder4.add(WeekPeekActivity.this.tueTablesEst.get(tipsInc5));
                            } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.tueTipsEst.get(inc4))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.tueTipsEst.get(tipsInc5))).doubleValue()) {
                                bestTablesHolder4.add(WeekPeekActivity.this.tueTablesEst.get(tipsInc5));
                            }
                        }
                    }
                }
                WeekPeekActivity.this.tueWorkTablesEst = bestTablesHolder4;
                if (WeekPeekActivity.this.wedTablesEst.size() >= 4) {
                    max = 4;
                }
                if (WeekPeekActivity.this.wedTablesEst.size() < 4) {
                    max = WeekPeekActivity.this.wedTablesEst.size();
                }
                ArrayList<Integer> bestTablesHolder5 = new ArrayList<>();
                for (int inc5 = 0; inc5 != WeekPeekActivity.this.wedTipsEst.size(); inc5++) {
                    for (int tipsInc6 = 1; tipsInc6 != WeekPeekActivity.this.wedTipsEst.size(); tipsInc6++) {
                        if (bestTablesHolder5.size() != max) {
                            if (Double.valueOf(String.valueOf(WeekPeekActivity.this.wedTipsEst.get(inc5))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.wedTipsEst.get(tipsInc6))).doubleValue()) {
                                bestTablesHolder5.add(WeekPeekActivity.this.wedTablesEst.get(tipsInc6));
                            } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.wedTipsEst.get(inc5))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.wedTipsEst.get(tipsInc6))).doubleValue()) {
                                bestTablesHolder5.add(WeekPeekActivity.this.wedTablesEst.get(tipsInc6));
                            }
                        }
                    }
                }
                WeekPeekActivity.this.wedWorkTablesEst = bestTablesHolder5;
                if (WeekPeekActivity.this.thuTablesEst.size() >= 4) {
                    max = 4;
                }
                if (WeekPeekActivity.this.thuTablesEst.size() < 4) {
                    max = WeekPeekActivity.this.thuTablesEst.size();
                }
                ArrayList<Integer> bestTablesHolder6 = new ArrayList<>();
                for (int inc6 = 0; inc6 != WeekPeekActivity.this.thuTipsEst.size(); inc6++) {
                    for (int tipsInc7 = 1; tipsInc7 != WeekPeekActivity.this.thuTipsEst.size(); tipsInc7++) {
                        if (bestTablesHolder6.size() != max) {
                            if (Double.valueOf(String.valueOf(WeekPeekActivity.this.thuTipsEst.get(inc6))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.thuTipsEst.get(tipsInc7))).doubleValue()) {
                                bestTablesHolder6.add(WeekPeekActivity.this.thuTablesEst.get(tipsInc7));
                            } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.thuTipsEst.get(inc6))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.thuTipsEst.get(tipsInc7))).doubleValue()) {
                                bestTablesHolder6.add(WeekPeekActivity.this.thuTablesEst.get(tipsInc7));
                            }
                        }
                    }
                }
                WeekPeekActivity.this.thuWorkTablesEst = bestTablesHolder6;
                if (WeekPeekActivity.this.friTablesEst.size() >= 4) {
                    max = 4;
                }
                if (WeekPeekActivity.this.friTablesEst.size() < 4) {
                    max = WeekPeekActivity.this.friTablesEst.size();
                }
                ArrayList<Integer> bestTablesHolder7 = new ArrayList<>();
                for (int inc7 = 0; inc7 != WeekPeekActivity.this.friTipsEst.size(); inc7++) {
                    for (int tipsInc8 = 1; tipsInc8 != WeekPeekActivity.this.friTipsEst.size(); tipsInc8++) {
                        if (bestTablesHolder7.size() != max) {
                            if (Double.valueOf(String.valueOf(WeekPeekActivity.this.friTipsEst.get(inc7))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.friTipsEst.get(tipsInc8))).doubleValue()) {
                                bestTablesHolder7.add(WeekPeekActivity.this.friTablesEst.get(tipsInc8));
                            } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.friTipsEst.get(inc7))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.friTipsEst.get(tipsInc8))).doubleValue()) {
                                bestTablesHolder7.add(WeekPeekActivity.this.friTablesEst.get(tipsInc8));
                            }
                        }
                    }
                }
                WeekPeekActivity.this.friWorkTablesEst = bestTablesHolder7;
                if (WeekPeekActivity.this.satTablesEst.size() >= 4) {
                    max = 4;
                }
                if (WeekPeekActivity.this.satTablesEst.size() < 4) {
                    max = WeekPeekActivity.this.satTablesEst.size();
                }
                ArrayList<Integer> bestTablesHolder8 = new ArrayList<>();
                for (int inc8 = 0; inc8 != WeekPeekActivity.this.satTipsEst.size(); inc8++) {
                    for (int tipsInc9 = 1; tipsInc9 != WeekPeekActivity.this.satTipsEst.size(); tipsInc9++) {
                        if (bestTablesHolder8.size() != max) {
                            if (Double.valueOf(String.valueOf(WeekPeekActivity.this.satTipsEst.get(inc8))).doubleValue() > Double.valueOf(String.valueOf(WeekPeekActivity.this.satTipsEst.get(tipsInc9))).doubleValue()) {
                                bestTablesHolder8.add(WeekPeekActivity.this.satTablesEst.get(tipsInc9));
                            } else if (Double.valueOf(String.valueOf(WeekPeekActivity.this.satTipsEst.get(inc8))).doubleValue() < Double.valueOf(String.valueOf(WeekPeekActivity.this.satTipsEst.get(tipsInc9))).doubleValue()) {
                                bestTablesHolder8.add(WeekPeekActivity.this.satTablesEst.get(tipsInc9));
                            }
                        }
                    }
                }
                WeekPeekActivity.this.satWorkTablesEst = bestTablesHolder8;
                String bestTime = "";
                for (int weekInc3 = 0; weekInc3 != 5; weekInc3++) {
                    for (int dayInc3 = 0; dayInc3 <= 9; dayInc3++) {
                        if (dataSnapshot.child(String.valueOf(weekInc3)).child("0" + dayInc3).exists()) {
                            try {
                                WeekPeekActivity.this.date = WeekPeekActivity.this.dateFormat.parse(WeekPeekActivity.this.year + "-" + WeekPeekActivity.this.month + "-" + "0" + dayInc3);
                            } catch (ParseException e3) {
                                e3.printStackTrace();
                            }
                            String day3 = WeekPeekActivity.this.formatDayOfTheWeek.format(WeekPeekActivity.this.date);
                            if (day3.equals("Sun")) {
                                ArrayList<Double> tipsHolder = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("tips").getValue();
                                ArrayList<String> timesHolder15 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("times").getValue();
                                if (timesHolder15.size() != 1) {
                                    for (int inc9 = 0; inc9 != tipsHolder.size(); inc9++) {
                                        for (int totInc = 1; totInc != tipsHolder.size(); totInc++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder.get(inc9))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder.get(totInc))).doubleValue()) {
                                                bestTime = (String) timesHolder15.get(totInc);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder.get(inc9))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder.get(totInc))).doubleValue()) {
                                                bestTime = (String) timesHolder15.get(totInc);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.sunWorkHoursEst = bestTime;
                                } else if (timesHolder15.size() == 1) {
                                    WeekPeekActivity.this.sunWorkHoursEst = (String) timesHolder15.get(0);
                                }
                            } else if (day3.equals("Mon")) {
                                ArrayList<Double> tipsHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("tips").getValue();
                                ArrayList<String> timesHolder16 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("times").getValue();
                                if (timesHolder16.size() != 1) {
                                    for (int inc10 = 0; inc10 != tipsHolder2.size(); inc10++) {
                                        for (int totInc2 = 1; totInc2 != tipsHolder2.size(); totInc2++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder2.get(inc10))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder2.get(totInc2))).doubleValue()) {
                                                bestTime = (String) timesHolder16.get(totInc2);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder2.get(inc10))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder2.get(totInc2))).doubleValue()) {
                                                bestTime = (String) timesHolder16.get(totInc2);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.monWorkHoursEst = bestTime;
                                } else if (timesHolder16.size() == 1) {
                                    WeekPeekActivity.this.monWorkHoursEst = (String) timesHolder16.get(0);
                                }
                            } else if (day3.equals("Tue")) {
                                ArrayList<Double> tipsHolder3 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("tips").getValue();
                                ArrayList<String> timesHolder17 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("times").getValue();
                                if (timesHolder17.size() != 1) {
                                    for (int inc11 = 0; inc11 != tipsHolder3.size(); inc11++) {
                                        for (int totInc3 = 1; totInc3 != tipsHolder3.size(); totInc3++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder3.get(inc11))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder3.get(totInc3))).doubleValue()) {
                                                bestTime = (String) timesHolder17.get(totInc3);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder3.get(inc11))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder3.get(totInc3))).doubleValue()) {
                                                bestTime = (String) timesHolder17.get(totInc3);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.tueWorkHoursEst = bestTime;
                                } else if (timesHolder17.size() == 1) {
                                    WeekPeekActivity.this.tueWorkHoursEst = (String) timesHolder17.get(0);
                                }
                            } else if (day3.equals("Wed")) {
                                ArrayList<Double> tipsHolder4 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("tips").getValue();
                                ArrayList<String> timesHolder18 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("times").getValue();
                                if (timesHolder18.size() != 1) {
                                    for (int inc12 = 0; inc12 != tipsHolder4.size(); inc12++) {
                                        for (int totInc4 = 1; totInc4 != tipsHolder4.size(); totInc4++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder4.get(inc12))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder4.get(totInc4))).doubleValue()) {
                                                bestTime = (String) timesHolder18.get(totInc4);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder4.get(inc12))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder4.get(totInc4))).doubleValue()) {
                                                bestTime = (String) timesHolder18.get(totInc4);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.wedWorkHoursEst = bestTime;
                                } else if (timesHolder18.size() == 1) {
                                    WeekPeekActivity.this.wedWorkHoursEst = (String) timesHolder18.get(0);
                                }
                            } else if (day3.equals("Thu")) {
                                ArrayList<Double> tipsHolder5 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("tips").getValue();
                                ArrayList<String> timesHolder19 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("times").getValue();
                                if (timesHolder19.size() != 1) {
                                    for (int inc13 = 0; inc13 != tipsHolder5.size(); inc13++) {
                                        for (int totInc5 = 1; totInc5 != tipsHolder5.size(); totInc5++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder5.get(inc13))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder5.get(totInc5))).doubleValue()) {
                                                bestTime = (String) timesHolder19.get(totInc5);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder5.get(inc13))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder5.get(totInc5))).doubleValue()) {
                                                bestTime = (String) timesHolder19.get(totInc5);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.thuWorkHoursEst = bestTime;
                                } else if (timesHolder19.size() == 1) {
                                    WeekPeekActivity.this.thuWorkHoursEst = (String) timesHolder19.get(0);
                                }
                            } else if (day3.equals("Fri")) {
                                ArrayList<Double> tipsHolder6 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("tips").getValue();
                                ArrayList<String> timesHolder20 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("times").getValue();
                                if (timesHolder20.size() != 1) {
                                    for (int inc14 = 0; inc14 != tipsHolder6.size(); inc14++) {
                                        for (int totInc6 = 1; totInc6 != tipsHolder6.size(); totInc6++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder6.get(inc14))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder6.get(totInc6))).doubleValue()) {
                                                bestTime = (String) timesHolder20.get(totInc6);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder6.get(inc14))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder6.get(totInc6))).doubleValue()) {
                                                bestTime = (String) timesHolder20.get(totInc6);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.friWorkHoursEst = bestTime;
                                } else if (timesHolder20.size() == 1) {
                                    WeekPeekActivity.this.friWorkHoursEst = (String) timesHolder20.get(0);
                                }
                            } else if (day3.equals("Sat")) {
                                ArrayList<Double> tipsHolder7 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("tips").getValue();
                                ArrayList<String> timesHolder21 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf("0" + dayInc3)).child(day3).child("times").getValue();
                                if (timesHolder21.size() != 1) {
                                    for (int inc15 = 0; inc15 != tipsHolder7.size(); inc15++) {
                                        for (int totInc7 = 1; totInc7 != tipsHolder7.size(); totInc7++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder7.get(inc15))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder7.get(totInc7))).doubleValue()) {
                                                bestTime = (String) timesHolder21.get(totInc7);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder7.get(inc15))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder7.get(totInc7))).doubleValue()) {
                                                bestTime = (String) timesHolder21.get(totInc7);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.satWorkHoursEst = bestTime;
                                } else if (timesHolder21.size() == 1) {
                                    WeekPeekActivity.this.satWorkHoursEst = (String) timesHolder21.get(0);
                                }
                            }
                        }
                    }
                    for (int dayInc4 = 10; dayInc4 <= 32; dayInc4++) {
                        if (dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).exists()) {
                            try {
                                WeekPeekActivity.this.date = WeekPeekActivity.this.dateFormat.parse(WeekPeekActivity.this.year + "-" + WeekPeekActivity.this.month + "-" + dayInc4);
                            } catch (ParseException e4) {
                                e4.printStackTrace();
                            }
                            String day4 = WeekPeekActivity.this.formatDayOfTheWeek.format(WeekPeekActivity.this.date);
                            if (day4.equals("Sun")) {
                                ArrayList<Double> tipsHolder8 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("tips").getValue();
                                ArrayList<String> timesHolder22 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("times").getValue();
                                if (timesHolder22.size() != 1) {
                                    for (int inc16 = 0; inc16 != tipsHolder8.size(); inc16++) {
                                        for (int totInc8 = 1; totInc8 != tipsHolder8.size(); totInc8++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder8.get(inc16))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder8.get(totInc8))).doubleValue()) {
                                                bestTime = (String) timesHolder22.get(totInc8);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder8.get(inc16))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder8.get(totInc8))).doubleValue()) {
                                                bestTime = (String) timesHolder22.get(totInc8);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.sunWorkHoursEst = bestTime;
                                } else if (timesHolder22.size() == 1) {
                                    WeekPeekActivity.this.sunWorkHoursEst = (String) timesHolder22.get(0);
                                }
                            } else if (day4.equals("Mon")) {
                                ArrayList<Double> tipsHolder9 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("tips").getValue();
                                ArrayList<String> timesHolder23 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("times").getValue();
                                if (timesHolder23.size() != 1) {
                                    for (int inc17 = 0; inc17 != tipsHolder9.size(); inc17++) {
                                        for (int totInc9 = 1; totInc9 != tipsHolder9.size(); totInc9++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder9.get(inc17))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder9.get(totInc9))).doubleValue()) {
                                                bestTime = (String) timesHolder23.get(totInc9);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder9.get(inc17))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder9.get(totInc9))).doubleValue()) {
                                                bestTime = (String) timesHolder23.get(totInc9);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.monWorkHoursEst = bestTime;
                                } else if (timesHolder23.size() == 1) {
                                    WeekPeekActivity.this.monWorkHoursEst = (String) timesHolder23.get(0);
                                }
                            } else if (day4.equals("Tue")) {
                                ArrayList<Double> tipsHolder10 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("tips").getValue();
                                ArrayList<String> timesHolder24 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("times").getValue();
                                if (timesHolder24.size() != 1) {
                                    for (int inc18 = 0; inc18 != tipsHolder10.size(); inc18++) {
                                        for (int totInc10 = 1; totInc10 != tipsHolder10.size(); totInc10++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder10.get(inc18))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder10.get(totInc10))).doubleValue()) {
                                                bestTime = (String) timesHolder24.get(totInc10);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder10.get(inc18))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder10.get(totInc10))).doubleValue()) {
                                                bestTime = (String) timesHolder24.get(totInc10);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.tueWorkHoursEst = bestTime;
                                } else if (timesHolder24.size() == 1) {
                                    WeekPeekActivity.this.tueWorkHoursEst = (String) timesHolder24.get(0);
                                }
                            } else if (day4.equals("Wed")) {
                                ArrayList<Double> tipsHolder11 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("tips").getValue();
                                ArrayList<String> timesHolder25 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("times").getValue();
                                if (timesHolder25.size() != 1) {
                                    for (int inc19 = 0; inc19 != tipsHolder11.size(); inc19++) {
                                        for (int totInc11 = 1; totInc11 != tipsHolder11.size(); totInc11++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder11.get(inc19))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder11.get(totInc11))).doubleValue()) {
                                                bestTime = (String) timesHolder25.get(totInc11);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder11.get(inc19))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder11.get(totInc11))).doubleValue()) {
                                                bestTime = (String) timesHolder25.get(totInc11);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.wedWorkHoursEst = bestTime;
                                } else if (timesHolder25.size() == 1) {
                                    WeekPeekActivity.this.wedWorkHoursEst = (String) timesHolder25.get(0);
                                }
                            } else if (day4.equals("Thu")) {
                                ArrayList<Double> tipsHolder12 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("tips").getValue();
                                ArrayList<String> timesHolder26 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("times").getValue();
                                if (timesHolder26.size() != 1) {
                                    for (int inc20 = 0; inc20 != tipsHolder12.size(); inc20++) {
                                        for (int totInc12 = 1; totInc12 != tipsHolder12.size(); totInc12++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder12.get(inc20))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder12.get(totInc12))).doubleValue()) {
                                                bestTime = (String) timesHolder26.get(totInc12);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder12.get(inc20))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder12.get(totInc12))).doubleValue()) {
                                                bestTime = (String) timesHolder26.get(totInc12);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.thuWorkHoursEst = bestTime;
                                } else if (timesHolder26.size() == 1) {
                                    WeekPeekActivity.this.thuWorkHoursEst = (String) timesHolder26.get(0);
                                }
                            } else if (day4.equals("Fri")) {
                                ArrayList<Double> tipsHolder13 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("tips").getValue();
                                ArrayList<String> timesHolder27 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("times").getValue();
                                if (timesHolder27.size() != 1) {
                                    for (int inc21 = 0; inc21 != tipsHolder13.size(); inc21++) {
                                        for (int totInc13 = 1; totInc13 != tipsHolder13.size(); totInc13++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder13.get(inc21))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder13.get(totInc13))).doubleValue()) {
                                                bestTime = (String) timesHolder27.get(totInc13);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder13.get(inc21))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder13.get(totInc13))).doubleValue()) {
                                                bestTime = (String) timesHolder27.get(totInc13);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.friWorkHoursEst = bestTime;
                                } else if (timesHolder27.size() == 1) {
                                    WeekPeekActivity.this.friWorkHoursEst = (String) timesHolder27.get(0);
                                }
                            } else if (day4.equals("Sat")) {
                                ArrayList<Double> tipsHolder14 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("tips").getValue();
                                ArrayList<String> timesHolder28 = (ArrayList) dataSnapshot.child(String.valueOf(weekInc3)).child(String.valueOf(dayInc4)).child(day4).child("times").getValue();
                                if (timesHolder28.size() != 1) {
                                    for (int inc22 = 0; inc22 != tipsHolder14.size(); inc22++) {
                                        for (int totInc14 = 1; totInc14 != tipsHolder14.size(); totInc14++) {
                                            if (Double.valueOf(String.valueOf(tipsHolder14.get(inc22))).doubleValue() > Double.valueOf(String.valueOf(tipsHolder14.get(totInc14))).doubleValue()) {
                                                bestTime = (String) timesHolder28.get(totInc14);
                                            } else if (Double.valueOf(String.valueOf(tipsHolder14.get(inc22))).doubleValue() < Double.valueOf(String.valueOf(tipsHolder14.get(totInc14))).doubleValue()) {
                                                bestTime = (String) timesHolder28.get(totInc14);
                                            }
                                        }
                                    }
                                    WeekPeekActivity.this.satWorkHoursEst = bestTime;
                                } else if (timesHolder28.size() == 1) {
                                    WeekPeekActivity.this.satWorkHoursEst = (String) timesHolder28.get(0);
                                }
                            }
                        }
                    }
                }
                if (WeekPeekActivity.this.sunSumEst > WeekPeekActivity.this.monSumEst) {
                    WeekPeekActivity.this.weekWorkHoursEst = WeekPeekActivity.this.sunWorkHoursEst;
                }
                if (WeekPeekActivity.this.monSumEst > WeekPeekActivity.this.tueSumEst) {
                    WeekPeekActivity.this.weekWorkHoursEst = WeekPeekActivity.this.monWorkHoursEst;
                }
                if (WeekPeekActivity.this.tueSumEst > WeekPeekActivity.this.wedSumEst) {
                    WeekPeekActivity.this.weekWorkHoursEst = WeekPeekActivity.this.tueWorkHoursEst;
                }
                if (WeekPeekActivity.this.wedSumEst > WeekPeekActivity.this.thuSumEst) {
                    WeekPeekActivity.this.weekWorkHoursEst = WeekPeekActivity.this.wedWorkHoursEst;
                }
                if (WeekPeekActivity.this.thuSumEst > WeekPeekActivity.this.friSumEst) {
                    WeekPeekActivity.this.weekWorkHoursEst = WeekPeekActivity.this.thuWorkHoursEst;
                }
                if (WeekPeekActivity.this.friSumEst > WeekPeekActivity.this.satSumEst) {
                    WeekPeekActivity.this.weekWorkHoursEst = WeekPeekActivity.this.friWorkHoursEst;
                }
                if (WeekPeekActivity.this.satSumEst > WeekPeekActivity.this.sunSumEst) {
                    WeekPeekActivity.this.weekWorkHoursEst = WeekPeekActivity.this.satWorkHoursEst;
                }
                if (WeekPeekActivity.this.weekSumEst > 0.0d) {
                    WeekPeekActivity.this.tipsEstTextView.setText("$" + String.valueOf(WeekPeekActivity.this.decimalFormat.format(WeekPeekActivity.this.weekSumEst)));
                } else {
                    WeekPeekActivity.this.tipsEstTextView.setText("$0.00");
                }
                if (WeekPeekActivity.this.weekWorkTables.size() != 0) {
                    WeekPeekActivity.this.tablesEstTextView.setText(String.valueOf(WeekPeekActivity.this.weekWorkTablesEst).replace("[", "").replace("]", ""));
                } else {
                    WeekPeekActivity.this.tablesEstTextView.setText("no tables");
                }
                if (WeekPeekActivity.this.weekWorkHoursEst != null) {
                    WeekPeekActivity.this.timesEstTextView.setText(WeekPeekActivity.this.weekWorkHoursEst);
                } else {
                    WeekPeekActivity.this.timesEstTextView.setText("no hours");
                }
                WeekPeekActivity.this.loadingIcon.stop();
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void onClick(View view) {
        Boolean valueOf = Boolean.valueOf(true);
        Boolean valueOf2 = Boolean.valueOf(true);
        Boolean valueOf3 = Boolean.valueOf(true);
        Boolean valueOf4 = Boolean.valueOf(true);
        Boolean valueOf5 = Boolean.valueOf(true);
        Boolean valueOf6 = Boolean.valueOf(true);
        Boolean valueOf7 = Boolean.valueOf(true);
        switch (view.getId()) {
            case R.id.week_peek_sunday /*2131558534*/:
                changeFocus();
                Boolean sunIsActive = Boolean.valueOf(true);
                this.focusedDayTextView.setText("Sunday");
                if (this.sunTot > 0.0d) {
                    this.tipsActualTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.sunTot - this.sunTipShare)));
                } else {
                    this.tipsActualTextView.setText("$0.00");
                }
                if (this.sunWorkTables.size() != 0) {
                    this.tablesActualTextView.setText(String.valueOf(this.sunWorkTables).replace("[", "").replace("]", ""));
                } else {
                    this.tablesActualTextView.setText("no tables");
                }
                if (this.sunWorkHours != null) {
                    this.timesActualTextView.setText(this.sunWorkHours);
                } else {
                    this.timesActualTextView.setText("no hours");
                }
                if (this.sunSumEst > 0.0d) {
                    this.tipsEstTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.sunSumEst)));
                } else {
                    this.tipsEstTextView.setText("$0.00");
                }
                if (this.sunWorkTablesEst.size() != 0) {
                    this.tablesEstTextView.setText(String.valueOf(this.sunWorkTablesEst).replace("[", "").replace("]", ""));
                } else {
                    this.tablesEstTextView.setText("no tables");
                }
                if (this.sunWorkHoursEst != null) {
                    this.timesEstTextView.setText(this.sunWorkHoursEst);
                } else {
                    this.timesEstTextView.setText("no hours");
                }
                if (sunIsActive.booleanValue()) {
                    this.sundayLayout.setBackgroundColor(Colors.SECONDARY_COLOR);
                    this.sundayTextView.setTextColor(Colors.PRIMARY_COLOR);
                    this.sundayTipTextView.setTextColor(Colors.PRIMARY_COLOR);
                    return;
                }
                return;
            case R.id.week_peek_monday /*2131558537*/:
                changeFocus();
                Boolean monIsActive = Boolean.valueOf(true);
                this.focusedDayTextView.setText("Monday");
                if (this.monTot > 0.0d) {
                    this.tipsActualTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.monTot - this.monTipShare)));
                } else {
                    this.tipsActualTextView.setText("$0.00");
                }
                if (this.monWorkTables.size() != 0) {
                    this.tablesActualTextView.setText(String.valueOf(this.monWorkTables).replace("[", "").replace("]", ""));
                } else {
                    this.tablesActualTextView.setText("no tables");
                }
                if (this.monWorkHours != null) {
                    this.timesActualTextView.setText(this.monWorkHours);
                } else {
                    this.timesActualTextView.setText("no hours");
                }
                if (this.monSumEst > 0.0d) {
                    this.tipsEstTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.monSumEst)));
                } else {
                    this.tipsEstTextView.setText("$0.00");
                }
                if (this.monWorkTablesEst.size() != 0) {
                    this.tablesEstTextView.setText(String.valueOf(this.monWorkTablesEst).replace("[", "").replace("]", ""));
                } else {
                    this.tablesEstTextView.setText("no tables");
                }
                if (this.monWorkHoursEst != null) {
                    this.timesEstTextView.setText(this.monWorkHoursEst);
                } else {
                    this.timesEstTextView.setText("no hours");
                }
                if (monIsActive.booleanValue()) {
                    this.mondayLayout.setBackgroundColor(Colors.SECONDARY_COLOR);
                    this.mondayTextView.setTextColor(Colors.PRIMARY_COLOR);
                    this.mondayTipTextView.setTextColor(Colors.PRIMARY_COLOR);
                    return;
                }
                return;
            case R.id.week_peek_tuesday /*2131558540*/:
                changeFocus();
                Boolean tueIsActive = Boolean.valueOf(true);
                this.focusedDayTextView.setText("Tuesday");
                if (this.tueTot > 0.0d) {
                    this.tipsActualTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.tueTot - this.tueTipShare)));
                } else {
                    this.tipsActualTextView.setText("$0.00");
                }
                if (this.tueWorkTables.size() != 0) {
                    this.tablesActualTextView.setText(String.valueOf(this.tueWorkTables).replace("[", "").replace("]", ""));
                } else {
                    this.tablesActualTextView.setText("no tables");
                }
                if (this.tueWorkHours != null) {
                    this.timesActualTextView.setText(this.tueWorkHours);
                } else {
                    this.timesActualTextView.setText("no hours");
                }
                if (this.tueSumEst > 0.0d) {
                    this.tipsEstTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.tueSumEst)));
                } else {
                    this.tipsEstTextView.setText("$0.00");
                }
                if (this.tueWorkTablesEst.size() != 0) {
                    this.tablesEstTextView.setText(String.valueOf(this.tueWorkTablesEst).replace("[", "").replace("]", ""));
                } else {
                    this.tablesEstTextView.setText("no tables");
                }
                if (this.tueWorkHoursEst != null) {
                    this.timesEstTextView.setText(this.tueWorkHoursEst);
                } else {
                    this.timesEstTextView.setText("no hours");
                }
                if (tueIsActive.booleanValue()) {
                    this.tuesdayLayout.setBackgroundColor(Colors.SECONDARY_COLOR);
                    this.tuesdayTextView.setTextColor(Colors.PRIMARY_COLOR);
                    this.tuesdayTipTextView.setTextColor(Colors.PRIMARY_COLOR);
                    return;
                }
                return;
            case R.id.week_peek_wednesday /*2131558543*/:
                changeFocus();
                Boolean wedIsActive = Boolean.valueOf(true);
                this.focusedDayTextView.setText("Wednesday");
                if (this.wedTot > 0.0d) {
                    this.tipsActualTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.wedTot - this.wedTipShare)));
                } else {
                    this.tipsActualTextView.setText("$0.00");
                }
                if (this.wedWorkTables.size() != 0) {
                    this.tablesActualTextView.setText(String.valueOf(this.wedWorkTables).replace("[", "").replace("]", ""));
                } else {
                    this.tablesActualTextView.setText("no tables");
                }
                if (this.wedWorkHours != null) {
                    this.timesActualTextView.setText(this.wedWorkHours);
                } else {
                    this.timesActualTextView.setText("no hours");
                }
                if (this.wedSumEst > 0.0d) {
                    this.tipsEstTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.wedSumEst)));
                } else {
                    this.tipsEstTextView.setText("$0.00");
                }
                if (this.wedWorkTablesEst.size() != 0) {
                    this.tablesEstTextView.setText(String.valueOf(this.wedWorkTablesEst).replace("[", "").replace("]", ""));
                } else {
                    this.tablesEstTextView.setText("no tables");
                }
                if (this.wedWorkHoursEst != null) {
                    this.timesEstTextView.setText(this.wedWorkHoursEst);
                } else {
                    this.timesEstTextView.setText("no hours");
                }
                if (wedIsActive.booleanValue()) {
                    this.wednesdayLayout.setBackgroundColor(Colors.SECONDARY_COLOR);
                    this.wednesdayTextView.setTextColor(Colors.PRIMARY_COLOR);
                    this.wednesdayTipTextView.setTextColor(Colors.PRIMARY_COLOR);
                    return;
                }
                return;
            case R.id.week_peek_thursday /*2131558546*/:
                changeFocus();
                Boolean thuIsActive = Boolean.valueOf(true);
                this.focusedDayTextView.setText("Thursday");
                if (this.thuTot > 0.0d) {
                    this.tipsActualTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.thuTot - this.thuTipShare)));
                } else {
                    this.tipsActualTextView.setText("$0.00");
                }
                if (this.thuWorkTables.size() != 0) {
                    this.tablesActualTextView.setText(String.valueOf(this.thuWorkTables).replace("[", "").replace("]", ""));
                } else {
                    this.tablesActualTextView.setText("no tables");
                }
                if (this.thuWorkHours != null) {
                    this.timesActualTextView.setText(this.thuWorkHours);
                } else {
                    this.timesActualTextView.setText("no hours");
                }
                if (this.thuSumEst > 0.0d) {
                    this.tipsEstTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.thuSumEst)));
                } else {
                    this.tipsEstTextView.setText("$0.00");
                }
                if (this.thuWorkTablesEst.size() != 0) {
                    this.tablesEstTextView.setText(String.valueOf(this.thuWorkTablesEst).replace("[", "").replace("]", ""));
                } else {
                    this.tablesEstTextView.setText("no tables");
                }
                if (this.thuWorkHoursEst != null) {
                    this.timesEstTextView.setText(this.thuWorkHoursEst);
                } else {
                    this.timesEstTextView.setText("no hours");
                }
                if (thuIsActive.booleanValue()) {
                    this.thursdayLayout.setBackgroundColor(Colors.SECONDARY_COLOR);
                    this.thursdayTextView.setTextColor(Colors.PRIMARY_COLOR);
                    this.thursdayTipTextView.setTextColor(Colors.PRIMARY_COLOR);
                    return;
                }
                return;
            case R.id.week_peek_friday /*2131558549*/:
                changeFocus();
                Boolean friIsActive = Boolean.valueOf(true);
                this.focusedDayTextView.setText("Friday");
                if (this.friTot > 0.0d) {
                    this.tipsActualTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.friTot - this.friTipShare)));
                } else {
                    this.tipsActualTextView.setText("$0.00");
                }
                if (this.friWorkTables.size() != 0) {
                    this.tablesActualTextView.setText(String.valueOf(this.friWorkTables).replace("[", "").replace("]", ""));
                } else {
                    this.tablesActualTextView.setText("no tables");
                }
                if (this.friWorkHours != null) {
                    this.timesActualTextView.setText(this.friWorkHours);
                } else {
                    this.timesActualTextView.setText("no hours");
                }
                if (this.friSumEst > 0.0d) {
                    this.tipsEstTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.friSumEst)));
                } else {
                    this.tipsEstTextView.setText("$0.00");
                }
                if (this.friWorkTablesEst.size() != 0) {
                    this.tablesEstTextView.setText(String.valueOf(this.friWorkTablesEst).replace("[", "").replace("]", ""));
                } else {
                    this.tablesEstTextView.setText("no tables");
                }
                if (this.friWorkHoursEst != null) {
                    this.timesEstTextView.setText(this.friWorkHoursEst);
                } else {
                    this.timesEstTextView.setText("no hours");
                }
                if (friIsActive.booleanValue()) {
                    this.fridayLayout.setBackgroundColor(Colors.SECONDARY_COLOR);
                    this.fridayTextView.setTextColor(Colors.PRIMARY_COLOR);
                    this.fridayTipTextView.setTextColor(Colors.PRIMARY_COLOR);
                    return;
                }
                return;
            case R.id.week_peek_saturday /*2131558552*/:
                changeFocus();
                Boolean satIsActive = Boolean.valueOf(true);
                this.focusedDayTextView.setText("Saturday");
                if (this.satTot > 0.0d) {
                    this.tipsActualTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.satTot - this.satTipShare)));
                } else {
                    this.tipsActualTextView.setText("$0.00");
                }
                if (this.satWorkTables.size() != 0) {
                    this.tablesActualTextView.setText(String.valueOf(this.satWorkTables).replace("[", "").replace("]", ""));
                } else {
                    this.tablesActualTextView.setText("no tables");
                }
                if (this.satWorkHours != null) {
                    this.timesActualTextView.setText(this.satWorkHours);
                } else {
                    this.timesActualTextView.setText("no hours");
                }
                if (this.satSumEst > 0.0d) {
                    this.tipsEstTextView.setText("$" + String.valueOf(this.decimalFormat.format(this.satSumEst)));
                } else {
                    this.tipsEstTextView.setText("$0.00");
                }
                if (this.satWorkTablesEst.size() != 0) {
                    this.tablesEstTextView.setText(String.valueOf(this.satWorkTablesEst).replace("[", "").replace("]", ""));
                } else {
                    this.tablesEstTextView.setText("no tables");
                }
                if (this.satWorkHoursEst != null) {
                    this.timesEstTextView.setText(this.satWorkHoursEst);
                } else {
                    this.timesEstTextView.setText("no hours");
                }
                if (satIsActive.booleanValue()) {
                    this.saturdayLayout.setBackgroundColor(Colors.SECONDARY_COLOR);
                    this.saturdayTextView.setTextColor(Colors.PRIMARY_COLOR);
                    this.saturdayTipTextView.setTextColor(Colors.PRIMARY_COLOR);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public void changeFocus() {
        this.sundayLayout.setBackgroundColor(Colors.DEFAULT_BACKGROUND);
        this.sundayTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
        this.sundayTipTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
        this.mondayLayout.setBackgroundColor(Colors.DEFAULT_BACKGROUND);
        this.mondayTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
        this.mondayTipTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
        this.tuesdayLayout.setBackgroundColor(Colors.DEFAULT_BACKGROUND);
        this.tuesdayTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
        this.tuesdayTipTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
        this.wednesdayLayout.setBackgroundColor(Colors.DEFAULT_BACKGROUND);
        this.wednesdayTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
        this.wednesdayTipTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
        this.thursdayLayout.setBackgroundColor(Colors.DEFAULT_BACKGROUND);
        this.thursdayTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
        this.thursdayTipTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
        this.fridayLayout.setBackgroundColor(Colors.DEFAULT_BACKGROUND);
        this.fridayTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
        this.fridayTipTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
        this.saturdayLayout.setBackgroundColor(Colors.DEFAULT_BACKGROUND);
        this.saturdayTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
        this.saturdayTipTextView.setTextColor(Colors.DEFAULT_TEXT_COLOR);
    }

    /* access modifiers changed from: private */
    public String hourConverter(int time) {
        String convertedTime = "";
        if (String.valueOf(time).equals("00") || String.valueOf(time).equals("0")) {
            convertedTime = "12AM";
        }
        if (String.valueOf(time).equals("01") || String.valueOf(time).equals("1")) {
            convertedTime = "1AM";
        }
        if (String.valueOf(time).equals("02") || String.valueOf(time).equals("2")) {
            convertedTime = "2AM";
        }
        if (String.valueOf(time).equals("03") || String.valueOf(time).equals("3")) {
            convertedTime = "3AM";
        }
        if (String.valueOf(time).equals("04") || String.valueOf(time).equals("4")) {
            convertedTime = "4AM";
        }
        if (String.valueOf(time).equals("05") || String.valueOf(time).equals("5")) {
            convertedTime = "5AM";
        }
        if (String.valueOf(time).equals("06") || String.valueOf(time).equals("6")) {
            convertedTime = "6AM";
        }
        if (String.valueOf(time).equals("07") || String.valueOf(time).equals("7")) {
            convertedTime = "7AM";
        }
        if (String.valueOf(time).equals("08") || String.valueOf(time).equals("8")) {
            convertedTime = "8AM";
        }
        if (String.valueOf(time).equals("09") || String.valueOf(time).equals("9")) {
            convertedTime = "9AM";
        }
        if (String.valueOf(time).equals("10")) {
            convertedTime = "10AM";
        }
        if (String.valueOf(time).equals("11")) {
            convertedTime = "11AM";
        }
        if (String.valueOf(time).equals("12")) {
            convertedTime = "12PM";
        }
        if (String.valueOf(time).equals("13")) {
            convertedTime = "1PM";
        }
        if (String.valueOf(time).equals("14")) {
            convertedTime = "2PM";
        }
        if (String.valueOf(time).equals("15")) {
            convertedTime = "3PM";
        }
        if (String.valueOf(time).equals("16")) {
            convertedTime = "4PM";
        }
        if (String.valueOf(time).equals("17")) {
            convertedTime = "5PM";
        }
        if (String.valueOf(time).equals("18")) {
            convertedTime = "6PM";
        }
        if (String.valueOf(time).equals("19")) {
            convertedTime = "7PM";
        }
        if (String.valueOf(time).equals("20")) {
            convertedTime = "8PM";
        }
        if (String.valueOf(time).equals("21")) {
            convertedTime = "9PM";
        }
        if (String.valueOf(time).equals("22")) {
            convertedTime = "10PM";
        }
        if (String.valueOf(time).equals("23")) {
            convertedTime = "11PM";
        }
        if (String.valueOf(time).equals("24")) {
            return "12AM";
        }
        return convertedTime;
    }

    /* access modifiers changed from: private */
    public double sumEst(ArrayList<Double> tipsArr) {
        double tip = 0.0d;
        for (int inc = 0; tipsArr.size() != inc; inc++) {
            tip += Double.valueOf(String.valueOf(tipsArr.get(inc))).doubleValue();
        }
        return tip;
    }
}
