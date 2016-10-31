package net.frozenorb.swagger.gen;

/**
 * The location where the parameter resides
 */
public enum ParameterLoc {
    QUERY("query"),
    HEADER("header"),
    PATH("path"),
    FORM_DATA("formData"),
    BODY("body");


    private String s;

    ParameterLoc(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
