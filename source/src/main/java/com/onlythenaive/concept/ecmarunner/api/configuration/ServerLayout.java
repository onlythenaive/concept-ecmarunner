package com.onlythenaive.concept.ecmarunner.api.configuration;

import java.util.Objects;

import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

@PublishedApi
@Immutable
public final class ServerLayout {

    private final ServerType type;

    public ServerLayout(final ServerType type) {
        Objects.requireNonNull(type, "Server type cannot be null");
        this.type = type;
    }

    public ServerType getType() {
        return this.type;
    }
}
