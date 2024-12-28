package EncoderSoftware.RoomRental.rentalRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EncoderSoftware.RoomRental.modelEntity.Room;
@Repository
public interface RentalRepository extends JpaRepository<Room,Long> {

	
}
