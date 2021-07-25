package com.demo.app.ws.mobileappws.ui.model.util;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utils {
    public String generateUserId() {
        return UUID.randomUUID().toString();
    }
}
