package guru.springframework.bootstrap;

//import guru.springframework.domain.Admin;
import guru.springframework.domain.Product;
//import guru.springframework.repositories.AdminRepository;
import guru.springframework.repositories.ProductRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;
   // private AdminRepository adminRepository;

    private Logger log = LogManager.getLogger(ProductLoader.class);


//    @Autowired
//    public void setAdminRepository(AdminRepository adminRepository){
//        this.adminRepository=adminRepository;
//    }
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        Admin color=new Admin();
//        color.setPrice(new BigDecimal(4));

        Product shirt = new Product();
        shirt.setPrice(new BigDecimal("4"));
        shirt.setProductId("Боядисване");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
     //   mug.setDescription("Шпакловане1");
//        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("Шпакловане2");
        mug.setPrice(new BigDecimal("5"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
    }
}
