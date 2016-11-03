package net.frozenorb.swagger.gen;

import com.google.common.collect.Maps;

import java.util.Map;

final class SwaggerResponse {

    private int status;
    private String desc;

    public SwaggerResponse(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    Map<String, Object> toMap() {
        Map<String, Object> serialized = Maps.newHashMap();
        serialized.put("description", desc);
        return serialized;
    }

    int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
