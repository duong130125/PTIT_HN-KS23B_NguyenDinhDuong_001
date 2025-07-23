package ra.hn_ks23b_nguyendinhduong_001.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bus_id;
    @Column(nullable = false, unique = true, length = 100)
    private String bus_name;
    @Column(nullable = false, unique = true, length = 30)
    private String registration_number;
    @Column(nullable = false)
    private Integer total_seats;
    private String image_bus;
    private Boolean status = true;
}
