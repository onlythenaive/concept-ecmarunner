package com.onlythenaive.concept.ecmarunner;

/**
 * Execution sandbox API.
 *
 * @author Ilia Gubarev
 */
public interface ExecutionSandbox {

    /**
     * Executes a specified invoice.
     *
     * @param invoice execution invoice to be executed.
     * @return execution result.
     *
     * @see ExecutionInvoice
     * @see ExecutionResult
     */
    ExecutionResult execute(ExecutionInvoice invoice);
}
