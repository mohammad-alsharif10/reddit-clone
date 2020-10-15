package com.clone.reddit.service;

import com.clone.reddit.database.UserRepository;
import com.clone.reddit.database.VerificationTokenRepository;
import com.clone.reddit.dto.AuthenticationResponse;
import com.clone.reddit.dto.LoginRequest;
import com.clone.reddit.dto.RegisterRequestDto;
import com.clone.reddit.exception.SpringRedditException;
import com.clone.reddit.mapper.UserMapper;
import com.clone.reddit.model.NotificationEmail;
import com.clone.reddit.model.User;
import com.clone.reddit.model.VerificationToken;
import com.clone.reddit.respnse.SingleResultResponse;
import com.clone.reddit.security.JwtProvider;
import com.clone.reddit.utils.Common;
import com.clone.reddit.utils.ResponseKeys;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    private final VerificationTokenRepository verificationTokenRepository;

    private final MailService mailService;

    private final UserMapper userMapper;

    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    private final RefreshTokenService refreshTokenService;

    @SneakyThrows
    @Transactional
    public SingleResultResponse signup(RegisterRequestDto registerRequestDto) {
        User user = User.builder()
                .username(registerRequestDto.getUsername())
                .email(registerRequestDto.getEmail())
                .password(bCryptPasswordEncoder.encode(registerRequestDto.getPassword()))
                .created(Instant.now())
                .enabled(false)
                .build();
        User savedUser = userRepository.save(user);
        VerificationToken verificationToken = generateVerificationToken(user);
        mailService.sendMail(NotificationEmail.builder()
                .body("Activate your Account")
                .recipient(user.getEmail())
                .subject("Thank you for signing up to Spring Reddit, " +
                        "please click on the below url to activate your account : " +
                        "http://localhost:8080/api/auth/accountVerification/" + verificationToken.getToken())
                .build());
        return Common.getSingleResultDto(
                userMapper.toBaseDto(savedUser),
                ResponseKeys.REGISTERED_SUCCESSFULLY,
                false, ResponseKeys.SUCCESS_RESPONSE);
    }


    private VerificationToken generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = VerificationToken.builder()
                .user(user)
                .token(token)
                .build();
        return verificationTokenRepository.save(verificationToken);
    }


    public SingleResultResponse verifyAccount(String token) throws SpringRedditException {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        if (verificationToken.isPresent()) {
            return Common.getSingleResultDto(
                    userMapper.toBaseDto(fetchUserAndEnable(verificationToken.get()))
                    , ResponseKeys.VERIFIED_SUCCESSFULLY
                    , false, ResponseKeys.SUCCESS_RESPONSE);
        }
        return Common.getSingleResultDto
                (null, ResponseKeys.VERIFYING_ERROR, true, ResponseKeys.EXCEPTION_RESPONSE);
    }

    private User fetchUserAndEnable(VerificationToken verificationToken) throws SpringRedditException {
        String username = verificationToken.getUser().getUsername();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new SpringRedditException("User not found with name - " + username));
        user.setEnabled(true);
        return userRepository.save(user);
    }

    public SingleResultResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtProvider.generateToken(authenticate);
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(loginRequest.getUsername())
                .build();
        System.out.println(authenticationResponse);
        return Common.getSingleResultDto(authenticationResponse, ResponseKeys.REGISTERED_SUCCESSFULLY, false, ResponseKeys.SUCCESS_RESPONSE);
    }


}
