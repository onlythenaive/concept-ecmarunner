package com.onlythenaive.concept.ecmarunner.internal.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;
import com.onlythenaive.concept.ecmarunner.convention.StaticService;

// TODO: add javadoc
@InternalImplementation
@StaticService
public final class UrlHelper {

    // TODO: add javadoc
    public static URL parseUrl(final String specification) {
        requireNonNullSpecification(specification);
        try {
            return new URL(specification);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: add javadoc
    public static boolean validUrl(final String specification) {
        requireNonNullSpecification(specification);
        try {
            new URL(specification);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    private static void requireNonNullSpecification(final String specification) {
        Objects.requireNonNull(specification, "URL specification cannot be null");
    }

    private UrlHelper() {

    }
}
