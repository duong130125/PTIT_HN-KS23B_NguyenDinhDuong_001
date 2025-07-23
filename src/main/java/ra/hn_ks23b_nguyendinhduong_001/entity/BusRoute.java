package ra.hn_ks23b_nguyendinhduong_001.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bus_route_id;
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
    @ManyToOne
    @JoinColumn(nullable = false)
    private Bus bus_id;
}
