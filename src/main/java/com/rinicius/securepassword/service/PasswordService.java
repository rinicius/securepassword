package com.rinicius.securepassword.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;

@Service
public class PasswordService {

    public List<String> validatePassword(String password) {

        List<String> failures = new ArrayList<>();

        if (StringUtils.isBlank(password) || password.length() < 8) {
            failures.add("Senha necessita de pelo menos 8 caracteres.");
        }
        if (!Pattern.matches(".*[A-Z].*", password)) {
            failures.add("Senha necessita de pelo menos 1 letra maiúscula.");
        }
        if (!Pattern.matches(".*[a-z].*", password)) {
            failures.add("Senha necessita de pelo menos 1 letra minúscula.");
        }
        if (!Pattern.matches(".*\\d.*", password)) {
            failures.add("Senha necessita de pelo menos 1 número.");
        }
        if (!Pattern.matches(".*[\\W].*", password)) {
            failures.add("Senha necessita de pelo menos 1 caractere especial.");
        }

        return failures;
    }
}
