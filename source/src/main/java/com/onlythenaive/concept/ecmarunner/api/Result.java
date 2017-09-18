package com.onlythenaive.concept.ecmarunner.api;

import java.util.ArrayList;
import java.util.List;

import com.onlythenaive.concept.ecmarunner.convention.ImmutableByContract;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

/**
 * Script(s) execution result.
 *
 * Contains results of an invoice execution. Designed to be immutable.
 *
 * @see Invoice
 * @see TerminationType
 * @see ResultValueType
 *
 * @author Ilia Gubarev
 */
@PublishedApi
@ImmutableByContract
public final class Result {

    private final Invoice invoice;
    private final List<LogRecord> logRecords;
    private final TerminationType terminationType;
    private final Object value;
    private final ResultValueType valueType;

    public Result(final Invoice invoice,
                  final List<LogRecord> logRecords,
                  final TerminationType terminationType,
                  final Object value,
                  final ResultValueType valueType) {
        if (invoice == null) {
            throw new NullPointerException("Execution invoice cannot be null");
        }
        this.invoice = invoice;
        if (logRecords == null) {
            throw new NullPointerException("Execution log records cannot be null");
        }
        this.logRecords = new ArrayList<>(logRecords);
        if (terminationType == null) {
            throw new NullPointerException("Termination type cannot be null");
        }
        this.terminationType = terminationType;
        this.value = value;
        if (valueType == null) {
            throw new NullPointerException("Result value type cannot be null");
        }
        // TODO: check if value type corresponds to the value
        this.valueType = valueType;
    }

    /**
     * Related execution invoice
     *
     * @return execution invoice.
     *
     * @see Invoice
     */
    public Invoice getInvoice() {
        return this.invoice;
    }

    /**
     * Gets a list of log records which were produced during execution of the invoice.
     *
     * @return list of log records.
     *
     * @see LogRecord
     */
    public List<LogRecord> getLogRecords() {
        return new ArrayList<>(this.logRecords);
    }

    /**
     * Gets the type of execution termination.
     *
     * @return termination type.
     *
     * @see TerminationType
     */
    public TerminationType getTerminationType() {
        return this.terminationType;
    }

    /**
     * Gets a resulting value of this execution if any.
     *
     * @return execution result value or <code>null</code>.
     */
    public Object getValue() {
        // TODO: analyze value type
        return this.value;
    }

    /**
     * Gets the type of this execution result value
     *
     * @return result value type.
     *
     * @see ResultValueType
     */
    public ResultValueType getValueType() {
        return this.valueType;
    }
}
