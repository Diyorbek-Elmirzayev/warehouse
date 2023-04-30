package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;
    @PostMapping
    public ResultMessage addCurrency(@RequestBody Currency currency){
        return currencyService.add(currency);
    }
    @GetMapping
    public List<Currency> getCurrencies(){
        return currencyService.get();
    }
    @GetMapping("/{id}")
    public ResultMessage getCurrencyById(@PathVariable Integer id){
        return currencyService.getById(id);
    }
}
