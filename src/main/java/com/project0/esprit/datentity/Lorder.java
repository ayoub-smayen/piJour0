package com.project0.esprit.datentity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project0.esprit.entity.AuditModel;
/*
public class Lorder  {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @JsonFormat(pattern = "dd/MM/yyyy")
	    private LocalDate dateCreated;

	    private String status;

	    @JsonManagedReference
	    @OneToMany(mappedBy = "pk.order")
	    @Valid
	    private List<OrderProduct2> orderProducts = new ArrayList<>();

	    @Transient
	    public Double getTotalOrderPrice() {
	        double sum = 0D;
	        List<OrderProduct2> orderProducts = getOrderProducts();
	        for (OrderProduct2 op : orderProducts) {
	            sum += op.getTotalPrice();
	        }
	        return sum;
	    }

	    @Override
		public String toString() {
			return "Lorder [id=" + id + ", dateCreated=" + dateCreated + ", status=" + status + ", orderProducts="
					+ orderProducts + "]";
		}

		public Lorder() {
			super();
		}

		public Lorder(LocalDate dateCreated, String status, @Valid List<OrderProduct2> orderProducts) {
			super();
			this.dateCreated = dateCreated;
			this.status = status;
			this.orderProducts = orderProducts;
		}

		public Lorder(Long id, LocalDate dateCreated, String status, @Valid List<OrderProduct2> orderProducts) {
			super();
			this.id = id;
			this.dateCreated = dateCreated;
			this.status = status;
			this.orderProducts = orderProducts;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDate getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(LocalDate dateCreated) {
			this.dateCreated = dateCreated;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<OrderProduct2> getOrderProducts() {
			return orderProducts;
		}

		public void setOrderProducts(List<OrderProduct2> orderProducts) {
			this.orderProducts = orderProducts;
		}

		@Transient
	    public int getNumberOfProducts() {
	        return this.orderProducts.size();
	    }

}
*/