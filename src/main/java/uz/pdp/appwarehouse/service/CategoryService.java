package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.payload.CategoryDTO;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.repository.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    public ResultMessage add(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());

        if(categoryDTO.getParentCategoryId()!=null) {
            Optional<Category> categoryOptional =
                    categoryRepository.findById(categoryDTO.getParentCategoryId());
            if (categoryOptional.isEmpty()) {
                return new ResultMessage(false,"Parent Category does not exist");
            }
            category.setParentCategory(categoryOptional.get());
        }
            categoryRepository.save(category);
            return new ResultMessage(true,"successfully saved");

    }
}
