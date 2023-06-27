package org.employee.entity;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.employee.entity.ValidationGroups.CreateEmployee;
import org.employee.entity.ValidationGroups.UpdateEmployee;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class Employee {

  @NotNull(groups = {UpdateEmployee.class})
  private Long id;

  public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

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

public LocalDate getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public LocalDate getStartDate() {
	return startDate;
}

public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}

public LocalDate getEndDate() {
	return endDate;
}

public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}

public String getEmploymentType() {
	return employmentType;
}

public void setEmploymentType(String employmentType) {
	this.employmentType = employmentType;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public List<Phone> getPhones() {
	return phones;
}

public void setPhones(List<Phone> phones) {
	this.phones = phones;
}

@NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  private String firstName;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  private String lastName;

  @NotNull(groups = {CreateEmployee.class,
                     UpdateEmployee.class})
  public LocalDate dateOfBirth;

  @NotNull(groups = {CreateEmployee.class,
                     UpdateEmployee.class})
  public LocalDate startDate;

  public LocalDate endDate;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  private String employmentType;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  private String email;

  @NotNull(groups = {CreateEmployee.class,
                     UpdateEmployee.class})
  private List<Phone> phones;

}
