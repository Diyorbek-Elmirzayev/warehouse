package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Attachment;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.payload.ProductDTO;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.repository.AttachmentRepository;
import uz.pdp.appwarehouse.repository.CategoryRepository;
import uz.pdp.appwarehouse.repository.MeasurementRepository;
import uz.pdp.appwarehouse.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    public ResultMessage addProduct(ProductDTO productDTO) {
        boolean existsByNameAndCategoryId =
                productRepository.existsByNameAndCategoryId(productDTO.getName(), productDTO.getCategoryId());
        if (existsByNameAndCategoryId)
            return new ResultMessage(false, "Product already exist this category");

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setCode("1");

        Optional<Category> optionalCategory = categoryRepository.findById(productDTO.getCategoryId());
        if (optionalCategory.isEmpty())
            return new ResultMessage(false, "Category does not exist ");
        product.setCategory(optionalCategory.get());

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDTO.getMeasurementId());
        if (optionalMeasurement.isEmpty())
            return new ResultMessage(false, "Measurement does not exist");
        product.setMeasurement(optionalMeasurement.get());

        Optional<Attachment> optionalPhoto = attachmentRepository.findById(productDTO.getPhotoId());
        if (optionalPhoto.isEmpty())
            return new ResultMessage(false, "Photo does not exist");
        product.setPhoto(optionalPhoto.get());

        productRepository.save(product);
        return new ResultMessage(true,"Successfully saved product");
    }

}
