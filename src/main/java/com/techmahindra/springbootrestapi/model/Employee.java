package com.techmahindra.springbootrestapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * @JsonProperty("full_name") This annotation using Alter native name required
	 **/

	/**
	 * @NotNull(message="Name should not be null") @NOTNULL Annotation is only check
	 *                        for NULL
	 * @NotEmpty(message="Name should not be null") @NOTEMPTY Annoatation is check
	 *                         for both EMPTY & NULL
	 * @NotBlank(message="Name should not be null") @NOTBLANK Annotation also check
	 *                         for EMPTY values NULL values as well as character not
	 *                         availabe throw the validaion error message
	 */
	@NotBlank(message = "Name should not be null")
	private String name;

	/**
	 * @JsonIgnore Hide Sensitive Information
	 */
	private Long age = 0L;

	private String location;
	@Email(message="Please enter the valid email address")
	private String email;

	/**
	 * @NotNull(message="Name should not be null") @NotEmpty(message="Name should
	 * not be null")
	 **/
	@NotBlank(message = "Name should not be null")
	private String department;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updateAt;

	public Employee() {
		super();
	}

	public Employee(Long id, String name, Long age, String location, String email, String department) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.location = location;
		this.email = email;
		this.department = department;
	}

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

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", location=" + location + "+email=" +email+", department="
				+ department + "]";
	}

}
