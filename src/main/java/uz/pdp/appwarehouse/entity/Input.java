package uz.pdp.appwarehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp date;
    @ManyToOne
    private WareHouse wareHouse;
    @ManyToOne
    private Supplier supplier;
    @ManyToOne
    private Currency currency;
    private String facture_number;
    @Column(nullable = false,unique = true)
    private String code;
}
