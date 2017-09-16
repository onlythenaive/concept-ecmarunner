package com.onlythenaive.concept.ecmarunner.api;

/**
 * Sandbox inspector API.
 *
 * @param <T> inspection result type.
 *
 * @author Ilia Gubarev
 */
public interface SandboxInspector<T> {

    /**
     * Performs an inspection based on specified sandbox premises.
     *
     * @param premises sandbox premises which depend on implementation.
     * @return inspection result or <code>null</code>.
     */
    T apply(Object... premises);
}
