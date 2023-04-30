package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.WareHouse;

public interface WareHouseRepository extends JpaRepository<WareHouse,Integer> {

    boolean existsByName(String name);
}
