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
@Table(name = "room15")
public class Room {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Column(name ="id")
	 private Long id;
       @Column(name ="title")
	 private String title;
       @Column(name ="description")
	 private String description;
       @Column(name ="price")
	 private double price;
       @Column(name ="location")
	 private String location;
       @Column(name = "is_available")
	 private boolean isAvailable;
       @Column(name = "image_url")
       private String imageUrl;
       @Column(name = "phone")
       private String phone;
       
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
   
	 
}
