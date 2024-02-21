package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository  extends JpaRepository<Room,Long> {


    Room findByRoomType(String roomType);

    boolean existsByRoomType(String roomType);
}
