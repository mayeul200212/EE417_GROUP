package ee419.server.service;

import ee419.server.model.Room;
import ee419.server.repository.RoomRepository;
import ee419.server.utils.ResultVo;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public boolean isDataValid(Room room){
        return StringUtils.isNotBlank(room.getName()) && room.getCapacity() != null;
    }


    public ResponseEntity<ResultVo<String>> addRoom(Room room){
        if(!isDataValid(room)){
            return ResponseEntity.badRequest().body(ResultVo.error(400, "Invalid data."));
        }

        if(roomRepository.existsByName(room.getName())){
            return ResponseEntity.badRequest().body(ResultVo.error(400, "Room already exists."));
        }

        roomRepository.save(room);
        return ResponseEntity.ok(ResultVo.success("Room added successful",""));
    }
}
