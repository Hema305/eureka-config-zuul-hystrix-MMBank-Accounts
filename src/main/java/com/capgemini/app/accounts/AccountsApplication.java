package com.capgemini.app.accounts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;

import com.capgemini.app.accounts.bankaccounts.CurrentAccount;
import com.capgemini.app.accounts.bankaccounts.SavingsAccount;
import com.capgemini.app.accounts.repository.AccountRepository;
@EnableDiscoveryClient
@SpringBootApplication
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

	
	@Bean

	public CommandLineRunner createAccount(AccountRepository repo)
	{
		return (arg) ->{
		repo.save(new SavingsAccount(101, "Hema", 34000.0, true));
		repo.save(new SavingsAccount(102, "Krishna", 78000.0, false));
		repo.save(new SavingsAccount(103, "Latha", 56000.0, true));
		repo.save(new CurrentAccount(104, "Jaffer", 56980.0, 6000.0));
		repo.save(new CurrentAccount(105, "Klayan", 56777.0, 10000.0));
		};
	
	}
}

