package com.aljounaidy.iampod;

import org.springframework.stereotype.Service;

@Service
public class VersionService {

    private String version = "6.1";

    public String getVersion() {
        return version;
    }
}
