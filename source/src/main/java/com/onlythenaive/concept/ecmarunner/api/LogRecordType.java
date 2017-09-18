package com.onlythenaive.concept.ecmarunner.api;

import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

/**
 * Possible log record types (levels).
 *
 * @author Ilia Gubarev
 */
@PublishedApi
@Immutable
public enum LogRecordType {

    /**
     * The finest possible level of execution debug.
     */
    TRACE(100),

    /**
     * Execution debug information.
     */
    DEBUG(200),

    /**
     * Important execution information.
     */
    INFO(300),

    /**
     * Possible deviation from a normal execution.
     */
    WARN(400),

    /**
     * Execution error.
     */
    ERROR(500),

    /**
     * Execution error, most possibly unrecoverable.
     */
    FATAl(600);

    private final int precedence;

    LogRecordType(final int precedence) {
        this.precedence = precedence;
    }

    /**
     * Gets a precedence of this type.
     *
     * @return type precedence.
     */
    public int getPrecedence() {
        return this.precedence;
    }

    /**
     * Checks if this log record type has a higher precedence than another one.
     *
     * @param another log record type to compare.
     * @return <code>true</code> if this type has a higher precedence than another.
     */
    public boolean greaterThan(final LogRecordType another) {
        return this.precedence > another.precedence;
    }
}
