package ee419.server.repository;

import ee419.server.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    boolean existsByName(String name);

    Optional<Room> findById(int id);

}
