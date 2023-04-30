package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.payload.CategoryDTO;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
   @Autowired
    CategoryService categoryService;
    @PostMapping
    public ResultMessage addCategory(@RequestBody CategoryDTO categoryDTO){
      return   categoryService.add(categoryDTO);
    }
}
