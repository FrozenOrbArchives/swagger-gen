package net.frozenorb.swagger.gen;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

final class SwaggerMethod {

    private String description = "";

    private List<SwaggerParameter> parameters = new ArrayList<>();
    private List<SwaggerResponse> responses = new ArrayList<>();


    public List<SwaggerParameter> getParameters() {
        return parameters;
    }

    public List<SwaggerResponse> getResponses() {
        return responses;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    Map<String, Object> toMap() {
        Map<String, Object> serialized = Maps.newHashMap();

        serialized.put("parameters", parameters.stream().map(SwaggerParameter::toMap).collect(Collectors.toList()));


        Map<String, Object> serializedResponses = Maps.newHashMap();

        responses.forEach((v) -> {
            serializedResponses.put(String.valueOf(v.getStatus()), v.toMap());
        });

        serialized.put("responses", serializedResponses);

        return serialized;
    }

}
