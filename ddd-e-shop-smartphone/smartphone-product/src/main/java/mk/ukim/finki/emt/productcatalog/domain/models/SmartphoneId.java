package mk.ukim.finki.emt.productcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class SmartphoneId extends DomainObjectId {

    private SmartphoneId() {
        super(SmartphoneId.randomId(SmartphoneId.class).getId());
    }

    public SmartphoneId(@NonNull String uuid) {
        super(uuid);
    }

    public static SmartphoneId of(String uuid) {
        SmartphoneId p = new SmartphoneId(uuid);
        return p;
    }

}
