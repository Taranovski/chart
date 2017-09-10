package com.stat.chart.service;

import com.stat.chart.domain.back.Block;
import com.stat.chart.domain.front.Chart;
import com.stat.chart.domain.front.ChartEntry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Titan on 04.09.2017.
 */
@Service
public class ChartCreator {

    @Value("${chart.service.mean.generation.time}")
    private int meanGenerationTime;

    public Chart createChart(List<Block> blocks) {
        List<ChartEntry> chartEntries = convertToChartEntries(blocks);

        return getChart(chartEntries);
    }

    private Chart getChart(List<ChartEntry> chartEntries) {
        Chart chart = new Chart();

        chart.setLegendX("messages.chart.legend.x");
        chart.setLegendY("messages.chart.legend.y");
        chart.setTitle("messages.chart.legend.title");

        if (chartEntries.isEmpty()) {
            chart.setMessage("messages.chart.no.data.found");
        }

        chart.setEntries(chartEntries);
        return chart;
    }

    private List<ChartEntry> convertToChartEntries(List<Block> blocks) {
        if (noDataAvailableForProcessing(blocks)) {
            return Collections.emptyList();
        }

        Collections.reverse(blocks);

        List<ChartEntry> chartEntries = new ArrayList<>();

        int size = blocks.size();
        for (int i = 1; i < size; i++) {
            ChartEntry chartEntry = new ChartEntry();

            Block currentBlock = blocks.get(i);
            chartEntry.setX(currentBlock.getHeight());
            chartEntry.setY(calculateValue(currentBlock, blocks.get(i - 1)));

            chartEntries.add(chartEntry);
        }

        return chartEntries;
    }

    private double calculateValue(Block currentBlock, Block previousBlock) {
        return ((double) (currentBlock.getTime() - previousBlock.getTime())) / meanGenerationTime;
    }

    private boolean noDataAvailableForProcessing(List<Block> blocks) {
        return blocks == null || blocks.isEmpty() || blocks.size() == 1;
    }
}
