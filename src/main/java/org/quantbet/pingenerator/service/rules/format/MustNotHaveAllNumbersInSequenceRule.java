package org.quantbet.pingenerator.service.rules.format;

import org.quantbet.pingenerator.service.rulesengine.format.FormatRule;
import org.springframework.stereotype.Component;

@Component
public class MustNotHaveAllNumbersInSequenceRule implements FormatRule {

     /*
        It must not contain a complete consecutive number sequence (eg 1234, 3456 are not allowed)
        ** Added reverse sequence **
     */

    @Override
    public boolean isValid(String pinNumber) {
        String[] sequence = pinNumber.split("");
        int actual;
        int next;
        int direction =
                Integer.parseInt(sequence[0]) <= Integer.parseInt(sequence[1])
                        ? 1
                        : -1;

        for (int i = 0; i < sequence.length - 1; i++) {

            actual = Integer.parseInt(sequence[i]);
            next = Integer.parseInt(sequence[i + 1]);

            if (actual + direction != next) {
                return true;
            }
        }
        return false;
    }
}