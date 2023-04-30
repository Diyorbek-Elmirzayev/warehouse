package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appwarehouse.payload.InputProductDTO;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.service.InputProductService;

@RestController
@RequestMapping("/inputProduct")
public class InputProductController {
    @Autowired
    InputProductService inputProductService;
    @PostMapping
    public ResultMessage addInputProduct(@RequestBody InputProductDTO inputProductDTO){
        return inputProductService.addInputProduct(inputProductDTO);
    }
}
