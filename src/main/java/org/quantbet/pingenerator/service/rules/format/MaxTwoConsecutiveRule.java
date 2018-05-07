package org.quantbet.pingenerator.service.rules.format;

import org.quantbet.pingenerator.service.rulesengine.format.FormatRule;
import org.springframework.stereotype.Component;

@Component
public class MaxTwoConsecutiveRule implements FormatRule {

    /*
       It must not contain more than two consecutive numbers (eg 1112, 1111 are not allowed; 1211 is
       allowed)
    */

    @Override
    public boolean isValid(String pinNumber) {
        return pinNumber != null
                && !pinNumber.matches("\\d*(\\d)\\1{2,}\\d*");
    }
}
