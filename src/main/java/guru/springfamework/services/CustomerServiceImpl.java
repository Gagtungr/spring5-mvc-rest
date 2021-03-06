package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerServiceImpl(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<CustomerDTO> getAllCustomers() {
        return repository.findAll()
                .stream()
                .map(customer -> {
                        CustomerDTO customerDTO = mapper.customerToCustomerDTO(customer);
                        customerDTO.setCustomerUrl("/api/v1/customer/" + customer.getId());
                        return  customerDTO;})
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return mapper.customerToCustomerDTO(repository.getCustomerById(id));
    }
}
