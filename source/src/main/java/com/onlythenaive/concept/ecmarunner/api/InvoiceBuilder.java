package com.onlythenaive.concept.ecmarunner.api;

import com.onlythenaive.concept.ecmarunner.convention.Builder;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

/**
 * Execution invoice builder.
 *
 * @see Invoice
 *
 * @author Ilia Gubarev
 */
@PublishedApi
@Builder(Invoice.class)
public final class InvoiceBuilder {

    /**
     * Default invoice description.
     */
    public static final String DEFAULT_DESCRIPTION = "";

    /**
     * Default restriction flag.
     */
    public static final boolean DEFAULT_RESTRICTED = true;

    /**
     * Default script to be executed.
     */
    public static final String DEFAULT_SCRIPT = null;

    /**
     * Default execution timeout flag.
     */
    public static final boolean DEFAULT_TIMEOUT_ENABLED = true;

    /**
     * Default execution timeout value.
     */
    public static final long DEFAULT_TIMEOUT_IN_MILLISECONDS = 5 * 1000;

    /**
     * Default invoice version.
     */
    public static final String DEFAULT_VERSION = "1.0";

    private String description = DEFAULT_DESCRIPTION;
    private boolean restricted = DEFAULT_RESTRICTED;
    private String script = DEFAULT_SCRIPT;
    private boolean timeoutEnabled = DEFAULT_TIMEOUT_ENABLED;
    private long timeoutInMilliseconds = DEFAULT_TIMEOUT_IN_MILLISECONDS;
    private String version = DEFAULT_VERSION;

    /**
     * Create a new execution invoice builder.
     */
    public InvoiceBuilder() {

    }

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
