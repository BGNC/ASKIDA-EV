package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District,Long> {

    District findByDistrictName(String district_name);

    @Query(value = "select * from district where city_id = ?1",nativeQuery = true)
    List<District> findDistrictByCityId(Long cityId);
}
