package ee419.server.service;

import ee419.server.model.NoiseSensor;
import ee419.server.repository.NoiseSensorRepository;
import ee419.server.utils.ResultVo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoiseSensorService {
    private final NoiseSensorRepository noiseSensorRepository;

    public NoiseSensorService(NoiseSensorRepository noiseSensorRepository) {
        this.noiseSensorRepository = noiseSensorRepository;
    }

    public ResponseEntity<ResultVo<List<NoiseSensor>>> getValueByRoomId(int roomId){
        LocalDateTime startOfDay = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime endOfDay = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999999999);

        List<NoiseSensor> list = noiseSensorRepository.findByRoomIdAndDateBetween(roomId, startOfDay, endOfDay);
        return ResponseEntity.ok(ResultVo.success("Room noise level values fetched.",list));
    }
}
