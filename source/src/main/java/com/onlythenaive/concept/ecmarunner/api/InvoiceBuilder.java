package com.onlythenaive.concept.ecmarunner.api;

/**
 * Execution invoice builder API.
 *
 * @author Ilia Gubarev
 */
public interface InvoiceBuilder {

    /**
     * Sets the description for an invoice.
     *
     * @param description invoice description (optional).
     * @return this invoice builder.
     */
    InvoiceBuilder description(String description);

    /**
     * Sets the restriction flag for an invoice.
     *
     * @param restricted <code>true</code> if execution must be restricted.
     * @return this invoice builder.
     */
    InvoiceBuilder restricted(boolean restricted);

    /**
     * Sets a script to the invoice.
     *
     * @param script an ECMA script.
     * @return this invoice builder.
     */
    InvoiceBuilder script(String script);

    /**
     * Enables or disables the timeout for an invoice.
     *
     * @param timeoutEnabled <code>true</code> if timeout is enabled.
     * @return this invoice builder.
     */
    InvoiceBuilder timeoutEnabled(boolean timeoutEnabled);

    /**
     * Sets the timeout for an invoice.
     *
     * @param timeoutInMilliseconds execution invoice timeout (in milliseconds).
     * @return this invoice builder.
     */
    InvoiceBuilder timeoutInMilliseconds(long timeoutInMilliseconds);

    /**
     * Sets the version for an invoice.
     *
     * @param version invoice version.
     * @return this invoice builder.
     */
    InvoiceBuilder version(String version);

    /**
     * Creates a new execution invoice.
     *
     * @return new invoice.
     */
    Invoice build();
}
