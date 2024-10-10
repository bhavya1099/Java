
  package com.thealgorithms.api_tests;

  import com.intuit.karate.Results;
  import com.intuit.karate.Runner;
  // import com.intuit.karate.http.HttpServer;
  // import com.intuit.karate.http.ServerConfig;
  import org.junit.jupiter.api.Test;

  import static org.junit.jupiter.api.Assertions.assertEquals;

  class ServiceActivationAndConfigurationV1Test {

      @Test
      void testAll() {
          String apiHostServer = System.getenv().getOrDefault("iout_URL_BASE", "http://localhost:4010");
String ioutauthtoken = System.getenv().getOrDefault("iout_AUTH_TOKEN", "dummy_iout_AUTH_TOKEN");
String apiHostServer = System.getenv().getOrDefault("iout_URL_BASE", "http://localhost:4010");
String ioutauthtoken = System.getenv().getOrDefault("iout_AUTH_TOKEN", "dummy_iout_AUTH_TOKEN");
          Results results = Runner.path("src/test/java/com/thealgorithms/api_tests/ServiceActivationAndConfigurationV1")
                  .systemProperty("iout_URL_BASE", apiHostServer)
.systemProperty("iout_AUTH_TOKEN", ioutauthtoken)
.systemProperty("iout_URL_BASE", apiHostServer)
.systemProperty("iout_AUTH_TOKEN", ioutauthtoken)
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
