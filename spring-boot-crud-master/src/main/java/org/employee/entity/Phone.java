package org.employee.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.employee.entity.ValidationGroups.CreateEmployee;
import org.employee.entity.ValidationGroups.UpdateEmployee;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class Phone {

	@NotNull(groups = CreateEmployee.class)
	private Long id;

	@NotEmpty(groups = {CreateEmployee.class,
			UpdateEmployee.class})
	private String type;

	@NotEmpty(groups = {CreateEmployee.class,
			UpdateEmployee.class})
	private String isdCode;

	@NotEmpty(groups = {CreateEmployee.class,
			UpdateEmployee.class})
	private String phoneNumber;

	private String extension;
  public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsdCode() {
		return isdCode;
	}

	public void setIsdCode(String isdCode) {
		this.isdCode = isdCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}


}
