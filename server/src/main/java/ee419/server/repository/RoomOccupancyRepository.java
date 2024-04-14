package ee419.server.repository;

import ee419.server.model.OccupancyStatus;
import ee419.server.model.RoomOccupancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RoomOccupancyRepository extends JpaRepository<RoomOccupancy, Integer> {
    int countByRoomIdAndStatusAndDate(Integer roomId, OccupancyStatus status, LocalDateTime date);

    @Query("SELECT COUNT(ro) FROM RoomOccupancy ro WHERE ro.room.id = :roomId AND ro.status = :status AND ro.date >= :startDate AND ro.date <= :endDate")
    int countByRoomIdAndStatusAndDateBetween(@Param("roomId") Integer roomId, @Param("status") OccupancyStatus status, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
