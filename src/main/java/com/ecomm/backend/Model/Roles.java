package com.ecomm.backend.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
//@Table(name="role")
public class Roles {

	@Id
	@Column(name = "Role_Id", nullable = false)
	private int roleId;
	@Column(name = "Role_Name", nullable = false)
	private String roleName;

	@ManyToMany(mappedBy = "role")
	Set<User> user = new HashSet<>();

}
