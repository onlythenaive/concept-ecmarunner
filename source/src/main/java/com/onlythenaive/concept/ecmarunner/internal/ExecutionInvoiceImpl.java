package com.onlythenaive.concept.ecmarunner.internal;

import com.onlythenaive.concept.ecmarunner.api.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class ExecutionInvoiceImpl implements ExecutionInvoice {

    private final String description;
    private final boolean restricted;
    private final String script;
    private final boolean timeoutEnabled;
    private final int timeoutInMilliseconds;
    private final String version;

    ExecutionInvoiceImpl(final String description,
                         final boolean restricted,
                         final String script,
                         final boolean timeoutEnabled,
                         final int timeoutInMilliseconds,
                         final String version) {
        this.description = description;
        this.restricted = restricted;
        if (script == null) {
            throw new NullPointerException("script cannot be null");
        }
        this.script = script;
        this.timeoutEnabled = timeoutEnabled;
        if (timeoutInMilliseconds < 0) {
            throw new IllegalArgumentException("timeout cannot be negative");
        }
        this.timeoutInMilliseconds = timeoutInMilliseconds;
        if (version == null) {
            throw new NullPointerException("version cannot be null");
        }
        if (version.isEmpty()) {
            throw new IllegalArgumentException("version cannot be empty");
        }
        this.version = version;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean isRestricted() {
        return this.restricted;
    }

    @Override
    public String getScript() {
        return this.script;
    }

    @Override
    public boolean isTimeoutEnabled() {
        return this.timeoutEnabled;
    }

    @Override
    public int getTimeoutInMilliseconds() {
        return this.timeoutInMilliseconds;
    }

    @Override
    public String getVersion() {
        return this.version;
    }
}
