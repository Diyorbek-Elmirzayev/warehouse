package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.service.MeasurementService;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;
    @PostMapping
    public ResultMessage addMeasurement(@RequestBody Measurement measurement){
       return measurementService.addMeasurement(measurement);
    }
}
