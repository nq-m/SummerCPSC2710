public class SeatReservation {
	private String flightDesignator;
	private java.time.LocalDate flightDate;
	private String firstName;
	private String lastName;

public String getFlightDesignator() {
	return flightDesignator;
}

public void setFlightDesignator(String fd) {
	if (fd.length() < 4 || fd.length() > 6) {
		throw new IllegalArgumentException();
	}
	this.flightDesignator = fd;
}
public java.time.LocalDate getFlightDate() {
	return flightDate;
}
public void setFlightDate(java.time.LocalDate date) {
	this.flightDate = date;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String fn) {
	this.firstName = fn;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String ln) {
	this.lastName = ln;
}	

public String toString() {
	String result = "SeatReservation{";
	if (flightDesignator == null || flightDesignator.trim().isEmpty()) {
		result += "flightDesignator=null,";
	} else {
			result += "flightDesignator=" + flightDesignator + ",";
	}
	if (flightDate == null) {
		result += "flightDate=null,";
	} else {
			result += "flightDate=" + flightDate + ",";
	}

	if (firstName == null || firstName.trim().isEmpty()) {
		result += "firstName=null,";
	} else {
			result += "firstName=" + firstName + ",";	
	}
			
	if (lastName == null || lastName.trim().isEmpty()) {
	result += "lastName=null";
	} else {
	result += "lastName=" + lastName;	
	}
	result += "}";
	return result;
}
	

}