package net.frozenorb.swagger.gen;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.AbstractElementVisitor8;

final class SwaggerElementVisitor extends AbstractElementVisitor8<SwaggerData, Void> {

    private Element element;

    public SwaggerElementVisitor(Element element) {
        this.element = element;
    }

    @Override
    public SwaggerData visitPackage(PackageElement e, Void aVoid) {
        /* NO-OP */
        return null;
    }

    @Override
    public SwaggerData visitType(TypeElement element, Void v) {
        return null;
    }

    @Override
    public SwaggerData visitVariable(VariableElement e, Void aVoid) {
        /* NO-OP */
        return null;
    }

    @Override
    public SwaggerData visitExecutable(ExecutableElement e, Void aVoid) {
        /* NO-OP */
        return null;
    }

    @Override
    public SwaggerData visitTypeParameter(TypeParameterElement e, Void aVoid) {
        /* NO-OP */
        return null;
    }
}
