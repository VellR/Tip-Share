package com.nightonke.boommenu;

import android.widget.FrameLayout.LayoutParams;
import com.nightonke.boommenu.Types.PlaceType;

public class PlaceParamsFactory {
    public static LayoutParams[] getDotParams(PlaceType placeType, int buttonWidth, int buttonHeight, int dotWidth, int dotHeight) {
        LayoutParams[] ps;
        LayoutParams[] ps2 = 0;
        if (placeType.equals(PlaceType.CIRCLE_1_1)) {
            ps = new LayoutParams[]{new LayoutParams(dotWidth, dotHeight)};
            ps[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
            ps[0].topMargin = (buttonHeight / 2) - (dotWidth / 2);
            ps2 = ps;
        } else {
            if (placeType.equals(PlaceType.CIRCLE_2_1)) {
                LayoutParams[] ps3 = new LayoutParams[2];
                ps3[0] = new LayoutParams(dotWidth, dotHeight);
                ps3[0].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                ps3[0].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                ps3[1] = new LayoutParams(dotWidth, dotHeight);
                ps3[1].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                ps3[1].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                ps2 = ps3;
            } else {
                if (placeType.equals(PlaceType.CIRCLE_2_2)) {
                    LayoutParams[] ps4 = new LayoutParams[2];
                    ps4[0] = new LayoutParams(dotWidth, dotHeight);
                    ps4[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                    ps4[0].topMargin = (buttonHeight / 3) - (dotWidth / 2);
                    ps4[1] = new LayoutParams(dotWidth, dotHeight);
                    ps4[1].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                    ps4[1].topMargin = ((buttonHeight * 2) / 3) - (dotWidth / 2);
                    ps2 = ps4;
                } else {
                    if (placeType.equals(PlaceType.CIRCLE_3_1)) {
                        LayoutParams[] ps5 = new LayoutParams[3];
                        ps5[0] = new LayoutParams(dotWidth, dotHeight);
                        ps5[0].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                        ps5[0].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                        ps5[1] = new LayoutParams(dotWidth, dotHeight);
                        ps5[1].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                        ps5[1].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                        ps5[2] = new LayoutParams(dotWidth, dotHeight);
                        ps5[2].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                        ps5[2].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                        ps2 = ps5;
                    } else {
                        if (placeType.equals(PlaceType.CIRCLE_3_2)) {
                            LayoutParams[] ps6 = new LayoutParams[3];
                            ps6[0] = new LayoutParams(dotWidth, dotHeight);
                            ps6[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                            ps6[0].topMargin = (buttonHeight / 3) - (dotWidth / 2);
                            ps6[1] = new LayoutParams(dotWidth, dotHeight);
                            ps6[1].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                            ps6[1].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                            ps6[2] = new LayoutParams(dotWidth, dotHeight);
                            ps6[2].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                            ps6[2].topMargin = ((buttonHeight * 2) / 3) - (dotWidth / 2);
                            ps2 = ps6;
                        } else {
                            if (placeType.equals(PlaceType.CIRCLE_3_3)) {
                                int c = buttonWidth / 6;
                                int a = c / 2;
                                int b = (int) Math.sqrt((double) ((c * c) - (a * a)));
                                LayoutParams[] ps7 = new LayoutParams[3];
                                ps7[0] = new LayoutParams(dotWidth, dotHeight);
                                ps7[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                ps7[0].topMargin = ((buttonHeight / 2) - c) - (dotWidth / 2);
                                ps7[1] = new LayoutParams(dotWidth, dotHeight);
                                ps7[1].leftMargin = ((buttonWidth / 2) - b) - (dotWidth / 2);
                                ps7[1].topMargin = ((buttonHeight / 2) + a) - (dotWidth / 2);
                                ps7[2] = new LayoutParams(dotWidth, dotHeight);
                                ps7[2].leftMargin = ((buttonWidth / 2) + b) - (dotWidth / 2);
                                ps7[2].topMargin = ((buttonHeight / 2) + a) - (dotWidth / 2);
                                ps2 = ps7;
                            } else {
                                if (placeType.equals(PlaceType.CIRCLE_3_4)) {
                                    int c2 = buttonWidth / 6;
                                    int a2 = c2 / 2;
                                    int b2 = (int) Math.sqrt((double) ((c2 * c2) - (a2 * a2)));
                                    LayoutParams[] ps8 = new LayoutParams[3];
                                    ps8[0] = new LayoutParams(dotWidth, dotHeight);
                                    ps8[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                    ps8[0].topMargin = ((buttonHeight / 2) + c2) - (dotWidth / 2);
                                    ps8[1] = new LayoutParams(dotWidth, dotHeight);
                                    ps8[1].leftMargin = ((buttonWidth / 2) - b2) - (dotWidth / 2);
                                    ps8[1].topMargin = ((buttonHeight / 2) - a2) - (dotWidth / 2);
                                    ps8[2] = new LayoutParams(dotWidth, dotHeight);
                                    ps8[2].leftMargin = ((buttonWidth / 2) + b2) - (dotWidth / 2);
                                    ps8[2].topMargin = ((buttonHeight / 2) - a2) - (dotWidth / 2);
                                    ps2 = ps8;
                                } else {
                                    if (placeType.equals(PlaceType.CIRCLE_4_1)) {
                                        LayoutParams[] ps9 = new LayoutParams[4];
                                        ps9[0] = new LayoutParams(dotWidth, dotHeight);
                                        ps9[0].leftMargin = ((buttonWidth * 3) / 8) - (dotWidth / 2);
                                        ps9[0].topMargin = ((buttonHeight * 3) / 8) - (dotWidth / 2);
                                        ps9[1] = new LayoutParams(dotWidth, dotHeight);
                                        ps9[1].leftMargin = ((buttonWidth * 5) / 8) - (dotWidth / 2);
                                        ps9[1].topMargin = ((buttonHeight * 3) / 8) - (dotWidth / 2);
                                        ps9[2] = new LayoutParams(dotWidth, dotHeight);
                                        ps9[2].leftMargin = ((buttonWidth * 3) / 8) - (dotWidth / 2);
                                        ps9[2].topMargin = ((buttonHeight * 5) / 8) - (dotWidth / 2);
                                        ps9[3] = new LayoutParams(dotWidth, dotHeight);
                                        ps9[3].leftMargin = ((buttonWidth * 5) / 8) - (dotWidth / 2);
                                        ps9[3].topMargin = ((buttonHeight * 5) / 8) - (dotWidth / 2);
                                        ps2 = ps9;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (placeType.equals(PlaceType.CIRCLE_4_2)) {
            double s2 = Math.sqrt(2.0d);
            LayoutParams[] ps10 = new LayoutParams[4];
            ps10[0] = new LayoutParams(dotWidth, dotHeight);
            ps10[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
            ps10[0].topMargin = (int) ((((double) (buttonWidth / 2)) - (((double) (buttonWidth / 4)) / s2)) - ((double) (dotWidth / 2)));
            ps10[1] = new LayoutParams(dotWidth, dotHeight);
            ps10[1].leftMargin = (int) ((((double) (buttonWidth / 2)) - (((double) (buttonWidth / 4)) / s2)) - ((double) (dotWidth / 2)));
            ps10[1].topMargin = (buttonHeight / 2) - (dotWidth / 2);
            ps10[2] = new LayoutParams(dotWidth, dotHeight);
            ps10[2].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
            ps10[2].topMargin = (int) ((((double) (buttonWidth / 2)) + (((double) (buttonWidth / 4)) / s2)) - ((double) (dotWidth / 2)));
            ps10[3] = new LayoutParams(dotWidth, dotHeight);
            ps10[3].leftMargin = (int) ((((double) (buttonWidth / 2)) + (((double) (buttonWidth / 4)) / s2)) - ((double) (dotWidth / 2)));
            ps10[3].topMargin = (buttonHeight / 2) - (dotWidth / 2);
            ps2 = ps10;
        } else {
            if (placeType.equals(PlaceType.CIRCLE_5_1)) {
                LayoutParams[] ps11 = new LayoutParams[5];
                ps11[0] = new LayoutParams(dotWidth, dotHeight);
                ps11[0].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                ps11[0].topMargin = (int) (((((double) buttonWidth) * 5.5d) / 12.0d) - ((double) (dotWidth / 2)));
                ps11[1] = new LayoutParams(dotWidth, dotHeight);
                ps11[1].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                ps11[1].topMargin = (int) (((((double) buttonWidth) * 5.5d) / 12.0d) - ((double) (dotWidth / 2)));
                ps11[2] = new LayoutParams(dotWidth, dotHeight);
                ps11[2].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                ps11[2].topMargin = (int) (((((double) buttonWidth) * 5.5d) / 12.0d) - ((double) (dotWidth / 2)));
                ps11[3] = new LayoutParams(dotWidth, dotHeight);
                ps11[3].leftMargin = ((buttonWidth * 5) / 12) - (dotWidth / 2);
                ps11[3].topMargin = (int) (((((double) buttonWidth) * 7.5d) / 12.0d) - ((double) (dotWidth / 2)));
                ps11[4] = new LayoutParams(dotWidth, dotHeight);
                ps11[4].leftMargin = ((buttonWidth * 7) / 12) - (dotWidth / 2);
                ps11[4].topMargin = (int) (((((double) buttonWidth) * 7.5d) / 12.0d) - ((double) (dotWidth / 2)));
                ps2 = ps11;
            } else {
                if (placeType.equals(PlaceType.CIRCLE_5_2)) {
                    LayoutParams[] ps12 = new LayoutParams[5];
                    ps12[0] = new LayoutParams(dotWidth, dotHeight);
                    ps12[0].leftMargin = ((buttonWidth * 5) / 12) - (dotWidth / 2);
                    ps12[0].topMargin = ((buttonHeight * 5) / 12) - (dotWidth / 2);
                    ps12[1] = new LayoutParams(dotWidth, dotHeight);
                    ps12[1].leftMargin = ((buttonWidth * 7) / 12) - (dotWidth / 2);
                    ps12[1].topMargin = ((buttonHeight * 5) / 12) - (dotWidth / 2);
                    ps12[2] = new LayoutParams(dotWidth, dotHeight);
                    ps12[2].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                    ps12[2].topMargin = ((buttonHeight * 7) / 12) - (dotWidth / 2);
                    ps12[3] = new LayoutParams(dotWidth, dotHeight);
                    ps12[3].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                    ps12[3].topMargin = ((buttonHeight * 7) / 12) - (dotWidth / 2);
                    ps12[4] = new LayoutParams(dotWidth, dotHeight);
                    ps12[4].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                    ps12[4].topMargin = ((buttonHeight * 7) / 12) - (dotWidth / 2);
                    ps2 = ps12;
                } else {
                    if (placeType.equals(PlaceType.CIRCLE_5_3)) {
                        LayoutParams[] ps13 = new LayoutParams[5];
                        ps13[0] = new LayoutParams(dotWidth, dotHeight);
                        ps13[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                        ps13[0].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                        ps13[1] = new LayoutParams(dotWidth, dotHeight);
                        ps13[1].leftMargin = ((buttonWidth * 3) / 8) - (dotWidth / 2);
                        ps13[1].topMargin = ((buttonHeight * 3) / 8) - (dotWidth / 2);
                        ps13[2] = new LayoutParams(dotWidth, dotHeight);
                        ps13[2].leftMargin = ((buttonWidth * 5) / 8) - (dotWidth / 2);
                        ps13[2].topMargin = ((buttonHeight * 3) / 8) - (dotWidth / 2);
                        ps13[3] = new LayoutParams(dotWidth, dotHeight);
                        ps13[3].leftMargin = ((buttonWidth * 3) / 8) - (dotWidth / 2);
                        ps13[3].topMargin = ((buttonHeight * 5) / 8) - (dotWidth / 2);
                        ps13[4] = new LayoutParams(dotWidth, dotHeight);
                        ps13[4].leftMargin = ((buttonWidth * 5) / 8) - (dotWidth / 2);
                        ps13[4].topMargin = ((buttonHeight * 5) / 8) - (dotWidth / 2);
                        ps2 = ps13;
                    } else {
                        if (placeType.equals(PlaceType.CIRCLE_5_4)) {
                            double s22 = Math.sqrt(2.0d);
                            LayoutParams[] ps14 = new LayoutParams[5];
                            ps14[0] = new LayoutParams(dotWidth, dotHeight);
                            ps14[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                            ps14[0].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                            ps14[1] = new LayoutParams(dotWidth, dotHeight);
                            ps14[1].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                            ps14[1].topMargin = (int) ((((double) (buttonWidth / 2)) - (((double) (buttonWidth / 4)) / s22)) - ((double) (dotWidth / 2)));
                            ps14[2] = new LayoutParams(dotWidth, dotHeight);
                            ps14[2].leftMargin = (int) ((((double) (buttonWidth / 2)) - (((double) (buttonWidth / 4)) / s22)) - ((double) (dotWidth / 2)));
                            ps14[2].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                            ps14[3] = new LayoutParams(dotWidth, dotHeight);
                            ps14[3].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                            ps14[3].topMargin = (int) ((((double) (buttonWidth / 2)) + (((double) (buttonWidth / 4)) / s22)) - ((double) (dotWidth / 2)));
                            ps14[4] = new LayoutParams(dotWidth, dotHeight);
                            ps14[4].leftMargin = (int) ((((double) (buttonWidth / 2)) + (((double) (buttonWidth / 4)) / s22)) - ((double) (dotWidth / 2)));
                            ps14[4].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                            ps2 = ps14;
                        } else {
                            if (placeType.equals(PlaceType.CIRCLE_6_1)) {
                                LayoutParams[] ps15 = new LayoutParams[6];
                                ps15[0] = new LayoutParams(dotWidth, dotHeight);
                                ps15[0].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                                ps15[0].topMargin = ((buttonHeight * 5) / 12) - (dotWidth / 2);
                                ps15[1] = new LayoutParams(dotWidth, dotHeight);
                                ps15[1].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                ps15[1].topMargin = ((buttonHeight * 5) / 12) - (dotWidth / 2);
                                ps15[2] = new LayoutParams(dotWidth, dotHeight);
                                ps15[2].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                                ps15[2].topMargin = ((buttonHeight * 5) / 12) - (dotWidth / 2);
                                ps15[3] = new LayoutParams(dotWidth, dotHeight);
                                ps15[3].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                                ps15[3].topMargin = ((buttonHeight * 7) / 12) - (dotWidth / 2);
                                ps15[4] = new LayoutParams(dotWidth, dotHeight);
                                ps15[4].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                ps15[4].topMargin = ((buttonHeight * 7) / 12) - (dotWidth / 2);
                                ps15[5] = new LayoutParams(dotWidth, dotHeight);
                                ps15[5].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                                ps15[5].topMargin = ((buttonHeight * 7) / 12) - (dotWidth / 2);
                                ps2 = ps15;
                            } else {
                                if (placeType.equals(PlaceType.CIRCLE_6_2)) {
                                    LayoutParams[] ps16 = new LayoutParams[6];
                                    ps16[0] = new LayoutParams(dotWidth, dotHeight);
                                    ps16[0].leftMargin = ((buttonWidth * 5) / 12) - (dotWidth / 2);
                                    ps16[0].topMargin = (buttonHeight / 3) - (dotWidth / 2);
                                    ps16[1] = new LayoutParams(dotWidth, dotHeight);
                                    ps16[1].leftMargin = ((buttonWidth * 7) / 12) - (dotWidth / 2);
                                    ps16[1].topMargin = (buttonHeight / 3) - (dotWidth / 2);
                                    ps16[2] = new LayoutParams(dotWidth, dotHeight);
                                    ps16[2].leftMargin = ((buttonWidth * 5) / 12) - (dotWidth / 2);
                                    ps16[2].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                    ps16[3] = new LayoutParams(dotWidth, dotHeight);
                                    ps16[3].leftMargin = ((buttonWidth * 7) / 12) - (dotWidth / 2);
                                    ps16[3].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                    ps16[4] = new LayoutParams(dotWidth, dotHeight);
                                    ps16[4].leftMargin = ((buttonWidth * 5) / 12) - (dotWidth / 2);
                                    ps16[4].topMargin = ((buttonHeight * 2) / 3) - (dotWidth / 2);
                                    ps16[5] = new LayoutParams(dotWidth, dotHeight);
                                    ps16[5].leftMargin = ((buttonWidth * 7) / 12) - (dotWidth / 2);
                                    ps16[5].topMargin = ((buttonHeight * 2) / 3) - (dotWidth / 2);
                                    ps2 = ps16;
                                } else {
                                    if (placeType.equals(PlaceType.CIRCLE_6_3)) {
                                        int dis2 = (int) (((double) (buttonWidth / 12)) * Math.sqrt(3.0d));
                                        LayoutParams[] ps17 = new LayoutParams[6];
                                        ps17[0] = new LayoutParams(dotWidth, dotHeight);
                                        ps17[0].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                                        ps17[0].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                        ps17[1] = new LayoutParams(dotWidth, dotHeight);
                                        ps17[1].leftMargin = ((buttonWidth * 5) / 12) - (dotWidth / 2);
                                        ps17[1].topMargin = ((buttonHeight / 2) - dis2) - (dotWidth / 2);
                                        ps17[2] = new LayoutParams(dotWidth, dotHeight);
                                        ps17[2].leftMargin = ((buttonWidth * 7) / 12) - (dotWidth / 2);
                                        ps17[2].topMargin = ((buttonHeight / 2) - dis2) - (dotWidth / 2);
                                        ps17[3] = new LayoutParams(dotWidth, dotHeight);
                                        ps17[3].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                                        ps17[3].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                        ps17[4] = new LayoutParams(dotWidth, dotHeight);
                                        ps17[4].leftMargin = ((buttonWidth * 7) / 12) - (dotWidth / 2);
                                        ps17[4].topMargin = ((buttonHeight / 2) + dis2) - (dotWidth / 2);
                                        ps17[5] = new LayoutParams(dotWidth, dotHeight);
                                        ps17[5].leftMargin = ((buttonWidth * 5) / 12) - (dotWidth / 2);
                                        ps17[5].topMargin = ((buttonHeight / 2) + dis2) - (dotWidth / 2);
                                        ps2 = ps17;
                                    } else {
                                        if (placeType.equals(PlaceType.CIRCLE_6_4)) {
                                            int dis22 = (int) (((double) (buttonWidth / 12)) * Math.sqrt(3.0d));
                                            LayoutParams[] ps18 = new LayoutParams[6];
                                            ps18[0] = new LayoutParams(dotWidth, dotHeight);
                                            ps18[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                            ps18[0].topMargin = (buttonHeight / 3) - (dotWidth / 2);
                                            ps18[1] = new LayoutParams(dotWidth, dotHeight);
                                            ps18[1].leftMargin = ((buttonWidth / 2) + dis22) - (dotWidth / 2);
                                            ps18[1].topMargin = ((buttonHeight * 5) / 12) - (dotWidth / 2);
                                            ps18[2] = new LayoutParams(dotWidth, dotHeight);
                                            ps18[2].leftMargin = ((buttonWidth / 2) + dis22) - (dotWidth / 2);
                                            ps18[2].topMargin = ((buttonHeight * 7) / 12) - (dotWidth / 2);
                                            ps18[3] = new LayoutParams(dotWidth, dotHeight);
                                            ps18[3].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                            ps18[3].topMargin = ((buttonHeight * 2) / 3) - (dotWidth / 2);
                                            ps18[4] = new LayoutParams(dotWidth, dotHeight);
                                            ps18[4].leftMargin = ((buttonWidth / 2) - dis22) - (dotWidth / 2);
                                            ps18[4].topMargin = ((buttonHeight * 7) / 12) - (dotWidth / 2);
                                            ps18[5] = new LayoutParams(dotWidth, dotHeight);
                                            ps18[5].leftMargin = ((buttonWidth / 2) - dis22) - (dotWidth / 2);
                                            ps18[5].topMargin = ((buttonHeight * 5) / 12) - (dotWidth / 2);
                                            ps2 = ps18;
                                        } else {
                                            if (placeType.equals(PlaceType.CIRCLE_6_5)) {
                                                int dis1 = buttonWidth / 12;
                                                int dis23 = (int) (((double) dis1) * Math.sqrt(3.0d));
                                                LayoutParams[] ps19 = new LayoutParams[6];
                                                ps19[0] = new LayoutParams(dotWidth, dotHeight);
                                                ps19[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                ps19[0].topMargin = ((buttonHeight / 2) - dis23) - (dotWidth / 2);
                                                ps19[1] = new LayoutParams(dotWidth, dotHeight);
                                                ps19[1].leftMargin = ((buttonWidth / 2) - dis1) - (dotWidth / 2);
                                                ps19[1].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                ps19[2] = new LayoutParams(dotWidth, dotHeight);
                                                ps19[2].leftMargin = ((buttonWidth / 2) + dis1) - (dotWidth / 2);
                                                ps19[2].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                ps19[3] = new LayoutParams(dotWidth, dotHeight);
                                                ps19[3].leftMargin = ((buttonWidth / 2) - (dis1 * 2)) - (dotWidth / 2);
                                                ps19[3].topMargin = ((buttonHeight / 2) + dis23) - (dotWidth / 2);
                                                ps19[4] = new LayoutParams(dotWidth, dotHeight);
                                                ps19[4].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                ps19[4].topMargin = ((buttonHeight / 2) + dis23) - (dotWidth / 2);
                                                ps19[5] = new LayoutParams(dotWidth, dotHeight);
                                                ps19[5].leftMargin = ((buttonWidth / 2) + (dis1 * 2)) - (dotWidth / 2);
                                                ps19[5].topMargin = ((buttonHeight / 2) + dis23) - (dotWidth / 2);
                                                ps2 = ps19;
                                            } else {
                                                if (placeType.equals(PlaceType.CIRCLE_6_6)) {
                                                    int dis12 = buttonWidth / 12;
                                                    int dis24 = (int) (((double) dis12) * Math.sqrt(3.0d));
                                                    LayoutParams[] ps20 = new LayoutParams[6];
                                                    ps20[0] = new LayoutParams(dotWidth, dotHeight);
                                                    ps20[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                    ps20[0].topMargin = ((buttonHeight / 2) + dis24) - (dotWidth / 2);
                                                    ps20[1] = new LayoutParams(dotWidth, dotHeight);
                                                    ps20[1].leftMargin = ((buttonWidth / 2) - dis12) - (dotWidth / 2);
                                                    ps20[1].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                    ps20[2] = new LayoutParams(dotWidth, dotHeight);
                                                    ps20[2].leftMargin = ((buttonWidth / 2) + dis12) - (dotWidth / 2);
                                                    ps20[2].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                    ps20[3] = new LayoutParams(dotWidth, dotHeight);
                                                    ps20[3].leftMargin = ((buttonWidth / 2) - (dis12 * 2)) - (dotWidth / 2);
                                                    ps20[3].topMargin = ((buttonHeight / 2) - dis24) - (dotWidth / 2);
                                                    ps20[4] = new LayoutParams(dotWidth, dotHeight);
                                                    ps20[4].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                    ps20[4].topMargin = ((buttonHeight / 2) - dis24) - (dotWidth / 2);
                                                    ps20[5] = new LayoutParams(dotWidth, dotHeight);
                                                    ps20[5].leftMargin = ((buttonWidth / 2) + (dis12 * 2)) - (dotWidth / 2);
                                                    ps20[5].topMargin = ((buttonHeight / 2) - dis24) - (dotWidth / 2);
                                                    ps2 = ps20;
                                                } else {
                                                    if (placeType.equals(PlaceType.CIRCLE_7_1)) {
                                                        LayoutParams[] ps21 = new LayoutParams[7];
                                                        ps21[0] = new LayoutParams(dotWidth, dotHeight);
                                                        ps21[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                        ps21[0].topMargin = (buttonHeight / 3) - (dotWidth / 2);
                                                        ps21[1] = new LayoutParams(dotWidth, dotHeight);
                                                        ps21[1].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                                                        ps21[1].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                        ps21[2] = new LayoutParams(dotWidth, dotHeight);
                                                        ps21[2].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                        ps21[2].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                        ps21[3] = new LayoutParams(dotWidth, dotHeight);
                                                        ps21[3].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                                                        ps21[3].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                        ps21[4] = new LayoutParams(dotWidth, dotHeight);
                                                        ps21[4].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                                                        ps21[4].topMargin = ((buttonHeight * 2) / 3) - (dotWidth / 2);
                                                        ps21[5] = new LayoutParams(dotWidth, dotHeight);
                                                        ps21[5].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                        ps21[5].topMargin = ((buttonHeight * 2) / 3) - (dotWidth / 2);
                                                        ps21[6] = new LayoutParams(dotWidth, dotHeight);
                                                        ps21[6].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                                                        ps21[6].topMargin = ((buttonHeight * 2) / 3) - (dotWidth / 2);
                                                        ps2 = ps21;
                                                    } else {
                                                        if (placeType.equals(PlaceType.CIRCLE_7_2)) {
                                                            LayoutParams[] ps22 = new LayoutParams[7];
                                                            ps22[0] = new LayoutParams(dotWidth, dotHeight);
                                                            ps22[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                            ps22[0].topMargin = ((buttonHeight * 2) / 3) - (dotWidth / 2);
                                                            ps22[1] = new LayoutParams(dotWidth, dotHeight);
                                                            ps22[1].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                                                            ps22[1].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                            ps22[2] = new LayoutParams(dotWidth, dotHeight);
                                                            ps22[2].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                            ps22[2].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                            ps22[3] = new LayoutParams(dotWidth, dotHeight);
                                                            ps22[3].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                                                            ps22[3].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                            ps22[4] = new LayoutParams(dotWidth, dotHeight);
                                                            ps22[4].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                                                            ps22[4].topMargin = (buttonHeight / 3) - (dotWidth / 2);
                                                            ps22[5] = new LayoutParams(dotWidth, dotHeight);
                                                            ps22[5].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                            ps22[5].topMargin = (buttonHeight / 3) - (dotWidth / 2);
                                                            ps22[6] = new LayoutParams(dotWidth, dotHeight);
                                                            ps22[6].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                                                            ps22[6].topMargin = (buttonHeight / 3) - (dotWidth / 2);
                                                            ps2 = ps22;
                                                        } else {
                                                            if (placeType.equals(PlaceType.CIRCLE_7_3)) {
                                                                int dis25 = (int) (((double) (buttonWidth / 12)) * Math.sqrt(3.0d));
                                                                LayoutParams[] ps23 = new LayoutParams[7];
                                                                ps23[0] = new LayoutParams(dotWidth, dotHeight);
                                                                ps23[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                ps23[0].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                ps23[1] = new LayoutParams(dotWidth, dotHeight);
                                                                ps23[1].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                                                                ps23[1].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                ps23[2] = new LayoutParams(dotWidth, dotHeight);
                                                                ps23[2].leftMargin = ((buttonWidth * 5) / 12) - (dotWidth / 2);
                                                                ps23[2].topMargin = ((buttonHeight / 2) - dis25) - (dotWidth / 2);
                                                                ps23[3] = new LayoutParams(dotWidth, dotHeight);
                                                                ps23[3].leftMargin = ((buttonWidth * 7) / 12) - (dotWidth / 2);
                                                                ps23[3].topMargin = ((buttonHeight / 2) - dis25) - (dotWidth / 2);
                                                                ps23[4] = new LayoutParams(dotWidth, dotHeight);
                                                                ps23[4].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                                                                ps23[4].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                ps23[5] = new LayoutParams(dotWidth, dotHeight);
                                                                ps23[5].leftMargin = ((buttonWidth * 7) / 12) - (dotWidth / 2);
                                                                ps23[5].topMargin = ((buttonHeight / 2) + dis25) - (dotWidth / 2);
                                                                ps23[6] = new LayoutParams(dotWidth, dotHeight);
                                                                ps23[6].leftMargin = ((buttonWidth * 5) / 12) - (dotWidth / 2);
                                                                ps23[6].topMargin = ((buttonHeight / 2) + dis25) - (dotWidth / 2);
                                                                ps2 = ps23;
                                                            } else {
                                                                if (placeType.equals(PlaceType.CIRCLE_7_4)) {
                                                                    int dis26 = (int) (((double) (buttonWidth / 12)) * Math.sqrt(3.0d));
                                                                    LayoutParams[] ps24 = new LayoutParams[7];
                                                                    ps24[0] = new LayoutParams(dotWidth, dotHeight);
                                                                    ps24[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                    ps24[0].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                    ps24[1] = new LayoutParams(dotWidth, dotHeight);
                                                                    ps24[1].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                    ps24[1].topMargin = (buttonHeight / 3) - (dotWidth / 2);
                                                                    ps24[2] = new LayoutParams(dotWidth, dotHeight);
                                                                    ps24[2].leftMargin = ((buttonWidth / 2) + dis26) - (dotWidth / 2);
                                                                    ps24[2].topMargin = ((buttonHeight * 5) / 12) - (dotWidth / 2);
                                                                    ps24[3] = new LayoutParams(dotWidth, dotHeight);
                                                                    ps24[3].leftMargin = ((buttonWidth / 2) + dis26) - (dotWidth / 2);
                                                                    ps24[3].topMargin = ((buttonHeight * 7) / 12) - (dotWidth / 2);
                                                                    ps24[4] = new LayoutParams(dotWidth, dotHeight);
                                                                    ps24[4].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                    ps24[4].topMargin = ((buttonHeight * 2) / 3) - (dotWidth / 2);
                                                                    ps24[5] = new LayoutParams(dotWidth, dotHeight);
                                                                    ps24[5].leftMargin = ((buttonWidth / 2) - dis26) - (dotWidth / 2);
                                                                    ps24[5].topMargin = ((buttonHeight * 7) / 12) - (dotWidth / 2);
                                                                    ps24[6] = new LayoutParams(dotWidth, dotHeight);
                                                                    ps24[6].leftMargin = ((buttonWidth / 2) - dis26) - (dotWidth / 2);
                                                                    ps24[6].topMargin = ((buttonHeight * 5) / 12) - (dotWidth / 2);
                                                                    ps2 = ps24;
                                                                } else {
                                                                    if (placeType.equals(PlaceType.CIRCLE_8_1)) {
                                                                        int dis13 = buttonWidth / 12;
                                                                        int dis27 = (int) (((double) dis13) * Math.sqrt(3.0d));
                                                                        LayoutParams[] ps25 = new LayoutParams[8];
                                                                        ps25[0] = new LayoutParams(dotWidth, dotHeight);
                                                                        ps25[0].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                                                                        ps25[0].topMargin = ((buttonHeight / 2) - dis27) - (dotWidth / 2);
                                                                        ps25[1] = new LayoutParams(dotWidth, dotHeight);
                                                                        ps25[1].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                        ps25[1].topMargin = ((buttonHeight / 2) - dis27) - (dotWidth / 2);
                                                                        ps25[2] = new LayoutParams(dotWidth, dotHeight);
                                                                        ps25[2].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                                                                        ps25[2].topMargin = ((buttonHeight / 2) - dis27) - (dotWidth / 2);
                                                                        ps25[3] = new LayoutParams(dotWidth, dotHeight);
                                                                        ps25[3].leftMargin = ((buttonWidth / 2) - dis13) - (dotWidth / 2);
                                                                        ps25[3].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                        ps25[4] = new LayoutParams(dotWidth, dotHeight);
                                                                        ps25[4].leftMargin = ((buttonWidth / 2) + dis13) - (dotWidth / 2);
                                                                        ps25[4].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                        ps25[5] = new LayoutParams(dotWidth, dotHeight);
                                                                        ps25[5].leftMargin = (buttonWidth / 3) - (dotWidth / 2);
                                                                        ps25[5].topMargin = ((buttonHeight / 2) + dis27) - (dotWidth / 2);
                                                                        ps25[6] = new LayoutParams(dotWidth, dotHeight);
                                                                        ps25[6].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                        ps25[6].topMargin = ((buttonHeight / 2) + dis27) - (dotWidth / 2);
                                                                        ps25[7] = new LayoutParams(dotWidth, dotHeight);
                                                                        ps25[7].leftMargin = ((buttonWidth * 2) / 3) - (dotWidth / 2);
                                                                        ps25[7].topMargin = ((buttonHeight / 2) + dis27) - (dotWidth / 2);
                                                                        ps2 = ps25;
                                                                    } else {
                                                                        if (placeType.equals(PlaceType.CIRCLE_8_2)) {
                                                                            int dis28 = (int) (((double) (buttonWidth / 12)) * Math.sqrt(3.0d));
                                                                            LayoutParams[] ps26 = new LayoutParams[8];
                                                                            ps26[0] = new LayoutParams(dotWidth, dotHeight);
                                                                            ps26[0].leftMargin = ((buttonWidth / 2) - dis28) - (dotWidth / 2);
                                                                            ps26[0].topMargin = (buttonHeight / 3) - (dotWidth / 2);
                                                                            ps26[1] = new LayoutParams(dotWidth, dotHeight);
                                                                            ps26[1].leftMargin = ((buttonWidth / 2) - dis28) - (dotWidth / 2);
                                                                            ps26[1].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                            ps26[2] = new LayoutParams(dotWidth, dotHeight);
                                                                            ps26[2].leftMargin = ((buttonWidth / 2) - dis28) - (dotWidth / 2);
                                                                            ps26[2].topMargin = ((buttonHeight * 2) / 3) - (dotWidth / 2);
                                                                            ps26[3] = new LayoutParams(dotWidth, dotHeight);
                                                                            ps26[3].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                            ps26[3].topMargin = ((buttonHeight * 5) / 12) - (dotWidth / 2);
                                                                            ps26[4] = new LayoutParams(dotWidth, dotHeight);
                                                                            ps26[4].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                            ps26[4].topMargin = ((buttonHeight * 7) / 12) - (dotWidth / 2);
                                                                            ps26[5] = new LayoutParams(dotWidth, dotHeight);
                                                                            ps26[5].leftMargin = ((buttonWidth / 2) + dis28) - (dotWidth / 2);
                                                                            ps26[5].topMargin = (buttonHeight / 3) - (dotWidth / 2);
                                                                            ps26[6] = new LayoutParams(dotWidth, dotHeight);
                                                                            ps26[6].leftMargin = ((buttonWidth / 2) + dis28) - (dotWidth / 2);
                                                                            ps26[6].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                            ps26[7] = new LayoutParams(dotWidth, dotHeight);
                                                                            ps26[7].leftMargin = ((buttonWidth / 2) + dis28) - (dotWidth / 2);
                                                                            ps26[7].topMargin = ((buttonHeight * 2) / 3) - (dotWidth / 2);
                                                                            ps2 = ps26;
                                                                        } else {
                                                                            if (placeType.equals(PlaceType.CIRCLE_8_3)) {
                                                                                int dis29 = (int) (((double) (buttonWidth / 12)) * Math.sqrt(3.0d));
                                                                                LayoutParams[] ps27 = new LayoutParams[8];
                                                                                ps27[0] = new LayoutParams(dotWidth, dotHeight);
                                                                                ps27[0].leftMargin = ((buttonWidth / 2) - dis29) - (dotWidth / 2);
                                                                                ps27[0].topMargin = ((buttonHeight / 2) - dis29) - (dotWidth / 2);
                                                                                ps27[1] = new LayoutParams(dotWidth, dotHeight);
                                                                                ps27[1].leftMargin = ((buttonWidth / 2) - dis29) - (dotWidth / 2);
                                                                                ps27[1].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                                ps27[2] = new LayoutParams(dotWidth, dotHeight);
                                                                                ps27[2].leftMargin = ((buttonWidth / 2) - dis29) - (dotWidth / 2);
                                                                                ps27[2].topMargin = ((buttonHeight / 2) + dis29) - (dotWidth / 2);
                                                                                ps27[3] = new LayoutParams(dotWidth, dotHeight);
                                                                                ps27[3].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                                ps27[3].topMargin = ((buttonHeight / 2) - dis29) - (dotWidth / 2);
                                                                                ps27[4] = new LayoutParams(dotWidth, dotHeight);
                                                                                ps27[4].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                                ps27[4].topMargin = ((buttonHeight / 2) + dis29) - (dotWidth / 2);
                                                                                ps27[5] = new LayoutParams(dotWidth, dotHeight);
                                                                                ps27[5].leftMargin = ((buttonWidth / 2) + dis29) - (dotWidth / 2);
                                                                                ps27[5].topMargin = ((buttonHeight / 2) - dis29) - (dotWidth / 2);
                                                                                ps27[6] = new LayoutParams(dotWidth, dotHeight);
                                                                                ps27[6].leftMargin = ((buttonWidth / 2) + dis29) - (dotWidth / 2);
                                                                                ps27[6].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                                ps27[7] = new LayoutParams(dotWidth, dotHeight);
                                                                                ps27[7].leftMargin = ((buttonWidth / 2) + dis29) - (dotWidth / 2);
                                                                                ps27[7].topMargin = ((buttonHeight / 2) + dis29) - (dotWidth / 2);
                                                                                ps2 = ps27;
                                                                            } else {
                                                                                if (placeType.equals(PlaceType.CIRCLE_9_1)) {
                                                                                    int dis210 = (int) (((double) (buttonWidth / 12)) * Math.sqrt(3.0d));
                                                                                    LayoutParams[] ps28 = new LayoutParams[9];
                                                                                    ps28[0] = new LayoutParams(dotWidth, dotHeight);
                                                                                    ps28[0].leftMargin = ((buttonWidth / 2) - dis210) - (dotWidth / 2);
                                                                                    ps28[0].topMargin = ((buttonHeight / 2) - dis210) - (dotWidth / 2);
                                                                                    ps28[1] = new LayoutParams(dotWidth, dotHeight);
                                                                                    ps28[1].leftMargin = ((buttonWidth / 2) - dis210) - (dotWidth / 2);
                                                                                    ps28[1].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                                    ps28[2] = new LayoutParams(dotWidth, dotHeight);
                                                                                    ps28[2].leftMargin = ((buttonWidth / 2) - dis210) - (dotWidth / 2);
                                                                                    ps28[2].topMargin = ((buttonHeight / 2) + dis210) - (dotWidth / 2);
                                                                                    ps28[3] = new LayoutParams(dotWidth, dotHeight);
                                                                                    ps28[3].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                                    ps28[3].topMargin = ((buttonHeight / 2) - dis210) - (dotWidth / 2);
                                                                                    ps28[4] = new LayoutParams(dotWidth, dotHeight);
                                                                                    ps28[4].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                                    ps28[4].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                                    ps28[5] = new LayoutParams(dotWidth, dotHeight);
                                                                                    ps28[5].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                                    ps28[5].topMargin = ((buttonHeight / 2) + dis210) - (dotWidth / 2);
                                                                                    ps28[6] = new LayoutParams(dotWidth, dotHeight);
                                                                                    ps28[6].leftMargin = ((buttonWidth / 2) + dis210) - (dotWidth / 2);
                                                                                    ps28[6].topMargin = ((buttonHeight / 2) - dis210) - (dotWidth / 2);
                                                                                    ps28[7] = new LayoutParams(dotWidth, dotHeight);
                                                                                    ps28[7].leftMargin = ((buttonWidth / 2) + dis210) - (dotWidth / 2);
                                                                                    ps28[7].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                                    ps28[8] = new LayoutParams(dotWidth, dotHeight);
                                                                                    ps28[8].leftMargin = ((buttonWidth / 2) + dis210) - (dotWidth / 2);
                                                                                    ps28[8].topMargin = ((buttonHeight / 2) + dis210) - (dotWidth / 2);
                                                                                    ps2 = ps28;
                                                                                } else {
                                                                                    if (placeType.equals(PlaceType.CIRCLE_9_2)) {
                                                                                        int dis14 = (int) (((double) (buttonWidth / 12)) * Math.sqrt(6.0d));
                                                                                        LayoutParams[] ps29 = new LayoutParams[9];
                                                                                        ps29[0] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps29[0].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                                        ps29[0].topMargin = ((buttonHeight / 2) - dis14) - (dotWidth / 2);
                                                                                        ps29[1] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps29[1].leftMargin = ((buttonWidth / 2) - (dis14 / 2)) - (dotWidth / 2);
                                                                                        ps29[1].topMargin = ((buttonHeight / 2) - (dis14 / 2)) - (dotWidth / 2);
                                                                                        ps29[2] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps29[2].leftMargin = ((buttonWidth / 2) + (dis14 / 2)) - (dotWidth / 2);
                                                                                        ps29[2].topMargin = ((buttonHeight / 2) - (dis14 / 2)) - (dotWidth / 2);
                                                                                        ps29[3] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps29[3].leftMargin = ((buttonWidth / 2) - dis14) - (dotWidth / 2);
                                                                                        ps29[3].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                                        ps29[4] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps29[4].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                                        ps29[4].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                                        ps29[5] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps29[5].leftMargin = ((buttonWidth / 2) + dis14) - (dotWidth / 2);
                                                                                        ps29[5].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                                        ps29[6] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps29[6].leftMargin = ((buttonWidth / 2) - (dis14 / 2)) - (dotWidth / 2);
                                                                                        ps29[6].topMargin = ((buttonHeight / 2) + (dis14 / 2)) - (dotWidth / 2);
                                                                                        ps29[7] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps29[7].leftMargin = ((buttonWidth / 2) + (dis14 / 2)) - (dotWidth / 2);
                                                                                        ps29[7].topMargin = ((buttonHeight / 2) + (dis14 / 2)) - (dotWidth / 2);
                                                                                        ps29[8] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps29[8].leftMargin = (buttonWidth / 2) - (dotWidth / 2);
                                                                                        ps29[8].topMargin = ((buttonHeight / 2) + dis14) - (dotWidth / 2);
                                                                                        ps2 = ps29;
                                                                                    } else if (PlaceType.SHARE_3_1.v <= placeType.v && placeType.v <= PlaceType.SHARE_9_2.v) {
                                                                                        int dis15 = buttonWidth / 6;
                                                                                        int dis211 = (int) ((Math.sqrt(3.0d) / 2.0d) * ((double) dis15));
                                                                                        ps = new LayoutParams[9];
                                                                                        ps[0] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps[0].leftMargin = ((buttonWidth / 2) + (dis15 / 2)) - (dotWidth / 2);
                                                                                        ps[0].topMargin = ((buttonHeight / 2) - dis211) - (dotWidth / 2);
                                                                                        ps[1] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps[1].leftMargin = ((buttonWidth / 2) - dis15) - (dotWidth / 2);
                                                                                        ps[1].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                                        ps[2] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps[2].leftMargin = ((buttonWidth / 2) + (dis15 / 2)) - (dotWidth / 2);
                                                                                        ps[2].topMargin = ((buttonHeight / 2) + dis211) - (dotWidth / 2);
                                                                                        ps[3] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps[3].leftMargin = ((buttonWidth / 2) + (dis15 / 2)) - (dotWidth / 2);
                                                                                        ps[3].topMargin = ((buttonHeight / 2) - dis211) - (dotWidth / 2);
                                                                                        ps[4] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps[4].leftMargin = ((buttonWidth / 2) - dis15) - (dotWidth / 2);
                                                                                        ps[4].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                                        ps[5] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps[5].leftMargin = ((buttonWidth / 2) + (dis15 / 2)) - (dotWidth / 2);
                                                                                        ps[5].topMargin = ((buttonHeight / 2) + dis211) - (dotWidth / 2);
                                                                                        ps[6] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps[6].leftMargin = ((buttonWidth / 2) + (dis15 / 2)) - (dotWidth / 2);
                                                                                        ps[6].topMargin = ((buttonHeight / 2) - dis211) - (dotWidth / 2);
                                                                                        ps[7] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps[7].leftMargin = ((buttonWidth / 2) - dis15) - (dotWidth / 2);
                                                                                        ps[7].topMargin = (buttonHeight / 2) - (dotWidth / 2);
                                                                                        ps[8] = new LayoutParams(dotWidth, dotHeight);
                                                                                        ps[8].leftMargin = ((buttonWidth / 2) + (dis15 / 2)) - (dotWidth / 2);
                                                                                        ps[8].topMargin = ((buttonHeight / 2) + dis211) - (dotWidth / 2);
                                                                                        ps2 = ps;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (LayoutParams layoutParams : ps2) {
            layoutParams.gravity = 51;
        }
        return ps2;
    }

    public static LayoutParams[] getBarParams(PlaceType placeType, int buttonWidth, int buttonHeight, int barWidth, int barHeight) {
        LayoutParams[] ps = null;
        if (placeType.equals(PlaceType.HAM_1_1)) {
            ps = new LayoutParams[]{new LayoutParams(barWidth, barHeight)};
            ps[0].leftMargin = (buttonWidth / 2) - (barWidth / 2);
            ps[0].topMargin = (buttonHeight / 2) - (barHeight / 2);
        } else if (placeType.equals(PlaceType.HAM_2_1)) {
            ps = new LayoutParams[2];
            ps[0] = new LayoutParams(barWidth, barHeight);
            ps[0].leftMargin = (buttonWidth / 2) - (barWidth / 2);
            ps[0].topMargin = (buttonHeight / 2) - ((barHeight * 3) / 2);
            ps[1] = new LayoutParams(barWidth, barHeight);
            ps[1].leftMargin = (buttonWidth / 2) - (barWidth / 2);
            ps[1].topMargin = (buttonHeight / 2) + (barHeight / 2);
        } else if (placeType.equals(PlaceType.HAM_3_1)) {
            ps = new LayoutParams[3];
            ps[0] = new LayoutParams(barWidth, barHeight);
            ps[0].leftMargin = (buttonWidth / 2) - (barWidth / 2);
            ps[0].topMargin = (buttonHeight / 2) - ((barHeight * 13) / 6);
            ps[1] = new LayoutParams(barWidth, barHeight);
            ps[1].leftMargin = (buttonWidth / 2) - (barWidth / 2);
            ps[1].topMargin = (buttonHeight / 2) - (barHeight / 2);
            ps[2] = new LayoutParams(barWidth, barHeight);
            ps[2].leftMargin = (buttonWidth / 2) - (barWidth / 2);
            ps[2].topMargin = (buttonHeight / 2) + ((barHeight * 7) / 6);
        } else if (placeType.equals(PlaceType.HAM_4_1)) {
            ps = new LayoutParams[4];
            ps[0] = new LayoutParams(barWidth, barHeight);
            ps[0].leftMargin = (buttonWidth / 2) - (barWidth / 2);
            ps[0].topMargin = (buttonHeight / 2) - ((barHeight * 11) / 4);
            ps[1] = new LayoutParams(barWidth, barHeight);
            ps[1].leftMargin = (buttonWidth / 2) - (barWidth / 2);
            ps[1].topMargin = (buttonHeight / 2) - ((barHeight * 5) / 4);
            ps[2] = new LayoutParams(barWidth, barHeight);
            ps[2].leftMargin = (buttonWidth / 2) - (barWidth / 2);
            ps[2].topMargin = (buttonHeight / 2) + (barHeight / 4);
            ps[3] = new LayoutParams(barWidth, barHeight);
            ps[3].leftMargin = (buttonWidth / 2) - (barWidth / 2);
            ps[3].topMargin = (buttonHeight / 2) + ((barHeight * 7) / 4);
        }
        for (LayoutParams layoutParams : ps) {
            layoutParams.gravity = 51;
        }
        return ps;
    }
}
