package com.aljounaidy.iampod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class IampodApplication {

	public static void main(String[] args) {
		SpringApplication.run(IampodApplication.class, args);
	}

	@GetMapping("/")
	public String home() throws UnknownHostException {
		String osName = System.getProperty("os.name");
		String hostName = InetAddress.getLocalHost().getHostName();

		double cpuUsage = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
		String currentLoad = String.format("%.2f", cpuUsage * 100);

		return "OS Name: " + osName + " || IP: " + InetAddress.getLocalHost().getHostAddress() + " || Hostname: "
				+ hostName + " || Current Load: " + currentLoad + "% version: 1.2.0";
	}
}
