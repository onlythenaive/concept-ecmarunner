package com.onlythenaive.concept.ecmarunner.api;

/**
 * Possible termination types.
 *
 * @author Ilia Gubarev
 */
public enum ExecutionTerminationType {

    /**
     * Execution has been terminated with an exception.
     */
    EXCEPTION,

    /**
     * Execution has been finished normally.
     */
    SUCCESS,

    /**
     * Execution has been terminated as it'd reached its timeout.
     */
    TIMEOUT
}
