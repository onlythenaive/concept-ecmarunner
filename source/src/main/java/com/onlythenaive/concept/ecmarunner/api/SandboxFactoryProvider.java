package com.onlythenaive.concept.ecmarunner.api;

import com.onlythenaive.concept.ecmarunner.api.configuration.EnvironmentType;
import com.onlythenaive.concept.ecmarunner.api.configuration.SandboxConfiguration;
import com.onlythenaive.concept.ecmarunner.api.configuration.SandboxConfigurationBuilder;
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
     * Create a new sandbox configuration builder.
     *
     * @return new configuration builder.
     *
     * @see SandboxConfiguration
     * @see SandboxConfigurationBuilder
     */
    public static SandboxConfigurationBuilder configurationBuilder() {
        return new SandboxConfigurationBuilder();
    }

    /**
     * Creates a new execution sandbox factory.
     *
     * @param configuration sandbox configuration.
     * @return new sandbox factory.
     *
     * @see SandboxConfiguration
     */
    public static SandboxFactory factory(final SandboxConfiguration configuration) {
        if (configuration == null) {
            throw new NullPointerException("Sandbox configuration cannot be null");
        }
        final EnvironmentType type = environmentType(configuration);
        switch (type) {
            case BROWSER:
                return new SandboxFactoryHtmlUnitImpl(configuration);
            case SERVER:
            default:
                throw new UnsupportedOperationException();
        }
    }

    private static EnvironmentType environmentType(final SandboxConfiguration configuration) {
        final EnvironmentType type = configuration.getEnvironmentType();
        if (type != EnvironmentType.AUTO) {
            return type;
        }
        if (configuration.getBrowserLayout() != null) {
            return EnvironmentType.BROWSER;
        }
        return EnvironmentType.SERVER;
    }

    private SandboxFactoryProvider() {

    }
}
