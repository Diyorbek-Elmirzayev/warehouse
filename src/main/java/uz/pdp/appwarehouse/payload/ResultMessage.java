package uz.pdp.appwarehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultMessage {
    private boolean success;
    private String message;

    private Object object;

    public ResultMessage(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
