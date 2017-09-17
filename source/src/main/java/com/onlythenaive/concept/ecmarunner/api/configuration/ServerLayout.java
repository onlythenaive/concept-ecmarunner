package com.onlythenaive.concept.ecmarunner.api.configuration;

import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

@PublishedApi
@Immutable
public final class ServerLayout {

    private final ServerType type;

    public ServerLayout(final ServerType type) {
        this.type = type;
    }

    public ServerType getType() {
        return this.type;
    }
}
