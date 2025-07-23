package ra.hn_ks23b_nguyendinhduong_001.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class BusRouteDTO {
    @Column(nullable = false)
    private String start_point;
    @Column(nullable = false)
    private String end_point;
    @Column(nullable = false)
    private String trip_information;
    @Column(nullable = false,length = 70)
    private String driver_name;
    @Column(nullable = false)
    private Boolean status = true;
}
