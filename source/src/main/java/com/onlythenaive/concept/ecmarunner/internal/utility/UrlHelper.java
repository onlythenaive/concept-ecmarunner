package com.onlythenaive.concept.ecmarunner.internal.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;

import com.onlythenaive.concept.ecmarunner.convention.InternalImplementation;
import com.onlythenaive.concept.ecmarunner.convention.StaticService;

/**
 * Static service class for URL parsing and verification
 *
 * @author Ilia Gubarev
 */
@InternalImplementation
@StaticService
public final class UrlHelper {

    /**
     * Creates a new URL from its specification.
     *
     * @param specification URL specification.
     * @return parsed URL.
     * @throws RuntimeException if error occurred during URL parsing.
     */
    public static URL parseUrl(final String specification) {
        requireNonNullSpecification(specification);
        try {
            return new URL(specification);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a new URL from its specification if possible.
     *
     * @param specification URL specification.
     * @return parsed URL (optional).
     */
    public static Optional<URL> parseUrlIfPossible(final String specification) {
        requireNonNullSpecification(specification);
        try {
            return Optional.of(new URL(specification));
        } catch (MalformedURLException e) {
            return Optional.empty();
        }
    }

    /**
     * Verifies an URL specification to be valid.
     *
     * @param specification URL specification.
     * @return <code>true</code> if the specification is valid.
     */
    public static boolean validUrl(final String specification) {
        return parseUrlIfPossible(specification).isPresent();
    }

    private static void requireNonNullSpecification(final String specification) {
        Objects.requireNonNull(specification, "URL specification cannot be null");
    }

    private UrlHelper() {

    }
}
