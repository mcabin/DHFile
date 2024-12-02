package api.DHFile.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.DHFile.Controller.Request.AuthenticationRequest;
import api.DHFile.Controller.Request.RegisterRequest;
import api.DHFile.Controller.Response.AuthenticationResponse;
import api.DHFile.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(
        @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }
    
    @PostMapping("log")
    public ResponseEntity<AuthenticationResponse> log(
        @RequestBody AuthenticationRequest request) {
            return ResponseEntity.ok(service.authenticate(request));
    }
}
