package com.onlythenaive.concept.ecmarunner.api;

import java.util.List;

/**
 * Script(s) execution result API.
 *
 * Contains results of an invoice execution. Designed to have immutable implementations.
 *
 * @see Invoice
 * @see TerminationType
 *
 * @author Ilia Gubarev
 */
public interface Result {

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
     * @see Invoice
     */
    Invoice getInvoice();

    /**
     * Gets the type of execution termination.
     *
     * @return termination type.
     *
     * @see TerminationType
     */
    TerminationType getTerminationType();

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
     * @see ResultValueType
     */
    ResultValueType getValueType();
}
