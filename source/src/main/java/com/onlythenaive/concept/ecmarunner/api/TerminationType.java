package com.onlythenaive.concept.ecmarunner.api;

import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

/**
 * Possible termination types.
 *
 * @author Ilia Gubarev
 */
@PublishedApi
@Immutable
public enum TerminationType {

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
