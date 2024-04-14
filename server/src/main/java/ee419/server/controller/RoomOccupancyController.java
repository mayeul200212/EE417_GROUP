package ee419.server.controller;

import ee419.server.model.Room;
import ee419.server.repository.RoomOccupancyRepository;
import ee419.server.service.RoomOccupancyService;
import ee419.server.utils.ResultVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomOccupancyController {

    private final RoomOccupancyService roomOccupancyService;

    public RoomOccupancyController(RoomOccupancyService roomOccupancyService) {
        this.roomOccupancyService = roomOccupancyService;
    }

    @GetMapping("/get-occupancy/{roomId}")
    public ResponseEntity<ResultVo<Integer>> addRoom(@PathVariable int roomId){
        return roomOccupancyService.getOccupiedCountByRoomId(roomId);
    }

    @GetMapping("/total-capacity/{roomId}")
    public ResponseEntity<ResultVo<Integer>> getTotalRoomCapacity(@PathVariable int roomId){
        return roomOccupancyService.getRoomCapacityById(roomId);
    }
}
