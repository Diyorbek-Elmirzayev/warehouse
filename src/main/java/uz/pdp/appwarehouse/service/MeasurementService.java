package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.repository.MeasurementRepository;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    public ResultMessage addMeasurement(Measurement measurement){
      boolean isName=  measurementRepository.existsByName(measurement.getName());
      if(isName) return new ResultMessage(false, "Measurement already exist");
      measurementRepository.save(measurement);
      return new ResultMessage(true,"Saved");
    }


}
