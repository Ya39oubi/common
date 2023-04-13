package tn.com.abt.smw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.com.abt.smw.domain.AccessPermissions;

@Repository
public interface AccessPermissionsRepository extends JpaRepository<AccessPermissions, Long> {

	@Query(value = "SELECT a.* FROM syn_access_permissions a WHERE a.id_access_client = ?1 AND a.id_microservice_method = (SELECT sm.id_microservice_method FROM syn_microservices_methods sm WHERE sm.security_role = ?2 AND sm.lib = ?3)", nativeQuery = true)
	AccessPermissions findByIdAccessClientAndSecurityRole(Long idAccessClient, String securityRole, String methodName);

}
