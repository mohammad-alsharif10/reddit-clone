package com.clone.reddit.service;

import com.clone.reddit.database.RefreshTokenRepository;
import com.clone.reddit.exception.SpringRedditException;
import com.clone.reddit.model.RefreshToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken generateRefreshToken() {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedDate(Instant.now());

        return refreshTokenRepository.save(refreshToken);
    }

    void validateRefreshToken(String token) {
        try {
            refreshTokenRepository.findByToken(token)
                    .orElseThrow(() -> new SpringRedditException("Invalid refresh Token"));
        } catch (SpringRedditException e) {
            e.printStackTrace();
        }
    }

    public void deleteRefreshToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }
}
