package org.quantbet.pingenerator.service.randomgenerator;


import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PinUtils {

    public String random() {
        return String.format(
                "%04d",
                (new Random()).nextInt(10000));
    }
}
