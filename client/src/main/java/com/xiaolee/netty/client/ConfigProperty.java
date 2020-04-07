package com.xiaolee.netty.client;

public class ConfigProperty {
    private ConfigProperty(Builder builder) {

    }

    public Builder builder() {
        return new Builder();
    }

    static class Builder {


        public ConfigProperty build() {
            return new ConfigProperty(this);
        }
    }
}
