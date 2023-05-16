package mk.ukim.finki.emt.productcatalog.domain.repository;

import mk.ukim.finki.emt.productcatalog.domain.models.Smartphone;
import mk.ukim.finki.emt.productcatalog.domain.models.SmartphoneId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Smartphone, SmartphoneId> {
}
