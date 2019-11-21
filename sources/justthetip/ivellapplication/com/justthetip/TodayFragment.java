package justthetip.ivellapplication.com.justthetip;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.util.ArrayList;
import java.util.List;

public class TodayFragment extends Fragment {
    private ArrayList<String> labels = new ArrayList<>();
    private ArrayList<Integer> timeStat = new ArrayList<>();
    private ArrayList<String> tipsArr = new ArrayList<>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        this.tipsArr = bundle.getStringArrayList("tipsArr");
        this.timeStat = bundle.getIntegerArrayList("timeStat");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedState) {
        View view = inflater.inflate(R.layout.fragment_today, container, false);
        ArrayList<String> timeHolder = new ArrayList<>();
        for (int timeInc = 0; timeInc != this.timeStat.size(); timeInc++) {
            timeHolder.add(String.valueOf(this.timeStat.get(timeInc)));
        }
        BarDataSet dataSet = new BarDataSet(new BarGraphTipConverter(this.tipsArr).entries(), "Time");
        dataSet.setColors(Colors.BAR_COLORS);
        dataSet.setBarShadowColor(Colors.PRIMARY_COLOR);
        dataSet.setValueTextColor(Colors.PRIMARY_COLOR);
        dataSet.setHighLightColor(Colors.HIGHLIGHT_COLOR);
        dataSet.setValueTextSize(20.0f);
        dataSet.setDrawValues(true);
        for (int i = 0; i != timeHolder.size(); i++) {
            if (((String) timeHolder.get(i)).equals("0") || ((String) timeHolder.get(i)).equals("00")) {
                this.labels.add("12AM");
            }
            if (((String) timeHolder.get(i)).equals("1") || ((String) timeHolder.get(i)).equals("01")) {
                this.labels.add("1AM");
            }
            if (((String) timeHolder.get(i)).equals("2") || ((String) timeHolder.get(i)).equals("02")) {
                this.labels.add("2AM");
            }
            if (((String) timeHolder.get(i)).equals("3") || ((String) timeHolder.get(i)).equals("03")) {
                this.labels.add("3AM");
            }
            if (((String) timeHolder.get(i)).equals("4") || ((String) timeHolder.get(i)).equals("04")) {
                this.labels.add("4AM");
            }
            if (((String) timeHolder.get(i)).equals("5") || ((String) timeHolder.get(i)).equals("05")) {
                this.labels.add("5AM");
            }
            if (((String) timeHolder.get(i)).equals("6") || ((String) timeHolder.get(i)).equals("06")) {
                this.labels.add("6AM");
            }
            if (((String) timeHolder.get(i)).equals("7") || ((String) timeHolder.get(i)).equals("07")) {
                this.labels.add("7AM");
            }
            if (((String) timeHolder.get(i)).equals("8") || ((String) timeHolder.get(i)).equals("08")) {
                this.labels.add("8AM");
            }
            if (((String) timeHolder.get(i)).equals("9") || ((String) timeHolder.get(i)).equals("09")) {
                this.labels.add("9AM");
            }
            if (((String) timeHolder.get(i)).equals("10")) {
                this.labels.add("10AM");
            }
            if (((String) timeHolder.get(i)).equals("11")) {
                this.labels.add("11AM");
            }
            if (((String) timeHolder.get(i)).equals("12")) {
                this.labels.add("12PM");
            }
            if (((String) timeHolder.get(i)).equals("13")) {
                this.labels.add("1PM");
            }
            if (((String) timeHolder.get(i)).equals("14")) {
                this.labels.add("2PM");
            }
            if (((String) timeHolder.get(i)).equals("15")) {
                this.labels.add("3PM");
            }
            if (((String) timeHolder.get(i)).equals("16")) {
                this.labels.add("4PM");
            }
            if (((String) timeHolder.get(i)).equals("17")) {
                this.labels.add("5PM");
            }
            if (((String) timeHolder.get(i)).equals("18")) {
                this.labels.add("6PM");
            }
            if (((String) timeHolder.get(i)).equals("19")) {
                this.labels.add("7PM");
            }
            if (((String) timeHolder.get(i)).equals("20")) {
                this.labels.add("8PM");
            }
            if (((String) timeHolder.get(i)).equals("21")) {
                this.labels.add("9PM");
            }
            if (((String) timeHolder.get(i)).equals("22")) {
                this.labels.add("10PM");
            }
            if (((String) timeHolder.get(i)).equals("23")) {
                this.labels.add("11PM");
            }
            if (((String) timeHolder.get(i)).equals("24")) {
                this.labels.add("12AM");
            }
        }
        BarChart chart = (BarChart) view.findViewById(R.id.fragment_today_barchart);
        chart.setData(new BarData((List<String>) this.labels, (IBarDataSet) dataSet));
        chart.setDescriptionColor(Colors.SECONDARY_COLOR);
        chart.setDescription("");
        chart.setNoDataText("No Data Available");
        chart.setNoDataTextDescription("No Data Available");
        chart.setMaxVisibleValueCount(10);
        chart.setDragEnabled(false);
        chart.animateXY(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
        chart.setBorderColor(Colors.SECONDARY_COLOR);
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxisPosition.BOTTOM);
        xAxis.setTextSize(10.0f);
        xAxis.setTextColor(Colors.SECONDARY_COLOR);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(true);
        YAxis yAxis = chart.getAxis(AxisDependency.LEFT);
        yAxis.setDrawLabels(true);
        yAxis.setDrawAxisLine(true);
        yAxis.setDrawGridLines(true);
        yAxis.setLabelCount(8, false);
        yAxis.setSpaceTop(15.0f);
        yAxis.setAxisMaxValue(300.0f);
        yAxis.setTextColor(Colors.SECONDARY_COLOR);
        YAxis yAxis2 = chart.getAxis(AxisDependency.RIGHT);
        yAxis2.setDrawLabels(false);
        yAxis2.setDrawAxisLine(false);
        yAxis2.setDrawGridLines(false);
        chart.getLegend().setEnabled(false);
        return view;
    }
}
