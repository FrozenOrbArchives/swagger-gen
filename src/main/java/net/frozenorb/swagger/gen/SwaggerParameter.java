package net.frozenorb.swagger.gen;

import com.google.common.collect.Maps;
import net.frozenorb.swagger.gen.annotations.Parameter;

import java.util.Map;

final class SwaggerParameter {
    private String name, desc, type;
    private ParameterLoc in;
    private boolean required;

    public SwaggerParameter(String name, String desc, String type, ParameterLoc in, boolean required) {
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.in = in;
        this.required = (in == ParameterLoc.PATH) || required;
    }

    public ParameterLoc getLocation() {
        return in;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getType() {
        return type;
    }

    public boolean isRequired() {
        return required;
    }

    Map<String, Object> toMap() {
        Map<String, Object> obj = Maps.newHashMap();

        obj.put("name", name);
        obj.put("description", desc);
        obj.put("type", type);
        obj.put("required", required);
        obj.put("in", in.toString());

        return obj;
    }

    static SwaggerParameter fromAnnotation(Parameter parameter) {
        return new SwaggerParameter(parameter.name(), parameter.desc(), parameter.type(), parameter.in(), parameter.required());
    }
}
