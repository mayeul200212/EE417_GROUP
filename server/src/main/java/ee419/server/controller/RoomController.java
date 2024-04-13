package ee419.server.controller;

import ee419.server.model.Room;
import ee419.server.service.RoomService;
import ee419.server.utils.ResultVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/admin/room/add")
    public ResponseEntity<ResultVo<String>> addRoom(@RequestBody Room request){
        return roomService.addRoom(request);
    }

    @GetMapping("room/get-all-rooms")
    public ResponseEntity<ResultVo<List<Room>>> getAllRooms(){
        return roomService.getAllRooms();
    }
}
