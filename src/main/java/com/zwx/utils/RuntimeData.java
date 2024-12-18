package com.zwx.utils;

public class RuntimeData {
    private static RuntimeData instance = null;


    private RuntimeData() {
        instance = this;
    }

    public static RuntimeData getInstance() {
        if (instance == null) {
            new RuntimeData();
        }
        return instance;
    }
}