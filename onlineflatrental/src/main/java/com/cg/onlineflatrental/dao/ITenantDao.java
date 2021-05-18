package com.cg.onlineflatrental.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineflatrental.model.Tenant;

/*public class ITenantDao {
    
}
*/

@Repository
public interface ITenantDao extends JpaRepository<Tenant, Integer> {
//	@Query("select t from Tenant t where t.tenantId=:tenantId")
 //    Boolean deleteTenantByID(int tenantId);

	//Tenant deleteTenantByID(int tenant_id);

	
}
