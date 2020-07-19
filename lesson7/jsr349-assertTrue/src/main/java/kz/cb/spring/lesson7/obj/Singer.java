package kz.cb.spring.lesson7.obj;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Singer {

	@NotNull
	@Size(min = 2, max = 60)
	private String firstName;
	private String lastName;
	@NotNull
	private Genre genre;
	private Gender gender;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@AssertTrue(message="Country Singer should have gender and last name defined")
	public boolean isCountrySinger() {
		boolean result = true;

		if (genre!= null &&
				(genre.equals(Genre.COUNTRY) && (gender == null || lastName == null))) {
			result = false;
		}

		return result;
	}

	@AssertTrue(message="Male Singer should have genre defined as POP")
	public boolean isMalePop() {
		boolean result = true;

		if ((!genre.equals(Genre.POP)) && gender.equals(Gender.MALE)) {
			result = false;
		}

		return result;
	}
}
