package com.project0.esprit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="codebart")
public class CodeBart {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	Long codebar_id;
	
	public CodeBart(@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar) {
		super();
		this.codebar = codebar;
	}

	public String getCodebar() {
		return codebar;
	}

	public CodeBart() {
		super();
	}

	public CodeBart(Long codebar_id,
			@Pattern(message = "codebar must start  with 619", regexp = "^619*[0-9]{9}") String codebar) {
		super();
		this.codebar_id = codebar_id;
		this.codebar = codebar;
	}

	public void setCodebar(String codebar) {
		this.codebar = codebar;
	}

	@Column(name="codebar_text")
	@Max(value = 12)
	@Min(value=10)
	@Pattern(message = "codebar must start  with 619", regexp="^619*[0-9]{9}")
	private String codebar;
}
