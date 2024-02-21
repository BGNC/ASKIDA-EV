package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateRoomRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateRoomRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllRoomResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByRoomTypeResponse;


import java.util.List;


public interface RoomService {

    void deleteRoom(Long room_id);

    List<GetAllRoomResponse> getAllRoom();

    void addRoom(CreateRoomRequest createRoomRequest);

    void updateRoom(UpdateRoomRequest updateRoom);


    GetByRoomTypeResponse findByRoomType(String roomType);


}
