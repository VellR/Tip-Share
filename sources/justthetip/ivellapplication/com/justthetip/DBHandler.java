package justthetip.ivellapplication.com.justthetip;

import android.util.Log;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DBHandler {
    private Date date = new Date();
    private String day = new SimpleDateFormat("dd").format(this.date);
    /* access modifiers changed from: private */
    public String dayOfWeek = this.formatDayOfTheWeek.format(this.date);
    private ArrayList<Integer> dayTable = new ArrayList<>();
    private ArrayList<Integer> dayTime = new ArrayList<>();
    private ArrayList<Double> dayTip = new ArrayList<>();
    private DateFormat formatDayOfTheWeek = new SimpleDateFormat("EEE");
    private String hour = new SimpleDateFormat("HH").format(this.date);
    private ArrayList<Integer> hourTable = new ArrayList<>();
    private ArrayList<Integer> hourTime = new ArrayList<>();
    private ArrayList<Double> hourTip = new ArrayList<>();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference mIdRef = this.mPostRef.child(this.mAuth.getCurrentUser().getUid());
    private DatabaseReference mPostRef = this.mRootRef.child("user-posts");
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private String month = new SimpleDateFormat("MM").format(this.date);
    private ArrayList<Integer> monthTable = new ArrayList<>();
    private ArrayList<Integer> monthTime = new ArrayList<>();
    private ArrayList<Double> monthTip = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Integer> theTable = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Double> theTip = new ArrayList<>();
    private String week = new SimpleDateFormat("W").format(this.date);
    private ArrayList<Integer> weekTable = new ArrayList<>();
    private ArrayList<Integer> weekTime = new ArrayList<>();
    private ArrayList<Double> weekTip = new ArrayList<>();
    private String year = new SimpleDateFormat("yyyy").format(this.date);
    private ArrayList<Integer> yearTable = new ArrayList<>();
    private ArrayList<Integer> yearTime = new ArrayList<>();
    private ArrayList<Double> yearTip = new ArrayList<>();

    public void updateDatabase(final ArrayList<Double> newTips, final ArrayList<Integer> newTable) {
        final DatabaseReference mHourRef = this.mIdRef.child(this.year + "/" + this.month + "/" + this.week + "/" + this.day + "/" + this.hour);
        if (newTips != null) {
            mHourRef.addListenerForSingleValueEvent(new ValueEventListener() {
                public void onDataChange(DataSnapshot dataSnapshot) {
                    ArrayList<Double> tips = (ArrayList) dataSnapshot.child("tips").getValue();
                    if (tips != null) {
                        tips.addAll(newTips);
                    } else {
                        tips = newTips;
                    }
                    ArrayList<Integer> tables = (ArrayList) dataSnapshot.child("tables").getValue();
                    if (tables != null) {
                        tables.addAll(newTable);
                    } else {
                        tables = newTable;
                    }
                    double total = DBHandler.this.totalUp(tips);
                    DBHandler.this.filter(tips, tables);
                    DBHandler.this.setHourTip(DBHandler.this.theTip);
                    DBHandler.this.setHourTable(DBHandler.this.theTable);
                    mHourRef.child("tips").setValue(DBHandler.this.getHourTip());
                    mHourRef.child("tables").setValue(DBHandler.this.getHourTable());
                    mHourRef.child("total").setValue(Double.valueOf(total));
                    DBHandler.this.updateDay();
                }

                public void onCancelled(DatabaseError databaseError) {
                }
            });
            return;
        }
        filter(null, null);
        updateDay();
    }

    /* access modifiers changed from: private */
    public void updateDay() {
        final DatabaseReference mDayRef = this.mIdRef.child(this.year + "/" + this.month + "/" + this.week + "/" + this.day);
        mDayRef.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Double> tips = new ArrayList<>();
                ArrayList<Integer> tables = new ArrayList<>();
                ArrayList<String> times = new ArrayList<>();
                for (int i = 0; i <= 9; i++) {
                    if (dataSnapshot.child(String.valueOf("0" + i)).exists()) {
                        ArrayList<Double> tipsHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child("tips").getValue();
                        ArrayList<Integer> tablesHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child("tables").getValue();
                        tips.addAll(tipsHolder);
                        tables.addAll(tablesHolder);
                    }
                }
                for (int i2 = 10; i2 <= 24; i2++) {
                    if (dataSnapshot.child(String.valueOf(i2)).exists()) {
                        ArrayList<Double> tipsHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(i2)).child("tips").getValue();
                        ArrayList<Integer> tablesHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(i2)).child("tables").getValue();
                        tips.addAll(tipsHolder2);
                        tables.addAll(tablesHolder2);
                    }
                }
                double total = DBHandler.this.totalUp(tips);
                ArrayList<Integer> timeHolder = new ArrayList<>();
                for (int timeInc = 0; timeInc <= 9; timeInc++) {
                    if (dataSnapshot.child("0" + timeInc).exists()) {
                        timeHolder.add(Integer.valueOf(timeInc));
                    }
                }
                for (int timeInc2 = 10; timeInc2 <= 24; timeInc2++) {
                    if (dataSnapshot.child(String.valueOf(timeInc2)).exists()) {
                        timeHolder.add(Integer.valueOf(timeInc2));
                    }
                }
                String startHour = DBHandler.this.hourConverter(((Integer) timeHolder.get(0)).intValue());
                String endHour = "";
                if (timeHolder.size() > 1) {
                    endHour = DBHandler.this.hourConverter(((Integer) timeHolder.get(timeHolder.size() - 1)).intValue());
                }
                times.add(startHour + "-" + endHour);
                DBHandler.this.filter(tips, tables);
                DBHandler.this.setDayTip(DBHandler.this.theTip);
                DBHandler.this.setDayTable(DBHandler.this.theTable);
                mDayRef.child("tips").setValue(DBHandler.this.getDayTip());
                mDayRef.child("tables").setValue(DBHandler.this.getDayTable());
                mDayRef.child(DBHandler.this.dayOfWeek).child("tips").setValue(DBHandler.this.getDayTip());
                mDayRef.child(DBHandler.this.dayOfWeek).child("tables").setValue(DBHandler.this.getDayTable());
                mDayRef.child(DBHandler.this.dayOfWeek).child("times").setValue(times);
                mDayRef.child(DBHandler.this.dayOfWeek).child("total").setValue(Double.valueOf(total));
                DBHandler.this.updateWeek();
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateWeek() {
        final DatabaseReference mWeekRef = this.mIdRef.child(this.year + "/" + this.month + "/" + this.week);
        mWeekRef.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Double> tips = new ArrayList<>();
                ArrayList<Integer> tables = new ArrayList<>();
                ArrayList<String> times = new ArrayList<>();
                for (int i = 0; i <= 9; i++) {
                    if (dataSnapshot.child(String.valueOf("0" + i)).exists()) {
                        ArrayList<Integer> tablesHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child("tables").getValue();
                        ArrayList<String> timesHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child(DBHandler.this.dayOfWeek).child("times").getValue();
                        tips.addAll((ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child("tips").getValue());
                        tables.addAll(tablesHolder);
                        times = timesHolder;
                    }
                }
                for (int i2 = 10; i2 <= 32; i2++) {
                    if (dataSnapshot.child(String.valueOf(i2)).exists()) {
                        ArrayList<Integer> tablesHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(i2)).child("tables").getValue();
                        ArrayList<String> timesHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(i2)).child(DBHandler.this.dayOfWeek).child("times").getValue();
                        tips.addAll((ArrayList) dataSnapshot.child(String.valueOf(i2)).child("tips").getValue());
                        tables.addAll(tablesHolder2);
                        times = timesHolder2;
                    }
                }
                double total = DBHandler.this.totalUp(tips);
                DBHandler.this.filter(tips, tables);
                DBHandler.this.setWeekTip(DBHandler.this.theTip);
                DBHandler.this.setWeekTable(DBHandler.this.theTable);
                mWeekRef.child("tips").setValue(DBHandler.this.getWeekTip());
                mWeekRef.child("tables").setValue(DBHandler.this.getWeekTable());
                mWeekRef.child(DBHandler.this.dayOfWeek).child("tips").setValue(DBHandler.this.getWeekTip());
                mWeekRef.child(DBHandler.this.dayOfWeek).child("tables").setValue(DBHandler.this.getWeekTable());
                mWeekRef.child(DBHandler.this.dayOfWeek).child("times").setValue(times);
                mWeekRef.child(DBHandler.this.dayOfWeek).child("total").setValue(Double.valueOf(total));
                DBHandler.this.updateMonth();
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateMonth() {
        final DatabaseReference mMonthRef = this.mIdRef.child(this.year + "/" + this.month);
        mMonthRef.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Double> tips = new ArrayList<>();
                ArrayList<Integer> tables = new ArrayList<>();
                ArrayList<String> times = new ArrayList<>();
                for (int i = 0; i <= 6; i++) {
                    if (dataSnapshot.child(String.valueOf(i)).exists()) {
                        ArrayList<Integer> tablesHolder = (ArrayList) dataSnapshot.child(String.valueOf(i)).child("tables").getValue();
                        ArrayList<String> timesHolder = (ArrayList) dataSnapshot.child(String.valueOf(i)).child(DBHandler.this.dayOfWeek).child("times").getValue();
                        tips.addAll((ArrayList) dataSnapshot.child(String.valueOf(i)).child("tips").getValue());
                        tables.addAll(tablesHolder);
                        times = timesHolder;
                    }
                }
                double total = DBHandler.this.totalUp(tips);
                DBHandler.this.filter(tips, tables);
                DBHandler.this.setMonthTip(DBHandler.this.theTip);
                DBHandler.this.setMonthTable(DBHandler.this.theTable);
                mMonthRef.child("tips").setValue(DBHandler.this.getMonthTip());
                mMonthRef.child("tables").setValue(DBHandler.this.getMonthTable());
                mMonthRef.child(DBHandler.this.dayOfWeek).child("tips").setValue(DBHandler.this.getMonthTip());
                mMonthRef.child(DBHandler.this.dayOfWeek).child("tables").setValue(DBHandler.this.getMonthTable());
                mMonthRef.child(DBHandler.this.dayOfWeek).child("times").setValue(times);
                mMonthRef.child(DBHandler.this.dayOfWeek).child("total").setValue(Double.valueOf(total));
                DBHandler.this.updateYear();
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateYear() {
        final DatabaseReference mYearRef = this.mIdRef.child(this.year);
        mYearRef.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Double> tips = new ArrayList<>();
                ArrayList<Integer> tables = new ArrayList<>();
                ArrayList<String> times = new ArrayList<>();
                for (int i = 0; i <= 9; i++) {
                    if (dataSnapshot.child(String.valueOf("0" + i)).exists()) {
                        ArrayList<Integer> tablesHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child("tables").getValue();
                        ArrayList<String> timesHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child(DBHandler.this.dayOfWeek).child("times").getValue();
                        tips.addAll((ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child("tips").getValue());
                        tables.addAll(tablesHolder);
                        if (timesHolder != null) {
                            times = timesHolder;
                        }
                    }
                }
                for (int i2 = 10; i2 <= 12; i2++) {
                    if (dataSnapshot.child(String.valueOf(i2)).exists()) {
                        ArrayList<Integer> tablesHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(i2)).child("tables").getValue();
                        ArrayList<String> timesHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(i2)).child(DBHandler.this.dayOfWeek).child("times").getValue();
                        tips.addAll((ArrayList) dataSnapshot.child(String.valueOf(i2)).child("tips").getValue());
                        tables.addAll(tablesHolder2);
                        if (timesHolder2 != null) {
                            times = timesHolder2;
                        }
                    }
                }
                double total = DBHandler.this.totalUp(tips);
                DBHandler.this.filter(tips, tables);
                DBHandler.this.setYearTip(DBHandler.this.theTip);
                DBHandler.this.setYearTable(DBHandler.this.theTable);
                mYearRef.child("tips").setValue(DBHandler.this.getYearTip());
                mYearRef.child("tables").setValue(DBHandler.this.getYearTable());
                mYearRef.child(DBHandler.this.dayOfWeek).child("tips").setValue(DBHandler.this.getYearTip());
                mYearRef.child(DBHandler.this.dayOfWeek).child("tables").setValue(DBHandler.this.getYearTable());
                mYearRef.child(DBHandler.this.dayOfWeek).child("times").setValue(times);
                mYearRef.child(DBHandler.this.dayOfWeek).child("total").setValue(Double.valueOf(total));
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void Day() {
        this.mIdRef.child(this.year + "/" + this.month + "/" + this.week + "/" + this.day).addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Integer> tables = new ArrayList<>();
                ArrayList<Integer> times = new ArrayList<>();
                ArrayList<Double> totals = new ArrayList<>();
                for (int i = 0; i <= 9; i++) {
                    if (dataSnapshot.child(String.valueOf("0" + i)).exists()) {
                        ArrayList<Double> tipsHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child("tips").getValue();
                        ArrayList<Integer> tablesHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child("tables").getValue();
                        times.add(Integer.valueOf(i));
                        tables.addAll(tablesHolder);
                        double sum = 0.0d;
                        for (int inc = 0; tipsHolder.size() != inc; inc++) {
                            sum += Double.valueOf(String.valueOf(tipsHolder.get(inc))).doubleValue();
                        }
                        totals.add(Double.valueOf(sum));
                    }
                }
                for (int i2 = 10; i2 <= 24; i2++) {
                    if (dataSnapshot.child(String.valueOf(i2)).exists()) {
                        ArrayList<Double> tipsHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(i2)).child("tips").getValue();
                        ArrayList<Integer> tablesHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(i2)).child("tables").getValue();
                        times.add(Integer.valueOf(i2));
                        tables.addAll(tablesHolder2);
                        double sum2 = 0.0d;
                        for (int inc2 = 0; tipsHolder2.size() != inc2; inc2++) {
                            sum2 += Double.valueOf(String.valueOf(tipsHolder2.get(inc2))).doubleValue();
                        }
                        totals.add(Double.valueOf(sum2));
                    }
                }
                DBHandler.this.setDayTip(totals);
                DBHandler.this.setDayTable(tables);
                DBHandler.this.setDayTime(times);
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void Week() {
        this.mIdRef.child(this.year + "/" + this.month + "/" + this.week).addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Integer> tables = new ArrayList<>();
                ArrayList<Integer> times = new ArrayList<>();
                ArrayList<Double> totals = new ArrayList<>();
                for (int i = 0; i <= 9; i++) {
                    if (dataSnapshot.child(String.valueOf("0" + i)).exists()) {
                        ArrayList<Double> tipsHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child("tips").getValue();
                        ArrayList<Integer> tablesHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child("tables").getValue();
                        times.add(Integer.valueOf(i));
                        tables.addAll(tablesHolder);
                        double sum = 0.0d;
                        for (int inc = 0; tipsHolder.size() != inc; inc++) {
                            sum += Double.valueOf(String.valueOf(tipsHolder.get(inc))).doubleValue();
                        }
                        totals.add(Double.valueOf(sum));
                    }
                }
                for (int i2 = 10; i2 <= 32; i2++) {
                    if (dataSnapshot.child(String.valueOf(i2)).exists()) {
                        ArrayList<Double> tipsHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(i2)).child("tips").getValue();
                        ArrayList<Integer> tablesHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(i2)).child("tables").getValue();
                        times.add(Integer.valueOf(i2));
                        tables.addAll(tablesHolder2);
                        double sum2 = 0.0d;
                        for (int inc2 = 0; tipsHolder2.size() != inc2; inc2++) {
                            sum2 += Double.valueOf(String.valueOf(tipsHolder2.get(inc2))).doubleValue();
                        }
                        totals.add(Double.valueOf(sum2));
                    }
                }
                DBHandler.this.setWeekTip(totals);
                DBHandler.this.setWeekTable(tables);
                DBHandler.this.setWeekTime(times);
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void Month() {
        this.mIdRef.child(this.year + "/" + this.month).addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Integer> tables = new ArrayList<>();
                ArrayList<Integer> times = new ArrayList<>();
                ArrayList<Double> totals = new ArrayList<>();
                for (int i = 0; i <= 6; i++) {
                    if (dataSnapshot.child(String.valueOf(i)).exists()) {
                        ArrayList<Double> tipsHolder = (ArrayList) dataSnapshot.child(String.valueOf(i)).child("tips").getValue();
                        ArrayList<Integer> tablesHolder = (ArrayList) dataSnapshot.child(String.valueOf(i)).child("tables").getValue();
                        times.add(Integer.valueOf(i));
                        tables.addAll(tablesHolder);
                        double sum = 0.0d;
                        for (int inc = 0; tipsHolder.size() != inc; inc++) {
                            sum += Double.valueOf(String.valueOf(tipsHolder.get(inc))).doubleValue();
                        }
                        totals.add(Double.valueOf(sum));
                    }
                }
                DBHandler.this.setMonthTip(totals);
                DBHandler.this.setMonthTable(tables);
                DBHandler.this.setMonthTime(times);
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void Year() {
        this.mIdRef.child(this.year).addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Integer> tables = new ArrayList<>();
                ArrayList<Integer> times = new ArrayList<>();
                ArrayList<Double> totals = new ArrayList<>();
                for (int i = 0; i <= 9; i++) {
                    if (dataSnapshot.child(String.valueOf("0" + i)).exists()) {
                        ArrayList<Double> tipsHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child("tips").getValue();
                        ArrayList<Integer> tablesHolder = (ArrayList) dataSnapshot.child(String.valueOf("0" + i)).child("tables").getValue();
                        times.add(Integer.valueOf(i));
                        tables.addAll(tablesHolder);
                        double sum = 0.0d;
                        for (int inc = 0; tipsHolder.size() != inc; inc++) {
                            sum += Double.valueOf(String.valueOf(tipsHolder.get(inc))).doubleValue();
                        }
                        totals.add(Double.valueOf(sum));
                    }
                }
                for (int i2 = 10; i2 <= 12; i2++) {
                    if (dataSnapshot.child(String.valueOf(i2)).exists()) {
                        ArrayList<Double> tipsHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(i2)).child("tips").getValue();
                        ArrayList<Integer> tablesHolder2 = (ArrayList) dataSnapshot.child(String.valueOf(i2)).child("tables").getValue();
                        times.add(Integer.valueOf(i2));
                        tables.addAll(tablesHolder2);
                        double sum2 = 0.0d;
                        for (int inc2 = 0; tipsHolder2.size() != inc2; inc2++) {
                            sum2 += Double.valueOf(String.valueOf(tipsHolder2.get(inc2))).doubleValue();
                        }
                        totals.add(Double.valueOf(sum2));
                    }
                }
                DBHandler.this.setYearTip(totals);
                DBHandler.this.setYearTable(tables);
                DBHandler.this.setYearTime(times);
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void updateTipShare(final double tipShare) {
        final DatabaseReference mDayRef = this.mIdRef.child(this.year + "/" + this.month + "/" + this.week + "/" + this.day);
        mDayRef.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                double oldTip = 0.0d;
                if (dataSnapshot.child("tipShare").exists()) {
                    oldTip = Double.valueOf(String.valueOf(dataSnapshot.child("tipShare").getValue())).doubleValue();
                }
                if (oldTip != 0.0d) {
                    mDayRef.child("tipShare").setValue(Double.valueOf(oldTip + tipShare));
                } else {
                    mDayRef.child("tipShare").setValue(Double.valueOf(tipShare));
                }
                DBHandler.this.updateWeekTipShare();
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateWeekTipShare() {
        final DatabaseReference mWeekRef = this.mIdRef.child(this.year + "/" + this.month + "/" + this.week);
        mWeekRef.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Double> tipShareArr = new ArrayList<>();
                for (int i = 0; i <= 9; i++) {
                    if (dataSnapshot.child(String.valueOf("0" + i)).exists()) {
                        tipShareArr.add(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + i)).child("tipShare").getValue())));
                    }
                }
                for (int i2 = 10; i2 <= 32; i2++) {
                    if (dataSnapshot.child(String.valueOf(i2)).exists()) {
                        tipShareArr.add(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(i2)).child("tipShare").getValue())));
                    }
                }
                mWeekRef.child("tipShare").setValue(Double.valueOf(DBHandler.this.totalUp(tipShareArr)));
                DBHandler.this.updateMonthTipShare();
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateMonthTipShare() {
        final DatabaseReference mMonthRef = this.mIdRef.child(this.year + "/" + this.month);
        mMonthRef.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Double> tipShareArr = new ArrayList<>();
                for (int i = 0; i <= 6; i++) {
                    if (dataSnapshot.child(String.valueOf(i)).exists()) {
                        tipShareArr.add(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(i)).child("tipShare").getValue())));
                    }
                }
                mMonthRef.child("tipShare").setValue(Double.valueOf(DBHandler.this.totalUp(tipShareArr)));
                DBHandler.this.updateYearTipShare();
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateYearTipShare() {
        final DatabaseReference mYearRef = this.mIdRef.child(this.year);
        mYearRef.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Double> tipShareArr = new ArrayList<>();
                for (int i = 0; i <= 9; i++) {
                    if (dataSnapshot.child(String.valueOf("0" + i)).exists()) {
                        tipShareArr.add(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf("0" + i)).child("tipShare").getValue())));
                    }
                }
                for (int i2 = 10; i2 <= 12; i2++) {
                    if (dataSnapshot.child(String.valueOf(i2)).exists()) {
                        tipShareArr.add(Double.valueOf(String.valueOf(dataSnapshot.child(String.valueOf(i2)).child("tipShare").getValue())));
                    }
                }
                mYearRef.child("tipShare").setValue(Double.valueOf(DBHandler.this.totalUp(tipShareArr)));
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void filter(ArrayList<Double> tips, ArrayList<Integer> tables) {
        if (tips != null) {
            int tableInc = 0;
            int tracker = 1;
            while (tables.size() != tableInc) {
                double tip = 0.0d;
                int inc = 1;
                while (tables.size() != inc && Integer.valueOf(tableInc + inc).intValue() != tableInc && Integer.valueOf(tableInc + inc).intValue() < tables.size()) {
                    int comparedInc = tableInc + inc;
                    if (String.valueOf(tables.get(tableInc)).equals(String.valueOf(tables.get(comparedInc)))) {
                        if (tracker == 1) {
                            tip += Double.valueOf(String.valueOf(tips.get(tableInc))).doubleValue() + Double.valueOf(String.valueOf(tips.get(comparedInc))).doubleValue();
                            tips.set(tableInc, Double.valueOf(tip));
                            tables.remove(comparedInc);
                            tips.remove(comparedInc);
                            tracker++;
                        } else {
                            tip += Double.valueOf(String.valueOf(tips.get(comparedInc))).doubleValue();
                            tips.set(tableInc, Double.valueOf(tip));
                            tables.remove(comparedInc);
                            tips.remove(comparedInc);
                        }
                    }
                    inc++;
                }
                tracker = 1;
                tableInc++;
            }
            this.theTip = tips;
            this.theTable = tables;
        }
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
    public double totalUp(ArrayList<Double> tipArr) {
        Log.d("Brent", "tipArr: " + tipArr);
        double total = 0.0d;
        if (tipArr != null) {
            for (int totalInc = 0; totalInc != tipArr.size(); totalInc++) {
                Log.d("Brent", "totalInc: " + totalInc);
                Log.d("Brent", "tipArr.get(totalInc): " + tipArr.get(totalInc));
                total += Double.valueOf(String.valueOf(tipArr.get(totalInc))).doubleValue();
            }
        }
        return total;
    }

    /* access modifiers changed from: private */
    public void setHourTip(ArrayList<Double> tip) {
        this.hourTip = tip;
    }

    /* access modifiers changed from: private */
    public void setHourTable(ArrayList<Integer> table) {
        this.hourTable = table;
    }

    /* access modifiers changed from: private */
    public void setDayTip(ArrayList<Double> tip) {
        this.dayTip = tip;
    }

    /* access modifiers changed from: private */
    public void setDayTable(ArrayList<Integer> table) {
        this.dayTable = table;
    }

    /* access modifiers changed from: private */
    public void setDayTime(ArrayList<Integer> time) {
        this.dayTime = time;
    }

    /* access modifiers changed from: private */
    public void setWeekTip(ArrayList<Double> tip) {
        this.weekTip = tip;
    }

    /* access modifiers changed from: private */
    public void setWeekTable(ArrayList<Integer> table) {
        this.weekTable = table;
    }

    /* access modifiers changed from: private */
    public void setWeekTime(ArrayList<Integer> time) {
        this.weekTime = time;
    }

    /* access modifiers changed from: private */
    public void setMonthTip(ArrayList<Double> tip) {
        this.monthTip = tip;
    }

    /* access modifiers changed from: private */
    public void setMonthTable(ArrayList<Integer> table) {
        this.monthTable = table;
    }

    /* access modifiers changed from: private */
    public void setMonthTime(ArrayList<Integer> time) {
        this.monthTime = time;
    }

    /* access modifiers changed from: private */
    public void setYearTip(ArrayList<Double> tip) {
        this.yearTip = tip;
    }

    /* access modifiers changed from: private */
    public void setYearTable(ArrayList<Integer> table) {
        this.yearTable = table;
    }

    /* access modifiers changed from: private */
    public void setYearTime(ArrayList<Integer> time) {
        this.yearTime = time;
    }

    public ArrayList<Double> getHourTip() {
        return this.hourTip;
    }

    public ArrayList<Integer> getHourTable() {
        return this.hourTable;
    }

    public ArrayList<Double> getDayTip() {
        return this.dayTip;
    }

    public ArrayList<Integer> getDayTable() {
        return this.dayTable;
    }

    public ArrayList<Integer> getDayTime() {
        return this.dayTime;
    }

    public ArrayList<Double> getWeekTip() {
        return this.weekTip;
    }

    public ArrayList<Integer> getWeekTable() {
        return this.weekTable;
    }

    public ArrayList<Integer> getWeekTime() {
        return this.weekTime;
    }

    public ArrayList<Double> getMonthTip() {
        return this.monthTip;
    }

    public ArrayList<Integer> getMonthTable() {
        return this.monthTable;
    }

    public ArrayList<Integer> getMonthTime() {
        return this.monthTime;
    }

    public ArrayList<Double> getYearTip() {
        return this.yearTip;
    }

    public ArrayList<Integer> getYearTable() {
        return this.yearTable;
    }

    public ArrayList<Integer> getYearTime() {
        return this.yearTime;
    }
}
