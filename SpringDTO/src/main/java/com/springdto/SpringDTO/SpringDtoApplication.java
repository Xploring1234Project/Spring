package com.springdto.SpringDTO;

import com.springdto.SpringDTO.dto.UserLocationDTO;
import com.springdto.SpringDTO.model.Location;
import com.springdto.SpringDTO.model.User;
import com.springdto.SpringDTO.repository.LocationRepository;
import com.springdto.SpringDTO.repository.UserRepository;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDtoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDtoApplication.class, args);
	}



	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception {

		Location location = new Location();
		location.setPlace("Chennai");
		location.setDecription("Its a good place");
		location.setLongitude(45.3);
		location.setLatitude(31.2);

		locationRepository.save(location);

		User user = new User();
		user.setFirstName("Harsha");
		user.setLastName("Vardhan");
		user.setEmail("harsha@gmail.com");
		user.setPassword("password");
		user.setLocation(location);
		userRepository.save(user);
	}
}
