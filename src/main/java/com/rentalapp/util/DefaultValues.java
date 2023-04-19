package com.rentalapp.util;

import java.util.Objects;

public class DefaultValues {

    /* ホントはOptional型を使うのがベストかな・・・ */
    public static <T> T defaultValue(T val, T defaultValue) {
        return Objects.nonNull(val) ? defaultValue : val;
    }
}
