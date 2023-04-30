package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appwarehouse.payload.InputDTO;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.service.InputService;

@RestController
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputService inputService;

    @PostMapping
    public ResultMessage addInput(@RequestBody InputDTO inputDTO){
        return inputService.addInput(inputDTO);
    }
}
