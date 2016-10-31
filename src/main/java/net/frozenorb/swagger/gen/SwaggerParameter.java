package net.frozenorb.swagger.gen;

final class SwaggerParameter {
    private String name, desc, type;
    private ParameterLoc in;
    private boolean required;

    public SwaggerParameter(String name, String desc, String type, ParameterLoc in, boolean required) {
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.in = in;
        this.required = required;
    }
}
