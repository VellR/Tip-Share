package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendDirection;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LegendRenderer extends Renderer {
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint = new Paint(1);

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.mLegend = legend;
        this.mLegendLabelPaint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Align.LEFT);
        this.mLegendFormPaint = new Paint(1);
        this.mLegendFormPaint.setStyle(Style.FILL);
        this.mLegendFormPaint.setStrokeWidth(3.0f);
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    public void computeLegend(ChartData<?> data) {
        if (!this.mLegend.isLegendCustom()) {
            List<String> labels = new ArrayList<>();
            List<Integer> colors = new ArrayList<>();
            for (int i = 0; i < data.getDataSetCount(); i++) {
                IDataSet dataSet = data.getDataSetByIndex(i);
                List<Integer> clrs = dataSet.getColors();
                int entryCount = dataSet.getEntryCount();
                if ((dataSet instanceof IBarDataSet) && ((IBarDataSet) dataSet).isStacked()) {
                    IBarDataSet bds = (IBarDataSet) dataSet;
                    String[] sLabels = bds.getStackLabels();
                    int j = 0;
                    while (j < clrs.size() && j < bds.getStackSize()) {
                        labels.add(sLabels[j % sLabels.length]);
                        colors.add(clrs.get(j));
                        j++;
                    }
                    if (bds.getLabel() != null) {
                        colors.add(Integer.valueOf(ColorTemplate.COLOR_SKIP));
                        labels.add(bds.getLabel());
                    }
                } else if (dataSet instanceof IPieDataSet) {
                    List<String> xVals = data.getXVals();
                    IPieDataSet pds = (IPieDataSet) dataSet;
                    int j2 = 0;
                    while (j2 < clrs.size() && j2 < entryCount && j2 < xVals.size()) {
                        labels.add(xVals.get(j2));
                        colors.add(clrs.get(j2));
                        j2++;
                    }
                    if (pds.getLabel() != null) {
                        colors.add(Integer.valueOf(ColorTemplate.COLOR_SKIP));
                        labels.add(pds.getLabel());
                    }
                } else if (!(dataSet instanceof ICandleDataSet) || ((ICandleDataSet) dataSet).getDecreasingColor() == 1122867) {
                    int j3 = 0;
                    while (j3 < clrs.size() && j3 < entryCount) {
                        if (j3 >= clrs.size() - 1 || j3 >= entryCount - 1) {
                            labels.add(data.getDataSetByIndex(i).getLabel());
                        } else {
                            labels.add(null);
                        }
                        colors.add(clrs.get(j3));
                        j3++;
                    }
                } else {
                    colors.add(Integer.valueOf(((ICandleDataSet) dataSet).getDecreasingColor()));
                    colors.add(Integer.valueOf(((ICandleDataSet) dataSet).getIncreasingColor()));
                    labels.add(null);
                    labels.add(dataSet.getLabel());
                }
            }
            if (!(this.mLegend.getExtraColors() == null || this.mLegend.getExtraLabels() == null)) {
                for (int color : this.mLegend.getExtraColors()) {
                    colors.add(Integer.valueOf(color));
                }
                Collections.addAll(labels, this.mLegend.getExtraLabels());
            }
            this.mLegend.setComputedColors(colors);
            this.mLegend.setComputedLabels(labels);
        }
        Typeface tf = this.mLegend.getTypeface();
        if (tf != null) {
            this.mLegendLabelPaint.setTypeface(tf);
        }
        this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
        this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
        this.mLegend.calculateDimensions(this.mLegendLabelPaint, this.mViewPortHandler);
    }

    public void renderLegend(Canvas c) {
        float posX;
        float posY;
        float originPosX;
        float posY2;
        float f;
        float f2;
        if (this.mLegend.isEnabled()) {
            Typeface tf = this.mLegend.getTypeface();
            if (tf != null) {
                this.mLegendLabelPaint.setTypeface(tf);
            }
            this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
            this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
            float labelLineHeight = Utils.getLineHeight(this.mLegendLabelPaint);
            float labelLineSpacing = Utils.getLineSpacing(this.mLegendLabelPaint) + this.mLegend.getYEntrySpace();
            float formYOffset = labelLineHeight - (((float) Utils.calcTextHeight(this.mLegendLabelPaint, "ABC")) / 2.0f);
            String[] labels = this.mLegend.getLabels();
            int[] colors = this.mLegend.getColors();
            float formToTextSpace = this.mLegend.getFormToTextSpace();
            float xEntrySpace = this.mLegend.getXEntrySpace();
            LegendDirection direction = this.mLegend.getDirection();
            float formSize = this.mLegend.getFormSize();
            float stackSpace = this.mLegend.getStackSpace();
            float yoffset = this.mLegend.getYOffset();
            float xoffset = this.mLegend.getXOffset();
            LegendPosition legendPosition = this.mLegend.getPosition();
            switch (legendPosition) {
                case BELOW_CHART_LEFT:
                case BELOW_CHART_RIGHT:
                case BELOW_CHART_CENTER:
                case ABOVE_CHART_LEFT:
                case ABOVE_CHART_RIGHT:
                case ABOVE_CHART_CENTER:
                    float contentWidth = this.mViewPortHandler.contentWidth();
                    if (legendPosition == LegendPosition.BELOW_CHART_LEFT || legendPosition == LegendPosition.ABOVE_CHART_LEFT) {
                        originPosX = this.mViewPortHandler.contentLeft() + xoffset;
                        if (direction == LegendDirection.RIGHT_TO_LEFT) {
                            originPosX += this.mLegend.mNeededWidth;
                        }
                    } else if (legendPosition == LegendPosition.BELOW_CHART_RIGHT || legendPosition == LegendPosition.ABOVE_CHART_RIGHT) {
                        originPosX = this.mViewPortHandler.contentRight() - xoffset;
                        if (direction == LegendDirection.LEFT_TO_RIGHT) {
                            originPosX -= this.mLegend.mNeededWidth;
                        }
                    } else {
                        originPosX = (this.mViewPortHandler.contentLeft() + (contentWidth / 2.0f)) - (this.mLegend.mNeededWidth / 2.0f);
                    }
                    FSize[] calculatedLineSizes = this.mLegend.getCalculatedLineSizes();
                    FSize[] calculatedLabelSizes = this.mLegend.getCalculatedLabelSizes();
                    Boolean[] calculatedLabelBreakPoints = this.mLegend.getCalculatedLabelBreakPoints();
                    float posX2 = originPosX;
                    if (legendPosition == LegendPosition.ABOVE_CHART_LEFT || legendPosition == LegendPosition.ABOVE_CHART_RIGHT || legendPosition == LegendPosition.ABOVE_CHART_CENTER) {
                        posY2 = 0.0f;
                    } else {
                        posY2 = (this.mViewPortHandler.getChartHeight() - yoffset) - this.mLegend.mNeededHeight;
                    }
                    int lineIndex = 0;
                    int count = labels.length;
                    for (int i = 0; i < count; i++) {
                        if (i < calculatedLabelBreakPoints.length && calculatedLabelBreakPoints[i].booleanValue()) {
                            posX2 = originPosX;
                            posY2 += labelLineHeight + labelLineSpacing;
                        }
                        if (posX2 == originPosX && legendPosition == LegendPosition.BELOW_CHART_CENTER && lineIndex < calculatedLineSizes.length) {
                            posX2 += (direction == LegendDirection.RIGHT_TO_LEFT ? calculatedLineSizes[lineIndex].width : -calculatedLineSizes[lineIndex].width) / 2.0f;
                            lineIndex++;
                        }
                        boolean drawingForm = colors[i] != 1122868;
                        boolean isStacked = labels[i] == null;
                        if (drawingForm) {
                            if (direction == LegendDirection.RIGHT_TO_LEFT) {
                                posX2 -= formSize;
                            }
                            drawForm(c, posX2, posY2 + formYOffset, i, this.mLegend);
                            if (direction == LegendDirection.LEFT_TO_RIGHT) {
                                posX2 += formSize;
                            }
                        }
                        if (!isStacked) {
                            if (drawingForm) {
                                if (direction == LegendDirection.RIGHT_TO_LEFT) {
                                    f2 = -formToTextSpace;
                                } else {
                                    f2 = formToTextSpace;
                                }
                                posX2 += f2;
                            }
                            if (direction == LegendDirection.RIGHT_TO_LEFT) {
                                posX2 -= calculatedLabelSizes[i].width;
                            }
                            drawLabel(c, posX2, posY2 + labelLineHeight, labels[i]);
                            if (direction == LegendDirection.LEFT_TO_RIGHT) {
                                posX2 += calculatedLabelSizes[i].width;
                            }
                            f = direction == LegendDirection.RIGHT_TO_LEFT ? -xEntrySpace : xEntrySpace;
                        } else {
                            f = direction == LegendDirection.RIGHT_TO_LEFT ? -stackSpace : stackSpace;
                        }
                        posX2 += f;
                    }
                    return;
                case PIECHART_CENTER:
                case RIGHT_OF_CHART:
                case RIGHT_OF_CHART_CENTER:
                case RIGHT_OF_CHART_INSIDE:
                case LEFT_OF_CHART:
                case LEFT_OF_CHART_CENTER:
                case LEFT_OF_CHART_INSIDE:
                    float stack = 0.0f;
                    boolean wasStacked = false;
                    if (legendPosition == LegendPosition.PIECHART_CENTER) {
                        posX = (this.mViewPortHandler.getChartWidth() / 2.0f) + (direction == LegendDirection.LEFT_TO_RIGHT ? (-this.mLegend.mTextWidthMax) / 2.0f : this.mLegend.mTextWidthMax / 2.0f);
                        posY = ((this.mViewPortHandler.getChartHeight() / 2.0f) - (this.mLegend.mNeededHeight / 2.0f)) + this.mLegend.getYOffset();
                    } else {
                        if (legendPosition == LegendPosition.RIGHT_OF_CHART || legendPosition == LegendPosition.RIGHT_OF_CHART_CENTER || legendPosition == LegendPosition.RIGHT_OF_CHART_INSIDE) {
                            posX = this.mViewPortHandler.getChartWidth() - xoffset;
                            if (direction == LegendDirection.LEFT_TO_RIGHT) {
                                posX -= this.mLegend.mTextWidthMax;
                            }
                        } else {
                            posX = xoffset;
                            if (direction == LegendDirection.RIGHT_TO_LEFT) {
                                posX += this.mLegend.mTextWidthMax;
                            }
                        }
                        if (legendPosition == LegendPosition.RIGHT_OF_CHART || legendPosition == LegendPosition.LEFT_OF_CHART) {
                            posY = this.mViewPortHandler.contentTop() + yoffset;
                        } else if (legendPosition == LegendPosition.RIGHT_OF_CHART_CENTER || legendPosition == LegendPosition.LEFT_OF_CHART_CENTER) {
                            posY = (this.mViewPortHandler.getChartHeight() / 2.0f) - (this.mLegend.mNeededHeight / 2.0f);
                        } else {
                            posY = this.mViewPortHandler.contentTop() + yoffset;
                        }
                    }
                    for (int i2 = 0; i2 < labels.length; i2++) {
                        Boolean drawingForm2 = Boolean.valueOf(colors[i2] != 1122868);
                        float x = posX;
                        if (drawingForm2.booleanValue()) {
                            if (direction == LegendDirection.LEFT_TO_RIGHT) {
                                x += stack;
                            } else {
                                x -= formSize - stack;
                            }
                            drawForm(c, x, posY + formYOffset, i2, this.mLegend);
                            if (direction == LegendDirection.LEFT_TO_RIGHT) {
                                x += formSize;
                            }
                        }
                        if (labels[i2] != null) {
                            if (drawingForm2.booleanValue() && !wasStacked) {
                                x += direction == LegendDirection.LEFT_TO_RIGHT ? formToTextSpace : -formToTextSpace;
                            } else if (wasStacked) {
                                x = posX;
                            }
                            if (direction == LegendDirection.RIGHT_TO_LEFT) {
                                x -= (float) Utils.calcTextWidth(this.mLegendLabelPaint, labels[i2]);
                            }
                            if (!wasStacked) {
                                drawLabel(c, x, posY + labelLineHeight, labels[i2]);
                            } else {
                                posY += labelLineHeight + labelLineSpacing;
                                drawLabel(c, x, posY + labelLineHeight, labels[i2]);
                            }
                            posY += labelLineHeight + labelLineSpacing;
                            stack = 0.0f;
                        } else {
                            stack += formSize + stackSpace;
                            wasStacked = true;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawForm(Canvas c, float x, float y, int index, Legend legend) {
        if (legend.getColors()[index] != 1122868) {
            this.mLegendFormPaint.setColor(legend.getColors()[index]);
            float formsize = legend.getFormSize();
            float half = formsize / 2.0f;
            switch (legend.getForm()) {
                case CIRCLE:
                    c.drawCircle(x + half, y, half, this.mLegendFormPaint);
                    return;
                case SQUARE:
                    c.drawRect(x, y - half, x + formsize, y + half, this.mLegendFormPaint);
                    return;
                case LINE:
                    c.drawLine(x, y, x + formsize, y, this.mLegendFormPaint);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawLabel(Canvas c, float x, float y, String label) {
        c.drawText(label, x, y, this.mLegendLabelPaint);
    }
}
