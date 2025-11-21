package com.talks.springmodulith.modularity;

import com.talks.springmodulith.SpringModulithApplication;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

/**
 * Verifies the basic modular integrity and generates simple documentation.
 */
class ArchitectureVerificationTests {

  @Test
  void verify_modules_and_generate_docs() {
    ApplicationModules modules = ApplicationModules.of(SpringModulithApplication.class);

    // fails if module boundaries are violated (dependencies not allowed, non-exposed types, cycles, etc.)
    modules.verify();

    // generate simple docs to build/docs/spring-modulith
    new Documenter(SpringModulithApplication.class).writeDocumentation();
  }
}
