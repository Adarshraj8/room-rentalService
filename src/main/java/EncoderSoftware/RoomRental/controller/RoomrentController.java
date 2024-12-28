package EncoderSoftware.RoomRental.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EncoderSoftware.RoomRental.modelEntity.Room;
import EncoderSoftware.RoomRental.services.RoomService;

@RestController
@RequestMapping("/api")
public class RoomrentController {

	@Autowired
	RoomService roomService;
	
	@GetMapping("/room")
	public List<Room> getAllRomRentalData(){
		  return roomService.findAll();
	}
	@GetMapping("/room/{id}")
	public Optional<Room> getRomRentalDataById(@PathVariable long id){
		  return roomService.findById(id);
	}
	@PostMapping("/room")
	public Room addRomRentalData(@RequestBody Room room){
		System.out.println(room.isAvailable());
		  Room rentdb = roomService.save(room);
		  return rentdb;
	}
	
	@PutMapping("/room")
	public Room UpdateRomRentalData(@RequestBody Room room){
		  Room rentdb = roomService.save(room);
		  return rentdb;
	}
	
	@DeleteMapping("/room/{id}")
	public String deleteRomRentalData(@PathVariable long id){
		    Optional<Room> rentdata = roomService.findById(id);
		    if(rentdata==null)
		    {
		    	throw new NullPointerException("Rental Data Nout Found : +"+id);
		    }
		    else {
		    	roomService.deleteById(id);
		    }
		    return "Rental Data with "+id +"deleted";
		  
	}
	  
	 
	
	 
}
