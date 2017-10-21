package com.timpamungkas.kafka;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
		List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
		list.forEach(i -> kafkaProducer.send("test.t", "payload " + i));
	}
}
