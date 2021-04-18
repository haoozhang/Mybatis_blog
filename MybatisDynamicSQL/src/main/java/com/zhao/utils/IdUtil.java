package com.zhao.utils;

import java.util.UUID;

public class IdUtil {

    public static String genId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
