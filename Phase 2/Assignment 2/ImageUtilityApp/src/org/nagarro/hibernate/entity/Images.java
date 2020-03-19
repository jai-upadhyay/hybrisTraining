package org.nagarro.hibernate.entity;

import java.sql.Blob;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Images {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	@Column(name="userId")
	private int userId;
	@Column(name="name")
	private String name;
	@Column(name="photo")
	private byte[] photo;
	@Column(name="size")
	private long size;

	public Images() {
		
	}
	/**
	 * @param name
	 * @param photo
	 * @param size
	 * @param userId
	 */
	public Images(String name, byte[] photo, long size, int userId) {
		super();
//		this.id = id;
		this.name = name;
		this.photo = photo;
		this.size = size;
		this.userId = userId;
	}
	/**
	 * @param id
	 * @param userId
	 * @param name
	 * @param photo
	 * @param size
	 */
	public Images(int id, int userId, String name, byte[] photo, long size) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.photo = photo;
		this.size = size;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getPhoto() {
		return photo;
	}	
	public long getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Images [id=" + id + ", name=" + name + ", size=" + size + ", userId=" + userId + "]";
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}
