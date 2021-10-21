package ru.unit_techno.car_entry_control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.unit_techno.car_entry_control.entity.RfidLabel;
import ru.unit_techno.car_entry_control.repository.RfidLabelRepository;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;

@EnableScheduling
@EnableFeignClients(basePackages =
		{"ru.unit.techno.device.registration.api",
		"ru.unit.techno.ariss.barrier.api"})
@EnableDiscoveryClient
@EntityScan(basePackages =
		{
				//todo release 2.0
//				"ru.unit_techno.user.model.impl.entity",
//		"ru.unit_techno.user.model.impl.entity.enums",
				"ru.unit_techno.car_entry_control.entity",
				"ru.unit_techno.car_entry_control.entity.enums",
				"ru.unit.techno.ariss.log.action.lib.entity"})
@SpringBootApplication
@EnableJpaRepositories(basePackages = {
		//todo release 2.0
		//"ru.unit_techno.user.model.impl.repository",

		"ru.unit_techno.car_entry_control.repository",
		"ru.unit.techno.ariss.log.action.lib.repository"})
public class CarEntryControlApplication {

	@Autowired
	RfidLabelRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CarEntryControlApplication.class, args);
	}


	@PostConstruct
	public void init() {
		repository.save(
				new RfidLabel()
						.setRfidLabelValue(123L)
						.setCreationDate(new Timestamp(Calendar.getInstance().getTimeInMillis()))
						.setBeforeActiveUntil(LocalDate.now())
						.setNoActiveUntil(LocalDate.now().plusMonths(1)));
	}
}
