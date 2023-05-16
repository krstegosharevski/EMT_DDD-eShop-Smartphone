package mk.ukim.finki.emt.productcatalog.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.models.Smartphone;
import mk.ukim.finki.emt.productcatalog.domain.repository.ProductRepository;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final ProductRepository productRepository;

    @PostConstruct
    public void initData() {
        Smartphone p1 = Smartphone.build("Nokia", Money.valueOf(Currency.MKD,1500), 10);
        Smartphone p2 = Smartphone.build("Samsung A51", Money.valueOf(Currency.MKD,5000), 5);
        if (productRepository.findAll().isEmpty()) {
            productRepository.saveAll(Arrays.asList(p1,p2));
        }
    }
}
