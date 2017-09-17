package com.onlythenaive.concept.ecmarunner.api.configuration;

import com.onlythenaive.concept.ecmarunner.api.Invoice;
import com.onlythenaive.concept.ecmarunner.convention.ImmutableByContract;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;

@PublishedApi
@ImmutableByContract
public interface DependencyResolver {

    Invoice resolve(Dependency dependency);
}
