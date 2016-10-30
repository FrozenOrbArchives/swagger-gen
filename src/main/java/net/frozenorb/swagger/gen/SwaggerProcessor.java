package net.frozenorb.swagger.gen;

import com.google.common.collect.Sets;
import net.frozenorb.swagger.gen.annotations.*;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.util.Set;

public final class SwaggerProcessor extends AbstractProcessor {
    private SwaggerData swaggerData = new SwaggerData();

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
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
        return true;
    }
}
