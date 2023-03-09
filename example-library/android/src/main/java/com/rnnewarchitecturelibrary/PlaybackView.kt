package com.rnnewarchitecturelibrary

import android.annotation.TargetApi
import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.view.Choreographer

class PlaybackView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context,
                attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}
    @TargetApi(21)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int,
                defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)


    init {
        Choreographer.getInstance().postFrameCallback(object : Choreographer.FrameCallback{
            override fun doFrame(frameTimeNanos: Long) {
                manuallyLayoutChildren();
                viewTreeObserver.dispatchOnGlobalLayout();
                Choreographer.getInstance().postFrameCallback(this)
            }

        })
    }

    fun manuallyLayoutChildren() {
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            // TO Align properly AspectRatioFrameLayout from ExoPlayer
            child.measure(MeasureSpec.makeMeasureSpec(measuredWidth, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(measuredHeight, MeasureSpec.EXACTLY))
            var horizontalMargin = 0
            if(width > child.measuredWidth || width < child.measuredWidth){
                horizontalMargin = (width - child.measuredWidth) / 2
            }
            var verticalMargin = 0
            if(height > child.measuredHeight || height < child.measuredHeight){
                verticalMargin = (height - child.measuredHeight) / 2
            }
            child.layout(horizontalMargin, verticalMargin, child.measuredWidth + horizontalMargin, child.measuredHeight + verticalMargin)
        }
    }
}