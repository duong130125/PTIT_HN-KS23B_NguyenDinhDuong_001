package ra.hn_ks23b_nguyendinhduong_001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.hn_ks23b_nguyendinhduong_001.dto.ApiResponse;
import ra.hn_ks23b_nguyendinhduong_001.entity.BusRoute;
import ra.hn_ks23b_nguyendinhduong_001.service.BusRouteService;

import java.util.List;

@RestController
@RequestMapping("/api/bus-routes")
public class BusRouteController {

    @Autowired
    private BusRouteService busRouteService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<BusRoute>>> getAllBusRoute() {
        List<BusRoute> busRoutes = busRouteService.findAll();
        ApiResponse<List<BusRoute>> response = new ApiResponse<>(true, "Lấy danh sách tuyến xe buýt thành công", busRoutes, HttpStatus.OK);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BusRoute>> createBusRoute(BusRoute busRoute) {
        BusRoute createdBusRoute = busRouteService.save(busRoute);
        ApiResponse<BusRoute> response = new ApiResponse<>(true, "Tạo tuyến xe buýt thành công", createdBusRoute, HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BusRoute>> updateBusRoute(@PathVariable Long id, @RequestBody BusRoute busRoute) {
        BusRoute updatedBusRoute = busRouteService.update(id,busRoute);
        ApiResponse<BusRoute> response = new ApiResponse<>(true, "Cập nhật tuyến xe buýt thành công", updatedBusRoute, HttpStatus.OK);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteBusRoute(@PathVariable Long id) {
        busRouteService.deleteById(id);
        ApiResponse<String> response = new ApiResponse<>(true, "Xóa tuyến xe buýt thành công", null, HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
}
