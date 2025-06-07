package edu.au.cpsc.module2;

public class SeatReservation {
	private String flightDesignator;
	private java.time.LocalDate flightDate;
	private String firstName;
	private String lastName;
	private int numberOfBags;
	private boolean flyingWithInfant;

	public String getFlightDesignator() {
		return flightDesignator;
	}

	public void setFlightDesignator(String fd) {
		if (fd == null) {
			throw new IllegalArgumentException("flight designator cannot be null");
		}
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

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int nb) {
		this.numberOfBags = nb;
	}

	public boolean getIsFlyingWithInfant() {
		return flyingWithInfant;
	}

	public void makeFlyingWithInfant() {
		this.flyingWithInfant = true;
	}

	public void makeNotFlyingWithInfant() {
		this.flyingWithInfant = false;
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
			result += "lastName=" + lastName + ",";
		}
		result += "numberOfBags=" + numberOfBags + ",";
		result += "flyingWithInfant=" + flyingWithInfant;
		result += "}";
		return result;
	}


}