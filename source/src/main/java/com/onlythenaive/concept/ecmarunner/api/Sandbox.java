package com.onlythenaive.concept.ecmarunner.api;

import java.util.List;

import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

/**
 * Execution sandbox API.
 *
 * @author Ilia Gubarev
 */
@PublishedApi
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

    /**
     * Creates a new invoice builder.
     *
     * @return new invoice builder.
     *
     * @see Invoice
     * @see InvoiceBuilder
     */
    default InvoiceBuilder invoiceBuilder() {
        return new InvoiceBuilder();
    }
}
