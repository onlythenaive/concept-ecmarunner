package com.onlythenaive.concept.ecmarunner.api.configuration;

import java.util.Objects;

import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;
import com.onlythenaive.concept.ecmarunner.internal.utility.UrlHelper;

@PublishedApi
@Immutable
public final class Dependency {

    private final String resource;
    private final DependencyType type;

    public Dependency(final String resource,
                      final DependencyType type) {
        Objects.requireNonNull(resource, "Dependency resource cannot be null");
        this.resource = resource;
        Objects.requireNonNull(type, "Dependency type cannot be null");
        this.type = type;
        if (resourceTypeMismatch()) {
            throw new IllegalArgumentException("Dependency ID and type mismatch");
        }
    }

    public String getResource() {
        return this.resource;
    }

    public DependencyType getType() {
        return this.type;
    }

    private boolean resourceTypeMatch() {
        switch (this.getType()) {
            case CDN:
                return UrlHelper.validUrl(this.resource);
            case NPM:
            default:
                return true;
        }
    }

    private boolean resourceTypeMismatch() {
        return !resourceTypeMatch();
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        final Dependency that = (Dependency) object;
        return Objects.equals(this.resource, that.resource) && this.type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resource, type);
    }
}
