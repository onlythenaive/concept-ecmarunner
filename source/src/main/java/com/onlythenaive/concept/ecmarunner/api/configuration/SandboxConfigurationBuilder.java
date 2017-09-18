package com.onlythenaive.concept.ecmarunner.api.configuration;

import java.util.ArrayList;
import java.util.List;

import com.onlythenaive.concept.ecmarunner.api.LogRecordType;
import com.onlythenaive.concept.ecmarunner.convention.Builder;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;
import com.onlythenaive.concept.ecmarunner.internal.configuration.DependencyResolverDefaultImpl;

@PublishedApi
@Builder(SandboxConfiguration.class)
public final class SandboxConfigurationBuilder {

    public static final String DEFAULT_BROWSER_HTML = "<html><body></body></html>";

    public static final String DEFAULT_BROWSER_URL = "http://ecmarunner.concept.onlythenaive.com";

    public static final BrowserType DEFAULT_BROWSER_TYPE = BrowserType.AUTO;

    public static final EnvironmentType DEFAULT_ENVIRONMENT_TYPE = EnvironmentType.AUTO;

    public static final boolean DEFAULT_LOG_ENABLED = true;

    public static final LogRecordType DEFAULT_LOG_LEVEL = LogRecordType.INFO;

    public static final String DEFAULT_VERSION = "1.0";

    private static final BrowserLayout DEFAULT_BROWSER_LAYOUT;
    private static final DependencyResolver DEFAULT_DEPENDENCY_RESOLVER;
    private static final LogLayout DEFAULT_LOG_LAYOUT;
    private static final ServerLayout DEFAULT_SERVER_LAYOUT;

    static {
        DEFAULT_BROWSER_LAYOUT = new BrowserLayout(DEFAULT_BROWSER_HTML, DEFAULT_BROWSER_TYPE, DEFAULT_BROWSER_URL);
        DEFAULT_DEPENDENCY_RESOLVER = new DependencyResolverDefaultImpl();
        DEFAULT_LOG_LAYOUT = new LogLayout(DEFAULT_LOG_ENABLED, DEFAULT_LOG_LEVEL);
        DEFAULT_SERVER_LAYOUT = null;
    }

    private BrowserLayout browserLayout = DEFAULT_BROWSER_LAYOUT;
    private List<Dependency> dependencies = new ArrayList<>();
    private DependencyResolver dependencyResolver = DEFAULT_DEPENDENCY_RESOLVER;
    private EnvironmentType environmentType = DEFAULT_ENVIRONMENT_TYPE;
    private LogLayout logLayout = DEFAULT_LOG_LAYOUT;
    private ServerLayout serverLayout = DEFAULT_SERVER_LAYOUT;
    private String version = DEFAULT_VERSION;

    public SandboxConfigurationBuilder browserLayout(final BrowserLayout browserLayout) {
        this.browserLayout = browserLayout;
        return this;
    }

    public SandboxConfigurationBuilder browserLayout(final String html, final BrowserType type, final String url) {
        this.browserLayout = new BrowserLayout(html, type, url);
        return this;
    }

    public SandboxConfigurationBuilder dependency(final Dependency dependency) {
        this.dependencies.add(dependency);
        return this;
    }

    public SandboxConfigurationBuilder dependency(final String id, final DependencyType type) {
        this.dependencies.add(new Dependency(id, type));
        return this;
    }

    public SandboxConfigurationBuilder dependencyResolver(final DependencyResolver dependencyResolver) {
        this.dependencyResolver = dependencyResolver;
        return this;
    }

    public SandboxConfigurationBuilder environmentType(final EnvironmentType environmentType) {
        this.environmentType = environmentType;
        return this;
    }

    public SandboxConfigurationBuilder logLayout(final LogLayout logLayout) {
        this.logLayout = logLayout;
        return this;
    }

    public SandboxConfigurationBuilder logLayout(final boolean enabled, final LogRecordType level) {
        this.logLayout = new LogLayout(enabled, level);
        return this;
    }

    public SandboxConfigurationBuilder serverLayout(final ServerLayout serverLayout) {
        this.serverLayout = serverLayout;
        return this;
    }

    public SandboxConfigurationBuilder serverLayout(final ServerType type) {
        this.serverLayout = new ServerLayout(type);
        return this;
    }

    public SandboxConfigurationBuilder version(final String version) {
        this.version = version;
        return this;
    }

    public SandboxConfiguration build() {
        return new SandboxConfiguration(
                this.browserLayout,
                this.dependencies,
                this.dependencyResolver,
                this.environmentType,
                this.logLayout,
                this.serverLayout,
                this.version
        );
    }
}
