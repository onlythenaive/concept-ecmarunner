package com.onlythenaive.concept.ecmarunner.api.configuration;

import java.util.ArrayList;
import java.util.List;

import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;
import com.onlythenaive.concept.ecmarunner.internal.configuration.DependencyResolverDefaultImpl;

@PublishedApi
public final class SandboxConfigurationBuilder {

    private static final String DEFAULT_BROWSER_HTML = "<html><body></body></html>";
    private static final BrowserLayout DEFAULT_BROWSER_LAYOUT;
    private static final String DEFAULT_BROWSER_URL = "http://ecmarunner.concept.onlythenaive.com";
    private static final BrowserType DEFAULT_BROWSER_TYPE = BrowserType.AUTO;
    private static final DependencyResolver DEFAULT_DEPENDENCY_RESOLVER;
    private static final EnvironmentType DEFAULT_ENVIRONMENT_TYPE = EnvironmentType.AUTO;
    private static final ServerLayout DEFAULT_SERVER_LAYOUT = null;
    private static final String DEFAULT_VERSION = "1.0";

    static {
        DEFAULT_BROWSER_LAYOUT = new BrowserLayout(DEFAULT_BROWSER_HTML, DEFAULT_BROWSER_TYPE, DEFAULT_BROWSER_URL);
        DEFAULT_DEPENDENCY_RESOLVER = new DependencyResolverDefaultImpl();
    }

    private BrowserLayout browserLayout = DEFAULT_BROWSER_LAYOUT;
    private List<Dependency> dependencies = new ArrayList<>();
    private DependencyResolver dependencyResolver = DEFAULT_DEPENDENCY_RESOLVER;
    private EnvironmentType environmentType = DEFAULT_ENVIRONMENT_TYPE;
    private ServerLayout serverLayout = DEFAULT_SERVER_LAYOUT;
    private String version = DEFAULT_VERSION;

    SandboxConfigurationBuilder browserLayout(final BrowserLayout browserLayout) {
        this.browserLayout = browserLayout;
        return this;
    }

    SandboxConfigurationBuilder browserLayout(final String html, final BrowserType type, final String url) {
        this.browserLayout = new BrowserLayout(html, type, url);
        return this;
    }

    SandboxConfigurationBuilder dependency(final Dependency dependency) {
        this.dependencies.add(dependency);
        return this;
    }

    SandboxConfigurationBuilder dependency(final String id, final DependencyType type) {
        this.dependencies.add(new Dependency(id, type));
        return this;
    }

    SandboxConfigurationBuilder dependencyResolver(final DependencyResolver dependencyResolver) {
        this.dependencyResolver = dependencyResolver;
        return this;
    }

    SandboxConfigurationBuilder environmentType(final EnvironmentType environmentType) {
        this.environmentType = environmentType;
        return this;
    }

    SandboxConfigurationBuilder serverLayout(final ServerLayout serverLayout) {
        this.serverLayout = serverLayout;
        return this;
    }

    SandboxConfigurationBuilder serverLayout(final ServerType type) {
        this.serverLayout = new ServerLayout(type);
        return this;
    }

    SandboxConfigurationBuilder version(final String version) {
        this.version = version;
        return this;
    }

    public SandboxConfiguration build() {
        return new SandboxConfiguration(
                this.browserLayout,
                this.dependencies,
                this.dependencyResolver,
                this.environmentType,
                this.serverLayout,
                this.version
        );
    }
}
