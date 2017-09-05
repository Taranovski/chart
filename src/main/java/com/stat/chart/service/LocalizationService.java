package com.stat.chart.service;

import com.stat.chart.annotations.Localized;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Locale;

/**
 * Created by Titan on 05.09.2017.
 */
@Service
public class LocalizationService {
    public static final Object[] ARGS = new Object[]{};
    private final LocaleResolver localeResolver;
    private final MessageSource messageSource;

    @Resource
    private HttpServletRequest request;

    public LocalizationService(LocaleResolver localeResolver, MessageSource messageSource) {
        this.localeResolver = localeResolver;
        this.messageSource = messageSource;
    }

    public Object localize(Object object) {
        Locale locale = localeResolver.resolveLocale(request);

        try {
            localizeObject(object, locale);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return object;
    }

    private void localizeObject(Object object, Locale locale) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field f : declaredFields) {

            if (f.isAnnotationPresent(Localized.class) && f.getType() == String.class) {
                f.setAccessible(true);

                String messageCode = (String) f.get(object);

                if (messageCode != null) {
                    String message = messageSource.getMessage(messageCode, ARGS, locale);

                    f.set(object, message);
                }
            } else if (f.getType().isAnnotationPresent(Localized.class)) {
                f.setAccessible(true);
                localizeObject(f.get(object), locale);
            }
        }
    }

    public boolean isEligibleForLocalization(Object object) {
        return object != null && object.getClass().isAnnotationPresent(Localized.class);
    }

}
