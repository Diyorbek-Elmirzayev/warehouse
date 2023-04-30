package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Input;

public interface InputRepository extends JpaRepository<Input,Integer> {
}
