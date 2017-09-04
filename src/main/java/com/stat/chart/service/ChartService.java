package com.stat.chart.service;

import com.stat.chart.domain.back.Block;
import com.stat.chart.domain.front.Chart;
import com.stat.chart.source.BlockSource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Titan on 04.09.2017.
 */
@Service
public class ChartService {

    private final BlockSource blockSource;
    private final ChartCreator chartCreator;

    public ChartService(BlockSource blockSource, ChartCreator chartCreator) {
        this.blockSource = blockSource;
        this.chartCreator = chartCreator;
    }

    public Chart getRecentData() {
        List<Block> blocks = blockSource.getRecentData();

        return chartCreator.createChart(blocks);
    }
}
