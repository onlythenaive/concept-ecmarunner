package com.onlythenaive.concept.ecmarunner;

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
     * Related execution invoice
     *
     * @return execution invoice.
     *
     * @see ExecutionInvoice
     */
    ExecutionInvoice getInvoice();

    /**
     * Gets a list of lines which were produced by execution as an output.
     *
     * @return list of output lines.
     */
    List<String> getOutputs();

    /**
     * Gets the type of execution termination.
     *
     * @return termination type.
     *
     * @see ExecutionTerminationType
     */
    ExecutionTerminationType getTerminationType();
}
