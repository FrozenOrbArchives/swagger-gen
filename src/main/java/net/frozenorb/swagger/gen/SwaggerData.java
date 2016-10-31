package net.frozenorb.swagger.gen;

import org.yaml.snakeyaml.Yaml;

import java.util.HashMap;
import java.util.Map;

final class SwaggerData {

    private SwaggerAppInfo appInfo;
    private Map<String, SwaggerRoute> paths = new HashMap<>();

    public SwaggerAppInfo getAppInfo() {
        return appInfo;
    }

    public Map<String, SwaggerRoute> getPaths() {
        return paths;
    }

    public SwaggerRoute getRouteFromMethod(String method) {
        return paths.putIfAbsent(method, new SwaggerRoute());
    }

    public void save() {
        Yaml yaml = new Yaml();
        String s = yaml.dumpAsMap(this);
    }
}
