package ra.hn_ks23b_nguyendinhduong_001.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.hn_ks23b_nguyendinhduong_001.config.AppConfig;
import ra.hn_ks23b_nguyendinhduong_001.dto.BusDTO;
import ra.hn_ks23b_nguyendinhduong_001.entity.Bus;
import ra.hn_ks23b_nguyendinhduong_001.repository.BusRepository;

import java.util.List;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    private AppConfig Cloudinary;

    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    public Bus create(BusDTO busDTO) {
        String imageUrl = Cloudinary.uploadImage(busDTO.getImage_bus());

        Bus bus = new Bus();
        bus.setBus_name(busDTO.getBus_name());
        bus.setRegistration_number(busDTO.getRegistration_number());
        bus.setTotal_seats(busDTO.getTotal_seats());
        bus.setImage_bus(imageUrl);
        bus.setStatus(busDTO.getStatus());
        return busRepository.save(bus);
    }

    public Bus findById(Long id) {
        return busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy xe bus với ID: " + id));
    }

    public Bus update(Long id, BusDTO busDTO) {
        Bus existingBus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Xe bus không tồn tại ID: " + id));

        existingBus.setBus_name(busDTO.getBus_name());
        existingBus.setRegistration_number(busDTO.getRegistration_number());
        existingBus.setTotal_seats(busDTO.getTotal_seats());
        existingBus.setStatus(busDTO.getStatus());

        if (busDTO.getImage_bus() != null && !busDTO.getImage_bus().isEmpty()) {
            String newImageUrl = Cloudinary.uploadImage(busDTO.getImage_bus());
            existingBus.setImage_bus(newImageUrl);
        }

        return busRepository.save(existingBus);
    }

    public void delete(Long id) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy xe bus với ID: " + id));
        busRepository.delete(bus);
    }
}
