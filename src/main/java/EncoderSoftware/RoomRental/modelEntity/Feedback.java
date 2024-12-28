package EncoderSoftware.RoomRental.modelEntity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table (name = "feedback21")
public class Feedback {
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name ="id")
	private Long id;
	 @Column(name ="name")
	private String name;
	 @Column(name ="email")
	private String email;
	 @Column(name ="message")
	private String message;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
