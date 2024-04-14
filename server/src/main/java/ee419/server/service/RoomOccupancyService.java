package ee419.server.service;

import ee419.server.model.OccupancyStatus;
import ee419.server.model.Room;
import ee419.server.repository.RoomOccupancyRepository;
import ee419.server.repository.RoomRepository;
import ee419.server.utils.ResultVo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class RoomOccupancyService {

    private final RoomOccupancyRepository roomOccupancyRepository;

    private final RoomRepository roomRepository;

    public RoomOccupancyService(RoomOccupancyRepository roomOccupancyRepository, RoomRepository roomRepository) {
        this.roomOccupancyRepository = roomOccupancyRepository;
        this.roomRepository = roomRepository;
    }

    public ResponseEntity<ResultVo<Integer>> getOccupiedCountByRoomId(int roomId) {
        LocalDateTime startOfDay = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime endOfDay = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999999999);

        int count = roomOccupancyRepository.countByRoomIdAndStatusAndDateBetween(roomId, OccupancyStatus.IN, startOfDay, endOfDay);

        return ResponseEntity.ok(ResultVo.success("Room occupancy count fetched.",count));
    }

    public ResponseEntity<ResultVo<Integer>> getRoomCapacityById(int roomId) {
        Room room;
        try {
            room = roomRepository.findById(roomId).orElseThrow();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.badRequest().body(ResultVo.error(400, "Room does not exists."));
        }
        return ResponseEntity.ok(ResultVo.success("Room total capacity fetched.",room.getCapacity()));
    }
}
