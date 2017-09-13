package com.onlythenaive.concept.ecmarunner.internal;

import java.util.Arrays;

import com.onlythenaive.concept.ecmarunner.ExecutionInvoice;
import com.onlythenaive.concept.ecmarunner.ExecutionResult;
import com.onlythenaive.concept.ecmarunner.ExecutionSandbox;
import com.onlythenaive.concept.ecmarunner.ExecutionTerminationType;
import com.onlythenaive.concept.ecmarunner.InternalImplementation;

@InternalImplementation
public final class ExecutionSandboxImpl implements ExecutionSandbox {

    @Override
    public ExecutionResult execute(final ExecutionInvoice invoice) {
        if (invoice == null) {
            throw new NullPointerException("Execution invoice cannot be null");
        }
        // TODO: implement invoice execution
        return new ExecutionResultImpl(
                invoice,
                Arrays.asList("output 1", "output 2"),
                ExecutionTerminationType.SUCCESS
        );
    }
}
