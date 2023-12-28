package org.example.service;

import lombok.AllArgsConstructor;
import org.example.entity.AuthRequest;
import org.example.entity.AuthResponce;
import org.example.entity.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class AuthService {

    private final RestTemplate restTemplate;
    private final JwtUtil jwtUtil;

    public AuthResponce register(AuthRequest request) {
        request.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        User user = restTemplate.postForObject("http://user-service/user", request, User.class);

        String accessToken = jwtUtil.generate(user.getId(), user.getRole(), "access");
        String refreshToken = jwtUtil.generate(user.getId(), user.getRole(), "refresh");

        return new AuthResponce(accessToken, refreshToken);
    }
}
