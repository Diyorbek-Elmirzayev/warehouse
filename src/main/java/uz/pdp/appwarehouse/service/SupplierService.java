package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Supplier;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.payload.SupplierDTO;
import uz.pdp.appwarehouse.repository.SupplierRepository;
@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public ResultMessage add(SupplierDTO supplierDTO) {
        boolean exists = supplierRepository.existsByPhoneNumber(supplierDTO.getPhoneNumber());
        if (exists) {
            return new ResultMessage(false,"Supplier already exists");
        }
        Supplier supplier = new Supplier();
        supplier.setName(supplierDTO.getName());
        supplier.setPhoneNumber(supplierDTO.getPhoneNumber());
        supplierRepository.save(supplier);
        return new ResultMessage(true,"Supplier added");
    }
}
