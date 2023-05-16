package mk.ukim.finki.emt.productcatalog.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;

@Entity
@Table(name="smartphone_product")
@Getter
public class Smartphone extends AbstractEntity<SmartphoneId> {

    private String productName;

    private int sales = 0;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    @Embedded
    private Money price;

    private Smartphone() {
        super(SmartphoneId.randomId(SmartphoneId.class));
    }

    public static Smartphone build(String productName, Money price, int sales) {
        Smartphone p = new Smartphone();
        p.price = price;
        p.productName = productName;
        p.sales = sales;
        return p;
    }

    public void addSales(int qty) {
        this.sales = this.sales - qty;
    }

    public void removeSales(int qty) {
        this.sales -= qty;
    }
}
