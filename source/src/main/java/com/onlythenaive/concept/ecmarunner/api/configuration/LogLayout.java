package com.onlythenaive.concept.ecmarunner.api.configuration;

import com.onlythenaive.concept.ecmarunner.api.LogRecordType;
import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

@PublishedApi
@Immutable
public final class LogLayout {

    private final boolean enabled;
    private final LogRecordType level;

    public LogLayout(final boolean enabled,
                     final LogRecordType level) {
        this.enabled = enabled;
        if (level == null) {
            throw new NullPointerException("Log level cannot be null");
        }
        this.level = level;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public LogRecordType getLevel() {
        return this.level;
    }
}
