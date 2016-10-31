package net.frozenorb.swagger.gen;

import com.google.common.collect.Maps;
import net.frozenorb.swagger.gen.annotations.AppInfo;

import java.util.Map;

final class SwaggerAppInfo {
    private String name;
    private String version;
    private String description;

    public SwaggerAppInfo(String name, String version, String description) {
        this.name = name;
        this.description = description;
        this.version = version;
    }

    Map<String, Object> toMap() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("name", name);
        map.put("version", version);
        map.put("description", description);
        return map;
    }

    static SwaggerAppInfo fromAnnotation(AppInfo annotation) {
        return new SwaggerAppInfo(annotation.title(), annotation.version(), annotation.desc());
    }
}
