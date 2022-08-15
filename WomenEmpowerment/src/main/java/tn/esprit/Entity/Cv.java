package tn.esprit.Entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Entity
@Table(name = "CV")
public class Cv implements MultipartFile {
	
	private static long SerialVersionUID=1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idCv ;
	private String nameCv;
	@Lob
	private byte[] data;
	
	@ManyToOne
	Candidat candidat;

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

	public int getIdCv() {
		return idCv;
	}

	public void setIdCv(int idCv) {
		this.idCv = idCv;
	}

	public String getNameCv() {
		return nameCv;
	}

	public void setNameCv(String nameCv) {
		this.nameCv = nameCv;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Candidat getUser() {
		return candidat;
	}

	public void setUser(Candidat candidat) {
		this.candidat = candidat;
	}

	public Cv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Cv(String nameCv, String contenttype, byte[] data) {
		super();
		this.nameCv = nameCv;
		this.getContentType();
		this.data = data;
	}

	public Cv(int idCv, String nameCv, byte[] data, Candidat candidat) {
		super();
		this.idCv = idCv;
		this.nameCv = nameCv;
		this.data = data;
		this.candidat = candidat;
	}

	public Cv(String nameCv, byte[] data, Candidat candidat) {
		super();
		this.nameCv = nameCv;
		this.data = data;
		this.candidat = candidat;
	}

	public Cv(int idCv, String nameCv, byte[] data) {
		super();
		this.idCv = idCv;
		this.nameCv = nameCv;
		this.data = data;
	}

	public Cv(String nameCv, byte[] data) {
		super();
		this.nameCv = nameCv;
		this.data = data;
	}
	

}
