package com.clone.reddit.controller;

import com.clone.reddit.dto.LoginRequest;
import com.clone.reddit.dto.RegisterRequestDto;
import com.clone.reddit.exception.SpringRedditException;
import com.clone.reddit.respnse.SingleResultDto;
import com.clone.reddit.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public SingleResultDto signup(@RequestBody RegisterRequestDto registerRequestDto) {
        return authService.signup(registerRequestDto);

    }

    @RequestMapping(value = "accountVerification/{token}", method = RequestMethod.GET)
    public ResponseEntity<String> verifyAccount(@PathVariable String token) throws SpringRedditException {
        SingleResultDto singleResultDto = authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public SingleResultDto login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

}
