package ee419.server.service;

import ee419.server.model.Role;
import ee419.server.model.User;
import ee419.server.payload.request.LoginRequest;
import ee419.server.payload.request.SignupRequest;
import ee419.server.repository.RoleRepository;
import ee419.server.repository.UserRepository;
import ee419.server.security.CustomUserDetails;
import ee419.server.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void registerUser(SignupRequest signUpRequest) {
        if (!StringUtils.hasText(signUpRequest.getUsername()) || !StringUtils.hasText(signUpRequest.getPassword()) || !StringUtils.hasText(signUpRequest.getRole())) {
            throw new IllegalArgumentException("Username, password, and role are required.");
        }

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new IllegalArgumentException("Error: Username is already taken!");
        }

        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        
        String strRole = signUpRequest.getRole();
        Role role = roleRepository.findByName(strRole)
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName(strRole);
                    return roleRepository.save(newRole);
                });

        user.setRole(role);
        userRepository.save(user);
    }

    public String authenticateUser(LoginRequest loginRequest) {
        if (!StringUtils.hasText(loginRequest.getUsername()) || !StringUtils.hasText(loginRequest.getPassword())) {
            throw new IllegalArgumentException("Username and password are required.");
        }

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            
            String username = ((CustomUserDetails) authentication.getPrincipal()).getUsername();

            String token = jwtUtil.generateToken(username);
            return token;
        } catch (AuthenticationException e) {
            throw new IllegalArgumentException("Authentication failed for user: " + loginRequest.getUsername());
        }
    }
}
