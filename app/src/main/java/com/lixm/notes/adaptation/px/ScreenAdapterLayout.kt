package com.lixm.notes.adaptation.px

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout

/**
 * Desc 屏幕适配
 * Author xm li
 * Date :2021/4/7
 */
class ScreenAdapterLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    private var flag = false
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if(!flag) {
            var scaleX = Utils.getInstance(context).getHorizontalScale()
            var scaleY = Utils.getInstance(context).getVerticalScale()
            for (i in 0 until childCount) {
                var child = getChildAt(i)
                var params: LayoutParams? = child.layoutParams as? LayoutParams
                if (params != null) {
                    params.width = (params.width * scaleX).toInt()
                    params.height = (params.height * scaleY).toInt()
                    params.leftMargin = (params.leftMargin * scaleX).toInt()
                    params.rightMargin = (params.rightMargin * scaleX).toInt()
                }
            }
            flag = true
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}