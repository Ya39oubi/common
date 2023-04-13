package tn.com.abt.smw.service;

import tn.com.abt.smw.template.ResourceAccessPermission;

public interface AccessPermissionsService {

	/**
	 * 
	 * @param idAccessClient
	 * @param securityRole
	 * @param methodName
	 * @return
	 */
	ResourceAccessPermission getResourceAccessPermission(Long idAccessClient, String securityRole, String methodName);

}
