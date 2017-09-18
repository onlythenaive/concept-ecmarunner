package com.onlythenaive.concept.ecmarunner.api;

import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

/**
 * Script execution invoice.
 * <br/>
 * Contains all the details required to execute contained script.
 *
 * @see InvoiceBuilder
 * @see Sandbox
 *
 * @author Ilia Gubarev
 */
@PublishedApi
@Immutable
public final class Invoice {

    private final String description;
    private final boolean restricted;
    private final String script;
    private final boolean timeoutEnabled;
    private final long timeoutInMilliseconds;
    private final String version;

    /**
     * Creates a new execution invoice.
     *
     * @param description execution description (optional).
     * @param restricted restriction flag (<code>true</code> if the execution must be restricted).
     * @param script a script to be executed.
     * @param timeoutEnabled execution timeout flag.
     * @param timeoutInMilliseconds execution timeout value in milliseconds (non-negative).
     * @param version invoice version for back-compatibility.
     */
    public Invoice(final String description,
                   final boolean restricted,
                   final String script,
                   final boolean timeoutEnabled,
                   final long timeoutInMilliseconds,
                   final String version) {
        this.description = description;
        this.restricted = restricted;
        if (script == null) {
            throw new NullPointerException("Execution script cannot be null");
        }
        this.script = script;
        this.timeoutEnabled = timeoutEnabled;
        if (timeoutInMilliseconds < 0) {
            throw new IllegalArgumentException("Execution timeout value cannot be negative");
        }
        this.timeoutInMilliseconds = timeoutInMilliseconds;
        if (version == null) {
            throw new NullPointerException("Execution version cannot be null");
        }
        if (version.isEmpty()) {
            throw new IllegalArgumentException("Execution version cannot be empty");
        }
        this.version = version;
    }

    /**
     * Gets a short description of this invoice if it exists.
     *
     * @return invoice description or <code>null</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Checks if this invoice must be secured (has no access to potentially dangerous instructions).
     *
     * @return <code>true</code> if this execution must be secured.
     */
    public boolean isRestricted() {
        return this.restricted;
    }

    /**
     * Gets a script to be executed in this invoice.
     *
     * @return target script.
     */
    public String getScript() {
        return this.script;
    }

    /**
     * Checks if this invoice execution is bound to a specific timeout.
     *
     * @return <code>true</code> if timeout is enabled.
     */
    public boolean isTimeoutEnabled() {
        return this.timeoutEnabled;
    }

    /**
     * Gets a value of the timeout in milliseconds.
     *
     * @return timeout in milliseconds (non-negative).
     */
    public long getTimeoutInMilliseconds() {
        return this.timeoutInMilliseconds;
    }

    /**
     * Gets the version of this invoice to support back-compatibility in future.
     *
     * @return invoice version.
     */
    public String getVersion() {
        return this.version;
    }
}
