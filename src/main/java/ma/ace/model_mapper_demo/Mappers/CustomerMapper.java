package ma.ace.model_mapper_demo.Mappers;


import ma.ace.model_mapper_demo.Dtos.CustomerDTO;
import ma.ace.model_mapper_demo.Dtos.CustomerDtoNew;
import ma.ace.model_mapper_demo.Entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private ModelMapper mapper=new ModelMapper();
    public CustomerDTO fromCustomer(Customer customer){
        return this.mapper.map(customer, CustomerDTO.class);
    }

    // New method to map from Customer to CustomerDtoNew
    public CustomerDtoNew fromCustomerToDtoNew(Customer customer) {
        return this.mapper.map(customer, CustomerDtoNew.class);
    }
    // New method to map from CustomerDtoNew to Customer
    public Customer toCustomerFromDtoNew(CustomerDtoNew customerDtoNew) {
        return this.mapper.map(customerDtoNew, Customer.class);
    }
}
