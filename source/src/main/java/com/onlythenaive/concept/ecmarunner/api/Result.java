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

    private final List<String> console;
    private final Invoice invoice;
    private final TerminationType terminationType;
    private final Object value;
    private final ResultValueType valueType;

    public Result(final List<String> console,
                  final Invoice invoice,
                  final TerminationType terminationType,
                  final Object value,
                  final ResultValueType valueType) {
        if (console == null) {
            throw new NullPointerException("Execution console outputs cannot be null");
        }
        this.console = console;
        if (invoice == null) {
            throw new NullPointerException("Execution invoice cannot be null");
        }
        this.invoice = invoice;
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
     * Gets a list of console output lines which were produced during execution of the invoice.
     *
     * @return list of console output lines.
     */
    public List<String> getConsole() {
        return new ArrayList<>(this.console);
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
