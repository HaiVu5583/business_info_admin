package com.inovationlab.businessinfo.base;

public interface BaseEnum {

    public default String getValue() {
        return this.toString().toUpperCase();
    }

    public static boolean isEquals(BaseEnum value1, BaseEnum value2) {
        if (value1 == null && value2 == null) {
            return true;
        }
        if (value1 == null || value2 == null) {
            return false;
        }
        return value1.equals(value2);
    }

}