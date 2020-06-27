package com.codeforce.product;

import com.codeforce.product.repo.StateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductApplicationTests {

    @Autowired
    StateRepository stateRepository;
    @Test
    void contextLoads() {
        assert(stateRepository!=null);
    }

}
