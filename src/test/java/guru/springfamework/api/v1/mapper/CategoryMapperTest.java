package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class CategoryMapperTest {

    public static final String VEGGY = "Veggy";
    public static final Long ID = 1L;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCategoryMapper() {

        Category veggy = new Category(ID, VEGGY);

        CategoryDTO veggyDTO = CategoryMapper.INSTANCE.categoryToCategoryDTO(veggy);

        assertEquals(ID, veggyDTO.getId());
        assertEquals(VEGGY, veggyDTO.getName());

    }
}