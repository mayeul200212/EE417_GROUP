package ee419.server.service;

import ee419.server.model.AirQualitySensor;
import ee419.server.model.NoiseSensor;
import ee419.server.repository.AirQualitySensorRepository;
import ee419.server.utils.ResultVo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AirQualitySensorService {
    private final AirQualitySensorRepository airQualitySensorRepository;

    public AirQualitySensorService(AirQualitySensorRepository airQualitySensorRepository) {
        this.airQualitySensorRepository = airQualitySensorRepository;
    }

    public ResponseEntity<ResultVo<List<AirQualitySensor>>> getValueByRoomId(int roomId){
        LocalDateTime startOfDay = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime endOfDay = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999999999);

        List<AirQualitySensor> list = airQualitySensorRepository.findByRoomIdAndDateBetween(roomId, startOfDay, endOfDay);
        return ResponseEntity.ok(ResultVo.success("Room air quality level values fetched.",list));
    }
}
