package vn.manroid.customprogress;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MyProgress extends FrameLayout {
    ImageView imgLoading;
    boolean isLoading = false;

    public MyProgress(@NonNull Context context) {
        super(context);
        init(context);
    }

    public MyProgress(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyProgress(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.my_progress_bar_layout, this);
        imgLoading = (ImageView) findViewById(R.id.img_loading);
    }

    public void setLoading(boolean isLoading) {
        if (this.isLoading == isLoading) {
            return;
        }
        this.isLoading = isLoading;
        if (isLoading) {
            Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_rotate);
            animation.setRepeatCount(Animation.INFINITE);
            animation.setRepeatMode(Animation.RESTART);
            imgLoading.startAnimation(animation);
        } else {
            imgLoading.clearAnimation();
        }
    }
}

