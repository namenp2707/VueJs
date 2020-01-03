package com.cpe.backend.Carname.Repository;

import com.cpe.backend.Carname.Entity.Province;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ProvinceRepository extends JpaRepository<Province, Long> {
	Province findById(long id);
}