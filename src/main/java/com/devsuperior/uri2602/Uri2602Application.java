package com.devsuperior.uri2602;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repository.CustomerRepository;

@SpringBootApplication
public class Uri2602Application  implements CommandLineRunner{

	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		List<CustomerMinProjection> result = repository.search1("mg");
		List<CustomerMinDTO> resultDto = result.stream().map(x -> new CustomerMinDTO(x)).toList();
		
		System.out.println("\n*** SQL RAIZ");
		for(CustomerMinDTO dto : resultDto) {
			System.out.println(dto.getName());
		}
		System.out.println("\n\n");
		
		List<CustomerMinDTO> result2 = repository.search2("mg");
	
		
		System.out.println("\n*** JPQL");
		for(CustomerMinDTO dto : result2) {
			System.out.println(dto.getName());
		}
		
	}
}
