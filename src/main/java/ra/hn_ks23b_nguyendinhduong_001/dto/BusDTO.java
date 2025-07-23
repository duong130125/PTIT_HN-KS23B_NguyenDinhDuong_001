package ra.hn_ks23b_nguyendinhduong_001.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BusDTO {
    private String bus_name;
    private String registration_number;
    private Integer total_seats;
    private MultipartFile image_bus;
    private Boolean status;
}
