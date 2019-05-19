package org.enfinitum.security.authentication;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser extends org.springframework.security.core.userdetails.User {


	private static final long serialVersionUID = 1L;
	private final Long id;
    private final String firstname;
    private final String lastname;
    private final String email;
    private Date lastPasswordChangedOn;

    public JwtUser(
          Long id,
          String firstname,
          String lastname,
          String email,
          String password, 
          Collection<? extends GrantedAuthority> authorities,
          boolean enabled,
          Date lastPasswordChangedOn
    ) {
    	super(email,password,enabled,true,true,true,authorities);
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
       this.lastPasswordChangedOn=lastPasswordChangedOn;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

	/**
	 * @return the lastPasswordChangedOn
	 */
	public Date getLastPasswordChangedOn() {
		return lastPasswordChangedOn;
	}

	/**
	 * @param lastPasswordChangedOn the lastPasswordChangedOn to set
	 */
	public void setLastPasswordChangedOn(Date lastPasswordChangedOn) {
		this.lastPasswordChangedOn = lastPasswordChangedOn;
	}

}
