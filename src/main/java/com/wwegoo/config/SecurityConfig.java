package com.wwegoo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends GlobalMethodSecurityConfiguration {

		@Autowired
		private CustomPermissionsEvaluator permissionEvaluator;

		@Autowired
		private ApplicationContext applicationContext;

		protected MethodSecurityExpressionHandler createExpressionHandler() {

			DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
			expressionHandler.setPermissionEvaluator(permissionEvaluator);
			expressionHandler.setApplicationContext(applicationContext);

			return expressionHandler;
		}
}
