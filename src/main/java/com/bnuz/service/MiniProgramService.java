package com.bnuz.service;

public interface MiniProgramService {
    String getAcessToken();

    String getMiniProgramActivityQRCode(String accessToken, String acid);
}