package com.lixm.notes.share;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.lixm.notes.R;

import java.util.ArrayList;

public class SavePicActivity extends AppCompatActivity {
    private MyPieChart pie_chart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_share_pic);
        pie_chart = (MyPieChart) findViewById(R.id.pie_chart);
        pie_chart.setUsePercentValues(false);
        pie_chart.getDescription().setEnabled(false);
        pie_chart.setExtraOffsets(0.f, 10.f, 0.f, 10.f);

        pie_chart.setDragDecelerationFrictionCoef(0.95f);
        pie_chart.setDrawCenterText(false);

        pie_chart.setDrawHoleEnabled(false);
        pie_chart.setHoleColor(Color.WHITE); //中间圆颜色

        pie_chart.setHoleRadius(30f);  //圆半径
        pie_chart.setTransparentCircleRadius(44f);

        pie_chart.setRotationAngle(-90);
        //the chart by touch
        pie_chart.setRotationEnabled(false);
        pie_chart.setHighlightPerTapEnabled(false);

        //((PieHolder) holder).pie_chart.setEntryLabelColor(mContext.getResources().getColor(R.color.red_main)); //设置饼图标签颜色

        setPieData(pie_chart, 5, 100);

//        pie_chart.animateY(1200, Easing.EasingOption.EaseInOutQuad); //设置饼图动画

        Legend l = pie_chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setTextColor(Color.BLUE);
        l.setEnabled(false);
    }

    /**
     * 设置饼图数据
     */
    private void setPieData(MyPieChart chart, int count, float range) {
        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        PieEntry sz = new PieEntry(1f, "运动打卡",getResources().getDrawable(R.drawable.ic_sport_card));
        PieEntry sz1 = new PieEntry(1f, "体育课堂",getResources().getDrawable(R.drawable.ic_basket_ball));
        PieEntry sz2 = new PieEntry(1f, "日常运动",getResources().getDrawable(R.drawable.ic_daily_sport));
        PieEntry sz3 = new PieEntry(1f, "体育作业",getResources().getDrawable(R.drawable.ic_sport_work));
        PieEntry sz4 = new PieEntry(96f, "课程锻炼",getResources().getDrawable(R.drawable.ic_course_exercise));
        entries.add(sz);
        entries.add(sz1);
        entries.add(sz2);
        entries.add(sz3);
        entries.add(sz4);

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");
        dataSet.setDrawIcons(true);
//        dataSet.setSliceSpace(3f);  //不同块之间的间距
//        dataSet.setSelectionShift(7f);//选中时候突出的间距

        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(getResources().getColor(R.color.pie_1));
        colors.add(getResources().getColor(R.color.pie_2));
        colors.add(getResources().getColor(R.color.pie_3));
        colors.add(getResources().getColor(R.color.pie_4));
        colors.add(getResources().getColor(R.color.pie_5));
        dataSet.setColors(colors);
        dataSet.setValueFormatter(new MyPieChatRendererPercentFormatter(chart));
        dataSet.setValueLinePart1OffsetPercentage(100f);
        dataSet.setValueLinePart1Length(0.6f);
        dataSet.setValueLinePart2Length(0.2f);
        dataSet.setHighlightEnabled(true);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);//标签显示在外面，关闭显示在饼图里面

        dataSet.setValueLineColor(0xff000000);  //设置指示线条颜色,必须设置成这样，才能和饼图区域颜色一致

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new MyPieChatRendererPercentFormatter(chart));
        data.setValueTextSize(10f);
        data.setValueTextColor(0xff616ff2);
        data.setHighlightEnabled(true);

        chart.setData(data);
        chart.highlightValues(null);
        chart.invalidate();
    }
}
