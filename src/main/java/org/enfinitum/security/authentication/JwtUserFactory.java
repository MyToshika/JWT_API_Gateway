package org.enfinitum.security.authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.enfinitum.security.model.User;
import org.springframework.security.core.GrantedAuthority;
public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),          
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                getAuthorities(),
                user.isEnabled() ,
                user.getLastPasswordChangedOn()
        );
    }

	public static Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities= new ArrayList<>();
		 authorities.add(new GrantedAuthority(){

			@Override
			public String getAuthority() {
				
				return "Customer";
			}});
		 return authorities;
	}
	
}
