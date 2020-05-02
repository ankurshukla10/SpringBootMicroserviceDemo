package com.ankur.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/****************************************************************************
 * This class ..
 *
 * @author ankurshukla
 ****************************************************************************/
@Component
@ConfigurationProperties("limits-service")
public class Configuration {

    private int minimum;
    private int maximum;

    public Configuration() {
    }

    public Configuration(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
