package com.victor.loading.book;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.victor.loading.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class BookLoading extends FrameLayout {
    private static final int DELAYED = 200;
    private static final long DURATION = 1000;
    private static final int PAGE_NUM = 5;
    private BookHandler bookHandler;
    private boolean isStart;
    private ArrayList<PageView> pageViews;

    static class BookHandler extends Handler {
        private WeakReference<BookLoading> weakReference;

        public BookHandler(BookLoading bookLoading) {
            this.weakReference = new WeakReference<>(bookLoading);
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            BookLoading bookLoading = (BookLoading) this.weakReference.get();
            if (bookLoading != null) {
                bookLoading.playAnim();
                sendMessageDelayed(obtainMessage(), 5000);
            }
        }
    }

    public BookLoading(Context context) {
        super(context);
        initView(context);
    }

    public BookLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BookLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.book_loading, this, true);
        this.pageViews = new ArrayList<>();
        this.bookHandler = new BookHandler(this);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        addPage();
    }

    private void addPage() {
        LayoutParams params = new LayoutParams(-1, -1);
        for (int i = 0; i < 5; i++) {
            PageView pageView = new PageView(getContext());
            addView(pageView, params);
            pageView.setTag(R.string.app_name, Integer.valueOf(i));
            this.pageViews.add(pageView);
        }
    }

    /* access modifiers changed from: private */
    public void playAnim() {
        setAnim((View) this.pageViews.get(4), 200);
        setAnim((View) this.pageViews.get(4), 1200);
        setAnim((View) this.pageViews.get(3), 1400);
        for (int i = 4; i >= 0; i--) {
            setAnim((View) this.pageViews.get(i), 3000 + ((long) (((4 - i) * 200) / 2)));
        }
    }

    private void setAnim(final View view, long delay) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotationY", new float[]{0.0f, -180.0f});
        animator.setDuration(DURATION);
        animator.setStartDelay(delay);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new AnimatorUpdateListener() {
            boolean change = false;

            public void onAnimationUpdate(ValueAnimator animation) {
                if (animation.getCurrentPlayTime() > 500 && !this.change) {
                    this.change = true;
                    view.bringToFront();
                }
            }
        });
        animator.addListener(new AnimatorListener() {
            public void onAnimationStart(Animator animation) {
                if (((Integer) view.getTag(R.string.app_name)).intValue() == 4) {
                    view.bringToFront();
                }
            }

            public void onAnimationEnd(Animator animation) {
            }

            public void onAnimationCancel(Animator animation) {
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
        animator.start();
    }

    public void start() {
        this.isStart = true;
        this.bookHandler.obtainMessage().sendToTarget();
    }

    public void stop() {
        this.isStart = false;
        this.bookHandler.removeCallbacks(null);
        this.bookHandler.removeCallbacksAndMessages(null);
    }

    public boolean isStart() {
        return this.isStart;
    }
}
