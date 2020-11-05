package com.lixm.notes.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Trend2View extends View {
    private float startPointX;
    private float startPointY;
    private float xScale;
    private float yScale;
    private float xLength;
    private float yLength;
    private Paint mScaleLinePaint;
    private String[] data;
    private String[] yLabel;
    private float[][] mDataCoords = new float[7][2];
    private Paint mDataLinePaint;
    public Trend2View(Context context) {
        this(context, null);
    }

    public Trend2View(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Trend2View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // 数据点
        if (data == null) {
            data = new String[]{"2.98", "2.99", "2.99", "2.98", "2.92", "2.94", "2.95"};
        }
        // 根据设置的数据值生成Y坐标刻度值
        yLabel = createYLabel();
        mDataLinePaint = new Paint();
        mScaleLinePaint = new Paint();

        mDataLinePaint.setAntiAlias(true);
        mScaleLinePaint.setAntiAlias(true);
    }

    private String[] createYLabel() {
        float[] dataFloats = new float[7];
        for(int i=0;i < data.length;i++){
            dataFloats[i] = Float.parseFloat(data[i]);
        }
        Arrays.sort(dataFloats);
        float middle = format3Bit((dataFloats[0] + dataFloats[6]) / 2f);
        float scale = format3Bit(((dataFloats[6]) - dataFloats[0]) / 4 + 0.01f);
        String[] yText = new String[5];
        yText[0] = (middle - 2 * scale) + "";
        yText[1] = (middle - scale) + "";
        yText[2] = middle + "";
        yText[3] = (middle + scale) + "";
        yText[4] = (middle + 2 * scale) + "";
        for(int i=0;i<yText.length;i++){
            yText[i] = format3Bit(yText[i]);
        }
        return yText;
    }
    private float format3Bit(float number){
        DecimalFormat decimalFormat = new DecimalFormat("###.000");
        String target = decimalFormat.format(number);
        if(target.startsWith(".")){
            target = "0" + target;
        }
        return Float.parseFloat(target);
    }
    private String format3Bit(String numberStr){
        if(TextUtils.isEmpty(numberStr)){
            return "0.00";
        }
        float numberFloat = Float.parseFloat(numberStr);
        DecimalFormat decimalFormat = new DecimalFormat("###.000");
        String target = decimalFormat.format(numberFloat);
        if(target.startsWith(".")){
            target = "0" + target;
        }
        return target;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initParams();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制x轴
        drawXAxis(canvas);
        //绘制y轴
        drawYAxis(canvas);
        //绘制数据线
        drawDataLines(canvas);
    }



    private void initParams() {
        int height = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        int width = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        yScale = height / 7.5f;
        xScale = width / 7.5f;
        startPointX = xScale / 2;
        startPointY = yScale / 2;
        xLength = 6.5f * xScale;
        yLength = 5.5f * yScale;
        float chartLineStrokeWidth = xScale / 50;

        mScaleLinePaint.setStrokeWidth(chartLineStrokeWidth);
        mScaleLinePaint.setColor(0xFFDEDED8);

    }

    private void drawXAxis(Canvas canvas) {
        for (int i = 0; i < 6; i++) {
            if (i < 5) {

            } else {
                canvas.drawLine(startPointX,
                        startPointY + (i + 0.5f) * yScale,
                        startPointX + xLength,
                        startPointY + (i + 0.5f) * yScale,
                        mScaleLinePaint);
            }
        }
    }

    private void drawYAxis(Canvas canvas) {
        for(int i = 0;i< 7;i++){
            canvas.drawLine(startPointX + i * xScale,
                    startPointY,
                    startPointX + i * xScale,
                    startPointY + yLength,
                    mScaleLinePaint
            );
        }

    }

    private void drawDataLines(Canvas canvas) {
        getDataRoords();
        for(int i = 0;i < 6;i++){
            canvas.drawLine(mDataCoords[i][0], mDataCoords[i][1], mDataCoords[i + 1][0], mDataCoords[i + 1][1], mDataLinePaint);
        }
    }

    private void getDataRoords() {
        float originalPointX = startPointX;
        float originalPointY = startPointY + yLength - yScale;
        for(int i = 0;i < data.length; i++){
            mDataCoords[i][0] = originalPointX + i * xScale;
            float dataY = Float.parseFloat(data[i]);
            float oriY = Float.parseFloat(yLabel[0]);
            mDataCoords[i][1] = originalPointY - (yScale * (dataY - oriY) / (Float.parseFloat(yLabel[1]) - Float.parseFloat(yLabel[0])));
            Log.d("xxx","===>"+mDataCoords[i][0] +";:"+mDataCoords[i][1]);
        }
    }
}
