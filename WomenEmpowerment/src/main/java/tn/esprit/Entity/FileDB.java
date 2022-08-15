package tn.esprit.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "files")
public class FileDB implements Serializable {
	
	private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String type;
  @Lob
  private byte[] data;




	@ManyToOne
	private Publicity Publicity;

	public Publicity getPublicity() {
		return Publicity;
	}
	public void setPublicity(Publicity publicity) {
		Publicity = publicity;
	}
	public FileDB() {
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public byte[] getData() {
	return data;
}
public void setData(byte[] data) {
	this.data = data;
}


public FileDB(int id, String name, String type, byte[] data) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.data = data;
}
public FileDB(String name, String type, byte[] data) {
	super();
	this.name = name;
	this.type = type;
	this.data = data;
}

  
  
}
