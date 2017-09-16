package com.onlythenaive.concept.ecmarunner.api;

/**
 * Execution sandbox factory API.
 *
 * @see ExecutionSandbox
 *
 * @author Ilia Gubarev
 */
public interface ExecutionSandboxFactory {

    /**
     * Creates a new execution sandbox.
     *
     * @return new execution sandbox.
     */
    ExecutionSandbox create();
}
