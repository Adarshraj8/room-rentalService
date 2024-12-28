package EncoderSoftware.RoomRental.services;

import org.springframework.stereotype.Service;

import EncoderSoftware.RoomRental.modelEntity.Feedback;
@Service
public interface FeedbackService {

	public void saveFeedback(Feedback feedback);
}
