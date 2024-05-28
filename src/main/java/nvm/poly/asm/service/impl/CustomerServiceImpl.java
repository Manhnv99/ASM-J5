package nvm.poly.asm.service.impl;

import nvm.poly.asm.entity.Customer;
import nvm.poly.asm.model.request.CustomerRequest;
import nvm.poly.asm.repository.CustomerRepository;
import nvm.poly.asm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> getAllByPage(int page) {
        Pageable pageable = PageRequest.of(page - 1, 7);
        return customerRepository.getAllByPage(pageable);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public String update(CustomerRequest request, Long id) {
        customerRepository.save(Customer.builder()
                .id(id)
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .build());
        return null;
    }
}
