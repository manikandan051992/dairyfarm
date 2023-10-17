package ua.vspelykh.dairyfarm.security.annotation;

import java.lang.annotation.*;

/**
 * Used to check if currentUser has Admin role.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IsAdmin {

}