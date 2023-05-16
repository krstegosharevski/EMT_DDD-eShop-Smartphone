package mk.ukim.finki.emt.productcatalog.services;

import mk.ukim.finki.emt.productcatalog.domain.models.Smartphone;
import mk.ukim.finki.emt.productcatalog.domain.models.SmartphoneId;
import mk.ukim.finki.emt.productcatalog.services.form.ProductForm;

import java.util.List;

public interface ProductService {

    Smartphone findById(SmartphoneId id);
    Smartphone createProduct(ProductForm form);
    Smartphone orderItemCreated(SmartphoneId smartphoneId, int quantity);
    Smartphone orderItemRemoved(SmartphoneId smartphoneId, int quantity);
    List<Smartphone> getAll();

}
