package com.onlythenaive.concept.ecmarunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.onlythenaive.concept.ecmarunner.convention.AcceptanceTest;
import com.onlythenaive.concept.ecmarunner.common.GenericAcceptanceTest;

@AcceptanceTest
@RunWith(JUnit4.class)
public class InvalidScriptTest extends GenericAcceptanceTest {

    @Test
    public void handleInvalidScriptExecutionAttempt() {
        // TODO: implement this test
        throw new UnsupportedOperationException();
    }
}
