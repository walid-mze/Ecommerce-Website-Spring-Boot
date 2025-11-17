package com.khomsi.site_project;

import com.khomsi.site_project.entity.Category;
import com.khomsi.site_project.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {
	"spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration"
})
public class CategoryRepoTest {
    @Autowired
    private CategoryRepository categoryRep;

    @Test
    void testListEnabledCategories() {
        List<Category> categories = categoryRep.findAllEnabled();

        categories.forEach(category -> {
            System.out.println(category.getTitle() + " (" + category.getEnabled() + ")");
        });
    }

    @Test
    void categoryFindByAlias() {
        String alias = "protectors";

        Category category = categoryRep.findByAliasEnabled(alias);

        assertThat(category).isNotNull();

    }

    @Test
    void testListRootCategories(){
        List<Category> categories = categoryRep.findRootCategories();
        categories.forEach(category -> System.out.println(category.getTitle()));
    }
}
