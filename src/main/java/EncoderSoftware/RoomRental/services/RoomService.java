package EncoderSoftware.RoomRental.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import EncoderSoftware.RoomRental.modelEntity.Room;
@Service
public interface RoomService {

	List<Room> findAll();
	public Optional<Room> findById(long id);
	public Room save(Room roomdetail);//use a save for both update anddelete
	public void deleteById(long id);
}
