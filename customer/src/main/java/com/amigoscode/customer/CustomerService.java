package com.amigoscode.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {

    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();

        customerRepository.saveAndFlush(customer);
        //todo check if email valid
        // todo check if email not taken

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }

    }

}

