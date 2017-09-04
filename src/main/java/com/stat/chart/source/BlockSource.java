package com.stat.chart.source;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.stat.chart.domain.back.Block;
import com.stat.chart.domain.back.BlockContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * Created by Titan on 04.09.2017.
 */
@Service
public class BlockSource {

    @Value("${chart.source.url.recentChartData}")
    private String url;
    private RestTemplate restTemplate;

    public BlockSource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "empty")
    public List<Block> getRecentData() {
        ResponseEntity<BlockContainer> forEntity = restTemplate.getForEntity(url, BlockContainer.class);

        return forEntity.getBody().getBlocks();
    }

    public List<Block> empty() {
        return Collections.emptyList();
    }
}
