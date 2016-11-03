package net.frozenorb.swagger.gen;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

final class SwaggerRoute {

    private String path;
    private Map<String, SwaggerMethod> methods = new HashMap<>();

    public SwaggerRoute(String path) {
        this.path = path;
    }

    public SwaggerMethod getSwaggerMethod(String method) {
        return methods.computeIfAbsent(method.toLowerCase(), (v) -> new SwaggerMethod());
    }

    String getPath() {
        return path;
    }

    Map<String, Object> toMap() {
        Map<String, Object> serialized = Maps.newHashMap();

        methods.forEach((k, v) -> {
            serialized.put(k, v.toMap());
        });

        return serialized;
    }
}
