package net.frozenorb.swagger.gen;

import com.google.common.collect.Maps;

import java.util.Map;

final class SwaggerAppInfo {
    private String name = "Test", version = "1.0", description = "test test test";

    Map<String, Object> toMap() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("name", name);
        map.put("version", version);
        map.put("description", description);
        return map;
    }
}
