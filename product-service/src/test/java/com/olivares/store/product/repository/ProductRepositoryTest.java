package com.olivares.store.product.repository;

import com.olivares.store.product.entity.Category;
import com.olivares.store.product.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository mockProductRepository;

    @Autowired
    CategoryRepository mockCategoryRepository;

    @BeforeEach
    public void setUp() {
        Category category = Category.builder().id(1L).name("test").build();
        mockCategoryRepository.save(category);
    }

    @Test
    public void whenFindByCategory_thenReturnListProduct() {
        Product product01 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .createAt(new Date()).build();
        mockProductRepository.save(product01);

        List<Product> founds = mockProductRepository.findByCategory(product01.getCategory());

        Assertions.assertThat(founds.size()).isEqualTo(3);
    }

}