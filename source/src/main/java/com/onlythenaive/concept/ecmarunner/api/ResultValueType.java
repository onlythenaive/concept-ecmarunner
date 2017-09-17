package com.onlythenaive.concept.ecmarunner.api;

import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

/**
 * Possible execution result value types.
 *
 * @author Ilia Gubarev
 */
@PublishedApi
@Immutable
public enum ResultValueType {

    /**
     * Array object (character sequence is not included).
     */
    ARRAY,

    /**
     * Boolean value (false or true).
     */
    BOOLEAN,

    /**
     * Function.
     */
    FUNCTION,

    /**
     * Null object.
     */
    NULL,

    /**
     * Numeric value.
     */
    NUMBER,

    /**
     * Complex object, including a map.
     */
    OBJECT,

    /**
     * Character sequence.
     */
    STRING,

    /**
     * No return value.
     */
    UNDEFINED
}
