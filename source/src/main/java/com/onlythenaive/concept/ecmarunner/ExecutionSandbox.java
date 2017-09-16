package com.onlythenaive.concept.ecmarunner;

import java.util.List;

/**
 * Execution sandbox API.
 *
 * @author Ilia Gubarev
 */
public interface ExecutionSandbox {

    /**
     * Gets a list of console output lines created after the last same operation.
     *
     * @return list of console output lines.
     */
    List<String> console();

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

    /**
     * Inspects an internal state of the sandbox.
     *
     * @param inspector specific implementation of inspector.
     * @param <T> inspection result type.
     * @return inspection result.
     *
     * @see ExecutionSandboxInspector
     */
    <T> T inspect(ExecutionSandboxInspector<T> inspector);
}
