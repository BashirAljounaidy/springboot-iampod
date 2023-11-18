package com.aljounaidy.iampod;

import org.springframework.stereotype.Service;

@Service
public class VersionService {

    private String version = "5.2";

    public String getVersion() {
        return version;
    }
}
