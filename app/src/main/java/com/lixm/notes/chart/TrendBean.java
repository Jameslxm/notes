package com.lixm.notes.chart;

import java.util.List;

public class TrendBean {


    private String startTime;
    private List<HrTrendBean> hrTrend;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<HrTrendBean> getHrTrend() {
        return hrTrend;
    }

    public void setHrTrend(List<HrTrendBean> hrTrend) {
        this.hrTrend = hrTrend;
    }

    public static class HrTrendBean {

        private int node;
        private int value;

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
