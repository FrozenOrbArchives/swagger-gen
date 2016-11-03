package net.frozenorb.swagger.gen;

import com.google.common.collect.Maps;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class SwaggerData {

    private SwaggerAppInfo appInfo;
    private Map<String, SwaggerRoute> paths = new HashMap<>(); // paths

    SwaggerAppInfo getAppInfo() {
        return appInfo;
    }

    Map<String, SwaggerRoute> getPaths() {
        return paths;
    }

    SwaggerRoute getRoute(String route) {
        System.out.println("The route is : " + route);
        return paths.computeIfAbsent(route, SwaggerRoute::new);
    }

    void addRoute(SwaggerRoute route) {
        paths.put(route.getPath(), route);
    }

    void setAppInfo(SwaggerAppInfo info) {
        this.appInfo = info;
    }

    void save() throws IOException {
        Yaml yaml = new Yaml();
        String s = yaml.dumpAsMap(this.toMap());

        try (FileWriter writer = new FileWriter("swagger.yaml")) {
            writer.write(s);
        }
    }


    private Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("swagger", "2.0"); // Force the 2.0 spec
        map.put("info", appInfo.toMap());

        Map<String, Map<String, Object>> serializedPaths = Maps.newHashMap();

        paths.forEach((k, v) -> {
            serializedPaths.put(k, v.toMap());
        });

        map.put("paths", serializedPaths);
        return map;
    }

}
