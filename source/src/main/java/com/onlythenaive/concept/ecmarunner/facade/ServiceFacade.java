package com.onlythenaive.concept.ecmarunner.facade;

import com.onlythenaive.concept.ecmarunner.api.SandboxFactory;
import com.onlythenaive.concept.ecmarunner.internal.SandboxFactoryImpl;

/**
 * Service provider.
 *
 * Acts as a facade for accessing API implementations.
 *
 * @author Ilia Gubarev
 */
public final class ServiceFacade {

    /**
     * Creates a new execution sandbox factory.
     *
     * @return new sandbox factory.
     *
     * @see SandboxFactory
     */
    public static SandboxFactory sandboxFactory() {
        return new SandboxFactoryImpl();
    }

    private ServiceFacade() {

    }
}
