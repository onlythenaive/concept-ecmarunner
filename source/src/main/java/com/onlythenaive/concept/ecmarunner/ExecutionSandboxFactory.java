package com.onlythenaive.concept.ecmarunner;

/**
 * Execution sandbox factory API.
 *
 * @see ExecutionSandbox
 * @see ServiceFacade
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
