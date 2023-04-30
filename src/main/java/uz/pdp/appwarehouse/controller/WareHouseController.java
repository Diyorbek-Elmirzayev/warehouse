package uz.pdp.appwarehouse.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.WareHouse;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.payload.WarehouseDTO;
import uz.pdp.appwarehouse.service.WareHouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WareHouseController {
    @Autowired
    WareHouseService wareHouseService;

    @PostMapping
    public ResultMessage addWarehouse(@RequestBody WarehouseDTO warehouseDTO){
        return wareHouseService.add(warehouseDTO);
    }
    @GetMapping
    public List<WareHouse> getWarehouses(){
        return wareHouseService.get();
    }

}
