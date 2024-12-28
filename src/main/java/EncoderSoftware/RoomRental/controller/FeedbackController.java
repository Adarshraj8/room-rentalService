package EncoderSoftware.RoomRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import EncoderSoftware.RoomRental.modelEntity.Feedback;
import EncoderSoftware.RoomRental.services.FeedbackService;

@RestController
@RequestMapping("/api")
public class FeedbackController {
   @Autowired
    FeedbackService feedbackService;
    
    @PostMapping("/feedback")
    public ResponseEntity<String> saveFeedback(@RequestBody Feedback feedback) {
        feedbackService.saveFeedback(feedback);
        return ResponseEntity.ok("Feedback saved successfully!");
    }
    
}

