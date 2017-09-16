package com.onlythenaive.concept.ecmarunner.internal;

import java.util.ArrayList;
import java.util.List;

import com.onlythenaive.concept.ecmarunner.api.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.api.ExecutionResult;
import com.onlythenaive.concept.ecmarunner.api.ExecutionResultValueType;
import com.onlythenaive.concept.ecmarunner.api.ExecutionTerminationType;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class ExecutionResultImpl implements ExecutionResult {

    private final List<String> console;
    private final ExecutionInvoice invoice;
    private final ExecutionTerminationType terminationType;
    private final Object value;
    private final ExecutionResultValueType valueType;

    ExecutionResultImpl(final List<String> console,
                        final ExecutionInvoice invoice,
                        final ExecutionTerminationType terminationType,
                        final Object value,
                        final ExecutionResultValueType valueType) {
        if (console == null) {
            throw new NullPointerException("execution console outputs cannot be null");
        }
        this.console = console;
        if (invoice == null) {
            throw new NullPointerException("execution invoice cannot be null");
        }
        this.invoice = invoice;
        if (terminationType == null) {
            throw new NullPointerException("termination type cannot be null");
        }
        this.terminationType = terminationType;
        this.value = value;
        if (valueType == null) {
            throw new NullPointerException("value type cannot be null");
        }
        // TODO: check if value type corresponds to the value
        this.valueType = valueType;
    }

    @Override
    public List<String> getConsole() {
        return new ArrayList<>(this.console);
    }

    @Override
    public ExecutionInvoice getInvoice() {
        return this.invoice;
    }

    @Override
    public ExecutionTerminationType getTerminationType() {
        return this.terminationType;
    }

    @Override
    public Object getValue() {
        // TODO: analyze value type
        return this.value;
    }

    @Override
    public ExecutionResultValueType getValueType() {
        return this.valueType;
    }
}
