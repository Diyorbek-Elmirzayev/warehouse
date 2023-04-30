package uz.pdp.appwarehouse.payload;

import lombok.Getter;

@Getter
public class InputDTO {
    private Integer warehouseId;
    private Integer supplierId;
    private Integer currencyId;
    private String factureNumber;
}
