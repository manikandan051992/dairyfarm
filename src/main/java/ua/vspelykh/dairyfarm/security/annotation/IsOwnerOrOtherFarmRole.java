package ua.vspelykh.dairyfarm.security.annotation;

import ua.vspelykh.dairyfarm.model.entity.Role;

import java.lang.annotation.*;

/**
 * Used to check if currentUser has Admin role or has one of the specified role.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IsOwnerOrOtherFarmRole {
    Role[] value();
}