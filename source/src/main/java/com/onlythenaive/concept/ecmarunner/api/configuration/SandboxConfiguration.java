package com.onlythenaive.concept.ecmarunner.api.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

@PublishedApi
@Immutable
public final class SandboxConfiguration {

    private final BrowserLayout browserLayout;
    private final List<Dependency> dependencies;
    private final DependencyResolver dependencyResolver;
    private final EnvironmentType environmentType;
    private final LogLayout logLayout;
    private final ServerLayout serverLayout;
    private final String version;

    public SandboxConfiguration(final BrowserLayout browserLayout,
                                final List<Dependency> dependencies,
                                final DependencyResolver dependencyResolver,
                                final EnvironmentType environmentType,
                                final LogLayout logLayout,
                                final ServerLayout serverLayout,
                                final String version) {
        Objects.requireNonNull(browserLayout, "Browser layout cannot be null");
        this.browserLayout = browserLayout;
        Objects.requireNonNull(dependencies, "Dependencies cannot be null");
        this.dependencies = new ArrayList<>(dependencies);
        Objects.requireNonNull(dependencyResolver, "Dependency resolver cannot be null");
        this.dependencyResolver = dependencyResolver;
        Objects.requireNonNull(environmentType, "Environment type cannot be null");
        this.environmentType = environmentType;
        Objects.requireNonNull(logLayout, "Log layout cannot be null");
        this.logLayout = logLayout;
        Objects.requireNonNull(serverLayout, "Server layout cannot be null");
        this.serverLayout = serverLayout;
        Objects.requireNonNull(version, "Configuration version cannot be null");
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

    public LogLayout getLogLayout() {
        return this.logLayout;
    }

    public ServerLayout getServerLayout() {
        return this.serverLayout;
    }

    public String getVersion() {
        return this.version;
    }
}
