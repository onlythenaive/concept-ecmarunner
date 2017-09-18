package com.onlythenaive.concept.ecmarunner.convention;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Marks a test class to be an acceptance test.
 *
 * @author Ilia Gubarev
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@RunWith(JUnit4.class)
public @interface AcceptanceTest {

}
