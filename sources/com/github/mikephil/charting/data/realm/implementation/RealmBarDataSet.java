package com.github.mikephil.charting.data.realm.implementation;

import android.graphics.Color;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.realm.base.RealmBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import io.realm.DynamicRealmObject;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.Iterator;

public class RealmBarDataSet<T extends RealmObject> extends RealmBarLineScatterCandleBubbleDataSet<T, BarEntry> implements IBarDataSet {
    private int mBarShadowColor;
    private float mBarSpace;
    private int mHighLightAlpha;
    private String[] mStackLabels;
    private int mStackSize;
    private String mStackValueFieldName;

    public RealmBarDataSet(RealmResults<T> results, String yValuesField, String xIndexField) {
        super(results, yValuesField, xIndexField);
        this.mBarSpace = 0.15f;
        this.mStackSize = 1;
        this.mBarShadowColor = Color.rgb(215, 215, 215);
        this.mHighLightAlpha = 120;
        this.mStackLabels = new String[]{"Stack"};
        this.mHighLightColor = Color.rgb(0, 0, 0);
        build(this.results);
        calcMinMax(0, results.size());
    }

    public RealmBarDataSet(RealmResults<T> results, String yValuesField, String xIndexField, String stackValueFieldName) {
        super(results, yValuesField, xIndexField);
        this.mBarSpace = 0.15f;
        this.mStackSize = 1;
        this.mBarShadowColor = Color.rgb(215, 215, 215);
        this.mHighLightAlpha = 120;
        this.mStackLabels = new String[]{"Stack"};
        this.mStackValueFieldName = stackValueFieldName;
        this.mHighLightColor = Color.rgb(0, 0, 0);
        build(this.results);
        calcMinMax(0, results.size());
    }

    public void build(RealmResults<T> results) {
        Iterator it = results.iterator();
        while (it.hasNext()) {
            DynamicRealmObject dynamicObject = new DynamicRealmObject((RealmObject) it.next());
            try {
                this.mValues.add(new BarEntry(dynamicObject.getFloat(this.mValuesField), dynamicObject.getInt(this.mIndexField)));
            } catch (IllegalArgumentException e) {
                RealmList<DynamicRealmObject> list = dynamicObject.getList(this.mValuesField);
                float[] values = new float[list.size()];
                int i = 0;
                Iterator i$ = list.iterator();
                while (i$.hasNext()) {
                    values[i] = ((DynamicRealmObject) i$.next()).getFloat(this.mStackValueFieldName);
                    i++;
                }
                this.mValues.add(new BarEntry(values, dynamicObject.getInt(this.mIndexField)));
            }
        }
        calcStackSize();
    }

    public void calcMinMax(int start, int end) {
        int endValue;
        if (this.mValues != null) {
            int yValCount = this.mValues.size();
            if (yValCount != 0) {
                if (end == 0 || end >= yValCount) {
                    endValue = yValCount - 1;
                } else {
                    endValue = end;
                }
                this.mYMin = Float.MAX_VALUE;
                this.mYMax = -3.4028235E38f;
                for (int i = start; i <= endValue; i++) {
                    BarEntry e = (BarEntry) this.mValues.get(i);
                    if (e != null && !Float.isNaN(e.getVal())) {
                        if (e.getVals() == null) {
                            if (e.getVal() < this.mYMin) {
                                this.mYMin = e.getVal();
                            }
                            if (e.getVal() > this.mYMax) {
                                this.mYMax = e.getVal();
                            }
                        } else {
                            if ((-e.getNegativeSum()) < this.mYMin) {
                                this.mYMin = -e.getNegativeSum();
                            }
                            if (e.getPositiveSum() > this.mYMax) {
                                this.mYMax = e.getPositiveSum();
                            }
                        }
                    }
                }
                if (this.mYMin == Float.MAX_VALUE) {
                    this.mYMin = 0.0f;
                    this.mYMax = 0.0f;
                }
            }
        }
    }

    private void calcStackSize() {
        for (int i = 0; i < this.mValues.size(); i++) {
            float[] vals = ((BarEntry) this.mValues.get(i)).getVals();
            if (vals != null && vals.length > this.mStackSize) {
                this.mStackSize = vals.length;
            }
        }
    }

    public int getStackSize() {
        return this.mStackSize;
    }

    public boolean isStacked() {
        return this.mStackSize > 1;
    }

    public float getBarSpacePercent() {
        return this.mBarSpace * 100.0f;
    }

    public float getBarSpace() {
        return this.mBarSpace;
    }

    public void setBarSpacePercent(float percent) {
        this.mBarSpace = percent / 100.0f;
    }

    public void setBarShadowColor(int color) {
        this.mBarShadowColor = color;
    }

    public int getBarShadowColor() {
        return this.mBarShadowColor;
    }

    public void setHighLightAlpha(int alpha) {
        this.mHighLightAlpha = alpha;
    }

    public int getHighLightAlpha() {
        return this.mHighLightAlpha;
    }

    public void setStackLabels(String[] labels) {
        this.mStackLabels = labels;
    }

    public String[] getStackLabels() {
        return this.mStackLabels;
    }
}
