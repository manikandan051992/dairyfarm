package ua.vspelykh.dairyfarm.security.handler;

import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;

public interface SecurityAnnotationHandler {

    void handle(HttpServletRequest request, HandlerMethod handlerMethod);
}
