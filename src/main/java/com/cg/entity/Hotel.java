package com.cg.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "hotel_tbl")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hotel_id")
	private int hotelId;
	@Length(min = 4, max = 50, message = "City name should be between 4 to 50")
	private String city;
	@NotEmpty(message = "Hotel Name cannot be empty")
	@Column(name = "hotel_name")
	@Length(min = 4, max = 50, message = "Hotel name should be between 4 to 50")
	private String hotelName;
	@NotEmpty(message = "Address cannot be empty")
	@Length(min = 3, max = 50, message = "Address should be between 3 to 50")
	private String address;
	private String description;
	@Column(name = "avg_rate_per_day")
	private double avgRatePerDay;
	@Email(message = "Please mention email in proper format")
	private String email;
	@Digits(integer = 10, fraction = 0, message = "Please enter 10 digit mobile number")
	private long phone1;
	@Digits(integer = 10, fraction = 0, message = "Please enter 10 digit mobile number")
	private long phone2;
	private String website;

	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	List<RoomDetails> rooms = new ArrayList<>();

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public double getAvgRatePerDay() {
		return avgRatePerDay;
	}

	public void setAvgRatePerDay(double avgRatePerDay) {
		this.avgRatePerDay = avgRatePerDay;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone1() {
		return phone1;
	}

	public void setPhone1(long phone1) {
		this.phone1 = phone1;
	}

	public long getPhone2() {
		return phone2;
	}

	public void setPhone2(long phone2) {
		this.phone2 = phone2;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<RoomDetails> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomDetails> rooms) {
		this.rooms = rooms;
	}

}