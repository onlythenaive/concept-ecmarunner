package com.onlythenaive.concept.ecmarunner.api.configuration;

import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

@PublishedApi
public final class Dependency {

    private final String id;
    private final DependencyType type;

    public Dependency(final String id,
                      final DependencyType type) {
        if (id == null) {
            throw new NullPointerException("Dependency ID cannot be null");
        }
        this.id = id;
        if (type == null) {
            throw new NullPointerException("Dependency type cannot be null");
        }
        this.type = type;
        if (idTypeMismatch()) {
            throw new IllegalArgumentException("Dependency ID and type mismatch");
        }
    }

    public String getId() {
        return this.id;
    }

    public DependencyType getType() {
        return this.type;
    }

    private boolean idTypeMismatch() {
        // TODO: implement id and type verification
        return false;
    }
}
