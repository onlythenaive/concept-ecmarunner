package com.onlythenaive.concept.ecmarunner.api;

/**
 * Script execution invoice API.
 *
 * Contains all the details required to execute contained script. Designed to have immutable implementations.
 *
 * @see InvoiceBuilder
 * @see InvoiceParser
 * @see Sandbox
 *
 * @author Ilia Gubarev
 */
public interface Invoice {

    /**
     * Gets a short description of this invoice if it exists.
     *
     * @return invoice description or <code>null</code>.
     */
    String getDescription();

    /**
     * Checks if this invoice must be secured (has no access to potentially dangerous instructions).
     *
     * @return <code>true</code> if this execution must be secured.
     */
    boolean isRestricted();

    /**
     * Gets a script to be executed in this invoice.
     *
     * @return target script.
     */
    String getScript();

    /**
     * Checks if this invoice execution is bound to a specific timeout.
     *
     * @return <code>true</code> if timeout is enabled.
     */
    boolean isTimeoutEnabled();

    /**
     * Gets a value of the timeout in milliseconds.
     *
     * @return timeout in milliseconds (non-negative).
     */
    int getTimeoutInMilliseconds();

    /**
     * Gets the version of this invoice to support back-compatibility in future.
     *
     * @return invoice version.
     */
    String getVersion();
}
