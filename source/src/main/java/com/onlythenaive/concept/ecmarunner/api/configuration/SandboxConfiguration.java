package com.onlythenaive.concept.ecmarunner.api.configuration;

import java.util.ArrayList;
import java.util.List;

import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

@PublishedApi
@Immutable
public final class SandboxConfiguration {

    private final BrowserLayout browserLayout;
    private final List<Dependency> dependencies;
    private final DependencyResolver dependencyResolver;
    private final EnvironmentType environmentType;
    private final ServerLayout serverLayout;
    private final String version;

    public SandboxConfiguration(final BrowserLayout browserLayout,
                                final List<Dependency> dependencies,
                                final DependencyResolver dependencyResolver,
                                final EnvironmentType environmentType,
                                final ServerLayout serverLayout,
                                final String version) {
        // TODO: validate input arguments
        this.browserLayout = browserLayout;
        this.dependencies = new ArrayList<>(dependencies);
        this.dependencyResolver = dependencyResolver;
        this.environmentType = environmentType;
        this.serverLayout = serverLayout;
        this.version = version;
    }

    public BrowserLayout getBrowserLayout() {
        return this.browserLayout;
    }

    public List<Dependency> getDependencies() {
        return new ArrayList<>(this.dependencies);
    }

    public DependencyResolver getDependencyResolver() {
        return this.dependencyResolver;
    }

    public EnvironmentType getEnvironmentType() {
        return this.environmentType;
    }

    public ServerLayout getServerLayout() {
        return this.serverLayout;
    }

    public String getVersion() {
        return this.version;
    }
}
