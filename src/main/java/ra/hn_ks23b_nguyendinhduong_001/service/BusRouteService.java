package ra.hn_ks23b_nguyendinhduong_001.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.hn_ks23b_nguyendinhduong_001.entity.BusRoute;
import ra.hn_ks23b_nguyendinhduong_001.repository.BusRouteRepository;

import java.util.List;

@Service
public class BusRouteService {
    @Autowired
    private BusRouteRepository busRouteRepository;

    public List<BusRoute> findAll() {
        return busRouteRepository.findAll();
    }

    public BusRoute findById(Long id) {
        return busRouteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chuyến xe bus không tồn tại ID: " + id));
    }

    public BusRoute save(BusRoute busRoute) {
        return busRouteRepository.save(busRoute);
    }

    public BusRoute update(Long id,BusRoute busRoute) {
        BusRoute existingBusRoute = busRouteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chuyến xe bus không tồn tại ID: " + id));

        existingBusRoute.setStart_point(busRoute.getStart_point());
        existingBusRoute.setEnd_point(busRoute.getEnd_point());
        existingBusRoute.setTrip_information(busRoute.getTrip_information());
        existingBusRoute.setDriver_name(busRoute.getDriver_name());
        existingBusRoute.setStatus(busRoute.getStatus());

        return busRouteRepository.save(existingBusRoute);
    }

    public void deleteById(Long id) {
        if (!busRouteRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy chuyến xe bus để xóa ID: " + id);
        }
        busRouteRepository.deleteById(id);
    }
}
