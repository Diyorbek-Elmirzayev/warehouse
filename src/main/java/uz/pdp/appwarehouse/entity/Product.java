package uz.pdp.appwarehouse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appwarehouse.entity.temlate.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product extends BaseEntity {
    @ManyToOne(optional = false)
    private Category category;
    @OneToOne
    private Attachment photo;
    private String code;
    @ManyToOne(optional = false)
    private Measurement measurement;

}
