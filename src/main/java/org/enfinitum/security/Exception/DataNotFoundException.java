package org.enfinitum.security.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Data Not Found") 
public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	public DataNotFoundException(int id){
		
		super("Data is not Avialable for  id = "+id);
		this.id=id;
	}
	
	public DataNotFoundException(){
		
		super("Data is not Avialable");
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
