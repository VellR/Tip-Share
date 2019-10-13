package com.github.mikephil.charting.interfaces.datasets;

import com.github.mikephil.charting.charts.ScatterChart.ScatterShape;
import com.github.mikephil.charting.data.Entry;

public interface IScatterDataSet extends ILineScatterCandleRadarDataSet<Entry> {
    ScatterShape getScatterShape();

    int getScatterShapeHoleColor();

    float getScatterShapeHoleRadius();

    float getScatterShapeSize();
}
