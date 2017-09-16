package com.onlythenaive.concept.ecmarunner.api;

/**
 * Execution sandbox factory API.
 *
 * @see Sandbox
 *
 * @author Ilia Gubarev
 */
public interface SandboxFactory {

    /**
     * Creates a new execution sandbox.
     *
     * @return new execution sandbox.
     */
    Sandbox create();
}
