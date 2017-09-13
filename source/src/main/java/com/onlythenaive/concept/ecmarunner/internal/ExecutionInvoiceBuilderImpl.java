package com.onlythenaive.concept.ecmarunner.internal;

import java.util.ArrayList;
import java.util.List;

import com.onlythenaive.concept.ecmarunner.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.ExecutionInvoiceBuilder;
import com.onlythenaive.concept.ecmarunner.InternalImplementation;

@InternalImplementation
public final class ExecutionInvoiceBuilderImpl implements ExecutionInvoiceBuilder {

    private String description = "";
    private boolean restricted = true;
    private List<String> scripts = new ArrayList<>();
    private boolean timeoutEnabled = true;
    private int timeoutInMilliseconds = 10 * 1000;
    private String version = "1.0";

    @Override
    public ExecutionInvoiceBuilder addScript(final String script) {
        this.scripts.add(script);
        return this;
    }

    @Override
    public ExecutionInvoiceBuilder description(final String description) {
        this.description = description;
        return this;
    }

    @Override
    public ExecutionInvoiceBuilder restricted(final boolean restricted) {
        this.restricted = restricted;
        return this;
    }

    @Override
    public ExecutionInvoiceBuilder timeoutEnabled(final boolean timeoutEnabled) {
        this.timeoutEnabled = timeoutEnabled;
        return this;
    }

    @Override
    public ExecutionInvoiceBuilder timeoutInMilliseconds(final int timeoutInMilliseconds) {
        this.timeoutInMilliseconds = timeoutInMilliseconds;
        return this;
    }

    @Override
    public ExecutionInvoiceBuilder version(final String version) {
        this.version = version;
        return this;
    }

    @Override
    public ExecutionInvoice build() {
        return new ExecutionInvoiceImpl(
                description,
                restricted,
                scripts,
                timeoutEnabled,
                timeoutInMilliseconds,
                version
        );
    }
}
