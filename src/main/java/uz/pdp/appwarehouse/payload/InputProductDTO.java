package uz.pdp.appwarehouse.payload;

import lombok.Getter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
public class InputProductDTO {
    private Integer productId;
    private Double amount;
    private Double price;
    private Date expireDate;
    private Integer inputId;
}
