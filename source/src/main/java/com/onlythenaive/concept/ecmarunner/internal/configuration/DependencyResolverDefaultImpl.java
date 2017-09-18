package com.onlythenaive.concept.ecmarunner.internal.configuration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.io.IOUtils;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.configuration.Dependency;
import com.onlythenaive.concept.ecmarunner.api.configuration.DependencyResolver;
import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;
import com.onlythenaive.concept.ecmarunner.internal.utility.UrlHelper;

@InternalImplementation
@Immutable
public final class DependencyResolverDefaultImpl implements DependencyResolver {

    private final ConcurrentMap<Dependency, String> cache = new ConcurrentHashMap<>();
    private final boolean cacheEnabled;

    public DependencyResolverDefaultImpl(final boolean cacheEnabled) {
        this.cacheEnabled = cacheEnabled;
    }

    @Override
    public Invoice resolve(final Dependency dependency) {
        Objects.requireNonNull(dependency, "Dependency cannot be null");
        final String description = "Dependency script: " + dependency.getResource();
        final boolean restricted = false;
        final String script = script(dependency);
        final boolean timeoutEnabled = false;
        final long timeoutInMilliseconds = 0;
        final String version = "1.0";
        return new Invoice(description, restricted, script, timeoutEnabled, timeoutInMilliseconds, version);
    }

    private String script(final Dependency dependency) {
        if (cacheEnabled) {
            return cache.computeIfAbsent(dependency, this::scriptNonCached);
        } else {
            return scriptNonCached(dependency);
        }
    }

    private String scriptNonCached(final Dependency dependency) {
        final String resource = dependency.getResource();
        switch (dependency.getType()) {
            case CDN:
                return scriptCdn(resource);
            case NPM:
            default:
                return scriptNpm(resource);
        }
    }

    private String scriptCdn(final String resource) {
        try {
            final URL url = UrlHelper.parseUrl(resource);
            return IOUtils.toString(url, "UTF-8");
        } catch (final IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private String scriptNpm(final String resource) {
        // TODO: implement NPM script resolution
        throw new UnsupportedOperationException();
    }
}
