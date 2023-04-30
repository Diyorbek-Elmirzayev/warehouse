package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.payload.ClientDTO;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.repository.ClientRepository;

@Service
public class ClientService
{
    @Autowired
    ClientRepository clientRepository;

    public ResultMessage add(ClientDTO clientDTO) {
        boolean exists = clientRepository.existsByPhoneNumber(clientDTO.getPhoneNumber());
        if (exists) {
            return new ResultMessage(false,"Client already exists");
        }
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(client);
        return new ResultMessage(true,"added");
    }
}
