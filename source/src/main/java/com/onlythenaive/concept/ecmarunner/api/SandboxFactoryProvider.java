package com.onlythenaive.concept.ecmarunner.api;

import com.onlythenaive.concept.ecmarunner.api.configuration.SandboxConfiguration;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;
import com.onlythenaive.concept.ecmarunner.internal.htmlunit.SandboxFactoryHtmlUnitImpl;

/**
 * Provider of sandbox factories.
 *
 * @see SandboxFactory
 *
 * @author Ilia Gubarev
 */
@PublishedApi
public final class SandboxFactoryProvider {

    /**
     * Creates a new execution sandbox factory.
     *
     * @param configuration sandbox configuration.
     * @return new sandbox factory.
     *
     * @see SandboxConfiguration
     */
    public static SandboxFactory factory(final SandboxConfiguration configuration) {
        return new SandboxFactoryHtmlUnitImpl();
    }

    private SandboxFactoryProvider() {

    }
}
