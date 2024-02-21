package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Room;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.RoomRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.RoomService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateRoomRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateRoomRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllRoomResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByRoomTypeResponse;

import com.askidaevimproject.Ask.da.evim.olsun.service.rules.RoomBusinessRules;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private ModelMapperService modelMapperService;
    private RoomBusinessRules roomBusinessRules;


    @Override
    public List<GetAllRoomResponse> getAllRoom() {


        List<Room> rooms = roomRepository.findAll();

        return rooms.
                stream()
                .map(room ->
                        this.modelMapperService.
                                forResponse().
                                map(room,GetAllRoomResponse.class)).toList();


    }

    @Override
    public void addRoom(CreateRoomRequest createRoomRequest) {


        this.roomBusinessRules.checkIfRoomTypeExists(createRoomRequest.getRoomType());

        Room room = this.modelMapperService.forRequest().map(createRoomRequest,Room.class);
        this.roomRepository.save(room);



    }

    @Override
    public void deleteRoom(Long room_id){

        if(this.roomRepository.existsById(room_id))
            this.roomRepository.deleteById(room_id);

    }

    @Override
    public void updateRoom(UpdateRoomRequest updateRoomRequest){


        this.roomBusinessRules.checkIfRoomTypeExists(updateRoomRequest.getRoomType());

        Room room = this.modelMapperService.forRequest().map(updateRoomRequest,Room.class);
        this.roomRepository.save(room);
    }



    @Override
    public GetByRoomTypeResponse findByRoomType(String roomType) {

        this.roomBusinessRules.checkIfRoomTypeIsNotFound(roomType);
        Room room=this.roomRepository.findByRoomType(roomType);
        return this.modelMapperService.forResponse().map(room,GetByRoomTypeResponse.class);
    }


}
