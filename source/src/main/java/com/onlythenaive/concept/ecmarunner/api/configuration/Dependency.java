package com.onlythenaive.concept.ecmarunner.api.configuration;

import java.util.Objects;

import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

@PublishedApi
@Immutable
public final class Dependency {

    private final String id;
    private final DependencyType type;

    public Dependency(final String id,
                      final DependencyType type) {
        Objects.requireNonNull(id, "Dependency ID cannot be null");
        this.id = id;
        Objects.requireNonNull(type, "Dependency type cannot be null");
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

    private boolean idTypeMatch() {
        // TODO: implement id and type verification
        return true;
    }

    private boolean idTypeMismatch() {
        return !idTypeMatch();
    }
}
