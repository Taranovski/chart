package com.stat.chart.domain.front;

import com.stat.chart.annotations.Localized;

import java.util.List;

/**
 * Created by Titan on 04.09.2017.
 */
@Localized
public class Chart {

    @Localized
    private String legendX;
    @Localized
    private String legendY;
    @Localized
    private String message;
    @Localized
    private String title;

    private List<ChartEntry> entries;

    public void setLegendX(String legendX) {
        this.legendX = legendX;
    }

    public String getLegendX() {
        return legendX;
    }

    public void setLegendY(String legendY) {
        this.legendY = legendY;
    }

    public String getLegendY() {
        return legendY;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setEntries(List<ChartEntry> entries) {
        this.entries = entries;
    }

    public List<ChartEntry> getEntries() {
        return entries;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
