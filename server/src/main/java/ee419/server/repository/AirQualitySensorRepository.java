package ee419.server.repository;

import ee419.server.model.AirQualitySensor;
import ee419.server.model.NoiseSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AirQualitySensorRepository extends JpaRepository<AirQualitySensor, Integer> {
    @Query("SELECT aqs FROM AirQualitySensor aqs WHERE aqs.room.id = :roomId AND aqs.date >= :startDate AND aqs.date <= :endDate")
    List<AirQualitySensor> findByRoomIdAndDateBetween(@Param("roomId") Integer roomId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
