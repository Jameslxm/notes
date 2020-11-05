package com.lixm.notes.share;

import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.DecimalFormat;

public class MyPieChatRendererPercentFormatter extends ValueFormatter {

    public DecimalFormat mFormat;
    private MyPieChart pieChart;

    public MyPieChatRendererPercentFormatter() {
        mFormat = new DecimalFormat("########0");
    }

    // Can be used to remove percent signs if the chart isn't in percent mode
    public MyPieChatRendererPercentFormatter(MyPieChart pieChart) {
        this();
        this.pieChart = pieChart;
    }

    @Override
    public String getFormattedValue(float value) {
        return mFormat.format(value) + " %";
    }

    @Override
    public String getPieLabel(float value, PieEntry pieEntry) {
        if (pieChart != null && pieChart.isUsePercentValuesEnabled()) {
            // Converted to percent
            return getFormattedValue(value);
        } else {
            // raw value, skip percent sign
            return mFormat.format(value) + "分钟";
        }
    }
}