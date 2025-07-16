
package com.thealgorithms.api_tests.Country;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
// import com.intuit.karate.http.HttpServer;
// import com.intuit.karate.http.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryTest {

	@Test
	void testAll() {
		String URLBASE = System.getenv().get("URL_BASE");
		String AUTHTOKEN = System.getenv().get("AUTH_TOKEN");
		Results results = Runner.path("src/test/java/com/thealgorithms/api_tests/Country")
			.systemProperty("URL_BASE", URLBASE)
			.systemProperty("AUTH_TOKEN", AUTHTOKEN)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
