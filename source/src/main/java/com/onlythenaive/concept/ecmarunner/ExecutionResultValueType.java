package com.onlythenaive.concept.ecmarunner;

/**
 * Possible execution result value types.
 *
 * @author Ilia Gubarev
 */
public enum ExecutionResultValueType {

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
