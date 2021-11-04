package com.amigoscode.app.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.amigoscode.app.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {

	STUDENT(Set.of()),
	ADMIN(Set.of(STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE)),
	ADMINTRAINEE(Set.of(STUDENT_READ, COURSE_READ));
	
	private final Set<ApplicationUserPermission> permissions;

	private ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}

	public Set<GrantedAuthority> getGrantedAuthorities() {
		Set<GrantedAuthority> authorities = getPermissions().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toSet());

		authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

		return authorities;
	}
}
