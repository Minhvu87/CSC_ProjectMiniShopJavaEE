package domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Member")
public class Member {
	@Id
	@Column(name = "memberid")
    private long id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private byte gender;
    private Date addedDate;
    public Member(long id, String username) {
    	this(id,username,null,null,null, Byte.MIN_VALUE);
    }
	public Member(long id, String username,  String password, String email, String fullname, byte gender) {
		// TODO Auto-generated constructor stub
		this(id, username,password, email, fullname, gender,null);
	}
	public Member(long id, String username, String password, String email, String fullname, byte gender,
			Date addedDate) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.gender = gender;
		this.addedDate = addedDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public byte getGender() {
		return gender;
	}
	public void setGender(byte gender) {
		this.gender = gender;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
}
