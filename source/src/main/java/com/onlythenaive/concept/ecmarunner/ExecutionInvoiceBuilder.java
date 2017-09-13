package com.onlythenaive.concept.ecmarunner;

/**
 * Execution invoice builder API.
 *
 * @see ExecutionInvoiceParser
 *
 * @author Ilia Gubarev
 */
public interface ExecutionInvoiceBuilder {

    /**
     * Adds a new script to the invoice.
     *
     * @param script a new ECMA script.
     * @return this invoice builder.
     */
    ExecutionInvoiceBuilder addScript(String script);

    /**
     * Sets the description for an invoice.
     *
     * @param description invoice description (optional).
     * @return this invoice builder.
     */
    ExecutionInvoiceBuilder description(String description);

    /**
     * Sets the restriction flag for an invoice.
     *
     * @param restricted <code>true</code> if execution must be restricted.
     * @return this invoice builder.
     */
    ExecutionInvoiceBuilder restricted(boolean restricted);

    /**
     * Enables or disables the timeout for an invoice.
     *
     * @param timeoutEnabled <code>true</code> if timeout is enabled.
     * @return this invoice builder.
     */
    ExecutionInvoiceBuilder timeoutEnabled(boolean timeoutEnabled);

    /**
     * Sets the timeout for an invoice.
     *
     * @param timeoutInMilliseconds execution invoice timeout (in milliseconds).
     * @return this invoice builder.
     */
    ExecutionInvoiceBuilder timeoutInMilliseconds(int timeoutInMilliseconds);

    /**
     * Sets the version for an invoice.
     *
     * @param version invoice version.
     * @return this invoice builder.
     */
    ExecutionInvoiceBuilder version(String version);

    /**
     * Creates a new execution invoice.
     *
     * @return new invoice.
     */
    ExecutionInvoice build();
}
