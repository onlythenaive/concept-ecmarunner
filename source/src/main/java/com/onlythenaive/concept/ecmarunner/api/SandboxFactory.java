package com.onlythenaive.concept.ecmarunner.api;

import com.onlythenaive.concept.ecmarunner.convention.ImmutableByContract;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

/**
 * Execution sandbox factory API.
 *
 * @see Sandbox
 *
 * @author Ilia Gubarev
 */
@PublishedApi
@ImmutableByContract
public interface SandboxFactory {

    /**
     * Creates a new execution sandbox.
     *
     * @return new execution sandbox.
     */
    Sandbox create();
}
