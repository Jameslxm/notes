package com.lixm.notes.chart;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.lixm.notes.R;

public class EChartsActivity extends AppCompatActivity {
    private EchartView lineChart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echarts);
        lineChart = findViewById(R.id.lineChart);
        lineChart.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                refreshLineChart();
            }
        });
    }

    private void refreshLineChart() {
        Object[] x = new Object[]{
                "Mon","Tue","Web","Thu","Fri","Sat","Sun"
        };
        Object[] y = new Object[]{
                820,932,901,934,1290,1330,1320
        };
        lineChart.refreshEchartsWithOption(EchartOptionUtil.getLineChartOptions(this,x,y));
    }
}
