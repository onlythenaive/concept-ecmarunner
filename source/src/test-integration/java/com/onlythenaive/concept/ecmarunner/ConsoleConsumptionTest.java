package com.onlythenaive.concept.ecmarunner;

import org.junit.Before;
import org.junit.Test;

import com.onlythenaive.concept.ecmarunner.api.ResultValueType;
import com.onlythenaive.concept.ecmarunner.common.GenericIntegrationTest;
import com.onlythenaive.concept.ecmarunner.convention.IntegrationTest;

@IntegrationTest
public class ConsoleConsumptionTest extends GenericIntegrationTest {

    @Before
    public void prepare() {
        resetSandbox();
    }

    @Test
    public void accessExecutionLogRecords() {
        execute("for (var i = 0; i < 5; i++) { console.log(i) }");
        assertLogSize(5);
        assertLogRecord(0, "0.0");
        assertLogRecord(1, "1.0");
        assertLogRecord(2, "2.0");
        assertLogRecord(3, "3.0");
        assertLogRecord(4, "4.0");
        assertTerminationSuccess();
        assertValue(null);
        assertValueType(ResultValueType.UNDEFINED);
    }
}
