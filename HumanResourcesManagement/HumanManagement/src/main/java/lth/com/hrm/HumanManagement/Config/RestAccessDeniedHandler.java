package lth.com.hrm.HumanManagement.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse, AccessDeniedException e)
            throws IOException, ServletException {

        httpServletResponse.setStatus(FORBIDDEN.value());
        Map<String, String> error = new HashMap<>();

        error.put("message", "Bạn không có quyền truy cập !");
        error.put("status", "403");
        httpServletResponse.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(httpServletResponse.getOutputStream(), error);
    }
}
