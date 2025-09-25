package com.meggalord.expense_collector;

import org.springframework.boot.SpringApplication;

public class TestExpenseCollectorApplication {

	public static void main(String[] args) {
		SpringApplication.from(ExpenseCollectorApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
