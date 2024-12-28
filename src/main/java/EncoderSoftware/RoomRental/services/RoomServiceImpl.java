package EncoderSoftware.RoomRental.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EncoderSoftware.RoomRental.modelEntity.Room;
import EncoderSoftware.RoomRental.rentalRepository.RentalRepository;
@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	RentalRepository rentalRepository;
	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return rentalRepository.findAll();
	}

	@Override
	public Optional<Room> findById(long id) {
		// TODO Auto-generated method stub
		return rentalRepository.findById(id);
	}

	@Override
	public Room save(Room roomdetail) {
		// TODO Auto-generated method stub
		return rentalRepository.save(roomdetail);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		 rentalRepository.deleteById(id);
	}


	
}
