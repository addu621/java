package com.example.cars;

import com.example.cars.services.AdminService;
import com.example.cars.services.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class CarsApplication {
	@Autowired
	private AdminService adminService;

	public static void main(String[] args) { SpringApplication.run(CarsApplication.class, args); }

	@EventListener(ApplicationReadyEvent.class)
	public void createAdmins() {
		adminService.createAdmins();
	}

}
