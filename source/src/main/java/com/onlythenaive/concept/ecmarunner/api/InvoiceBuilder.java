package com.onlythenaive.concept.ecmarunner.api;

import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

/**
 * Execution invoice builder.
 *
 * @see Invoice
 *
 * @author Ilia Gubarev
 */
@PublishedApi
public final class InvoiceBuilder {

    private String description = "";
    private boolean restricted = true;
    private String script = null;
    private boolean timeoutEnabled = true;
    private long timeoutInMilliseconds = 10 * 1000;
    private String version = "1.0";

    /**
     * Sets the description for an invoice.
     *
     * @param description invoice description (optional).
     * @return this invoice builder.
     */
    public InvoiceBuilder description(final String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the restriction flag for an invoice.
     *
     * @param restricted <code>true</code> if execution must be restricted.
     * @return this invoice builder.
     */
    public InvoiceBuilder restricted(final boolean restricted) {
        this.restricted = restricted;
        return this;
    }

    /**
     * Sets a script to the invoice.
     *
     * @param script an ECMA script.
     * @return this invoice builder.
     */
    public InvoiceBuilder script(final String script) {
        this.script = script;
        return this;
    }

    /**
     * Enables or disables the timeout for an invoice.
     *
     * @param timeoutEnabled <code>true</code> if timeout is enabled.
     * @return this invoice builder.
     */
    public InvoiceBuilder timeoutEnabled(final boolean timeoutEnabled) {
        this.timeoutEnabled = timeoutEnabled;
        return this;
    }

    /**
     * Sets the timeout for an invoice.
     *
     * @param timeoutInMilliseconds execution invoice timeout (in milliseconds).
     * @return this invoice builder.
     */
    public InvoiceBuilder timeoutInMilliseconds(final long timeoutInMilliseconds) {
        this.timeoutInMilliseconds = timeoutInMilliseconds;
        return this;
    }

    /**
     * Sets the version for an invoice.
     *
     * @param version invoice version.
     * @return this invoice builder.
     */
    public InvoiceBuilder version(final String version) {
        this.version = version;
        return this;
    }

    /**
     * Creates a new execution invoice.
     *
     * @return new invoice.
     */
    public Invoice build() {
        return new Invoice(
                description,
                restricted,
                script,
                timeoutEnabled,
                timeoutInMilliseconds,
                version
        );
    }
}
