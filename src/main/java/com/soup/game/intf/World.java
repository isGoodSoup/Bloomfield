package com.soup.game.intf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a class as a persistent or logical world data
 * within the game framework.
 *
 * <p>Optional {@code type} parameter can be used to categorize
 * the world entity as, e.g., "crop", "animal", or "building".</p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface World {

    /**
     * Specifies the Entity or category of the entity.
     * @return a string representing the entity type
     */
    String entity() default "";
}