package com.nightonke.boommenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nightonke.boommenu.CircleButton.OnCircleButtonClickListener;
import com.nightonke.boommenu.Eases.EaseType;
import com.nightonke.boommenu.HamButton.OnHamButtonClickListener;
import com.nightonke.boommenu.Types.BoomType;
import com.nightonke.boommenu.Types.ButtonType;
import com.nightonke.boommenu.Types.ClickEffectType;
import com.nightonke.boommenu.Types.DimType;
import com.nightonke.boommenu.Types.OrderType;
import com.nightonke.boommenu.Types.PlaceType;
import com.nightonke.boommenu.Types.StateType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BoomMenuButton extends FrameLayout implements OnCircleButtonClickListener, OnHamButtonClickListener {
    public static final int MAX_CIRCLE_BUTTON_NUMBER = 9;
    public static final int MAX_HAM_BUTTON_NUMBER = 4;
    public static final boolean MEMORY_OPTIMIZATION = true;
    public static final int MIN_CIRCLE_BUTTON_NUMBER = 1;
    public static final int MIN_HAM_BUTTON_NUMBER = 1;
    /* access modifiers changed from: private */
    public ViewGroup animationLayout;
    /* access modifiers changed from: private */
    public boolean animationPlaying;
    /* access modifiers changed from: private */
    public AnimatorListener animatorListener;
    private boolean autoDismiss;
    private int barHeight;
    private int barWidth;
    private Bar[] bars;
    private int boomButtonColor;
    private int boomButtonPressedColor;
    private int boomButtonRadius;
    private BoomType boomType;
    private int buttonNum;
    /* access modifiers changed from: private */
    public ButtonType buttonType;
    private int buttonWidth;
    /* access modifiers changed from: private */
    public boolean cancelable;
    /* access modifiers changed from: private */
    public CircleButton[] circleButtons;
    private ClickEffectType clickEffectType;
    private int[][] colors;
    private int delay;
    private DimType dimType;
    private int dotHeight;
    private int dotWidth;
    private Dot[] dots;
    private Drawable[] drawables;
    private int duration;
    private int[][] endLocations;
    private FrameLayout frameLayout;
    private int frames;
    private int hamButtonHeight;
    private int hamButtonWidth;
    /* access modifiers changed from: private */
    public HamButton[] hamButtons;
    private EaseType hideMoveEaseType;
    private OrderType hideOrderType;
    private EaseType hideRotateEaseType;
    private EaseType hideScaleEaseType;
    private boolean isInActionBar;
    /* access modifiers changed from: private */
    public boolean isInList;
    private Context mContext;
    private OnClickListener onClickListener;
    private OnSubButtonClickListener onSubButtonClickListener;
    private PlaceType placeType;
    private View ripple;
    private int rotateDegree;
    private ShadowLayout shadowLayout;
    private ShareLines shareLines;
    private EaseType showMoveEaseType;
    private OrderType showOrderType;
    private EaseType showRotateEaseType;
    private EaseType showScaleEaseType;
    private int[][] startLocations;
    /* access modifiers changed from: private */
    public StateType state;
    private String[] strings;
    private float subButtonsXOffsetOfShadow;
    private float subButtonsYOffsetOfShadow;

    public interface AnimatorListener {
        void hided();

        void hiding(float f);

        void showed();

        void showing(float f);

        void toHide();

        void toShow();
    }

    public static class Builder {
        private AnimatorListener animatorListener = null;
        private boolean autoDismiss = true;
        private float boomButtonXOffsetOfShadow = 0.0f;
        private float boomButtonYOffsetOfShadow = 0.0f;
        private BoomType boomType = BoomType.HORIZONTAL_THROW;
        private ButtonType buttonType = ButtonType.CIRCLE;
        private boolean cancelable = true;
        private ClickEffectType clickEffectType = ClickEffectType.RIPPLE;
        private ArrayList<int[]> colors = null;
        private int delay = 100;
        private DimType dimType = DimType.DIM_6;
        private ArrayList<Drawable> drawables = null;
        private int duration = 800;
        private int frames = 80;
        private EaseType hideMoveEaseType = EaseType.EaseOutCirc;
        private OrderType hideOrderType = OrderType.DEFAULT;
        private EaseType hideRotateEaseType = EaseType.Linear;
        private EaseType hideScaleEaseType = EaseType.EaseOutCirc;
        private OnClickListener onClickListener = null;
        private OnSubButtonClickListener onSubButtonClickListener = null;
        private PlaceType placeType = null;
        private int rotateDegree = 720;
        private int shareLine1Color = -1;
        private int shareLine2Color = -1;
        private float shareLineWidth = 3.0f;
        private EaseType showMoveEaseType = EaseType.EaseOutBack;
        private OrderType showOrderType = OrderType.DEFAULT;
        private EaseType showRotateEaseType = EaseType.EaseOutBack;
        private EaseType showScaleEaseType = EaseType.EaseOutBack;
        private ArrayList<String> strings = null;
        private int subButtonTextColor = -1;
        private float subButtonsXOffsetOfShadow = 0.0f;
        private float subButtonsYOffsetOfShadow = 0.0f;

        public Builder subButtons(ArrayList<Drawable> drawables2, ArrayList<int[]> colors2, ArrayList<String> strings2) {
            this.drawables = drawables2;
            this.colors = colors2;
            this.strings = strings2;
            return this;
        }

        public Builder subButtons(Drawable[] drawables2, int[][] colors2, String[] strings2) {
            this.drawables = new ArrayList<>(Arrays.asList(drawables2));
            this.colors = new ArrayList<>(Arrays.asList(colors2));
            this.strings = new ArrayList<>(Arrays.asList(strings2));
            return this;
        }

        public Builder frames(int frames2) {
            this.frames = frames2;
            return this;
        }

        public Builder duration(int duration2) {
            this.duration = duration2;
            return this;
        }

        public Builder delay(int delay2) {
            this.delay = delay2;
            return this;
        }

        public Builder showOrder(OrderType showOrderType2) {
            this.showOrderType = showOrderType2;
            return this;
        }

        public Builder hideOrder(OrderType hideOrderType2) {
            this.hideOrderType = hideOrderType2;
            return this;
        }

        public Builder button(ButtonType buttonType2) {
            this.buttonType = buttonType2;
            return this;
        }

        public Builder boom(BoomType boomType2) {
            this.boomType = boomType2;
            return this;
        }

        public Builder place(PlaceType placeType2) {
            this.placeType = placeType2;
            return this;
        }

        public Builder showMoveEase(EaseType showMoveEaseType2) {
            this.showMoveEaseType = showMoveEaseType2;
            return this;
        }

        public Builder hideMoveEase(EaseType hideMoveEaseType2) {
            this.hideMoveEaseType = hideMoveEaseType2;
            return this;
        }

        public Builder showScaleEase(EaseType showScaleEaseType2) {
            this.showScaleEaseType = showScaleEaseType2;
            return this;
        }

        public Builder hideScaleType(EaseType hideScaleEaseType2) {
            this.hideScaleEaseType = hideScaleEaseType2;
            return this;
        }

        public Builder rotateDegree(int rotateDegree2) {
            this.rotateDegree = rotateDegree2;
            return this;
        }

        public Builder showRotateEase(EaseType showRotateEaseType2) {
            this.showRotateEaseType = showRotateEaseType2;
            return this;
        }

        public Builder hideRotateType(EaseType hideRotateEaseType2) {
            this.hideRotateEaseType = hideRotateEaseType2;
            return this;
        }

        public Builder autoDismiss(boolean autoDismiss2) {
            this.autoDismiss = autoDismiss2;
            return this;
        }

        public Builder cancelable(boolean cancelable2) {
            this.cancelable = cancelable2;
            return this;
        }

        public Builder dim(DimType dimType2) {
            this.dimType = dimType2;
            return this;
        }

        public Builder clickEffect(ClickEffectType clickEffectType2) {
            this.clickEffectType = clickEffectType2;
            return this;
        }

        public Builder boomButtonShadow(float boomButtonXOffsetOfShadow2, float boomButtonYOffsetOfShadow2) {
            this.boomButtonXOffsetOfShadow = boomButtonXOffsetOfShadow2;
            this.boomButtonYOffsetOfShadow = boomButtonYOffsetOfShadow2;
            return this;
        }

        public Builder subButtonsShadow(float subButtonsXOffsetOfShadow2, float subButtonsYOffsetOfShadow2) {
            this.subButtonsXOffsetOfShadow = subButtonsXOffsetOfShadow2;
            this.subButtonsYOffsetOfShadow = subButtonsYOffsetOfShadow2;
            return this;
        }

        public Builder subButtonTextColor(int subButtonTextColor2) {
            this.subButtonTextColor = subButtonTextColor2;
            return this;
        }

        public Builder onBoomButtonBlick(OnClickListener onClickListener2) {
            this.onClickListener = onClickListener2;
            return this;
        }

        public Builder animator(AnimatorListener animatorListener2) {
            this.animatorListener = animatorListener2;
            return this;
        }

        public Builder onSubButtonClick(OnSubButtonClickListener onSubButtonClickListener2) {
            this.onSubButtonClickListener = onSubButtonClickListener2;
            return this;
        }

        public Builder shareStyle(float shareLineWidth2, int shareLine1Color2, int shareLine2Color2) {
            this.shareLineWidth = shareLineWidth2;
            this.shareLine1Color = shareLine1Color2;
            this.shareLine2Color = shareLine2Color2;
            return this;
        }

        public Builder addSubButton(Drawable drawable, int[] twoColors, String string) {
            if (this.drawables == null) {
                this.drawables = new ArrayList<>();
            }
            this.drawables.add(drawable);
            if (this.colors == null) {
                this.colors = new ArrayList<>();
            }
            this.colors.add(twoColors);
            if (this.strings == null) {
                this.strings = new ArrayList<>();
            }
            this.strings.add(string);
            return this;
        }

        public Builder addSubButton(Drawable drawable, int[] twoColors) {
            if (this.drawables == null) {
                this.drawables = new ArrayList<>();
            }
            this.drawables.add(drawable);
            if (this.colors == null) {
                this.colors = new ArrayList<>();
            }
            this.colors.add(twoColors);
            return this;
        }

        public Builder addSubButton(Context context, int drawable, int[] twoColors, String string) {
            if (this.drawables == null) {
                this.drawables = new ArrayList<>();
            }
            this.drawables.add(ContextCompat.getDrawable(context, drawable));
            if (this.colors == null) {
                this.colors = new ArrayList<>();
            }
            this.colors.add(twoColors);
            if (this.strings == null) {
                this.strings = new ArrayList<>();
            }
            this.strings.add(string);
            return this;
        }

        public Builder addSubButton(Context context, int drawable, int[] twoColors) {
            if (this.drawables == null) {
                this.drawables = new ArrayList<>();
            }
            this.drawables.add(ContextCompat.getDrawable(context, drawable));
            if (this.colors == null) {
                this.colors = new ArrayList<>();
            }
            this.colors.add(twoColors);
            return this;
        }

        public BoomMenuButton init(BoomMenuButton boomMenuButton) {
            if (boomMenuButton == null) {
                throw new RuntimeException("BMB is null!");
            }
            Drawable[] drawablesInArray = new Drawable[this.drawables.size()];
            for (int i = 0; i < this.drawables.size(); i++) {
                drawablesInArray[i] = (Drawable) this.drawables.get(i);
            }
            String[] stringsInArray = new String[this.strings.size()];
            for (int i2 = 0; i2 < this.strings.size(); i2++) {
                stringsInArray[i2] = (String) this.strings.get(i2);
            }
            int[][] colorsInArray = (int[][]) Array.newInstance(Integer.TYPE, new int[]{this.colors.size(), 2});
            for (int i3 = 0; i3 < this.colors.size(); i3++) {
                colorsInArray[i3] = (int[]) this.colors.get(i3);
            }
            boomMenuButton.init(drawablesInArray, stringsInArray, colorsInArray, this.buttonType, this.boomType, this.placeType, this.showMoveEaseType, this.showScaleEaseType, this.showRotateEaseType, this.hideMoveEaseType, this.hideScaleEaseType, this.hideRotateEaseType, Integer.valueOf(this.rotateDegree));
            boomMenuButton.setFrames(this.frames);
            boomMenuButton.setDuration(this.duration);
            boomMenuButton.setDelay(this.delay);
            boomMenuButton.setShowOrderType(this.showOrderType);
            boomMenuButton.setHideOrderType(this.hideOrderType);
            boomMenuButton.setAutoDismiss(this.autoDismiss);
            boomMenuButton.setCancelable(this.cancelable);
            boomMenuButton.setDimType(this.dimType);
            boomMenuButton.setClickEffectType(this.clickEffectType);
            boomMenuButton.setBoomButtonShadowOffset(this.boomButtonXOffsetOfShadow, this.boomButtonYOffsetOfShadow);
            boomMenuButton.setSubButtonShadowOffset(this.subButtonsXOffsetOfShadow, this.subButtonsYOffsetOfShadow);
            boomMenuButton.setTextViewColor(this.subButtonTextColor);
            boomMenuButton.setOnClickListener(this.onClickListener);
            boomMenuButton.setAnimatorListener(this.animatorListener);
            boomMenuButton.setOnSubButtonClickListener(this.onSubButtonClickListener);
            boomMenuButton.setShareLineWidth(this.shareLineWidth);
            boomMenuButton.setShareLine1Color(this.shareLine1Color);
            boomMenuButton.setShareLine2Color(this.shareLine2Color);
            return boomMenuButton;
        }
    }

    public interface OnClickListener {
        void onClick();
    }

    public interface OnSubButtonClickListener {
        void onClick(int i);
    }

    public BoomMenuButton(Context context) {
        this(context, null);
    }

    public BoomMenuButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.animationLayout = null;
        this.startLocations = (int[][]) Array.newInstance(Integer.TYPE, new int[]{9, 2});
        this.endLocations = (int[][]) Array.newInstance(Integer.TYPE, new int[]{9, 2});
        this.animationPlaying = false;
        this.state = StateType.CLOSED;
        this.buttonNum = 0;
        this.circleButtons = new CircleButton[9];
        this.hamButtons = new HamButton[4];
        this.dots = new Dot[9];
        this.bars = new Bar[4];
        this.shareLines = null;
        this.drawables = null;
        this.colors = null;
        this.strings = null;
        this.isInActionBar = false;
        this.isInList = false;
        this.boomButtonColor = 0;
        this.boomButtonPressedColor = 0;
        this.frames = 80;
        this.duration = 800;
        this.delay = 100;
        this.showOrderType = OrderType.DEFAULT;
        this.hideOrderType = OrderType.DEFAULT;
        this.buttonType = ButtonType.CIRCLE;
        this.boomType = BoomType.HORIZONTAL_THROW;
        this.placeType = null;
        this.dotWidth = 10;
        this.dotHeight = 10;
        this.buttonWidth = (int) Util.getInstance().dp2px(88.0f);
        this.barWidth = 50;
        this.barHeight = 8;
        this.hamButtonWidth = 0;
        this.hamButtonHeight = (int) Util.getInstance().dp2px(70.0f);
        this.boomButtonRadius = (int) Util.getInstance().dp2px(56.0f);
        this.showMoveEaseType = EaseType.EaseOutBack;
        this.hideMoveEaseType = EaseType.EaseOutCirc;
        this.showScaleEaseType = EaseType.EaseOutBack;
        this.hideScaleEaseType = EaseType.EaseOutCirc;
        this.rotateDegree = 720;
        this.showRotateEaseType = EaseType.EaseOutBack;
        this.hideRotateEaseType = EaseType.Linear;
        this.autoDismiss = true;
        this.cancelable = true;
        this.dimType = DimType.DIM_6;
        this.clickEffectType = ClickEffectType.RIPPLE;
        this.subButtonsXOffsetOfShadow = 0.0f;
        this.subButtonsYOffsetOfShadow = 0.0f;
        this.onClickListener = null;
        this.animatorListener = null;
        this.onSubButtonClickListener = null;
        this.mContext = context;
        TypedArray attr = context.obtainStyledAttributes(attrs, R.styleable.BoomMenuButton, 0, 0);
        if (attr != null) {
            try {
                this.isInActionBar = attr.getBoolean(R.styleable.BoomMenuButton_boom_inActionBar, false);
                this.isInList = attr.getBoolean(R.styleable.BoomMenuButton_boom_inList, false);
                this.boomButtonColor = attr.getColor(R.styleable.BoomMenuButton_boom_button_color, ContextCompat.getColor(this.mContext, R.color.default_boom_button_color));
                this.boomButtonPressedColor = attr.getColor(R.styleable.BoomMenuButton_boom_button_pressed_color, ContextCompat.getColor(this.mContext, R.color.default_boom_button_color_pressed));
            } finally {
                attr.recycle();
            }
        }
        if (this.isInActionBar || this.isInList) {
            LayoutInflater.from(context).inflate(R.layout.boom_menu_button_in_action_bar, this, true);
            this.frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
            this.frameLayout.setOnClickListener(new android.view.View.OnClickListener() {
                public void onClick(View v) {
                    BoomMenuButton.this.shoot();
                }
            });
        } else {
            if (VERSION.SDK_INT >= 21) {
                LayoutInflater.from(context).inflate(R.layout.boom_menu_button, this, true);
            } else {
                LayoutInflater.from(context).inflate(R.layout.boom_menu_button_below_lollipop, this, true);
            }
            this.shadowLayout = (ShadowLayout) findViewById(R.id.shadow_layout);
            this.frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
            this.ripple = findViewById(R.id.ripple);
            setRipple(this.clickEffectType);
            setBoomButtonBackgroundColor(this.boomButtonPressedColor, this.boomButtonColor);
        }
        this.hamButtonWidth = (int) (((float) ((Util.getInstance().getScreenWidth(getContext()) * 8) / 9)) + Util.getInstance().dp2px(4.0f));
        setWillNotDraw(false);
    }

    public void init(Drawable[] drawables2, String[] strings2, int[][] colors2, ButtonType buttonType2, BoomType boomType2, PlaceType placeType2, EaseType showMoveEaseType2, EaseType showScaleEaseType2, EaseType showRotateEaseType2, EaseType hideMoveEaseType2, EaseType hideScaleEaseType2, EaseType hideRotateEaseType2, Integer rotateDegree2) {
        errorJudge(drawables2, strings2, colors2, buttonType2);
        this.buttonType = buttonType2;
        this.boomType = boomType2;
        if (placeType2 == null) {
            throw new RuntimeException("Place type is null!");
        }
        this.placeType = placeType2;
        if (showMoveEaseType2 != null) {
            this.showMoveEaseType = showMoveEaseType2;
        }
        if (showScaleEaseType2 != null) {
            this.showScaleEaseType = showScaleEaseType2;
        }
        if (showRotateEaseType2 != null) {
            this.showRotateEaseType = showRotateEaseType2;
        }
        if (hideMoveEaseType2 != null) {
            this.hideMoveEaseType = hideMoveEaseType2;
        }
        if (hideScaleEaseType2 != null) {
            this.hideScaleEaseType = hideScaleEaseType2;
        }
        if (hideRotateEaseType2 != null) {
            this.hideRotateEaseType = hideRotateEaseType2;
        }
        if (rotateDegree2 != null) {
            this.rotateDegree = rotateDegree2.intValue();
        }
        if (buttonType2.equals(ButtonType.CIRCLE)) {
            this.buttonNum = drawables2.length;
            if (!this.isInList) {
            }
            this.drawables = drawables2;
            this.colors = colors2;
            this.strings = strings2;
            for (int i = 0; i < this.buttonNum; i++) {
                this.dots[i] = new Dot(this.mContext);
                this.dots[i].setColor(colors2[i][1]);
            }
            placeDots();
        } else if (buttonType2.equals(ButtonType.HAM)) {
            this.hamButtonWidth = (Util.getInstance().getScreenWidth(getContext()) * 8) / 9;
            this.buttonNum = drawables2.length;
            if (!this.isInList) {
            }
            this.drawables = drawables2;
            this.colors = colors2;
            this.strings = strings2;
            for (int i2 = 0; i2 < this.buttonNum; i2++) {
                this.bars[i2] = new Bar(this.mContext);
                this.bars[i2].setColor(colors2[i2][1]);
            }
            placeBars();
        }
    }

    private void errorJudge(Drawable[] drawables2, String[] strings2, int[][] colors2, ButtonType buttonType2) {
        if (drawables2 == null) {
            throw new RuntimeException("The button's drawables are null!");
        } else if (colors2 == null) {
            throw new RuntimeException("The button's colors are null!");
        } else if (buttonType2.equals(ButtonType.CIRCLE)) {
            if (1 > drawables2.length || drawables2.length > 9 || ((strings2 != null && (1 > strings2.length || strings2.length > 9)) || 1 > colors2.length || colors2.length > 9)) {
                throw new RuntimeException("The circle type button's length must be in [1, 9]!");
            }
        } else if (!buttonType2.equals(ButtonType.HAM)) {
        } else {
            if (1 > drawables2.length || drawables2.length > 4 || ((strings2 != null && (1 > strings2.length || strings2.length > 4)) || 1 > colors2.length || colors2.length > 4)) {
                throw new RuntimeException("The ham type button's length must be in [1, 4]!");
            }
        }
    }

    private void placeDots() {
        this.frameLayout.removeAllViews();
        LayoutParams[] ps = PlaceParamsFactory.getDotParams(this.placeType, this.frameLayout.getWidth(), this.frameLayout.getHeight(), this.dotWidth, this.dotHeight);
        PlaceType placeType2 = this.placeType;
        if (PlaceType.SHARE_3_1.v <= this.placeType.v && this.placeType.v <= PlaceType.SHARE_9_2.v) {
            this.shareLines = new ShareLines(this.mContext);
            float[][] locations = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 2});
            locations[0][0] = (float) (ps[0].leftMargin + (this.dotWidth / 2));
            locations[0][1] = (float) (ps[0].topMargin + (this.dotHeight / 2));
            locations[1][0] = (float) (ps[1].leftMargin + (this.dotWidth / 2));
            locations[1][1] = (float) (ps[1].topMargin + (this.dotHeight / 2));
            locations[2][0] = (float) (ps[2].leftMargin + (this.dotWidth / 2));
            locations[2][1] = (float) (ps[2].topMargin + (this.dotHeight / 2));
            this.shareLines.setLocations(locations);
            this.shareLines.setOffset(1.0f);
            this.frameLayout.addView(this.shareLines, new LayoutParams(this.frameLayout.getWidth(), this.frameLayout.getHeight()));
        }
        for (int i = 0; i < this.buttonNum; i++) {
            this.frameLayout.addView(this.dots[i], ps[i]);
        }
    }

    private void placeBars() {
        this.frameLayout.removeAllViews();
        LayoutParams[] ps = PlaceParamsFactory.getBarParams(this.placeType, this.frameLayout.getWidth(), this.frameLayout.getHeight(), this.barWidth, this.barHeight);
        for (int i = 0; i < ps.length; i++) {
            this.frameLayout.addView(this.bars[i], ps[i]);
        }
    }

    /* access modifiers changed from: private */
    public void shoot() {
        if (!this.isInList) {
        }
        if (this.buttonType.equals(ButtonType.CIRCLE)) {
            for (int i = 0; i < this.buttonNum; i++) {
                this.circleButtons[i] = new CircleButton(this.mContext);
                this.circleButtons[i].setOnCircleButtonClickListener(this, i);
                this.circleButtons[i].setDrawable(this.drawables[i]);
                if (this.strings != null) {
                    this.circleButtons[i].setText(this.strings[i]);
                }
                this.circleButtons[i].setColor(this.colors[i][0], this.colors[i][1]);
                this.circleButtons[i].setShadowDx(this.subButtonsXOffsetOfShadow);
                this.circleButtons[i].setShadowDy(this.subButtonsYOffsetOfShadow);
            }
        } else if (this.buttonType.equals(ButtonType.HAM)) {
            for (int i2 = 0; i2 < this.buttonNum; i2++) {
                this.hamButtons[i2] = new HamButton(this.mContext);
                this.hamButtons[i2].setOnHamButtonClickListener(this, i2);
                this.hamButtons[i2].setDrawable(this.drawables[i2]);
                if (this.strings != null) {
                    this.hamButtons[i2].setText(this.strings[i2]);
                }
                this.hamButtons[i2].setColor(this.colors[i2][0], this.colors[i2][1]);
                this.hamButtons[i2].setShadowDx(this.subButtonsXOffsetOfShadow);
                this.hamButtons[i2].setShadowDy(this.subButtonsYOffsetOfShadow);
            }
        }
        setRipple(this.clickEffectType);
        if (this.onClickListener != null) {
            this.onClickListener.onClick();
        }
        if (!this.animationPlaying) {
            this.animationPlaying = true;
            dimAnimationLayout();
            startShowAnimations();
        }
    }

    private void dimAnimationLayout() {
        if (this.animationLayout == null) {
            this.animationLayout = createAnimationLayout();
            this.animationLayout.setOnClickListener(new android.view.View.OnClickListener() {
                public void onClick(View v) {
                    if (!BoomMenuButton.this.animationPlaying && BoomMenuButton.this.cancelable) {
                        BoomMenuButton.this.startHideAnimations();
                    }
                }
            });
        }
        this.animationLayout.setVisibility(0);
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(this.animationLayout, "backgroundColor", new int[]{DimType.DIM_0.value, this.dimType.value}).setDuration((long) (this.duration + (this.delay * (this.buttonNum - 1))));
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                if (BoomMenuButton.this.animatorListener != null) {
                    BoomMenuButton.this.animatorListener.toShow();
                }
                BoomMenuButton.this.state = StateType.OPENING;
            }

            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (BoomMenuButton.this.animatorListener != null) {
                    BoomMenuButton.this.animatorListener.showed();
                }
                BoomMenuButton.this.state = StateType.OPEN;
            }
        });
        objectAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                if (BoomMenuButton.this.animatorListener != null) {
                    BoomMenuButton.this.animatorListener.showing(animation.getAnimatedFraction());
                }
            }
        });
        objectAnimator.start();
        PlaceType placeType2 = this.placeType;
        if (PlaceType.SHARE_3_1.v <= this.placeType.v && this.placeType.v <= PlaceType.SHARE_9_2.v) {
            ObjectAnimator shareLinesAnimator = ObjectAnimator.ofFloat(this.shareLines, "offset", new float[]{1.0f, 0.0f}).setDuration((long) (this.duration + (this.delay * (this.buttonNum - 1))));
            shareLinesAnimator.setStartDelay(0);
            shareLinesAnimator.start();
        }
    }

    private void startShowAnimations() {
        if (this.animationLayout != null) {
            this.animationLayout.removeAllViews();
        }
        if (this.buttonType.equals(ButtonType.CIRCLE)) {
            getEndLocations();
            if (this.showOrderType.equals(OrderType.DEFAULT)) {
                for (int i = 0; i < this.buttonNum; i++) {
                    this.dots[i].getLocationOnScreen(this.startLocations[i]);
                    int[] iArr = this.startLocations[i];
                    iArr[0] = iArr[0] - ((this.buttonWidth - this.dots[i].getWidth()) / 2);
                    int[] iArr2 = this.startLocations[i];
                    iArr2[1] = iArr2[1] - ((this.buttonWidth - this.dots[i].getHeight()) / 2);
                    setShowAnimation(this.dots[i], this.circleButtons[i], this.startLocations[i], this.endLocations[i], i);
                }
            } else if (this.showOrderType.equals(OrderType.REVERSE)) {
                for (int i2 = 0; i2 < this.buttonNum; i2++) {
                    this.dots[i2].getLocationOnScreen(this.startLocations[i2]);
                    int[] iArr3 = this.startLocations[i2];
                    iArr3[0] = iArr3[0] - ((this.buttonWidth - this.dots[i2].getWidth()) / 2);
                    int[] iArr4 = this.startLocations[i2];
                    iArr4[1] = iArr4[1] - ((this.buttonWidth - this.dots[i2].getHeight()) / 2);
                    setShowAnimation(this.dots[i2], this.circleButtons[i2], this.startLocations[i2], this.endLocations[i2], (this.buttonNum - i2) - 1);
                }
            } else if (this.showOrderType.equals(OrderType.RANDOM)) {
                Random random = new Random();
                boolean[] used = new boolean[this.buttonNum];
                for (int i3 = 0; i3 < this.buttonNum; i3++) {
                    used[i3] = false;
                }
                int count = 0;
                while (true) {
                    int i4 = random.nextInt(this.buttonNum);
                    if (!used[i4]) {
                        used[i4] = true;
                        this.dots[count].getLocationOnScreen(this.startLocations[count]);
                        int[] iArr5 = this.startLocations[count];
                        iArr5[0] = iArr5[0] - ((this.buttonWidth - this.dots[count].getWidth()) / 2);
                        int[] iArr6 = this.startLocations[count];
                        iArr6[1] = iArr6[1] - ((this.buttonWidth - this.dots[count].getHeight()) / 2);
                        setShowAnimation(this.dots[count], this.circleButtons[count], this.startLocations[count], this.endLocations[count], i4);
                        count++;
                        if (count == this.buttonNum) {
                            return;
                        }
                    }
                }
            }
        } else if (this.buttonType.equals(ButtonType.HAM)) {
            getEndLocations();
            if (this.showOrderType.equals(OrderType.DEFAULT)) {
                for (int i5 = 0; i5 < this.buttonNum; i5++) {
                    this.bars[i5].getLocationOnScreen(this.startLocations[i5]);
                    int[] iArr7 = this.startLocations[i5];
                    iArr7[0] = iArr7[0] - ((this.hamButtonWidth - this.bars[i5].getWidth()) / 2);
                    int[] iArr8 = this.startLocations[i5];
                    iArr8[1] = iArr8[1] - ((this.hamButtonHeight - this.bars[i5].getHeight()) / 2);
                    setShowAnimation(this.bars[i5], this.hamButtons[i5], this.startLocations[i5], this.endLocations[i5], i5);
                }
            } else if (this.showOrderType.equals(OrderType.REVERSE)) {
                for (int i6 = 0; i6 < this.buttonNum; i6++) {
                    this.bars[i6].getLocationOnScreen(this.startLocations[i6]);
                    int[] iArr9 = this.startLocations[i6];
                    iArr9[0] = iArr9[0] - ((this.hamButtonWidth - this.bars[i6].getWidth()) / 2);
                    int[] iArr10 = this.startLocations[i6];
                    iArr10[1] = iArr10[1] - ((this.hamButtonHeight - this.bars[i6].getHeight()) / 2);
                    setShowAnimation(this.bars[i6], this.hamButtons[i6], this.startLocations[i6], this.endLocations[i6], (this.buttonNum - i6) - 1);
                }
            } else if (this.showOrderType.equals(OrderType.RANDOM)) {
                Random random2 = new Random();
                boolean[] used2 = new boolean[this.buttonNum];
                for (int i7 = 0; i7 < this.buttonNum; i7++) {
                    used2[i7] = false;
                }
                int count2 = 0;
                while (true) {
                    int i8 = random2.nextInt(this.buttonNum);
                    if (!used2[i8]) {
                        used2[i8] = true;
                        this.bars[count2].getLocationOnScreen(this.startLocations[count2]);
                        int[] iArr11 = this.startLocations[count2];
                        iArr11[0] = iArr11[0] - ((this.hamButtonWidth - this.bars[count2].getWidth()) / 2);
                        int[] iArr12 = this.startLocations[count2];
                        iArr12[1] = iArr12[1] - ((this.hamButtonHeight - this.bars[count2].getHeight()) / 2);
                        setShowAnimation(this.bars[count2], this.hamButtons[count2], this.startLocations[count2], this.endLocations[count2], i8);
                        count2++;
                        if (count2 == this.buttonNum) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private void getEndLocations() {
        int width = Util.getInstance().getScreenWidth(this.mContext);
        int height = Util.getInstance().getScreenHeight(this.mContext);
        if (this.buttonType.equals(ButtonType.CIRCLE)) {
            this.endLocations = EndLocationsFactory.getEndLocations(this.placeType, width, height, this.buttonWidth, this.buttonWidth);
        } else if (this.buttonType.equals(ButtonType.HAM)) {
            this.endLocations = EndLocationsFactory.getEndLocations(this.placeType, width, height, this.hamButtonWidth, this.hamButtonHeight);
        }
    }

    private ViewGroup createAnimationLayout() {
        ViewGroup rootView = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
        LinearLayout animLayout = new LinearLayout(this.mContext);
        animLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        animLayout.setBackgroundResource(17170445);
        rootView.addView(animLayout);
        return animLayout;
    }

    private View setViewLocationInAnimationLayout(View view, int[] location) {
        int x = location[0];
        int y = location[1];
        LinearLayout.LayoutParams lp = null;
        if (this.buttonType.equals(ButtonType.CIRCLE)) {
            lp = new LinearLayout.LayoutParams(this.buttonWidth, this.buttonWidth);
        } else if (this.buttonType.equals(ButtonType.HAM)) {
            lp = new LinearLayout.LayoutParams(this.hamButtonWidth, this.hamButtonHeight);
        }
        lp.leftMargin = x;
        lp.topMargin = y;
        this.animationLayout.addView(view, lp);
        return view;
    }

    public void setShowAnimation(View dot, View button, int[] startLocation, int[] endLocation, int index) {
        button.bringToFront();
        View view = setViewLocationInAnimationLayout(button, startLocation);
        float[] xs = new float[(this.frames + 1)];
        float[] ys = new float[(this.frames + 1)];
        getShowXY(new float[]{((float) startLocation[0]) * 1.0f, ((float) startLocation[1]) * 1.0f}, new float[]{((float) endLocation[0]) * 1.0f, ((float) endLocation[1]) * 1.0f}, xs, ys);
        if (view != null) {
            ObjectAnimator xAnimator = ObjectAnimator.ofFloat(view, "x", xs).setDuration((long) this.duration);
            xAnimator.setStartDelay((long) (this.delay * index));
            xAnimator.setInterpolator(InterpolatorFactory.getInterpolator(this.showMoveEaseType));
            xAnimator.start();
            ObjectAnimator yAnimator = ObjectAnimator.ofFloat(view, "y", ys).setDuration((long) this.duration);
            yAnimator.setStartDelay((long) (this.delay * index));
            yAnimator.setInterpolator(InterpolatorFactory.getInterpolator(this.showMoveEaseType));
            yAnimator.start();
        }
        float scaleW = 0.0f;
        float scaleH = 0.0f;
        if (this.buttonType.equals(ButtonType.CIRCLE)) {
            scaleW = (((float) this.dotWidth) * 1.0f) / ((float) this.buttonWidth);
            scaleH = (((float) this.dotWidth) * 1.0f) / ((float) this.buttonWidth);
        } else if (this.buttonType.equals(ButtonType.HAM)) {
            scaleW = (((float) this.barWidth) * 1.0f) / ((float) this.hamButtonWidth);
            scaleH = (((float) this.barHeight) * 1.0f) / ((float) this.hamButtonHeight);
        }
        if (view != null) {
            view.setScaleX(scaleW);
            ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(view, "scaleX", new float[]{scaleW, 1.0f}).setDuration((long) this.duration);
            scaleXAnimator.setStartDelay((long) (this.delay * index));
            scaleXAnimator.setInterpolator(InterpolatorFactory.getInterpolator(this.showScaleEaseType));
            scaleXAnimator.start();
            view.setScaleY(scaleH);
            ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(view, "scaleY", new float[]{scaleH, 1.0f}).setDuration((long) this.duration);
            scaleYAnimator.setStartDelay((long) (this.delay * index));
            scaleYAnimator.setInterpolator(InterpolatorFactory.getInterpolator(this.showScaleEaseType));
            final View view2 = dot;
            AnonymousClass5 r0 = new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    view2.setVisibility(4);
                }

                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    BoomMenuButton.this.animationPlaying = false;
                }
            };
            scaleYAnimator.addListener(r0);
            scaleYAnimator.start();
        }
        View view1 = null;
        View view22 = null;
        if (button != null && (button instanceof CircleButton)) {
            view1 = ((CircleButton) button).getImageView();
            view22 = ((CircleButton) button).getTextView();
        } else if (button != null && (button instanceof HamButton)) {
            view1 = ((HamButton) button).getImageView();
            view22 = ((HamButton) button).getTextView();
        }
        if (view1 != null) {
            ObjectAnimator alphaAnimator1 = ObjectAnimator.ofFloat(view1, "alpha", new float[]{0.0f, 1.0f}).setDuration((long) this.duration);
            alphaAnimator1.setStartDelay((long) (this.delay * index));
            alphaAnimator1.setInterpolator(InterpolatorFactory.getInterpolator(this.showMoveEaseType));
            alphaAnimator1.start();
        }
        if (view22 != null) {
            ObjectAnimator alphaAnimator2 = ObjectAnimator.ofFloat(view22, "alpha", new float[]{0.0f, 1.0f}).setDuration((long) this.duration);
            alphaAnimator2.setStartDelay((long) (this.delay * index));
            alphaAnimator2.setInterpolator(InterpolatorFactory.getInterpolator(this.showMoveEaseType));
            alphaAnimator2.start();
        }
        if (view != null && (view instanceof CircleButton)) {
            ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(((CircleButton) view).getFrameLayout(), "rotation", new float[]{0.0f, (float) this.rotateDegree}).setDuration((long) this.duration);
            rotateAnimator.setStartDelay((long) (this.delay * index));
            rotateAnimator.setInterpolator(InterpolatorFactory.getInterpolator(this.showRotateEaseType));
            rotateAnimator.start();
        }
    }

    private void getShowXY(float[] startPoint, float[] endPoint, float[] xs, float[] ys) {
        if (this.boomType.equals(BoomType.LINE)) {
            float x1 = startPoint[0];
            float y1 = startPoint[1];
            float k = (endPoint[1] - y1) / (endPoint[0] - x1);
            float b = y1 - (x1 * k);
            float per = 1.0f / ((float) this.frames);
            float xx = endPoint[0] - startPoint[0];
            for (int i = 0; i <= this.frames; i++) {
                xs[i] = startPoint[0] + (((float) i) * per * xx);
                ys[i] = (xs[i] * k) + b;
            }
        } else if (this.boomType.equals(BoomType.PARABOLA)) {
            float x12 = startPoint[0];
            float y12 = startPoint[1];
            float x2 = endPoint[0];
            float y2 = endPoint[1];
            float x3 = (startPoint[0] + endPoint[0]) / 2.0f;
            float a = ((((x2 - x3) * y12) + ((x3 - x12) * y2)) + ((x12 - x2) * (Math.min(startPoint[1], endPoint[1]) / 2.0f))) / ((((x12 * x12) * (x2 - x3)) + ((x2 * x2) * (x3 - x12))) + ((x3 * x3) * (x12 - x2)));
            float b2 = ((y12 - y2) / (x12 - x2)) - ((x12 + x2) * a);
            float c = (y12 - ((x12 * x12) * a)) - (x12 * b2);
            float per2 = 1.0f / ((float) this.frames);
            float xx2 = endPoint[0] - startPoint[0];
            for (int i2 = 0; i2 <= this.frames; i2++) {
                xs[i2] = startPoint[0] + (((float) i2) * per2 * xx2);
                ys[i2] = (xs[i2] * a * xs[i2]) + (xs[i2] * b2) + c;
            }
        } else if (this.boomType.equals(BoomType.HORIZONTAL_THROW)) {
            float x13 = startPoint[0];
            float y13 = startPoint[1];
            float x32 = endPoint[0];
            float x22 = (2.0f * x32) - x13;
            float y22 = y13;
            float a2 = ((((x22 - x32) * y13) + ((x32 - x13) * y22)) + ((x13 - x22) * endPoint[1])) / ((((x13 * x13) * (x22 - x32)) + ((x22 * x22) * (x32 - x13))) + ((x32 * x32) * (x13 - x22)));
            float b3 = ((y13 - y22) / (x13 - x22)) - ((x13 + x22) * a2);
            float c2 = (y13 - ((x13 * x13) * a2)) - (x13 * b3);
            float per3 = 1.0f / ((float) this.frames);
            float xx3 = x32 - x13;
            for (int i3 = 0; i3 <= this.frames; i3++) {
                xs[i3] = (((float) i3) * per3 * xx3) + x13;
                ys[i3] = (xs[i3] * a2 * xs[i3]) + (xs[i3] * b3) + c2;
            }
        } else if (this.boomType.equals(BoomType.PARABOLA_2)) {
            float x14 = startPoint[0];
            float y14 = startPoint[1];
            float x23 = endPoint[0];
            float y23 = endPoint[1];
            float x33 = (startPoint[0] + endPoint[0]) / 2.0f;
            float a3 = ((((x23 - x33) * y14) + ((x33 - x14) * y23)) + ((x14 - x23) * (((((float) Util.getInstance().getScreenHeight(this.mContext)) - Math.max(startPoint[1], endPoint[1])) / 2.0f) + Math.max(startPoint[1], endPoint[1])))) / ((((x14 * x14) * (x23 - x33)) + ((x23 * x23) * (x33 - x14))) + ((x33 * x33) * (x14 - x23)));
            float b4 = ((y14 - y23) / (x14 - x23)) - ((x14 + x23) * a3);
            float c3 = (y14 - ((x14 * x14) * a3)) - (x14 * b4);
            float per4 = 1.0f / ((float) this.frames);
            float xx4 = x23 - x14;
            for (int i4 = 0; i4 <= this.frames; i4++) {
                xs[i4] = (((float) i4) * per4 * xx4) + x14;
                ys[i4] = (xs[i4] * a3 * xs[i4]) + (xs[i4] * b4) + c3;
            }
        } else if (this.boomType.equals(BoomType.HORIZONTAL_THROW_2)) {
            float x15 = endPoint[0];
            float y15 = endPoint[1];
            float x34 = startPoint[0];
            float x24 = (2.0f * x34) - x15;
            float y24 = y15;
            float a4 = ((((x24 - x34) * y15) + ((x34 - x15) * y24)) + ((x15 - x24) * startPoint[1])) / ((((x15 * x15) * (x24 - x34)) + ((x24 * x24) * (x34 - x15))) + ((x34 * x34) * (x15 - x24)));
            float b5 = ((y15 - y24) / (x15 - x24)) - ((x15 + x24) * a4);
            float c4 = (y15 - ((x15 * x15) * a4)) - (x15 * b5);
            float per5 = 1.0f / ((float) this.frames);
            float xx5 = endPoint[0] - startPoint[0];
            for (int i5 = 0; i5 <= this.frames; i5++) {
                xs[i5] = startPoint[0] + (((float) i5) * per5 * xx5);
                ys[i5] = (xs[i5] * a4 * xs[i5]) + (xs[i5] * b5) + c4;
            }
        }
    }

    private void getHideXY(float[] startPoint, float[] endPoint, float[] xs, float[] ys) {
        if (this.boomType.equals(BoomType.LINE)) {
            float x1 = startPoint[0];
            float y1 = startPoint[1];
            float k = (endPoint[1] - y1) / (endPoint[0] - x1);
            float b = y1 - (x1 * k);
            float per = 1.0f / ((float) this.frames);
            float xx = endPoint[0] - startPoint[0];
            for (int i = 0; i <= this.frames; i++) {
                xs[i] = startPoint[0] + (((float) i) * per * xx);
                ys[i] = (xs[i] * k) + b;
            }
        } else if (this.boomType.equals(BoomType.PARABOLA)) {
            float x12 = startPoint[0];
            float y12 = startPoint[1];
            float x2 = endPoint[0];
            float y2 = endPoint[1];
            float x3 = (startPoint[0] + endPoint[0]) / 2.0f;
            float a = ((((x2 - x3) * y12) + ((x3 - x12) * y2)) + ((x12 - x2) * (Math.min(startPoint[1], endPoint[1]) / 2.0f))) / ((((x12 * x12) * (x2 - x3)) + ((x2 * x2) * (x3 - x12))) + ((x3 * x3) * (x12 - x2)));
            float b2 = ((y12 - y2) / (x12 - x2)) - ((x12 + x2) * a);
            float c = (y12 - ((x12 * x12) * a)) - (x12 * b2);
            float per2 = 1.0f / ((float) this.frames);
            float xx2 = endPoint[0] - startPoint[0];
            for (int i2 = 0; i2 <= this.frames; i2++) {
                xs[i2] = startPoint[0] + (((float) i2) * per2 * xx2);
                ys[i2] = (xs[i2] * a * xs[i2]) + (xs[i2] * b2) + c;
            }
        } else if (this.boomType.equals(BoomType.HORIZONTAL_THROW)) {
            float x13 = endPoint[0];
            float y13 = endPoint[1];
            float x32 = startPoint[0];
            float x22 = (2.0f * x32) - x13;
            float y22 = y13;
            float a2 = ((((x22 - x32) * y13) + ((x32 - x13) * y22)) + ((x13 - x22) * startPoint[1])) / ((((x13 * x13) * (x22 - x32)) + ((x22 * x22) * (x32 - x13))) + ((x32 * x32) * (x13 - x22)));
            float b3 = ((y13 - y22) / (x13 - x22)) - ((x13 + x22) * a2);
            float c2 = (y13 - ((x13 * x13) * a2)) - (x13 * b3);
            float per3 = 1.0f / ((float) this.frames);
            float xx3 = endPoint[0] - startPoint[0];
            for (int i3 = 0; i3 <= this.frames; i3++) {
                xs[i3] = startPoint[0] + (((float) i3) * per3 * xx3);
                ys[i3] = (xs[i3] * a2 * xs[i3]) + (xs[i3] * b3) + c2;
            }
        } else if (this.boomType.equals(BoomType.PARABOLA_2)) {
            float x14 = startPoint[0];
            float y14 = startPoint[1];
            float x23 = endPoint[0];
            float y23 = endPoint[1];
            float x33 = (startPoint[0] + endPoint[0]) / 2.0f;
            float a3 = ((((x23 - x33) * y14) + ((x33 - x14) * y23)) + ((x14 - x23) * (((((float) Util.getInstance().getScreenHeight(this.mContext)) - Math.max(startPoint[1], endPoint[1])) / 2.0f) + Math.max(startPoint[1], endPoint[1])))) / ((((x14 * x14) * (x23 - x33)) + ((x23 * x23) * (x33 - x14))) + ((x33 * x33) * (x14 - x23)));
            float b4 = ((y14 - y23) / (x14 - x23)) - ((x14 + x23) * a3);
            float c3 = (y14 - ((x14 * x14) * a3)) - (x14 * b4);
            float per4 = 1.0f / ((float) this.frames);
            float xx4 = x23 - x14;
            for (int i4 = 0; i4 <= this.frames; i4++) {
                xs[i4] = (((float) i4) * per4 * xx4) + x14;
                ys[i4] = (xs[i4] * a3 * xs[i4]) + (xs[i4] * b4) + c3;
            }
        } else if (this.boomType.equals(BoomType.HORIZONTAL_THROW_2)) {
            float x15 = startPoint[0];
            float y15 = startPoint[1];
            float x34 = endPoint[0];
            float x24 = (2.0f * x34) - x15;
            float y24 = y15;
            float a4 = ((((x24 - x34) * y15) + ((x34 - x15) * y24)) + ((x15 - x24) * endPoint[1])) / ((((x15 * x15) * (x24 - x34)) + ((x24 * x24) * (x34 - x15))) + ((x34 * x34) * (x15 - x24)));
            float b5 = ((y15 - y24) / (x15 - x24)) - ((x15 + x24) * a4);
            float c4 = (y15 - ((x15 * x15) * a4)) - (x15 * b5);
            float per5 = 1.0f / ((float) this.frames);
            float xx5 = endPoint[0] - startPoint[0];
            for (int i5 = 0; i5 <= this.frames; i5++) {
                xs[i5] = startPoint[0] + (((float) i5) * per5 * xx5);
                ys[i5] = (xs[i5] * a4 * xs[i5]) + (xs[i5] * b5) + c4;
            }
        }
    }

    /* access modifiers changed from: private */
    public void startHideAnimations() {
        this.animationPlaying = true;
        lightAnimationLayout();
        if (this.buttonType.equals(ButtonType.CIRCLE)) {
            if (this.hideOrderType.equals(OrderType.DEFAULT)) {
                for (int i = 0; i < this.buttonNum; i++) {
                    setHideAnimation(this.dots[i], this.circleButtons[i], this.endLocations[i], this.startLocations[i], i);
                }
            } else if (this.hideOrderType.equals(OrderType.REVERSE)) {
                for (int i2 = 0; i2 < this.buttonNum; i2++) {
                    setHideAnimation(this.dots[i2], this.circleButtons[i2], this.endLocations[i2], this.startLocations[i2], (this.buttonNum - i2) - 1);
                }
            } else if (this.hideOrderType.equals(OrderType.RANDOM)) {
                Random random = new Random();
                boolean[] used = new boolean[this.buttonNum];
                for (int i3 = 0; i3 < this.buttonNum; i3++) {
                    used[i3] = false;
                }
                int count = 0;
                while (true) {
                    int i4 = random.nextInt(this.buttonNum);
                    if (!used[i4]) {
                        used[i4] = true;
                        setHideAnimation(this.dots[count], this.circleButtons[count], this.endLocations[count], this.startLocations[count], i4);
                        count++;
                        if (count == this.buttonNum) {
                            return;
                        }
                    }
                }
            }
        } else if (!this.buttonType.equals(ButtonType.HAM)) {
        } else {
            if (this.hideOrderType.equals(OrderType.DEFAULT)) {
                for (int i5 = 0; i5 < this.buttonNum; i5++) {
                    setHideAnimation(this.bars[i5], this.hamButtons[i5], this.endLocations[i5], this.startLocations[i5], i5);
                }
            } else if (this.hideOrderType.equals(OrderType.REVERSE)) {
                for (int i6 = 0; i6 < this.buttonNum; i6++) {
                    setHideAnimation(this.bars[i6], this.hamButtons[i6], this.endLocations[i6], this.startLocations[i6], (this.buttonNum - i6) - 1);
                }
            } else if (this.hideOrderType.equals(OrderType.RANDOM)) {
                Random random2 = new Random();
                boolean[] used2 = new boolean[this.buttonNum];
                for (int i7 = 0; i7 < this.buttonNum; i7++) {
                    used2[i7] = false;
                }
                int count2 = 0;
                while (true) {
                    int i8 = random2.nextInt(this.buttonNum);
                    if (!used2[i8]) {
                        used2[i8] = true;
                        setHideAnimation(this.bars[count2], this.hamButtons[count2], this.endLocations[count2], this.startLocations[count2], i8);
                        count2++;
                        if (count2 == this.buttonNum) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public void setHideAnimation(View dot, View button, int[] startLocation, int[] endLocation, int index) {
        float[] xs = new float[(this.frames + 1)];
        float[] ys = new float[(this.frames + 1)];
        getHideXY(new float[]{((float) startLocation[0]) * 1.0f, ((float) startLocation[1]) * 1.0f}, new float[]{((float) endLocation[0]) * 1.0f, ((float) endLocation[1]) * 1.0f}, xs, ys);
        if (button != null) {
            ObjectAnimator xAnimator = ObjectAnimator.ofFloat(button, "x", xs).setDuration((long) this.duration);
            xAnimator.setStartDelay((long) (this.delay * index));
            xAnimator.setInterpolator(InterpolatorFactory.getInterpolator(this.hideMoveEaseType));
            xAnimator.start();
            ObjectAnimator yAnimator = ObjectAnimator.ofFloat(button, "y", ys).setDuration((long) this.duration);
            yAnimator.setStartDelay((long) (this.delay * index));
            yAnimator.setInterpolator(InterpolatorFactory.getInterpolator(this.hideMoveEaseType));
            yAnimator.start();
        }
        float scaleW = 0.0f;
        float scaleH = 0.0f;
        if (this.buttonType.equals(ButtonType.CIRCLE)) {
            scaleW = (((float) this.dotWidth) * 1.0f) / ((float) this.buttonWidth);
            scaleH = (((float) this.dotWidth) * 1.0f) / ((float) this.buttonWidth);
        } else if (this.buttonType.equals(ButtonType.HAM)) {
            scaleW = (((float) this.barWidth) * 1.0f) / ((float) this.hamButtonWidth);
            scaleH = (((float) this.barHeight) * 1.0f) / ((float) this.hamButtonHeight);
        }
        if (button != null) {
            ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(button, "scaleX", new float[]{1.0f, scaleW}).setDuration((long) this.duration);
            scaleXAnimator.setStartDelay((long) (this.delay * index));
            scaleXAnimator.setInterpolator(InterpolatorFactory.getInterpolator(this.hideScaleEaseType));
            scaleXAnimator.start();
            ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(button, "scaleY", new float[]{1.0f, scaleH}).setDuration((long) this.duration);
            scaleYAnimator.setStartDelay((long) (this.delay * index));
            scaleYAnimator.setInterpolator(InterpolatorFactory.getInterpolator(this.hideScaleEaseType));
            final View view = dot;
            final int i = index;
            AnonymousClass6 r0 = new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.setVisibility(0);
                    if (!BoomMenuButton.this.isInList) {
                    }
                    if (BoomMenuButton.this.buttonType.equals(ButtonType.CIRCLE)) {
                        BoomMenuButton.this.circleButtons[i] = null;
                    } else if (BoomMenuButton.this.buttonType.equals(ButtonType.HAM)) {
                        BoomMenuButton.this.hamButtons[i] = null;
                    }
                }
            };
            scaleYAnimator.addListener(r0);
            scaleYAnimator.start();
        }
        View view1 = null;
        View view2 = null;
        if (button != null && (button instanceof CircleButton)) {
            view1 = ((CircleButton) button).getImageView();
            view2 = ((CircleButton) button).getTextView();
        } else if (button != null && (button instanceof HamButton)) {
            view1 = ((HamButton) button).getImageView();
            view2 = ((HamButton) button).getTextView();
        }
        if (view1 != null) {
            ObjectAnimator alphaAnimator1 = ObjectAnimator.ofFloat(view1, "alpha", new float[]{1.0f, 0.0f}).setDuration((long) this.duration);
            alphaAnimator1.setStartDelay((long) (this.delay * index));
            alphaAnimator1.setInterpolator(InterpolatorFactory.getInterpolator(this.hideMoveEaseType));
            alphaAnimator1.start();
        }
        if (view2 != null) {
            ObjectAnimator alphaAnimator2 = ObjectAnimator.ofFloat(view2, "alpha", new float[]{1.0f, 0.0f}).setDuration((long) this.duration);
            alphaAnimator2.setStartDelay((long) (this.delay * index));
            alphaAnimator2.setInterpolator(InterpolatorFactory.getInterpolator(this.hideMoveEaseType));
            alphaAnimator2.start();
        }
        if (button != null && (button instanceof CircleButton)) {
            ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(((CircleButton) button).getFrameLayout(), "rotation", new float[]{0.0f, (float) (-this.rotateDegree)}).setDuration((long) this.duration);
            rotateAnimator.setStartDelay((long) (this.delay * index));
            rotateAnimator.setInterpolator(InterpolatorFactory.getInterpolator(this.hideRotateEaseType));
            rotateAnimator.start();
        }
    }

    public void lightAnimationLayout() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(this.animationLayout, "backgroundColor", new int[]{this.dimType.value, DimType.DIM_0.value}).setDuration((long) (this.duration + (this.delay * (this.buttonNum - 1))));
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                if (BoomMenuButton.this.animatorListener != null) {
                    BoomMenuButton.this.animatorListener.toHide();
                }
                BoomMenuButton.this.state = StateType.CLOSING;
            }

            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                BoomMenuButton.this.animationLayout.removeAllViews();
                BoomMenuButton.this.animationLayout.setVisibility(8);
                BoomMenuButton.this.animationPlaying = false;
                if (BoomMenuButton.this.animatorListener != null) {
                    BoomMenuButton.this.animatorListener.hided();
                }
                BoomMenuButton.this.state = StateType.CLOSED;
            }
        });
        objectAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                if (BoomMenuButton.this.animatorListener != null) {
                    BoomMenuButton.this.animatorListener.hiding(animation.getAnimatedFraction());
                }
            }
        });
        objectAnimator.start();
        PlaceType placeType2 = this.placeType;
        if (PlaceType.SHARE_3_1.v <= this.placeType.v && this.placeType.v <= PlaceType.SHARE_9_2.v) {
            ObjectAnimator shareLinesAnimator = ObjectAnimator.ofFloat(this.shareLines, "offset", new float[]{0.0f, 1.0f}).setDuration((long) (this.duration + (this.delay * (this.buttonNum - 1))));
            shareLinesAnimator.setStartDelay(0);
            shareLinesAnimator.start();
        }
    }

    public void setAutoDismiss(boolean autoDismiss2) {
        this.autoDismiss = autoDismiss2;
    }

    public void setCancelable(boolean cancelable2) {
        this.cancelable = cancelable2;
    }

    public void setFrames(int frames2) {
        this.frames = frames2;
    }

    public void setDuration(int duration2) {
        this.duration = duration2;
    }

    public void setDelay(int delay2) {
        this.delay = delay2;
    }

    public void setRotateDegree(int rotateDegree2) {
        this.rotateDegree = rotateDegree2;
    }

    public void setShowOrderType(OrderType showOrderType2) {
        this.showOrderType = showOrderType2;
    }

    public void setHideOrderType(OrderType hideOrderType2) {
        this.hideOrderType = hideOrderType2;
    }

    public void setOnClickListener(OnClickListener onClickListener2) {
        this.onClickListener = onClickListener2;
    }

    public void setAnimatorListener(AnimatorListener animatorListener2) {
        this.animatorListener = animatorListener2;
    }

    public ImageButton[] getImageButtons() {
        ImageButton[] imageButtons = new ImageButton[this.buttonNum];
        for (int i = 0; i < this.buttonNum; i++) {
            if (this.circleButtons[i] != null) {
                imageButtons[i] = this.circleButtons[i].getImageButton();
            }
        }
        return imageButtons;
    }

    public ImageView[] getImageViews() {
        ImageView[] imageViews = new ImageView[this.buttonNum];
        if (this.buttonType.equals(ButtonType.CIRCLE)) {
            for (int i = 0; i < this.buttonNum; i++) {
                if (this.circleButtons[i] != null) {
                    imageViews[i] = this.circleButtons[i].getImageView();
                }
            }
        } else if (this.buttonType.equals(ButtonType.HAM)) {
            for (int i2 = 0; i2 < this.buttonNum; i2++) {
                if (this.hamButtons[i2] != null) {
                    imageViews[i2] = this.hamButtons[i2].getImageView();
                }
            }
        }
        return imageViews;
    }

    public TextView[] getTextViews() {
        TextView[] textViews = new TextView[this.buttonNum];
        if (this.buttonType.equals(ButtonType.CIRCLE)) {
            for (int i = 0; i < this.buttonNum; i++) {
                if (this.circleButtons != null) {
                    textViews[i] = this.circleButtons[i].getTextView();
                }
            }
        } else if (this.buttonType.equals(ButtonType.HAM)) {
            for (int i2 = 0; i2 < this.buttonNum; i2++) {
                if (this.hamButtons[i2] != null) {
                    textViews[i2] = this.hamButtons[i2].getTextView();
                }
            }
        }
        return textViews;
    }

    public void setOnSubButtonClickListener(OnSubButtonClickListener onSubButtonClickListener2) {
        this.onSubButtonClickListener = onSubButtonClickListener2;
    }

    public void setBoomButtonBackgroundColor(int pressedColor, int normalColor) {
        Util.getInstance().setCircleButtonStateListDrawable(this.frameLayout, this.boomButtonRadius, pressedColor, normalColor);
    }

    public void setSubButtonShadowOffset(float xOffset, float yOffset) {
        for (int i = 0; i < this.buttonNum; i++) {
            if (this.buttonType.equals(ButtonType.CIRCLE)) {
                if (this.circleButtons[i] != null) {
                    this.circleButtons[i].setShadowDx(xOffset);
                    this.circleButtons[i].setShadowDy(yOffset);
                } else {
                    this.subButtonsXOffsetOfShadow = xOffset;
                    this.subButtonsYOffsetOfShadow = xOffset;
                }
            } else if (this.buttonType.equals(ButtonType.HAM)) {
                if (this.hamButtons[i] != null) {
                    this.hamButtons[i].setShadowDx(xOffset);
                    this.hamButtons[i].setShadowDy(yOffset);
                } else {
                    this.subButtonsXOffsetOfShadow = xOffset;
                    this.subButtonsYOffsetOfShadow = xOffset;
                }
            }
        }
    }

    public void setBoomButtonShadowOffset(float xOffset, float yOffset) {
        if (this.shadowLayout != null) {
            this.shadowLayout.setmDx(xOffset);
            this.shadowLayout.setmDy(yOffset);
        }
    }

    public void setDimType(DimType dimType2) {
        this.dimType = dimType2;
    }

    public void setClickEffectType(ClickEffectType clickEffectType2) {
        setRipple(clickEffectType2);
        if (this.buttonType.equals(ButtonType.CIRCLE)) {
            if (this.circleButtons != null) {
                for (int i = 0; i < this.buttonNum; i++) {
                    if (this.circleButtons[i] != null) {
                        this.circleButtons[i].setRipple(clickEffectType2);
                    }
                }
            }
        } else if (this.buttonType.equals(ButtonType.HAM) && this.hamButtons != null) {
            for (int i2 = 0; i2 < this.buttonNum; i2++) {
                if (this.hamButtons[i2] != null) {
                    this.hamButtons[i2].setRipple(clickEffectType2);
                }
            }
        }
    }

    private void setRipple(ClickEffectType clickEffectType2) {
        this.clickEffectType = clickEffectType2;
        if (VERSION.SDK_INT < 21 || !clickEffectType2.equals(ClickEffectType.RIPPLE) || this.ripple == null) {
            if (this.ripple != null) {
                this.ripple.setVisibility(8);
            }
            this.frameLayout.setOnClickListener(new android.view.View.OnClickListener() {
                public void onClick(View v) {
                    BoomMenuButton.this.shoot();
                }
            });
            return;
        }
        this.ripple.setVisibility(0);
        this.ripple.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View v) {
                BoomMenuButton.this.shoot();
            }
        });
    }

    public void setTextViewColor(int color) {
        if (this.buttonType.equals(ButtonType.CIRCLE)) {
            if (this.circleButtons != null) {
                for (int i = 0; i < this.buttonNum; i++) {
                    if (this.circleButtons[i] != null) {
                        this.circleButtons[i].getTextView().setTextColor(color);
                    }
                }
            }
        } else if (this.buttonType.equals(ButtonType.HAM) && this.hamButtons != null) {
            for (int i2 = 0; i2 < this.buttonNum; i2++) {
                if (this.hamButtons[i2] != null) {
                    this.hamButtons[i2].getTextView().setTextColor(color);
                }
            }
        }
    }

    public void setTextViewColor(int[] colors2) {
        int length = Math.min(this.buttonNum, colors2.length);
        if (this.buttonType.equals(ButtonType.CIRCLE)) {
            if (this.circleButtons != null) {
                for (int i = 0; i < length; i++) {
                    if (this.circleButtons[i] != null) {
                        this.circleButtons[i].getTextView().setTextColor(colors2[i]);
                    }
                }
            }
        } else if (this.buttonType.equals(ButtonType.HAM) && this.hamButtons != null) {
            for (int i2 = 0; i2 < length; i2++) {
                if (this.hamButtons[i2] != null) {
                    this.hamButtons[i2].getTextView().setTextColor(colors2[i2]);
                }
            }
        }
    }

    public void setBoomType(BoomType boomType2) {
        this.boomType = boomType2;
    }

    public boolean isClosed() {
        return this.state.equals(StateType.CLOSED);
    }

    public boolean isClosing() {
        return this.state.equals(StateType.CLOSING);
    }

    public boolean isOpen() {
        return this.state.equals(StateType.OPEN);
    }

    public boolean isOpening() {
        return this.state.equals(StateType.OPENING);
    }

    public void setShowMoveEaseType(EaseType showMoveEaseType2) {
        this.showMoveEaseType = showMoveEaseType2;
    }

    public void setShowScaleEaseType(EaseType showScaleEaseType2) {
        this.showScaleEaseType = showScaleEaseType2;
    }

    public void setShowRotateEaseType(EaseType showRotateEaseType2) {
        this.showRotateEaseType = showRotateEaseType2;
    }

    public void setHideMoveEaseType(EaseType hideMoveEaseType2) {
        this.hideMoveEaseType = hideMoveEaseType2;
    }

    public void setHideScaleEaseType(EaseType hideScaleEaseType2) {
        this.hideScaleEaseType = hideScaleEaseType2;
    }

    public void setHideRotateEaseType(EaseType hideRotateEaseType2) {
        this.hideRotateEaseType = hideRotateEaseType2;
    }

    public void onClick(int index) {
        if (this.state.equals(StateType.OPEN)) {
            if (this.onSubButtonClickListener != null) {
                this.onSubButtonClickListener.onClick(index);
            }
            if (this.autoDismiss && !this.animationPlaying) {
                startHideAnimations();
            }
        }
    }

    public boolean dismiss() {
        if (this.state != StateType.OPEN) {
            return false;
        }
        startHideAnimations();
        return true;
    }

    public boolean boom() {
        if (this.state != StateType.CLOSED) {
            return false;
        }
        shoot();
        return true;
    }

    public void setShareLineWidth(float width) {
        if (this.shareLines != null) {
            this.shareLines.setLineWidth(width);
        }
    }

    public void setShareLine1Color(int color) {
        if (this.shareLines != null) {
            this.shareLines.setLine1Color(color);
        }
    }

    public void setShareLine2Color(int color) {
        if (this.shareLines != null) {
            this.shareLines.setLine2Color(color);
        }
    }
}
