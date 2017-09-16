package com.onlythenaive.concept.ecmarunner.internal;

import java.util.ArrayList;
import java.util.List;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.api.Result;
import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.api.TerminationType;
import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;

@InternalImplementation
public final class ResultImpl implements Result {

    private final List<String> console;
    private final Invoice invoice;
    private final TerminationType terminationType;
    private final Object value;
    private final ResultValueType valueType;

    ResultImpl(final List<String> console,
               final Invoice invoice,
               final TerminationType terminationType,
               final Object value,
               final ResultValueType valueType) {
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
    public Invoice getInvoice() {
        return this.invoice;
    }

    @Override
    public TerminationType getTerminationType() {
        return this.terminationType;
    }

    @Override
    public Object getValue() {
        // TODO: analyze value type
        return this.value;
    }

    @Override
    public ResultValueType getValueType() {
        return this.valueType;
    }
}
