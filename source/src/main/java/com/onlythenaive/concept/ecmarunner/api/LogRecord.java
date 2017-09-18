package com.onlythenaive.concept.ecmarunner.api;

import java.time.Instant;

import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

/**
 * Log record produced during an execution in a sandbox.
 *
 * @see LogRecordType
 *
 * @author Ilia Gubarev
 */
@PublishedApi
@Immutable
public final class LogRecord {

    private final LogRecordType type;
    private final String value;
    private final Instant when;

    /**
     * Create a new log record
     *
     * @param type record type.
     * @param value record value.
     * @param when record registration timestamp.
     *
     * @see LogRecordType
     */
    public LogRecord(final LogRecordType type,
                     final String value,
                     final Instant when) {
        if (type == null) {
            throw new NullPointerException("Log record type cannot be null");
        }
        this.type = type;
        if (value == null) {
            throw new NullPointerException("Log record value cannot be null");
        }
        this.value = value;
        if (when == null) {
            throw new NullPointerException("Log record registration timestamp cannot be null");
        }
        this.when = when;
    }

    /**
     * Gets the type of this record.
     *
     * @return record type.
     *
     * @see LogRecordType
     */
    public LogRecordType getType() {
        return this.type;
    }

    /**
     * Gets the value of this record.
     *
     * @return record value.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Gets a registration timestamp for this record.
     *
     * @return record timestamp.
     */
    public Instant getWhen() {
        return this.when;
    }
}
