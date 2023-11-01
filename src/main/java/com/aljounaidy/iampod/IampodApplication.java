package com.aljounaidy.iampod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class IampodApplication {

    public static void main(String[] args) {
        SpringApplication.run(IampodApplication.class, args);
    }

    @GetMapping("/")
    public Map<String, String> home() throws UnknownHostException {
        // Edit version
        String version = "2.0";
        String osName = System.getProperty("os.name");
        String hostName = InetAddress.getLocalHost().getHostName();

        double cpuUsage = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
        String currentLoad = String.format("%.2f", cpuUsage);

        Map<String, String> response = new HashMap<>();
        response.put("osName", osName);
        response.put("ip", InetAddress.getLocalHost().getHostAddress());
        response.put("hostname", hostName);
        response.put("currentLoad", currentLoad + "%");
        response.put("version", version);

        return response;
    }
}
