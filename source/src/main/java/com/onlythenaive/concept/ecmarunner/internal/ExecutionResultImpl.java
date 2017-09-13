package com.onlythenaive.concept.ecmarunner.internal;

import java.util.ArrayList;
import java.util.List;

import com.onlythenaive.concept.ecmarunner.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.ExecutionResult;
import com.onlythenaive.concept.ecmarunner.ExecutionTerminationType;
import com.onlythenaive.concept.ecmarunner.InternalImplementation;

@InternalImplementation
public final class ExecutionResultImpl implements ExecutionResult {

    private final ExecutionInvoice invoice;
    private final List<String> outputs;
    private final ExecutionTerminationType terminationType;

    ExecutionResultImpl(final ExecutionInvoice invoice,
                        final List<String> outputs,
                        final ExecutionTerminationType terminationType) {
        if (invoice == null) {
            throw new NullPointerException("execution invoice cannot be null");
        }
        this.invoice = invoice;
        if (outputs == null) {
            throw new NullPointerException("execution outputs cannot be null");
        }
        this.outputs = outputs;
        if (terminationType == null) {
            throw new NullPointerException("termination type cannot be null");
        }
        this.terminationType = terminationType;
    }

    @Override
    public ExecutionInvoice getInvoice() {
        return this.invoice;
    }

    @Override
    public List<String> getOutputs() {
        return new ArrayList<>(this.outputs);
    }

    @Override
    public ExecutionTerminationType getTerminationType() {
        return this.terminationType;
    }
}
