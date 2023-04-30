package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Input;
import uz.pdp.appwarehouse.entity.InputProduct;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.payload.InputProductDTO;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.repository.InputProductRepository;
import uz.pdp.appwarehouse.repository.InputRepository;
import uz.pdp.appwarehouse.repository.ProductRepository;

import java.util.Optional;

@Service
public class InputProductService {
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;
    public ResultMessage addInputProduct(InputProductDTO inputProductDTO) {
        InputProduct inputProduct = new InputProduct();

        Optional<Product> optionalProduct = productRepository.findById(inputProductDTO.getProductId());
        if (optionalProduct.isEmpty()) return new ResultMessage(false,"Product not found");
        Product product = optionalProduct.get();

        Optional<Input> inputOptional = inputRepository.findById(inputProductDTO.getInputId());
        if (inputOptional.isEmpty()) return new ResultMessage(false,"Product not found");
        Input input = inputOptional.get();

        inputProduct.setProduct(product);
        inputProduct.setAmount(inputProductDTO.getAmount());
        inputProduct.setPrice(inputProductDTO.getPrice());
        inputProduct.setExpireDate(inputProductDTO.getExpireDate());
        inputProduct.setInput(input);

        inputProductRepository.save(inputProduct);
        return new ResultMessage(true,"Successfully input product saved");
    }
}
