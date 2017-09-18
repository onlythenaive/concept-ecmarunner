package com.onlythenaive.concept.ecmarunner.api.configuration;

import java.net.URL;
import java.util.Objects;

import com.onlythenaive.concept.ecmarunner.convention.Immutable;
import com.onlythenaive.concept.ecmarunner.convention.PublishedApi;
import com.onlythenaive.concept.ecmarunner.internal.utility.UrlHelper;

@PublishedApi
@Immutable
public final class BrowserLayout {

    private final String html;
    private final BrowserType type;
    private final URL url;

    public BrowserLayout(final String html,
                         final BrowserType type,
                         final String url) {
        Objects.requireNonNull(html, "Browser layout HTML cannot be null");
        this.html = html;
        Objects.requireNonNull(type, "Browser layout type cannot be null");
        this.type = type;
        Objects.requireNonNull(url, "Browser layout URL cannot be null");
        this.url = UrlHelper.parseUrl(url);
    }

    public String getHtml() {
        return this.html;
    }

    public BrowserType getType() {
        return this.type;
    }

    public URL getUrl() {
        return this.url;
    }
}
