package com.gmail.tveretco.UniIng.service;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Optional;

@UtilityClass
public class Utils {
    static String getStringValue(List<String> strings, int index) {
        return Optional.ofNullable(strings.get(index)).orElse("");
    }

    static int getIntValue(String value) {
        try {
            return (Double.valueOf(value)).intValue();
        } catch (NumberFormatException e) {
            System.out.println(value);
            return 999;
        }
    }
}
