package ra.hn_ks23b_nguyendinhduong_001.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse<T>{
    private boolean success;
    private String message;
    private T data;
    private HttpStatus httpStatus;
}
