package com.onlythenaive.concept.ecmarunner.convention;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.experimental.categories.Category;

/**
 * Marks a test class to be a specification (unit) test.
 *
 * @author Ilia Gubarev
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Category(UnitTest.class)
public @interface Specification {

    /**
     * Target class.
     */
    Class<?> value();
}
