package com.onlythenaive.concept.ecmarunner.internal;

import java.util.ArrayList;
import java.util.List;

import com.onlythenaive.concept.ecmarunner.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.InternalImplementation;

@InternalImplementation
public final class ExecutionInvoiceImpl implements ExecutionInvoice {

    private final String description;
    private final boolean restricted;
    private final List<String> scripts;
    private final boolean timeoutEnabled;
    private final int timeoutInMilliseconds;
    private final String version;

    ExecutionInvoiceImpl(final String description,
                         final boolean restricted,
                         final List<String> scripts,
                         final boolean timeoutEnabled,
                         final int timeoutInMilliseconds,
                         final String version) {
        this.description = description;
        this.restricted = restricted;
        if (scripts == null) {
            throw new NullPointerException("scripts cannot be null");
        }
        if (scripts.isEmpty()) {
            throw new IllegalArgumentException("scripts cannot be empty");
        }
        this.scripts = new ArrayList<>(scripts);
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
    public List<String> getScripts() {
        return new ArrayList<>(this.scripts);
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
