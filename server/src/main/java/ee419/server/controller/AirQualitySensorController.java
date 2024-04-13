package ee419.server.controller;

import ee419.server.model.AirQualitySensor;
import ee419.server.model.NoiseSensor;
import ee419.server.service.AirQualitySensorService;
import ee419.server.utils.ResultVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room-air-quality-level")
public class AirQualitySensorController {
    private final AirQualitySensorService airQualitySensorService;

    public AirQualitySensorController(AirQualitySensorService airQualitySensorService) {
        this.airQualitySensorService = airQualitySensorService;
    }

    @GetMapping("/get-by-room/{roomId}")
    public ResponseEntity<ResultVo<List<AirQualitySensor>>> getByRoom(@PathVariable int roomId){
        return airQualitySensorService.getValueByRoomId(roomId);
    }
}
