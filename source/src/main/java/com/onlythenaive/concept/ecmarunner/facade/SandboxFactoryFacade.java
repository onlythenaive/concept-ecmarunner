package com.onlythenaive.concept.ecmarunner.facade;

import com.onlythenaive.concept.ecmarunner.api.SandboxFactory;
import com.onlythenaive.concept.ecmarunner.convention.ImplementationFacade;
import com.onlythenaive.concept.ecmarunner.internal.SandboxFactoryImpl;

/**
 * Implementation facade for sandbox factories.
 *
 * @see SandboxFactory
 *
 * @author Ilia Gubarev
 */
@ImplementationFacade
public final class SandboxFactoryFacade {

    /**
     * Creates a new Nashorn-based execution sandbox factory.
     *
     * @return new sandbox factory.
     *
     * @see SandboxFactory
     */
    public static SandboxFactory nashornSandboxFactory() {
        return new SandboxFactoryImpl();
    }

    private SandboxFactoryFacade() {

    }
}
