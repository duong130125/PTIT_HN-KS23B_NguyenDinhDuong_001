package ra.hn_ks23b_nguyendinhduong_001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.hn_ks23b_nguyendinhduong_001.dto.ApiResponse;
import ra.hn_ks23b_nguyendinhduong_001.dto.BusDTO;
import ra.hn_ks23b_nguyendinhduong_001.entity.Bus;
import ra.hn_ks23b_nguyendinhduong_001.service.BusService;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Bus>>> getAllBuses() {
        List<Bus> busList = busService.findAll();
        ApiResponse<List<Bus>> response = new ApiResponse<>(true, "Lấy danh sách tuyến xe buýt thành công", busList, HttpStatus.OK);
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Bus>> createBus(@ModelAttribute BusDTO busdto) {
        Bus createdBus = busService.create(busdto);
        ApiResponse<Bus> response = new ApiResponse<>(true, "Tạo tuyến xe buýt thành công", createdBus, HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Bus>> updateBus(@PathVariable Long id, @RequestBody Bus bus) {
        Bus updatedBus = busService.update(id, bus);
        ApiResponse<Bus> response = new ApiResponse<>(true, "Cập nhật tuyến xe buýt thành công", updatedBus, HttpStatus.OK);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteBus(@PathVariable Long id) {
        busService.delete(id);
        ApiResponse<String> response = new ApiResponse<>(true, "Xóa tuyến xe buýt thành công", null, HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
}
