package com.onlythenaive.concept.ecmarunner.api;

import java.util.List;

/**
 * Execution sandbox API.
 *
 * @author Ilia Gubarev
 */
public interface Sandbox {

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
     * @see Invoice
     * @see Result
     */
    Result execute(Invoice invoice);

    /**
     * Inspects an internal state of the sandbox.
     *
     * @param inspector specific implementation of inspector.
     * @param <T> inspection result type.
     * @return inspection result.
     *
     * @see SandboxInspector
     */
    <T> T inspect(SandboxInspector<T> inspector);
}
