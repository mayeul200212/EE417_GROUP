package ee419.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

@RestController
public class EnvController {

  @Value("${TEST_VAR_ENV:Variable not set}")
  private String testVarEnv;

  @GetMapping("/api/env")
  public ResponseEntity<String> getEnv() {

    return ResponseEntity.ok().body(testVarEnv);
  }
}
