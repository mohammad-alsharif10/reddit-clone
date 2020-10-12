package com.clone.reddit.service;

import com.clone.reddit.database.UserRepository;
import com.clone.reddit.database.VerificationTokenRepository;
import com.clone.reddit.dto.RegisterRequest;
import com.clone.reddit.model.NotificationEmail;
import com.clone.reddit.model.User;
import com.clone.reddit.model.VerificationToken;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.annotation.Transient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;
    private VerificationTokenRepository verificationTokenRepository;
    private MailService mailService;

    @SneakyThrows
    @Transient
    public void signup(RegisterRequest registerRequest) {
        User user = User.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(registerRequest.getPassword()))
                .created(Instant.now())
                .enabled(false)
                .build();
        userRepository.save(user);
        VerificationToken verificationToken = generateVerificationToken(user);
        mailService.sendMail(NotificationEmail.builder()
                .body("Activate your Account")
                .recipient(user.getEmail())
                .subject("Thank you for signing up to Spring Reddit, " +
                        "please click on the below url to activate your account : " +
                        "http://localhost:8080/api/auth/accountVerification/" + verificationToken.getToken())
                .build());
    }

    private VerificationToken generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = VerificationToken.builder()
                .user(user)
                .token(token)
                .build();
        return verificationTokenRepository.save(verificationToken);
    }


}
