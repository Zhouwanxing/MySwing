package com.zwx.utils;

import com.zwx.entity.SwingConfig;

public class RuntimeData {
    private static RuntimeData instance = null;

    private SwingConfig swingConfig;

    private RuntimeData() {
        instance = this;
    }

    public static RuntimeData getInstance() {
        if (instance == null) {
            new RuntimeData();
        }
        return instance;
    }

    public SwingConfig getSwingConfig() {
        return swingConfig;
    }

    public void setSwingConfig(SwingConfig swingConfig) {
        this.swingConfig = swingConfig;
    }
}