package ee419.server.repository;

import ee419.server.model.NoiseSensor;
import ee419.server.model.OccupancyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface NoiseSensorRepository extends JpaRepository<NoiseSensor, Integer> {
    List<NoiseSensor> findByRoomId(int roomId);

    @Query("SELECT ns FROM NoiseSensor ns WHERE ns.room.id = :roomId AND ns.date >= :startDate AND ns.date <= :endDate")
    List<NoiseSensor> findByRoomIdAndDateBetween(@Param("roomId") Integer roomId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
