package com.aljounaidy.iampod;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

    @Autowired
    private VersionService versionService;

    @GetMapping("/api")
    public Map<String, String> home() throws UnknownHostException {
        String osName = System.getProperty("os.name");
        String hostName = InetAddress.getLocalHost().getHostName();

        double cpuUsage = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
        String currentLoad = String.format("%.2f", cpuUsage);

        Map<String, String> response = new HashMap<>();
        response.put("osName", osName);
        response.put("ip", InetAddress.getLocalHost().getHostAddress());
        response.put("hostname", hostName);
        response.put("currentLoad", currentLoad + "%");
        response.put("version", versionService.getVersion());

        return response;
    }
}
