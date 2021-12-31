package com.alok.services;

import com.alok.domain.Product;
import com.alok.repositories.ProductRepository;
import com.alok.services.jms.JmsTextMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.IteratorUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor (onConstructor = @__ (@Autowired))
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final JmsTextMessageService jmsTextMessageService;


    @Override
    public Product getProduct(Integer id) {
        jmsTextMessageService.sendTextMessage("Fetching Product ID: " + id );
        return Optional.ofNullable(productRepository.findById(id))
                .orElseThrow(()-> new RuntimeException("product not found for id "+ id)).get();
    }

    @Override
    public List<Product> listProducts() {
        jmsTextMessageService.sendTextMessage("Listing Products");
        return IteratorUtils.toList(productRepository.findAll().iterator());
    }
}
