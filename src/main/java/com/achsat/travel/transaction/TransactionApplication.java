package com.achsat.travel.transaction;

import com.achsat.travel.transaction.model.Transaction;
import com.achsat.travel.transaction.service.TransactionService;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.StreamJoined;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.time.Duration;

@SpringBootApplication
public class TransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

	@Bean
	public NewTopic orders() {
		return TopicBuilder.name("transactions")
				.partitions(3)
				.compact()
				.build();
	}

	@Bean
	public NewTopic paymentTopic() {
		return TopicBuilder.name("payment")
				.partitions(3)
				.compact()
				.build();
	}

	@Bean
	public NewTopic stockTopic() {
		return TopicBuilder.name("tourpackage")
				.partitions(3)
				.compact()
				.build();
	}

	@Autowired
	TransactionService transactionService;

	@Bean
	public KStream<Long, Transaction> stream(StreamsBuilder builder) {
		JsonSerde<Transaction> orderSerde = new JsonSerde<>(Transaction.class);
		KStream<Long, Transaction> stream = builder
				.stream("transactions", Consumed.with(Serdes.Long(), orderSerde));

		stream.join(
						builder.stream("tourpackage"),
						transactionService::confirm,
						JoinWindows.of(Duration.ofSeconds(10)),
						StreamJoined.with(Serdes.Long(), orderSerde, orderSerde))
				.peek((k, o) -> LOG.info("Output: {}", o))
				.to("orders");

		return stream;
	}

}
