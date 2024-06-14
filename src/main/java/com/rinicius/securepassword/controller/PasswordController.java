package com.rinicius.securepassword.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rinicius.securepassword.controller.dto.BodyRequest;
import com.rinicius.securepassword.service.PasswordService;

@RestController
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/validate-password")
    public ResponseEntity<List<String>> create(@RequestBody BodyRequest req) {
        var failures = this.passwordService.validatePassword(req.password());

        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(failures);
    }

}
