package com.stat.chart.aspect;

import com.stat.chart.service.LocalizationService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Titan on 05.09.2017.
 */
@Aspect
@Component
public class RestBodyLocalizationAspect {

    private final LocalizationService localizationService;

    public RestBodyLocalizationAspect(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @Around("execution(* com.stat.chart.controller.ChartController.getChart())")
    public Object aroundSampleCreation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed = proceedingJoinPoint.proceed();

        if (localizationService.isEligibleForLocalization(proceed)) {
            proceed = localizationService.localize(proceed);
        }

        return proceed;
    }

}
