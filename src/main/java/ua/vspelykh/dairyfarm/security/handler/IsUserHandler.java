package ua.vspelykh.dairyfarm.security.handler;

import org.springframework.stereotype.Component;
import ua.vspelykh.dairyfarm.security.annotation.IsUser;

import javax.servlet.http.HttpServletRequest;

@Component
public class IsUserHandler extends AbstractSecurityAnnotationHandler<IsUser>{

    public IsUserHandler() {
        super(IsUser.class);
    }

    @Override
    public void handle(HttpServletRequest request, IsUser annotation) {
        if (!request.isUserInRole("USER")){
            throw new SecurityException(AbstractSecurityAnnotationHandler.NOT_ENOUGH_PERMISSIONS_MESSAGE);
        }
    }
}
