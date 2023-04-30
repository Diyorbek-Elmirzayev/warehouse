package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public ResultMessage add(Currency currency) {
        boolean exists = currencyRepository.existsByName(currency.getName());
        if (exists) return new ResultMessage(false, "Currency already exist");

        currencyRepository.save(currency);
        return new ResultMessage(true,"Successfully currency saved");
    }

    public List<Currency> get() {
      return  currencyRepository.findAll();
    }

    public ResultMessage getById(Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isEmpty()) {
            return new ResultMessage(false,"Currency does not exists with id = "+id);
        }
        Currency currency = optionalCurrency.get();
        return new ResultMessage(true,"successfully",currency);
    }
}
