package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AdvertRepository extends JpaRepository<Advert,Long> {


    Advert findByAdvertTitle(String advert_title);


    @Query(value = "select count(*) from advert",nativeQuery = true)
    Integer getNumberOfAdvert();
}
