package com.asksira.imagerpickersheet.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.asksira.imagerpickersheet.R;

/**
 * An ImageView that measures itself according to specified aspect ratio.
 */

public class AspectRatioImageView extends android.support.v7.widget.AppCompatImageView {

    /**
     * Aspect ratio is calculated by width / height.
     */
    protected float aspectRatio;

    public AspectRatioImageView(Context context) {
        super(context);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AspectRatioView, 0, 0);
        try {
            aspectRatio = a.getFloat(R.styleable.AspectRatioView_view_aspectRatio, 0);
        } finally {
            a.recycle();
        }
    }

    public AspectRatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (aspectRatio > 0) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = Math.round(MeasureSpec.getSize(widthMeasureSpec) / aspectRatio);
            int finalWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
            int finalHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
            super.onMeasure(finalWidthMeasureSpec, finalHeightMeasureSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
