package tn.esprit.Entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Entity
@Table(name = "IMAGE_USER")
public class ImageUser implements MultipartFile {
	
	private static long SerialVersionUID=1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idImageUser ;
	private String nameImageUser;
	@Lob
	private byte[] data;
	
	@ManyToOne
    User user;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOriginalFilename() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] getBytes() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	public int getIdImageUser() {
		return idImageUser;
	}

	public void setIdImageUser(int idImageUser) {
		this.idImageUser = idImageUser;
	}

	public String getNameImageUser() {
		return nameImageUser;
	}

	public void setNameImageUser(String nameImageUser) {
		this.nameImageUser = nameImageUser;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ImageUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ImageUser(String nameImageUser, String contenttype, byte[] data) {
		super();
		this.nameImageUser = nameImageUser;
		this.getContentType();
		this.data = data;
	}

	public ImageUser(int idImageUser, String nameImageUser, byte[] data, User user) {
		super();
		this.idImageUser = idImageUser;
		this.nameImageUser = nameImageUser;
		this.data = data;
		this.user = user;
	}

	public ImageUser(String nameImageUser, byte[] data, User user) {
		super();
		this.nameImageUser = nameImageUser;
		this.data = data;
		this.user = user;
	}

	public ImageUser(int idImageUser, String nameImageUser, byte[] data) {
		super();
		this.idImageUser = idImageUser;
		this.nameImageUser = nameImageUser;
		this.data = data;
	}

	public ImageUser(String nameImageUser, byte[] data) {
		super();
		this.nameImageUser = nameImageUser;
		this.data = data;
	}
	

}
