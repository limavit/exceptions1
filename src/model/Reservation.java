package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomBumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomBumber, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("A data de checkout tem que ser após o check in");
			
		}
		this.roomBumber = roomBumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomBumber() {
		return roomBumber;
	}
	public void setRoomBumber(Integer roomBumber) {
		this.roomBumber = roomBumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	public void updateDates(Date checkIn, Date checkOut) throws DomainException{
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("As datas da reserva devem ser datas futuras") ;
			
		}if (!checkOut.after(checkIn)) {
			throw new DomainException("A data de checkout tem que ser após o check in");
			
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Room " 
				+ roomBumber
				+ ", check-in: "
				+sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+duration()
				+ " nights.";
	}
	
	
}
