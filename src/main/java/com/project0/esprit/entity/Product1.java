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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project0.esprit.datentity.Comment;
import com.project0.esprit.datentity.Favourite;

import com.project0.esprit.datentity.WishList;
@Entity
@Table(name="product")
public class Product1 extends AuditModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long product_id;
	@NotNull(message = "Product name is required.")
    @Basic(optional = false)
	
	@Column(name="productweight",nullable = true)
	private Double productWieght ;
	
	

	

	

	
	@JsonBackReference
	//@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="favourite_id",nullable = true)
	private Favourite favourite;
	public Favourite getFavourite() {
		return favourite;
	}

	public Product1(@NotNull(message = "Product name is required.") Double productWieght, Favourite favourite,
			String productsize, String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, Orders orders) {
		super();
		this.productWieght = productWieght;
		this.favourite = favourite;
		this.productsize = productsize;
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
	}

	public void setFavourite(Favourite favourite) {
		this.favourite = favourite;
	}

	public Product1(Long product_id, @NotNull(message = "Product name is required.") Double productWieght,
			Favourite favourite, String productsize, String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, Orders orders) {
		super();
		this.product_id = product_id;
		this.productWieght = productWieght;
		this.favourite = favourite;
		this.productsize = productsize;
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
	}

	public Double getProductWieght() {
		return productWieght;
	}

	public Product1(@NotNull(message = "Product name is required.") Double productWieght, String productsize,
			String productname, @NotBlank(message = "description  is mandatory") String productdescription,
			Integer quantity, Double price, @NotBlank(message = "Brand is mandatory") String brand, Double remise_price,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, Orders orders) {
		super();
		this.productWieght = productWieght;
		this.productsize = productsize;
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
	}

	public Product1(Long product_id, @NotNull(message = "Product name is required.") Double productWieght,
			String productsize, String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, Orders orders) {
		super();
		this.product_id = product_id;
		this.productWieght = productWieght;
		this.productsize = productsize;
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
	}

	public void setProductWieght(Double productWieght) {
		this.productWieght = productWieght;
	}

	public String getProductsize() {
		return productsize;
	}

	public void setProductsize(String productsize) {
		this.productsize = productsize;
	}
	@Column(name="productsize",nullable = true)
	private String productsize ;
	
	@Column(name="productname",unique = true)
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
	
	
	
	@Column(columnDefinition = "integer default 0")
	private Integer likes ;
	
	
	@Column(columnDefinition = "integer default 0")
	private Integer deslike ;
	


	
	
	
	
	

	
	public  void   adddesLike() {
		
		deslike ++ ;
		
		
		
		
	}
	
	
	
	
	
	
	
	public Product1(@NotNull(message = "Product name is required.") Double productWieght, Favourite favourite,
			String productsize, String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price, Integer like, Integer deslike,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, WishList wishlist,
			Orders orders) {
		super();
		this.productWieght = productWieght;
		this.favourite = favourite;
		this.productsize = productsize;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.remise_price = remise_price;
		this.likes = like;
		this.deslike = deslike;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.comments = comments;
		this.wishlist = wishlist;
		this.orders = orders;
	}

	public Product1(Long product_id, @NotNull(message = "Product name is required.") Double productWieght,
			Favourite favourite, String productsize, String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price, Integer like, Integer deslike,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, WishList wishlist,
			Orders orders) {
		super();
		this.product_id = product_id;
		this.productWieght = productWieght;
		this.favourite = favourite;
		this.productsize = productsize;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.remise_price = remise_price;
		this.likes = like;
		this.deslike = deslike;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.comments = comments;
		this.wishlist = wishlist;
		this.orders = orders;
	}

	public Integer getDeslike() {
		return deslike;
	}

	public void setDeslike(Integer deslike) {
		this.deslike = deslike;
	}

	public void decrese() {
		deslike --;
		
	}
	
	
	public void increment() {
		
		likes++;
	}
	
	public  void decrements() {
		if(likes==0) {
			likes=0;
		}
		else likes--;
	}
	
	
	public Product1(@NotNull(message = "Product name is required.") Double productWieght, Favourite favourite,
			String productsize, String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price, Integer like,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, WishList wishlist,
			Orders orders) {
		super();
		this.productWieght = productWieght;
		this.favourite = favourite;
		this.productsize = productsize;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.remise_price = remise_price;
		this.likes = like;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.comments = comments;
		this.wishlist = wishlist;
		this.orders = orders;
	}

	public Integer getLike() {
		return likes;
	}
	@Column(name = "productViews", nullable = false, columnDefinition = "bigint(20) default 0")
    private long productViews = 0;

	public Integer getLikes() {
		return likes;
	}

	public Product1(@NotNull(message = "Product name is required.") Double productWieght, Favourite favourite,
			String productsize, String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price, Integer likes, Integer deslike,
			long productViews,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, WishList wishlist,
			Orders orders) {
		super();
		this.productWieght = productWieght;
		this.favourite = favourite;
		this.productsize = productsize;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.remise_price = remise_price;
		this.likes = likes;
		this.deslike = deslike;
		this.productViews = productViews;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.comments = comments;
		this.wishlist = wishlist;
		this.orders = orders;
	}

	public Product1(Long product_id, @NotNull(message = "Product name is required.") Double productWieght,
			Favourite favourite, String productsize, String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price, Integer likes, Integer deslike,
			long productViews,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, WishList wishlist,
			Orders orders) {
		super();
		this.product_id = product_id;
		this.productWieght = productWieght;
		this.favourite = favourite;
		this.productsize = productsize;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.remise_price = remise_price;
		this.likes = likes;
		this.deslike = deslike;
		this.productViews = productViews;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.comments = comments;
		this.wishlist = wishlist;
		this.orders = orders;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public long getProductViews() {
		return productViews;
	}

	public void setProductViews(long productViews) {
		this.productViews = productViews;
	}

	public void setLike(Integer like) {
		this.likes = like;
	}

	public Product1(Long product_id, @NotNull(message = "Product name is required.") Double productWieght,
			Favourite favourite, String productsize, String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price, Integer like,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, WishList wishlist,
			Orders orders) {
		super();
		this.product_id = product_id;
		this.productWieght = productWieght;
		this.favourite = favourite;
		this.productsize = productsize;
		this.productname = productname;
		this.productdescription = productdescription;
		Quantity = quantity;
		this.price = price;
		Brand = brand;
		this.remise_price = remise_price;
		this.likes = like;
		this.codebar = codebar;
		ProductImg = productImg;
		this.publicity = publicity;
		this.category = category;
		this.comments = comments;
		this.wishlist = wishlist;
		this.orders = orders;
	}

	public Product1(String productname, String productdescription, Integer quantity, Double price, String brand,
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
	}

	public Double getRemise_price() {
		return remise_price;
	}

	public void setRemise_price(Double remise_price) {
		this.remise_price = remise_price;
	}
	public Product1(Long product_id, String productname, String productdescription, Integer quantity, Double price,
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
	}
	@Column(name="codebar")
	@Pattern(message = "codebar must start  with 619", regexp="^619*[0-9]{9}")
	private String codebar ;
	
	public Product1(String productname, String productdescription, Integer quantity, Double price, String brand,
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
	}

	public String getCodebar() {
		return codebar;
	}
	//@Max(value = 12)
	//@Min(value=10)
	public void setCodebar(String codebar) {
		this.codebar = codebar;
	}
	public Product1(Long product_id, String productname, String productdescription, Integer quantity, Double price,
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
	}
	
	@Lob
	@Column(name="productimg")
	private byte[] ProductImg;
	
	
	@JsonBackReference
	//@JsonIgnore
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

	public Product1(String productname, String productdescription, Integer quantity, Double price, String brand,
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
//id  entity =  entity_id
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
	//@JsonBackReference(value = "cat1")
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	    @JoinColumn(name = "category_id", nullable = true,referencedColumnName = "category_id")
	    private Category1 category;
	
	
	//@JsonManagedReference(value = "prod1")
	@JsonIgnore
	@OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
	private Set<Comment> comments ;
	
    
	//@JsonBackReference(value = "cat1")
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	    @JoinColumn(name = "wishlist_id", nullable = true,referencedColumnName = "id")
	    private WishList wishlist;



	public Product1(Long product_id, @NotNull(message = "Product name is required.") Double productWieght,
			Favourite favourite, String productsize, String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, WishList wishlist,
			Orders orders) {
		super();
		this.product_id = product_id;
		this.productWieght = productWieght;
		this.favourite = favourite;
		this.productsize = productsize;
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
		this.wishlist = wishlist;
		this.orders = orders;
	}

	public Product1(@NotNull(message = "Product name is required.") Double productWieght, Favourite favourite,
			String productsize, String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, WishList wishlist,
			Orders orders) {
		super();
		this.productWieght = productWieght;
		this.favourite = favourite;
		this.productsize = productsize;
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
		this.wishlist = wishlist;
		this.orders = orders;
	}

	public WishList getWishlist() {
		return wishlist;
	}

	public void setWishlist(WishList wishlist) {
		this.wishlist = wishlist;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Product1(String productname, String productdescription, Integer quantity, Double price, String brand,
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
	}

	public Product1(Long product_id, String productname, String productdescription, Integer quantity, Double price,
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
	}
	public Product1(Long product_id, String productname, String productdescription, Integer quantity, Double price,
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
	}
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	    @JoinColumn(name = "order_id",referencedColumnName = "order_id",insertable = false, nullable = true)
	    private Orders orders;

	public Product1(Long product_id, String productname, String productdescription, Integer quantity, Double price,
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
	}

	/*public Product1(Long product_id, @NotNull(message = "Product name is required.") Double productWieght,
			Favourite favourite, String productsize, String productname,
			@NotBlank(message = "description  is mandatory") String productdescription, Integer quantity, Double price,
			@NotBlank(message = "Brand is mandatory") String brand, Double remise_price,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar,
			byte[] productImg, Publicity publicity, Category1 category, Set<Comment> comments, Orders orders) {
		super();
		this.product_id = product_id;
		this.productWieght = productWieght;
		this.favourite = favourite;
		this.productsize = productsize;
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
	}
	
	*/
	
	

}
