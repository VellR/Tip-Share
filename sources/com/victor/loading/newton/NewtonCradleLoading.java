package com.victor.loading.newton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.victor.loading.R;

public class NewtonCradleLoading extends LinearLayout {
    private static final int DEGREE = 30;
    private static final int DURATION = 400;
    private static final float PIVOT_X = 0.5f;
    private static final float PIVOT_Y = -3.0f;
    private static final int SHAKE_DISTANCE = 2;
    /* access modifiers changed from: private */
    public CradleBall cradleBallFive;
    /* access modifiers changed from: private */
    public CradleBall cradleBallFour;
    private CradleBall cradleBallOne;
    /* access modifiers changed from: private */
    public CradleBall cradleBallThree;
    /* access modifiers changed from: private */
    public CradleBall cradleBallTwo;
    /* access modifiers changed from: private */
    public boolean isStart = false;
    RotateAnimation rotateLeftAnimation;
    RotateAnimation rotateRightAnimation;
    TranslateAnimation shakeLeftAnimation;
    TranslateAnimation shakeRightAnimation;

    public NewtonCradleLoading(Context context) {
        super(context);
        initView(context);
    }

    public NewtonCradleLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public NewtonCradleLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.newton_cradle_loading, this, true);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.cradleBallOne = (CradleBall) findViewById(R.id.ball_one);
        this.cradleBallTwo = (CradleBall) findViewById(R.id.ball_two);
        this.cradleBallThree = (CradleBall) findViewById(R.id.ball_three);
        this.cradleBallFour = (CradleBall) findViewById(R.id.ball_four);
        this.cradleBallFive = (CradleBall) findViewById(R.id.ball_five);
        initAnim();
    }

    private void initAnim() {
        this.rotateRightAnimation = new RotateAnimation(0.0f, -30.0f, 1, PIVOT_X, 1, PIVOT_Y);
        this.rotateRightAnimation.setRepeatCount(1);
        this.rotateRightAnimation.setRepeatMode(2);
        this.rotateRightAnimation.setDuration(400);
        this.rotateRightAnimation.setInterpolator(new LinearInterpolator());
        this.rotateRightAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (NewtonCradleLoading.this.isStart) {
                    NewtonCradleLoading.this.startRightAnim();
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.shakeLeftAnimation = new TranslateAnimation(0.0f, 2.0f, 0.0f, 0.0f);
        this.shakeLeftAnimation.setDuration(400);
        this.shakeLeftAnimation.setInterpolator(new CycleInterpolator(2.0f));
        this.rotateLeftAnimation = new RotateAnimation(0.0f, 30.0f, 1, PIVOT_X, 1, PIVOT_Y);
        this.rotateLeftAnimation.setRepeatCount(1);
        this.rotateLeftAnimation.setRepeatMode(2);
        this.rotateLeftAnimation.setDuration(400);
        this.rotateLeftAnimation.setInterpolator(new LinearInterpolator());
        this.rotateLeftAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (NewtonCradleLoading.this.isStart) {
                    NewtonCradleLoading.this.cradleBallTwo.startAnimation(NewtonCradleLoading.this.shakeLeftAnimation);
                    NewtonCradleLoading.this.cradleBallThree.startAnimation(NewtonCradleLoading.this.shakeLeftAnimation);
                    NewtonCradleLoading.this.cradleBallFour.startAnimation(NewtonCradleLoading.this.shakeLeftAnimation);
                    NewtonCradleLoading.this.cradleBallFive.startAnimation(NewtonCradleLoading.this.rotateRightAnimation);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.shakeRightAnimation = new TranslateAnimation(0.0f, -2.0f, 0.0f, 0.0f);
        this.shakeRightAnimation.setDuration(400);
        this.shakeRightAnimation.setInterpolator(new CycleInterpolator(2.0f));
        this.shakeRightAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {
                if (NewtonCradleLoading.this.isStart) {
                    NewtonCradleLoading.this.startLeftAnim();
                }
            }

            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void startLeftAnim() {
        this.cradleBallOne.startAnimation(this.rotateLeftAnimation);
    }

    /* access modifiers changed from: private */
    public void startRightAnim() {
        this.cradleBallTwo.startAnimation(this.shakeRightAnimation);
        this.cradleBallThree.startAnimation(this.shakeRightAnimation);
        this.cradleBallFour.startAnimation(this.shakeRightAnimation);
    }

    public void start() {
        if (!this.isStart) {
            this.isStart = true;
            startLeftAnim();
        }
    }

    public void stop() {
        this.isStart = false;
        this.cradleBallOne.clearAnimation();
        this.cradleBallTwo.clearAnimation();
        this.cradleBallThree.clearAnimation();
        this.cradleBallFour.clearAnimation();
        this.cradleBallFive.clearAnimation();
    }

    public boolean isStart() {
        return this.isStart;
    }

    public void setLoadingColor(int color) {
        this.cradleBallOne.setLoadingColor(color);
        this.cradleBallTwo.setLoadingColor(color);
        this.cradleBallThree.setLoadingColor(color);
        this.cradleBallFour.setLoadingColor(color);
        this.cradleBallFive.setLoadingColor(color);
    }
}
