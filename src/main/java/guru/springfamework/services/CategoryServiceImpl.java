package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CategoryMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository repository) {
        this.categoryMapper = categoryMapper;
        this.repository = repository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return repository.findAll().stream()
                .map(c -> categoryMapper.categoryToCategoryDTO(c))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDTO(repository.findByName(name));
    }
}
