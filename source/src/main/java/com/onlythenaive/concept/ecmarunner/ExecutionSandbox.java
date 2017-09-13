package com.onlythenaive.concept.ecmarunner;

/**
 * Execution sandbox API.
 *
 * @see ExecutionSandboxFactory
 * @see ExecutionSandboxConfiguration
 *
 * @author Ilia Gubarev
 */
public interface ExecutionSandbox {

    /**
     * Gets a configuration which was used to create this sandbox.
     *
     * @return execution sandbox configuration
     *
     * @see ExecutionSandboxConfiguration
     */
    ExecutionSandboxConfiguration getConfiguration();

    /**
     * Gets a factory which was used to create this sandbox.
     *
     * @return execution sandbox factory
     *
     * @see ExecutionSandboxFactory
     */
    ExecutionSandboxFactory getFactory();

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
