package com.example.Task_Manager.util;

public class TokenUtil {

    public static String generateToken(String username) {
        return username + "_token";
    }
    public static String validateToken(String token) {
        if (token != null && token.endsWith("_token")) {
            return token.replace("_token", "");
        }
        return null;
    }
}