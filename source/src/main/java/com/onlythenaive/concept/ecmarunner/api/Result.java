package com.onlythenaive.concept.ecmarunner.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.onlythenaive.concept.ecmarunner.convention.ImmutableByContract;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

/**
 * Script execution result.
 * <br/>
 * Contains results of an invoice execution. Designed to be immutable.
 *
 * @see Invoice
 * @see LogRecord
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

    /**
     * Creates a new execution invoice result.
     *
     * @param invoice initial execution invoice.
     * @param logRecords log records produced during execution of the invoice.
     * @param terminationType execution termination type.
     * @param value execution result value object.
     * @param valueType result value type.
     *
     * @see Invoice
     * @see LogRecord
     * @see TerminationType
     * @see ResultValueType
     */
    public Result(final Invoice invoice,
                  final List<LogRecord> logRecords,
                  final TerminationType terminationType,
                  final Object value,
                  final ResultValueType valueType) {
        Objects.requireNonNull(invoice, "Execution invoice cannot be null");
        this.invoice = invoice;
        Objects.requireNonNull(logRecords, "Execution log records cannot be null");
        this.logRecords = new ArrayList<>(logRecords);
        Objects.requireNonNull(terminationType, "Termination type cannot be null");
        this.terminationType = terminationType;
        this.value = value;
        Objects.requireNonNull(valueType, "Result value type cannot be null");
        this.valueType = valueType;
        if (valueTypeMismatch()) {
            throw new IllegalArgumentException("Value type and actual result value mismatch");
        }
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
        return this.value;
    }

    /**
     * Gets a resulting value of this execution if any as <code>List</code> (copied).
     *
     * @return execution result value or <code>null</code>.
     */
    public List<?> getValueAsList() {
        return new ArrayList<>((List<?>) this.value);
    }

    /**
     * Gets a resulting value of this execution if any as <code>Boolean</code>.
     *
     * @return execution result value or <code>null</code>.
     */
    public Boolean getValueAsBoolean() {
        return (Boolean) this.value;
    }

    /**
     * Gets a resulting value of this execution if any as <code>Double</code>.
     *
     * @return execution result value or <code>null</code>.
     */
    public Double getValueAsDouble() {
        return (Double) this.value;
    }

    /**
     * Gets a resulting value of this execution if any as <code>String</code>.
     *
     * @return execution result value or <code>null</code>.
     */
    public String getValueAsString() {
        return (String) this.value;
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

    private boolean valueTypeMatch() {
        switch (valueType) {
            case ARRAY:
                return this.value instanceof List<?>;
            case BOOLEAN:
                return this.value instanceof Boolean;
            case FUNCTION:
            case NULL:
            case UNDEFINED:
                return this.value == null;
            case NUMBER:
                return this.value instanceof Number;
            case STRING:
                return this.value instanceof String;
            default:
                return true;
        }
    }

    private boolean valueTypeMismatch() {
        return !valueTypeMatch();
    }
}
