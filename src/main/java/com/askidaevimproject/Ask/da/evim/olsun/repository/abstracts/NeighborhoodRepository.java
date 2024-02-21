package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood,Long> {

    Neighborhood findByZipCode(String zip_code);

    @Query(value = "select * from neighborhood where neighborhood_name = ?1 limit 1", nativeQuery = true)
    Neighborhood findByNeighborhoodName(String neighborhood_name);
}
