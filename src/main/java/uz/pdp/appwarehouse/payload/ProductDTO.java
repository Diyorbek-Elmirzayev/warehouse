package uz.pdp.appwarehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private Integer categoryId;
    private Integer photoId;
    private Integer measurementId;
}
