package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply,Long> {

    @Query(value = "select * from application where advert_id = ?1 and member_id = ?2",nativeQuery = true)
    Apply findByMemberIdAndAdvertId(Long advertId, Long memberId);

    @Query(value = "select DISTINCT advert_id from application where advert_id IN (select advert_id from application where status = 0) " , nativeQuery = true)
    List<Long> getAdvertIds();

    @Query(value = "select * from application where advert_id = ?1",nativeQuery = true)
    List<Apply> findByMemberId(Long memberId);
}
