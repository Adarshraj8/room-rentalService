package EncoderSoftware.RoomRental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EncoderSoftware.RoomRental.modelEntity.Feedback;
import EncoderSoftware.RoomRental.rentalRepository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {
     @Autowired
    FeedbackRepository feedbackRepository;
	
	@Override
	public void saveFeedback(Feedback feedback) {
		
		feedbackRepository.save(feedback);
	}

}
