package com.onlythenaive.concept.ecmarunner.api.facade;

import com.onlythenaive.concept.ecmarunner.api.SandboxFactory;
import com.onlythenaive.concept.ecmarunner.convention.ImplementationFacade;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;
import com.onlythenaive.concept.ecmarunner.internal.htmlunit.SandboxFactoryHtmlUnitImpl;

/**
 * Implementation facade for sandbox factories.
 *
 * @see SandboxFactory
 *
 * @author Ilia Gubarev
 */
@PublishedApi
@ImplementationFacade
public final class SandboxFactoryFacade {

    /**
     * Creates a new execution sandbox factory.
     *
     * @return new sandbox factory.
     */
    public static SandboxFactory htmlUnitSandboxFactory() {
        return new SandboxFactoryHtmlUnitImpl();
    }

    private SandboxFactoryFacade() {

    }
}
