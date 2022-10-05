package com.paradise.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paradise.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

		@Transactional
		@Modifying
		@Query("Delete from Admin v where v.adminId=:id")
		public void deleteAdmin(@Param("id") Integer id);

		@Transactional
		@Query("Select a from Admin a where a.username=:ausername and a.password=:apassword")
		public Admin login(@Param("ausername") String id,@Param("apassword") String apassword);

	}

