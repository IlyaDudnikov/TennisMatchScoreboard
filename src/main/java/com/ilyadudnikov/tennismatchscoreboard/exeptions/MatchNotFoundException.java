package com.ilyadudnikov.tennismatchscoreboard.exeptions;

public class MatchNotFoundException extends RuntimeException {
    public MatchNotFoundException(String message) {
        super(message);
    }
}
