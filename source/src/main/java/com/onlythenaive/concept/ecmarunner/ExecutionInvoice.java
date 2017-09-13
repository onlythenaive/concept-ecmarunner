package com.onlythenaive.concept.ecmarunner;

import java.util.List;

/**
 * Script(s) execution invoice API.
 *
 * Contains all the details required to execute contained script(s). Designed to have immutable implementations.
 *
 * @see ExecutionInvoiceBuilder
 * @see ExecutionInvoiceParser
 * @see ExecutionSandbox
 *
 * @author Ilia Gubarev
 */
public interface ExecutionInvoice {

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
     * Gets a list of the scripts to be executed in this invoice.
     *
     * @return list of the scripts (copy).
     */
    List<String> getScripts();

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
