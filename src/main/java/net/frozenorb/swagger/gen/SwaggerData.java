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

    public void setAppInfo(SwaggerAppInfo info) {
        this.appInfo = info;
    }

    public void save() {
        Yaml yaml = new Yaml();
        String s = yaml.dumpAsMap(this.toMap());
        System.out.println(s);
    }


    Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("swagger", "2.0"); // Force the 2.0 spec
        map.put("info", appInfo.toMap());
        return map;
    }

}
