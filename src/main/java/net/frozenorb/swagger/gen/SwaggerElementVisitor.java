package net.frozenorb.swagger.gen;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.AbstractElementVisitor8;

final class SwaggerElementVisitor extends AbstractElementVisitor8<Void, SwaggerData> {

    private Element element;

    public SwaggerElementVisitor(Element element) {
        this.element = element;
    }

    @Override
    public Void visitPackage(PackageElement e, SwaggerData swaggerData) {
        /* NO-OP */
        return null;
    }

    @Override
    public Void visitType(TypeElement e, SwaggerData swaggerData) {
        return null;
    }

    @Override
    public Void visitVariable(VariableElement e, SwaggerData swaggerData) {
        /* NO-OP */
        return null;
    }

    @Override
    public Void visitExecutable(ExecutableElement e, SwaggerData swaggerData) {
        /* NO-OP */
        return null;
    }

    @Override
    public Void visitTypeParameter(TypeParameterElement e, SwaggerData swaggerData) {
        /* NO-OP */
        return null;
    }
}
