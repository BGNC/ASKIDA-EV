package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood,Long> {

    Neighborhood findByZipCode(String zip_code);

    Neighborhood findByNeighborhoodName(String neighborhood_name);
}
