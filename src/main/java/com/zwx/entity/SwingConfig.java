package com.zwx.entity;

import lombok.Data;

@Data
public class SwingConfig {
    private String broker;
    private String topic;
    private String messageSecret;
}