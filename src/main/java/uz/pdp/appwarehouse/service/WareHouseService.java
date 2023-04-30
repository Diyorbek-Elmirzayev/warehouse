package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.WareHouse;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.payload.WarehouseDTO;
import uz.pdp.appwarehouse.repository.WareHouseRepository;

import java.util.List;

@Service
public class WareHouseService {
    @Autowired
    WareHouseRepository wareHouseRepository;

    public ResultMessage add(WarehouseDTO warehouseDTO) {
       boolean exists = wareHouseRepository.existsByName(warehouseDTO.getName());
        if (exists) {
            return new ResultMessage(false,"Warehouse already exist");
        }
        WareHouse wareHouse = new WareHouse();
        wareHouse.setName(warehouseDTO.getName());
        wareHouseRepository.save(wareHouse);
        return new ResultMessage(true,"Warehouse added");
    }

    public List<WareHouse> get() {
        return wareHouseRepository.findAll();
    }
}
