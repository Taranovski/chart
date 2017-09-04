package com.stat.chart.controller;

import com.stat.chart.domain.front.Chart;
import com.stat.chart.service.ChartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Titan on 04.09.2017.
 */
@RestController
public class ChartController {

    private final ChartService chartService;

    public ChartController(ChartService chartService) {
        this.chartService = chartService;
    }

    @GetMapping("recentChartData")
    public Chart getChart() {
        return chartService.getRecentData();
    }
}
