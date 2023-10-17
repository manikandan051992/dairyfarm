package ua.vspelykh.dairyfarm.security.handler;

import org.springframework.stereotype.Component;
import ua.vspelykh.dairyfarm.security.annotation.IsOwnerOrOtherFarmRole;

import javax.servlet.http.HttpServletRequest;

@Component
public class IsOwnerOrOtherFarmRoleHandler extends AbstractSecurityAnnotationHandler<IsOwnerOrOtherFarmRole> {

    public IsOwnerOrOtherFarmRoleHandler() {
        super(IsOwnerOrOtherFarmRole.class);
    }

    @Override
    public void handle(HttpServletRequest request, IsOwnerOrOtherFarmRole annotation) {

        if (request.isUserInRole("ADMIN")) {
            throw new SecurityException(AbstractSecurityAnnotationHandler.NOT_ENOUGH_PERMISSIONS_MESSAGE);
        }

    }
}
