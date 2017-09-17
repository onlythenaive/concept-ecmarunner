package com.onlythenaive.concept.ecmarunner.internal.configuration;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.configuration.Dependency;
import com.onlythenaive.concept.ecmarunner.api.configuration.DependencyResolver;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class DependencyResolverDefaultImpl implements DependencyResolver {

    @Override
    public Invoice resolve(final Dependency dependency) {
        // TODO: implement real CDN/NPM dependency resolution
        return new Invoice(
                "Dependency script (fake): " + dependency.getId(),
                false,
                "if (console) { console.log('Dependency fake execution: " + dependency.getId() + "') }",
                false,
                0,
                "1.0"
        );
    }
}