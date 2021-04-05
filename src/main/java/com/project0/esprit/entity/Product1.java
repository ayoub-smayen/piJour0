package com.project0.esprit.entity;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project0.esprit.datentity.Comment;
@Entity
@Table(name="product")
public class Product1 extends AuditModel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;
	@NotNull(message = "Product name is required.")
    @Basic(optional = false)
	
	@Column(name="productname")
	private String productname ;

    @NotBlank(message = "description  is mandatory")
	@Column(name="productdescription")
	private String productdescription  ;
	@Column(name="quantity")
	private Integer Quantity  ;
	@Column(name="price")
	private Double price  ;

    @NotBlank(message = "Brand is mandatory")
	@Column(name="brand")
	private String Brand ;
	
	@Column(name="remise_price",nullable = true)
	private Double remise_price;
	
	@Column(name="bestProduct")
    private boolean bestProduct;
	
	
	

	/*public Product1(String productname, String productdescription, Integer quantity, Double price, String brand,
			Double remise_price,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, Orders orders) {
		super();
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.remise_price = remise_price;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.comments = comments;
		this.orders = orders;
	}*/

	public boolean isBestProduct() {
		return bestProduct;
	}

	public void setBestProduct(boolean bestProduct) {
		this.bestProduct = bestProduct;
	}

	public Double getRemise_price() {
		return remise_price;
	}

	public void setRemise_price(Double remise_price) {
		this.remise_price = remise_price;
	}
	/*public Product1(Long product_id, String productname, String productdescription, Integer quantity, Double price,
			String brand, Double remise_price,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, Orders orders) {
		super();
		this.product_id = product_id;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.remise_price = remise_price;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.comments = comments;
		this.orders = orders;
	}*/
	@Column(name="codebar")
	@Pattern(message = "codebar must start  with 619", regexp="^619*[0-9]{9}")
	private String codebar ;
	
	/*public Product1(String productname, String productdescription, Integer quantity, Double price, String brand,
			String codebar, byte[] productImg, Publicity publicity, Category1 category, Orders orders) {
		super();
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.orders = orders;
	}*/

	public String getCodebar() {
		return codebar;
	}
	//@Max(value = 12)
	//@Min(value=10)
	public void setCodebar(String codebar) {
		this.codebar = codebar;
	}
	/*public Product1(Long product_id, String productname, String productdescription, Integer quantity, Double price,
			String brand, String codebar, byte[] productImg, Publicity publicity, Category1 category, Orders orders) {
		super();
		this.product_id = product_id;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.orders = orders;
	}*/
	@Lob
	@Column(name="productimg")
	private byte[] ProductImg;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="publicity_id",nullable = true)
	private Publicity publicity;
	
	
	 public Publicity getPublicity() {
		return publicity;
	}

	public void setPublicity(Publicity publicity) {
		this.publicity = publicity;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	 @Column(name="percentage")
	 private int percentage;


/*	public Product1(String productname, String productdescription, Integer quantity, Double price, String brand,
			byte[] productImg, Publicity publicity, Category1 category, Orders orders) {
		super();
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.orders = orders;
	}*/

	public Product1(@NotNull(message = "Product name is required.") String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price, boolean bestProduct,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, int percentage, Category1 category, Set<Comment> comments,
			Orders orders) {
		super();
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.remise_price = remise_price;
		this.bestProduct = bestProduct;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.percentage = percentage;
		this.category = category;
		this.comments = comments;
		this.orders = orders;
	}

	public Product1(Long product_id, @NotNull(message = "Product name is required.") String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price, boolean bestProduct,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, int percentage, Category1 category, Set<Comment> comments,
			Orders orders) {
		super();
		this.product_id = product_id;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.remise_price = remise_price;
		this.bestProduct = bestProduct;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.percentage = percentage;
		this.category = category;
		this.comments = comments;
		this.orders = orders;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public Product1() {
		super();
	}

	public Long getProduct_id() {
		return product_id;
	}

	

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public byte[] getProductImg() {
		return ProductImg;
	}

	public void setProductImg(byte[] productImg) {
		ProductImg = productImg;
	}

	public Category1 getCategory() {
		return category;
	}

	public void setCategory(Category1 category) {
		this.category = category;
	}
	@JsonBackReference
    //@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	    @JoinColumn(name = "category_id", nullable = true)
	    private Category1 category;
	
	
	@JsonManagedReference
	//@JsonIgnore
	@OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
	private Set<Comment> comments ;
	
    
   


	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

/*public Product1(String productname, String productdescription, Integer quantity, Double price, String brand,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, Orders orders) {
		super();
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.comments = comments;
		this.orders = orders;
	}*/

/*	public Product1(Long product_id, String productname, String productdescription, Integer quantity, Double price,
			String brand, @Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, Orders orders) {
		super();
		this.product_id = product_id;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.comments = comments;
		this.orders = orders;
	}*/
	/*public Product1(Long product_id, String productname, String productdescription, Integer quantity, Double price,
			String brand, Double remise_price,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments) {
		super();
		this.product_id = product_id;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.remise_price = remise_price;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.comments = comments;
	}*/
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	    @JoinColumn(name = "order_id",referencedColumnName = "order_id",insertable = false, nullable = true)
	    private Orders orders;


	public Product1(Long product_id, @NotNull(message = "Product name is required.") String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price, boolean bestProduct,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, Orders orders) {
		super();
		this.product_id = product_id;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.remise_price = remise_price;
		this.bestProduct = bestProduct;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.comments = comments;
		this.orders = orders;
	}

	public Product1(@NotNull(message = "Product name is required.") String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price, boolean bestProduct,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, Orders orders) {
		super();
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.remise_price = remise_price;
		this.bestProduct = bestProduct;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.comments = comments;
		this.orders = orders;
	}

	/*public Product1(Long product_id, String productname, String productdescription, Integer quantity, Double price,
			String brand, byte[] productImg, Category1 category) {
		super();
		this.product_id = product_id;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		ProductImg = productImg;
		this.category = category;
	}*/
	
	
	
	

}
