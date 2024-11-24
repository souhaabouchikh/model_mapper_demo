package ma.ace.model_mapper_demo;

import ma.ace.model_mapper_demo.Dtos.CustomerDTO;
import ma.ace.model_mapper_demo.Dtos.CustomerDtoNew;
import ma.ace.model_mapper_demo.Entities.Customer;
import ma.ace.model_mapper_demo.Mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ModelMapperDemoApplication {
	@Autowired
	private CustomerMapper customerMapper;

	public static void main(String[] args) {
		SpringApplication.run(ModelMapperDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner start() {
		return args -> {
			// 2. Create 3 customers using the builder
			Customer customer1 = Customer.builder().id(1L).name("John Doe").email("john.doe@example.com").password("password123").build();
			Customer customer2 = Customer.builder().id(2L).name("Jane Smith").email("jane.smith@example.com").password("password456").build();
			Customer customer3 = Customer.builder().id(3L).name("Sam Wilson").email("sam.wilson@example.com").password("password789").build();

			// 3. Add the customers to a list
			List<Customer> customers = List.of(customer1, customer2, customer3);

			// 4. Transform customers to CustomerDTOs using CustomerMapper
			List<CustomerDTO> customerDTOs = customers.stream()
					.map(customerMapper::fromCustomer)
					.collect(Collectors.toList());

			// 5. Optionally transform customers to CustomerDtoNew
			List<CustomerDtoNew> customerDtoNews = customers.stream()
					.map(customerMapper::fromCustomerToDtoNew)
					.collect(Collectors.toList());

			// Print the CustomerDTOs (Optional, for testing)
			customerDTOs.forEach(System.out::println);
			System.out.println("\n");
			/// Print the CustomerDTOsNew (Optional, for testing)
			customerDtoNews.forEach(System.out::println);
		};
	}
}
