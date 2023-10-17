package ua.vspelykh.dairyfarm.security.handler;

import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;

public abstract class AbstractSecurityAnnotationHandler<T extends Annotation> implements SecurityAnnotationHandler {
    protected static final String NOT_ENOUGH_PERMISSIONS_MESSAGE = "*****************************" +
            "User do not have permissions to execute service method. " +
            "*****************************";
    protected final Class<T> annotationClass;

    AbstractSecurityAnnotationHandler(Class<T> annotationClass) {
        this.annotationClass = annotationClass;
    }

    public abstract void handle(HttpServletRequest request, T annotation);

    @Override
    public void handle(HttpServletRequest request, HandlerMethod handlerMethod) {
        if (handlerMethod.getMethod().isAnnotationPresent(annotationClass)) {
            T annotation = handlerMethod.getMethod().getAnnotation(annotationClass);
            handle(request, annotation);
        }
    }
}
