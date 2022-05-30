package ua.vspelykh.dairyfarm.security.handler;

import org.springframework.stereotype.Component;
import ua.vspelykh.dairyfarm.security.annotation.IsAdmin;

import javax.servlet.http.HttpServletRequest;

@Component
public class IsAdminHandler extends AbstractSecurityAnnotationHandler<IsAdmin> {

    public IsAdminHandler() {
        super(IsAdmin.class);
    }

    @Override
    public void handle(HttpServletRequest request, IsAdmin annotation) {
        if (!request.isUserInRole("ADMIN")){
            throw new SecurityException(AbstractSecurityAnnotationHandler.NOT_ENOUGH_PERMISSIONS_MESSAGE);
        }
    }
}
