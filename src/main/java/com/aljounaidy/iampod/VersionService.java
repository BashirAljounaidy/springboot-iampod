package com.aljounaidy.iampod;

import org.springframework.stereotype.Service;

@Service
public class VersionService {

    private String version = "v12";

    public String getVersion() {
        return version;
    }
}
