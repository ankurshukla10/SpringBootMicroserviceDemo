package com.ankur.microservices.limitsservice;

import com.ankur.microservices.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/****************************************************************************
 * This class ..
 *
 * @author ankurshukla
 ****************************************************************************/
@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations(){
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }
}
