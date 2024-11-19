package org.example.movies;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "password"; // Replace with the desired password
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
    }
}
