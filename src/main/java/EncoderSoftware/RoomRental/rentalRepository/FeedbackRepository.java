package EncoderSoftware.RoomRental.rentalRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EncoderSoftware.RoomRental.modelEntity.Feedback;

   @Repository
	public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	

    }
