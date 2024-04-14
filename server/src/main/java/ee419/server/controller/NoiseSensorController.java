package ee419.server.controller;

import ee419.server.model.NoiseSensor;
import ee419.server.service.NoiseSensorService;
import ee419.server.utils.ResultVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room-noise-level")
public class NoiseSensorController {
    private final NoiseSensorService noiseSensorService;

    public NoiseSensorController(NoiseSensorService noiseSensorService) {
        this.noiseSensorService = noiseSensorService;
    }

    @GetMapping("/get-by-room/{roomId}")
    public ResponseEntity<ResultVo<List<NoiseSensor>>> getByRoom(@PathVariable int roomId){
        return noiseSensorService.getValueByRoomId(roomId);
    }
}
