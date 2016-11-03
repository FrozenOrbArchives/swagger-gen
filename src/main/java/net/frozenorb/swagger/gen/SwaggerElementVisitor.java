package net.frozenorb.swagger.gen;

import net.frozenorb.swagger.gen.annotations.Description;
import net.frozenorb.swagger.gen.annotations.Method;
import net.frozenorb.swagger.gen.annotations.Parameter;
import net.frozenorb.swagger.gen.annotations.Response;
import net.frozenorb.swagger.gen.annotations.Route;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.AbstractElementVisitor8;

final class SwaggerElementVisitor extends AbstractElementVisitor8<SwaggerRoute, SwaggerData> {

    @Override
    public SwaggerRoute visitPackage(PackageElement e, SwaggerData d) {
        return null;
    }

    @Override
    public SwaggerRoute visitType(TypeElement element, SwaggerData d) {
        // Route & Method are required
        if (element.getAnnotation(Method.class) == null) {
            throw new IllegalArgumentException("Method is required on a Route class.");
        }
        Route route = element.getAnnotation(Route.class);

        SwaggerRoute swaggerRoute = d.getRoute(route.value());

        System.out.println(swaggerRoute);

        Method method = element.getAnnotation(Method.class);

        SwaggerMethod swaggerMethod = swaggerRoute.getSwaggerMethod(method.value());

        Parameter[] parameters = element.getAnnotationsByType(Parameter.class);
        if (parameters.length > 0) {
            for (Parameter parameter : parameters) {
                swaggerMethod.getParameters().add(SwaggerParameter.fromAnnotation(parameter));
            }
        }

        Description description = element.getAnnotation(Description.class);
        if (description != null) {
            swaggerMethod.setDescription(description.value());
        }


        Response[] responses = element.getAnnotationsByType(Response.class);
        if (responses.length > 0) {
            for (Response response : responses) {
                swaggerMethod.getResponses().add(new SwaggerResponse(response.responseCode(), response.desc()));
            }
        }

        return swaggerRoute;
    }

    @Override
    public SwaggerRoute visitVariable(VariableElement e, SwaggerData d) {
        return null;
    }

    @Override
    public SwaggerRoute visitExecutable(ExecutableElement e, SwaggerData d) {
        return null;
    }

    @Override
    public SwaggerRoute visitTypeParameter(TypeParameterElement e, SwaggerData d) {
        return null;
    }
}
