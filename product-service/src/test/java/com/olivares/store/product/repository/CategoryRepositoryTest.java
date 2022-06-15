package com.olivares.store.product.repository;

import com.olivares.store.product.entity.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository mockCategoryRepository;

    @Test
    public void should_test() {
        Category category = Category.builder()
                .name("test")
                .build();

        mockCategoryRepository.save(category);

        List<Category> categories = mockCategoryRepository.findAll();

        Assertions.assertThat(categories.size()).isEqualTo(4);
    }
}