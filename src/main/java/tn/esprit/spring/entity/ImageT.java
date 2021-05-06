package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="image_tab")
public class ImageT  extends AuditModel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name = "id")
	
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	    private Long id;
	
	    @Column(name = "name")
	
	    private String name;
	
	    @Column(name = "type")
	
	    private String type;
	
	    @Column(name = "picByte", length = 4915200)
	    private byte[] picByte;
	   

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

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public byte[] getPicByte() {
			return picByte;
		}

		public void setPicByte(byte[] picByte) {
			this.picByte = picByte;
		}

		public ImageT() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ImageT(Long id, String name, String type, byte[] picByte) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.picByte = picByte;
		}

		public ImageT(String name, String type, byte[] picByte) {
			super();
			this.name = name;
			this.type = type;
			this.picByte = picByte;
		}
	    
    
    
}