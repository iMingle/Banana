package org.mingle.banana.spring.jdbc;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="spitter")
public class SpitterJPA {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(min=3, max=20, message="Username must be between 3 and 20 characters long.")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alphanumeric with no spaces")
	@Column(name="username", unique=true)
	private String username;
	@Size(min=6, max=20, message="The password must be at least 6 characters long.")
	@Column(name="password")
	private String password;
	@Size(min=3, max=50, message="Your full name must be between 3 and 50 characters long.")
	@Column(name="fullname")
	private String fullName;
	@Transient
	@JsonIgnore
	private List<Spittle> spittles;
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message="Invalid email address.")
	@Column(name="email")
	private String email;
	@Column(name="update_by_email")
	private boolean updateByEmail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setSpittles(List<Spittle> spittles) {
		this.spittles = spittles;
	}

	public List<Spittle> getSpittles() {
		return spittles;
	}

	public void setUpdateByEmail(boolean updateByEmail) {
		this.updateByEmail = updateByEmail;
	}

	public boolean isUpdateByEmail() {
		return updateByEmail;
	}

	@Override
	public boolean equals(Object obj) {
		SpitterJPA other = (SpitterJPA) obj;
		return other.fullName.equals(fullName)
				&& other.username.equals(username)
				&& other.password.equals(password);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Spitter [id=" + id + ", username=" + username + ", password="
				+ password + ", fullName=" + fullName + ", spittles="
				+ spittles + ", email=" + email + "]";
	}
}
