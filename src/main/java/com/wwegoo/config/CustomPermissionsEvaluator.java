package com.wwegoo.config;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomPermissionsEvaluator implements PermissionEvaluator {

    public boolean hasPermission(String id) {
        return id.equals("correct");
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
    	for (GrantedAuthority originalAuth : authentication.getAuthorities()) {
    		if (originalAuth.getAuthority().equals(permission)) {
    			return true;
    		}
    	}
    	return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
    	return false;
    }
}