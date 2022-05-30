package ua.vspelykh.dairyfarm.security.handler;

import org.springframework.stereotype.Component;
import ua.vspelykh.dairyfarm.security.annotation.IsOwner;

import javax.servlet.http.HttpServletRequest;

@Component
public class IsOwnerHandler extends AbstractSecurityAnnotationHandler<IsOwner>{

    public IsOwnerHandler() {
        super(IsOwner.class);
    }

    @Override
    public void handle(HttpServletRequest request, IsOwner annotation) {
        if (!request.isUserInRole("OWNER")){
            throw new SecurityException(AbstractSecurityAnnotationHandler.NOT_ENOUGH_PERMISSIONS_MESSAGE);
        }
    }
}
