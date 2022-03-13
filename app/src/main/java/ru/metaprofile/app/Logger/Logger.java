package ru.metaprofile.app.Logger;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Logger {

    public static void debug(Object... message) {
        System.out.println(Arrays.stream(message).map(Object::toString).collect(Collectors.joining(" ")));
    }
}
