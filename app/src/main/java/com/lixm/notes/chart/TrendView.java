package com.lixm.notes.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TrendView extends View {
    private int height;
    private int width;
    private Paint mPaint;
    private List<TrendBean.HrTrendBean> hrTrends;
    public TrendView(Context context) {
        this(context,null);
    }

    public TrendView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TrendView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        hrTrends = new ArrayList<>();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#003297"));
        mPaint.setStrokeWidth(2f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initParams();
    }

    private void initParams() {
        height = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        width = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制x轴
        drawXAxis(canvas);
        //绘制y轴
        drawYAxis(canvas);
        //绘制折线
        drawPolyLine(canvas);

    }

    private void drawPolyLine(Canvas canvas) {
        for(int i=0;i<hrTrends.size();i++) {
//            canvas.drawLine();
        }
    }

    private void drawYAxis(Canvas canvas) {
        canvas.drawLine(0,0,0,height,mPaint);
    }

    private void drawXAxis(Canvas canvas) {
        canvas.drawLine(0,height,width,height,mPaint);
    }
    public void setData(List<TrendBean.HrTrendBean> hrTrend){
        if(hrTrends.size()>0){
            hrTrend.clear();
        }
        hrTrends.addAll(hrTrend);
        invalidate();
    }
}
