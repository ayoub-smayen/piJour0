package com.project0.esprit.datentity;


public enum RoleEnum {

    ROLE_ADMIN("ROLE_ADMIN"), ROLE_USER("ROLE_USER"), DELIVERY_MAN("DELIVERY_MAN");
	
	public String role ;
	
	public String  getRole() {
		
		return this.role;
	}
	
	RoleEnum(String g){
		this.role =g;
	}

}
