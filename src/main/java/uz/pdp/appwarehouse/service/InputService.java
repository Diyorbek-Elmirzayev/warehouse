package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.entity.Input;
import uz.pdp.appwarehouse.entity.Supplier;
import uz.pdp.appwarehouse.entity.WareHouse;
import uz.pdp.appwarehouse.payload.InputDTO;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.repository.CurrencyRepository;
import uz.pdp.appwarehouse.repository.InputRepository;
import uz.pdp.appwarehouse.repository.SupplierRepository;
import uz.pdp.appwarehouse.repository.WareHouseRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    WareHouseRepository wareHouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    public ResultMessage addInput(InputDTO inputDTO) {
        Input input = new Input();
        input.setDate(Timestamp.valueOf(LocalDateTime.now()));

        Optional<WareHouse> optionalWareHouse = wareHouseRepository.findById(inputDTO.getWarehouseId());
        if (optionalWareHouse.isEmpty()) return new ResultMessage(false,"Warehouse not found");
        WareHouse wareHouse = optionalWareHouse.get();

        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDTO.getSupplierId());
        if (optionalSupplier.isEmpty()) return new ResultMessage(false,"Warehouse not found");
        Supplier supplier = optionalSupplier.get();

        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDTO.getCurrencyId());
        if (optionalCurrency.isEmpty()) return new ResultMessage(false,"Warehouse not found");
        Currency currency = optionalCurrency.get();

        input.setWareHouse(wareHouse);
        input.setSupplier(supplier);
        input.setCurrency(currency);
        input.setFacture_number(code(input.getFacture_number()));
        input.setCode(code(input.getCode()));
        inputRepository.save(input);
        return new ResultMessage(true,"Successfully added");
    }

    private String code(String code) {
        int integer = Integer.parseInt(code);
        return String.valueOf(++integer);
    }
}
