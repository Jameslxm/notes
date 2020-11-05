package com.lixm.notes.chart;

import android.content.Context;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Symbol;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import com.lixm.notes.util.DimenUtil;

public class EchartOptionUtil {
    public static GsonOption getLineChartOptions(Context context, Object[] xAxis, Object[] yAxis) {
        GsonOption option = new GsonOption();
        ValueAxis valueAxis = new ValueAxis();
        valueAxis.splitLine().show(false);
        valueAxis.axisLabel().show(false);
        valueAxis.axisLine().lineStyle().color("#003297").width(DimenUtil.dp2px(context,2));
        valueAxis.axisTick().show(false);
        option.yAxis(valueAxis);

        CategoryAxis categorxAxis = new CategoryAxis();
        categorxAxis.axisLine().onZero(false);
        categorxAxis.boundaryGap(true);
        categorxAxis.data(xAxis);
        categorxAxis.axisLabel().show(false);

        categorxAxis.axisLine().lineStyle().color("#003297").width(DimenUtil.dp2px(context,2));

        categorxAxis.splitLine().show(false);

        categorxAxis.axisTick().show(false);
        categorxAxis.setBoundaryGap(false);
        option.xAxis(categorxAxis);


        Line line = new Line();
        line.symbol(Symbol.none).smooth(false).data(yAxis).itemStyle().normal().lineStyle().color("#3FDCDA").width(DimenUtil.dp2px(context,2));
        option.series(line);
        return option;
    }
}
