package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.text.DecimalFormat;

public class StackedValueFormatter implements ValueFormatter {
    private String mAppendix;
    private boolean mDrawWholeStack;
    private DecimalFormat mFormat;

    public StackedValueFormatter(boolean drawWholeStack, String appendix, int decimals) {
        this.mDrawWholeStack = drawWholeStack;
        this.mAppendix = appendix;
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < decimals; i++) {
            if (i == 0) {
                b.append(".");
            }
            b.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + b.toString());
    }

    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        if (!this.mDrawWholeStack && (entry instanceof BarEntry)) {
            BarEntry barEntry = (BarEntry) entry;
            float[] vals = barEntry.getVals();
            if (vals != null) {
                if (vals[vals.length - 1] == value) {
                    return this.mFormat.format((double) barEntry.getVal()) + this.mAppendix;
                }
                return "";
            }
        }
        return this.mFormat.format((double) value) + this.mAppendix;
    }
}
