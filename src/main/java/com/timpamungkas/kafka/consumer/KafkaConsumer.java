package com.timpamungkas.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	  @KafkaListener(topics = "${kafka.topic.test}")
	  public void receive(String payload) {
	    LOGGER.info("received payload='{}'", payload);
	  }
	
}
