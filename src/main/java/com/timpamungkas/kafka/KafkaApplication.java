package com.timpamungkas.kafka;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.timpamungkas.kafka.model.Person;
import com.timpamungkas.kafka.producer.KafkaProducer;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	@Autowired
	private KafkaProducer kafkaProducer;

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Producer: " + kafkaProducer);

		// IntStream.rangeClosed(5, 10).boxed().collect(Collectors.toList())
		// .forEach(i -> kafkaProducer.send("test.t", "payload " + i));

		kafkaProducer.send("test.t", new Person("Timotius" + ThreadLocalRandom.current().nextInt(100), "Serpong"));
	}
}
