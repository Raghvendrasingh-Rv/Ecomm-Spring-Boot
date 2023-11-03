package com.ecomm.backend.Model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "userInfo")
@Getter
@Setter
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	@Column(nullable = false)
	private String name;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false, length = 10)
	private String phone;
	@Column(name = "CreatedAt")
	private Date date;
	private boolean active;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<Roles> role = new HashSet<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> collect = this.role.stream().map(r -> new SimpleGrantedAuthority(r.getRoleName()))
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
