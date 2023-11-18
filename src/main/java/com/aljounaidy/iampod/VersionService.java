package com.aljounaidy.iampod;

import org.springframework.stereotype.Service;

@Service
public class VersionService {

    private String version = "4.7";

    public String getVersion() {
        return version;
    }
}
