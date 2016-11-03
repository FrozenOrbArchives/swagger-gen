package net.frozenorb.swagger.gen;

import com.google.common.collect.Sets;
import net.frozenorb.swagger.gen.annotations.AppInfo;
import net.frozenorb.swagger.gen.annotations.Description;
import net.frozenorb.swagger.gen.annotations.Method;
import net.frozenorb.swagger.gen.annotations.Parameter;
import net.frozenorb.swagger.gen.annotations.Parameters;
import net.frozenorb.swagger.gen.annotations.Response;
import net.frozenorb.swagger.gen.annotations.Responses;
import net.frozenorb.swagger.gen.annotations.Returns;
import net.frozenorb.swagger.gen.annotations.Route;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Set;

public final class SwaggerProcessor extends AbstractProcessor {
    private SwaggerData swaggerData = new SwaggerData();

    private Messager messsager;

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.messsager = processingEnv.getMessager();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Sets.newHashSet(
                Route.class.getCanonicalName(),
                Description.class.getCanonicalName(),
                Parameter.class.getCanonicalName(),
                Parameters.class.getCanonicalName(),
                Method.class.getCanonicalName(),
                Returns.class.getCanonicalName(),
                AppInfo.class.getCanonicalName(),
                Response.class.getCanonicalName(),
                Responses.class.getCanonicalName()
        );
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : getElementsMarkedWith(roundEnv, Route.class, AppInfo.class)) {
            if (element.getKind() != ElementKind.CLASS) {
                continue;
            }

            // Is an application class
            if (element.getAnnotation(AppInfo.class) != null) {
                if (swaggerData.getAppInfo() != null) {
                    // already have an app info
                    throw new IllegalArgumentException("Already have the Swagger application information");
                } else {
                    swaggerData.setAppInfo(SwaggerAppInfo.fromAnnotation(element.getAnnotation(AppInfo.class)));
                }
            } else {
                element.accept(new SwaggerElementVisitor(), swaggerData);
            }
        }


        // Processing is over, save the Swagger YAML file.
        if (roundEnv.processingOver()) {
            try {
                swaggerData.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @SafeVarargs
    private final Set<Element> getElementsMarkedWith(RoundEnvironment env, Class<? extends Annotation>... classes) {
        Set<Element> elements = Sets.newHashSet();
        Arrays.stream(classes).forEach((a) -> elements.addAll(env.getElementsAnnotatedWith(a)));
        return elements;
    }
}
