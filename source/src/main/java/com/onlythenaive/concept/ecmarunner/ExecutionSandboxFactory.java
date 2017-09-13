package com.onlythenaive.concept.ecmarunner;

/**
 * Execution sandbox factory API.
 *
 * @see ExecutionSandbox
 * @see ExecutionSandboxConfiguration
 *
 * @author Ilia Gubarev
 */
public interface ExecutionSandboxFactory {

    /**
     * Creates a new execution sandbox with a specified configuration.
     *
     * @param configuration sandbox configuration.
     * @return new execution sandbox.
     *
     * @see ExecutionSandboxConfiguration
     */
    ExecutionSandbox create(ExecutionSandboxConfiguration configuration);
}
