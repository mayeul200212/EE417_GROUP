package ee419.server.controller;

import ee419.server.payload.request.LoginRequest;
import ee419.server.payload.request.SignupRequest;
import ee419.server.service.AuthService;
import ee419.server.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/auth/signup")
    public ResponseEntity<ResultVo<Boolean>> registerUser(@RequestBody SignupRequest signUpRequest) {
        try {
            authService.registerUser(signUpRequest);
            return ResponseEntity.ok(ResultVo.success("User registered successfully!", true));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(ResultVo.error(400, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResultVo.error(400, "An unexpected error occurred"));
        }
    }

    @PostMapping("/auth/signin")
    public ResponseEntity<ResultVo<String>> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            String jwt = authService.authenticateUser(loginRequest);
            return ResponseEntity.ok(ResultVo.success("User successfully signed in!", jwt));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(ResultVo.error(400, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResultVo.error(400, "An unexpected error occurred"));
        }
    }
}
