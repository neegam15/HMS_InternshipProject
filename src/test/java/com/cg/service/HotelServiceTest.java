package com.cg.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.entity.Hotel;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.IHotelRepository;

@SpringBootTest
class HotelServiceTest {

	@Mock
	private IHotelRepository hotelRepository;
	
	@InjectMocks
	private HotelServiceImpl hotelServiceImpl;
	
	@Test
	void testShowHotelById() {
		
		Hotel hotel = new Hotel();
		hotel.setHotelId(101);
		hotel.setHotelName("Montellicious");
		hotel.setAddress("Pallur Hills");
		hotel.setDescription("Highway Restaurant");
		hotel.setCity("Berhampur");
		hotel.setAvgRatePerDay(1500);
		hotel.setEmail("service@montellicious.com");
		hotel.setPhone1(984756021);
		hotel.setPhone2(123456789);
		hotel.setWebsite("montellicious.com");
		
		Optional<Hotel> optionalHotel = Optional.of(hotel);
		
		when(hotelRepository.findById(101)).thenReturn(optionalHotel);
		
		Hotel actualHotel = hotelServiceImpl.showHotel(101);
		
		Hotel expectedHotel = optionalHotel.get();
		
		assertEquals(expectedHotel.getHotelName(), actualHotel.getHotelName());
	}
	
	@Test
	void testShowHotelByIdThrowsException() {
		
		when(hotelRepository.findById(102)).thenThrow(ResourceNotFoundException.class);
		
		assertThrows(ResourceNotFoundException.class, () -> hotelServiceImpl.showHotel(102));
	}
	
	@Test
	void testSaveHotel() {
		
		Hotel hotel = new Hotel();
		hotel.setHotelId(103);
		hotel.setHotelName("Bombay Kitchen");
		hotel.setAddress("Hill Patna");
		hotel.setDescription("Family Restaurant");
		hotel.setCity("Berhampur");
		hotel.setAvgRatePerDay(2500);
		hotel.setEmail("service@BombayKitchen.com");
		hotel.setPhone1(984756021);
		hotel.setPhone2(123456789);
		hotel.setWebsite("BombayKitchen.com");
		
		when(hotelRepository.save(hotel)).thenReturn(hotel);
		
		Hotel newHotel = hotelServiceImpl.addHotel(hotel);
		
		assertEquals(hotel.getHotelName(), newHotel.getHotelName());
		assertEquals(hotel.getAddress(), newHotel.getAddress());
		assertEquals(hotel.getAvgRatePerDay(), newHotel.getAvgRatePerDay());
	}
	
	@Test
	void testDeleteHotelById() {
		
		Hotel hotel = new Hotel();
		hotel.setHotelId(104);
		hotel.setHotelName("Babaji Dhaba");
		hotel.setAddress("Berhampur Highway");
		hotel.setDescription("Party Restaurant");
		hotel.setCity("Berhampur");
		hotel.setAvgRatePerDay(3000);
		hotel.setEmail("service@BabajiDhaba.com");
		hotel.setPhone1(984756021);
		hotel.setPhone2(123456789);
		hotel.setWebsite("BabajiDhaba.com");
		
		Optional<Hotel> optionalHotel = Optional.of(hotel);
		
		when(hotelRepository.findById(104)).thenReturn(optionalHotel);
		
		doNothing().when(hotelRepository).delete(optionalHotel.get());
		
		hotelServiceImpl.removeHotel(104);
		
		verify(hotelRepository,times(1)).delete(optionalHotel.get());
	}
	
	
}

