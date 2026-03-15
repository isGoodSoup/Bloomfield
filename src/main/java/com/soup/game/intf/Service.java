package com.soup.game.intf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a class as a service within the game framework.
 *
 * <p>Services are usually responsible for handling game logic
 * such as inventory management, localization, or other utilities.</p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Service {

    /**
     * Optional type name for the service, which can be used
     * for categorization or dependency injection.
     * @return a string representing the service type
     */
    String type() default "";
}