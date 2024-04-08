package ee419.server.security;

import com.fasterxml.jackson.databind.ObjectMapper;

import ee419.server.utils.ResultVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        
        ResultVo<Object> result = new ResultVo<>();
        result.setCode(HttpServletResponse.SC_UNAUTHORIZED);
        result.setMessage("Unauthorized: Access is denied due to invalid credentials.");
        result.setData(null); 
        byte[] body = new ObjectMapper().writeValueAsBytes(result);
        response.getOutputStream().write(body);
    }
}

