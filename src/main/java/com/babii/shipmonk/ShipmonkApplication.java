package com.babii.shipmonk;

import com.babii.shipmonk.api.SortedLinkedListLibrary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ShipmonkApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShipmonkApplication.class, args);
		final var list = Arrays.stream(args)
				.peek(System.out::println)
				.toList();
		System.out.println("Given elements");

		final var sortedList = new SortedLinkedListLibrary<String>();
		sortedList.sortedLinkedListFrom(list);
		sortedList.printValues();
		System.out.println("Sorted elements");
	}

}
