package ua.vspelykh.dairyfarm.security.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import ua.vspelykh.dairyfarm.security.handler.SecurityAnnotationHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class SecurityInterceptor implements AsyncHandlerInterceptor {

    private final List<SecurityAnnotationHandler> securityAnnotationHandlers;

    @Autowired
    public SecurityInterceptor(List<SecurityAnnotationHandler> securityAnnotationHandlers) {
        this.securityAnnotationHandlers = securityAnnotationHandlers;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            securityAnnotationHandlers
                    .forEach(securityAnnotationHandler -> securityAnnotationHandler.handle(request, handlerMethod));
        }

        return true;
    }
}
