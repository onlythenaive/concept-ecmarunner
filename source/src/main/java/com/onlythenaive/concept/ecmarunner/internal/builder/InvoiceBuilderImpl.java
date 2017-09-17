package com.onlythenaive.concept.ecmarunner.internal.builder;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.InvoiceBuilder;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class InvoiceBuilderImpl implements InvoiceBuilder {

    private String description = "";
    private boolean restricted = true;
    private String script = null;
    private boolean timeoutEnabled = true;
    private long timeoutInMilliseconds = 10 * 1000;
    private String version = "1.0";

    @Override
    public InvoiceBuilder description(final String description) {
        this.description = description;
        return this;
    }

    @Override
    public InvoiceBuilder restricted(final boolean restricted) {
        this.restricted = restricted;
        return this;
    }

    @Override
    public InvoiceBuilder script(final String script) {
        this.script = script;
        return this;
    }

    @Override
    public InvoiceBuilder timeoutEnabled(final boolean timeoutEnabled) {
        this.timeoutEnabled = timeoutEnabled;
        return this;
    }

    @Override
    public InvoiceBuilder timeoutInMilliseconds(final long timeoutInMilliseconds) {
        this.timeoutInMilliseconds = timeoutInMilliseconds;
        return this;
    }

    @Override
    public InvoiceBuilder version(final String version) {
        this.version = version;
        return this;
    }

    @Override
    public Invoice build() {
        return new Invoice(
                description,
                restricted,
                script,
                timeoutEnabled,
                timeoutInMilliseconds,
                version
        );
    }
}
