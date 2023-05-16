package mk.ukim.finki.emt.productcatalog.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.productcatalog.domain.models.Smartphone;
import mk.ukim.finki.emt.productcatalog.domain.models.SmartphoneId;
import mk.ukim.finki.emt.productcatalog.domain.repository.ProductRepository;
import mk.ukim.finki.emt.productcatalog.services.ProductService;
import mk.ukim.finki.emt.productcatalog.services.form.ProductForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Smartphone findById(SmartphoneId id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Smartphone createProduct(ProductForm form) {
        Smartphone p = Smartphone.build(form.getProductName(),form.getPrice(),form.getSales());
        productRepository.save(p);
        return p;
    }

    @Override
    public Smartphone orderItemCreated(SmartphoneId smartphoneId, int quantity) {
        Smartphone p = productRepository.findById(smartphoneId).orElseThrow(ProductNotFoundException::new);
        p.addSales(quantity);
        productRepository.saveAndFlush(p);
        return p;
    }

    @Override
    public Smartphone orderItemRemoved(SmartphoneId smartphoneId, int quantity) {
        Smartphone p = productRepository.findById(smartphoneId).orElseThrow(ProductNotFoundException::new);
        p.removeSales(quantity);
        productRepository.saveAndFlush(p);
        return p;
    }

    @Override
    public List<Smartphone> getAll() {
        return productRepository.findAll();
    }
}
