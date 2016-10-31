package net.frozenorb.swagger.gen;

import com.google.common.collect.Sets;
import net.frozenorb.swagger.gen.annotations.*;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
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
                AppInfo.class.getCanonicalName()
        );
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Route.class)) {
            messsager.printMessage(Diagnostic.Kind.NOTE, "Element Name: " + element.getSimpleName());
        }

        if (roundEnv.processingOver()) {
            messsager.printMessage(Diagnostic.Kind.NOTE, "Processing Completed");
        }
        return true;
    }
}
