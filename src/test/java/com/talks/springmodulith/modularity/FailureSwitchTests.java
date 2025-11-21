package com.talks.springmodulith.modularity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

/**
 * Intentionally fails when the system property -Ddemo.fail=true is provided.
 * Useful to demonstrate CI failure hooks in the workshop.
 */
class FailureSwitchTests {

  @Test
  @EnabledIfSystemProperty(named = "demo.fail", matches = "true")
  void fail_on_purpose_when_enabled() {
    Assertions.fail("Intentional failure due to -Ddemo.fail=true");
  }
}
