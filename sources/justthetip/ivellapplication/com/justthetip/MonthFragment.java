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

public class MonthFragment extends Fragment {
    private ArrayList<String> labels = new ArrayList<>();
    private ArrayList<Integer> timesArr = new ArrayList<>();
    private ArrayList<String> tipsArr = new ArrayList<>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        this.tipsArr = bundle.getStringArrayList("tipsArr");
        this.timesArr = bundle.getIntegerArrayList("timeStat");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedState) {
        View view = inflater.inflate(R.layout.fragment_month, container, false);
        ArrayList<String> timesHolder = new ArrayList<>();
        for (int inc = 0; inc != this.timesArr.size(); inc++) {
            timesHolder.add(String.valueOf(this.timesArr.get(inc)));
        }
        BarDataSet dataSet = new BarDataSet(new BarGraphTipConverter(this.tipsArr).entries(), "Time");
        dataSet.setColors(Colors.BAR_COLORS);
        dataSet.setBarShadowColor(Colors.PRIMARY_COLOR);
        dataSet.setValueTextColor(Colors.PRIMARY_COLOR);
        dataSet.setHighLightColor(Colors.HIGHLIGHT_COLOR);
        dataSet.setValueTextSize(20.0f);
        for (int timeHolderInc = 0; timeHolderInc != timesHolder.size(); timeHolderInc++) {
            if (((String) timesHolder.get(timeHolderInc)).equals("1") || ((String) timesHolder.get(timeHolderInc)).equals("01")) {
                this.labels.add("1st Week");
            }
            if (((String) timesHolder.get(timeHolderInc)).equals("2") || ((String) timesHolder.get(timeHolderInc)).equals("02")) {
                this.labels.add("2nd Week");
            }
            if (((String) timesHolder.get(timeHolderInc)).equals("3") || ((String) timesHolder.get(timeHolderInc)).equals("03")) {
                this.labels.add("3rd Week");
            }
            if (((String) timesHolder.get(timeHolderInc)).equals("4") || ((String) timesHolder.get(timeHolderInc)).equals("04")) {
                this.labels.add("4th Week");
            }
            if (((String) timesHolder.get(timeHolderInc)).equals("5") || ((String) timesHolder.get(timeHolderInc)).equals("05")) {
                this.labels.add("5th Week");
            }
        }
        BarChart chart = (BarChart) view.findViewById(R.id.fragment_month_barchart);
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
        yAxis.setAxisMaxValue(1000.0f);
        yAxis.setTextColor(Colors.SECONDARY_COLOR);
        YAxis yAxis2 = chart.getAxis(AxisDependency.RIGHT);
        yAxis2.setDrawLabels(false);
        yAxis2.setDrawAxisLine(false);
        yAxis2.setDrawGridLines(false);
        chart.getLegend().setEnabled(false);
        return view;
    }
}
