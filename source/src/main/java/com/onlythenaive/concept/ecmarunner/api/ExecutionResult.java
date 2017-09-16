package com.onlythenaive.concept.ecmarunner.api;

import java.util.List;

/**
 * Script(s) execution result API.
 *
 * Contains results of an invoice execution. Designed to have immutable implementations.
 *
 * @see ExecutionInvoice
 * @see ExecutionTerminationType
 *
 * @author Ilia Gubarev
 */
public interface ExecutionResult {

    /**
     * Gets a list of console output lines which were produced during execution of the invoice.
     *
     * @return list of console output lines.
     */
    List<String> getConsole();

    /**
     * Related execution invoice
     *
     * @return execution invoice.
     *
     * @see ExecutionInvoice
     */
    ExecutionInvoice getInvoice();

    /**
     * Gets the type of execution termination.
     *
     * @return termination type.
     *
     * @see ExecutionTerminationType
     */
    ExecutionTerminationType getTerminationType();

    /**
     * Gets a resulting value of this execution if any.
     *
     * @return execution result value or <code>null</code>.
     */
    Object getValue();

    /**
     * Gets the type of this execution result value
     *
     * @return result value type.
     *
     * @see ExecutionResultValueType
     */
    ExecutionResultValueType getValueType();
}
