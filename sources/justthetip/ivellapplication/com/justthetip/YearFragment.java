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

public class YearFragment extends Fragment {
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
        View view = inflater.inflate(R.layout.fragment_year, container, false);
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
        for (int inc = 0; inc != timeHolder.size(); inc++) {
            if (((String) timeHolder.get(inc)).equals("1") || ((String) timeHolder.get(inc)).equals("01")) {
                this.labels.add("Jan");
            }
            if (((String) timeHolder.get(inc)).equals("2") || ((String) timeHolder.get(inc)).equals("02")) {
                this.labels.add("Feb");
            }
            if (((String) timeHolder.get(inc)).equals("3") || ((String) timeHolder.get(inc)).equals("03")) {
                this.labels.add("Mar");
            }
            if (((String) timeHolder.get(inc)).equals("4") || ((String) timeHolder.get(inc)).equals("04")) {
                this.labels.add("Apr");
            }
            if (((String) timeHolder.get(inc)).equals("5") || ((String) timeHolder.get(inc)).equals("05")) {
                this.labels.add("May");
            }
            if (((String) timeHolder.get(inc)).equals("6") || ((String) timeHolder.get(inc)).equals("06")) {
                this.labels.add("Jun");
            }
            if (((String) timeHolder.get(inc)).equals("7") || ((String) timeHolder.get(inc)).equals("07")) {
                this.labels.add("Jul");
            }
            if (((String) timeHolder.get(inc)).equals("8") || ((String) timeHolder.get(inc)).equals("08")) {
                this.labels.add("Aug");
            }
            if (((String) timeHolder.get(inc)).equals("9") || ((String) timeHolder.get(inc)).equals("09")) {
                this.labels.add("Sep");
            }
            if (((String) timeHolder.get(inc)).equals("10")) {
                this.labels.add("Oct");
            }
            if (((String) timeHolder.get(inc)).equals("11")) {
                this.labels.add("Nov");
            }
            if (((String) timeHolder.get(inc)).equals("12")) {
                this.labels.add("Dec");
            }
        }
        BarChart chart = (BarChart) view.findViewById(R.id.fragment_year_barchart);
        chart.setData(new BarData((List<String>) this.labels, (IBarDataSet) dataSet));
        chart.setDescriptionColor(Colors.SECONDARY_COLOR);
        chart.setNoDataText("No Data Available");
        chart.setDescription("");
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
        yAxis.setAxisMaxValue(10000.0f);
        yAxis.setTextColor(Colors.SECONDARY_COLOR);
        YAxis yAxis2 = chart.getAxis(AxisDependency.RIGHT);
        yAxis2.setDrawLabels(false);
        yAxis2.setDrawAxisLine(false);
        yAxis2.setDrawGridLines(false);
        chart.getLegend().setEnabled(false);
        return view;
    }
}
