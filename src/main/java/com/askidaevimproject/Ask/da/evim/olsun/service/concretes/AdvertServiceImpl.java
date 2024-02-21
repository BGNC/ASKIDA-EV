package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.*;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.*;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.AdvertService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAdvertByIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllAdvertResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByAdvertTitle;
import com.askidaevimproject.Ask.da.evim.olsun.service.rules.AdvertBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private  AdvertRepository advertRepository;
    private  MemberRepository memberRepository;
    private  ModelMapperService modelMapperService;

    private CityRepository cityRepository;

    private DistrictRepository districtRepository;
    private AdvertBusinessRules advertBusinessRules;
    private MediaRepository mediaRepository;

    private FuelRepository fuelRepository;

    private RoomRepository roomRepository;
    private NeighborhoodRepository neighborhoodRepository;



    public List<GetAllAdvertResponse> getAllAdvert() {
        List<Advert> adverts = this.advertRepository.findAll();

        return adverts
                .stream()
                .map(advert ->
                        this.
                                modelMapperService.
                                forResponse().
                                map(advert,GetAllAdvertResponse.class)).
                toList();
    }


    public void deleteAdvert(Long advert_id) {

        if(advertRepository.existsById(advert_id))
            if(memberRepository.existsById(advertRepository.findById(advert_id).get().getMember().getMemberId()))

            {
                //Delete medias that have related advert id from media table.
                List<Media> mediaList = mediaRepository.getAllMediaById(advert_id);
                if(mediaList != null) {
                    for (int i = 0; mediaList.size() > i; i++) {
                        mediaRepository.deleteById(mediaList.get(i).getMediaId());
                    }
                }
                advertRepository.deleteById(advert_id);
            }

    }

    @Override
    public void updateAdvert(UpdateAdvertRequest updateAdvertRequest) {
        // There will be error here because there is id in updateAdvertRequest but in Advert.class , there is object.
        // They cannot be mapped each other.
        Advert advert=this.modelMapperService.forRequest().map(updateAdvertRequest,Advert.class);
        Advert advert1 = new Advert().builder()
                .advertId(updateAdvertRequest.getAdvertId())
                .advertTitle(updateAdvertRequest.getAdvertTitle())
                .ageOfDwelling(updateAdvertRequest.getAgeOfDwelling())
                .city(cityRepository.findById(updateAdvertRequest.getCityId()).get())
                .description(updateAdvertRequest.getDescription())
                .district(districtRepository.findById(updateAdvertRequest.getDistrictId()).get())
                .fuel(fuelRepository.findById(updateAdvertRequest.getFuelId()).get())
                .room(roomRepository.findById(updateAdvertRequest.getRoomId()).get())
                .meterSquare(updateAdvertRequest.getMeterSquare())
                .neighborhood(neighborhoodRepository.findById(updateAdvertRequest.getNeighborhoodId()).get())
                .member(memberRepository.findById(updateAdvertRequest.getMemberId()).get())
                .build();

        this.advertRepository.save(advert1);



    }

    @Override
    public GetByAdvertTitle getByAdvertTitle(String advert_title) {

        Advert advert= this.advertRepository.findByAdvertTitle(advert_title);
        return this.modelMapperService.forResponse().map(advert,GetByAdvertTitle.class);
    }

    @Override
    public GetAdvertByIdResponse getAdvertById(Long advertId) {
        Optional<Advert> advert1 = advertRepository.findById(advertId);
        if(advert1.isEmpty()){
            return null;
        }
        Advert advert = advert1.get();
        GetAdvertByIdResponse getAdvertByIdResponse = new GetAdvertByIdResponse().builder()
                .advertId(advert.getAdvertId())
                .advertTitle(advert.getAdvertTitle())
                .fuelType(advert.getFuel().getFuelType())
                .memberName(advert.getMember().getMemberName())
                .cityName(advert.getCity().getCityName())
                .neighborhoodName("Mahalle")
                .districtName(advert.getDistrict().getDistrictName())
                .roomType(advert.getRoom().getRoomType())
                .ageOfDwelling(advert.getAgeOfDwelling())
                .description(advert.getDescription())
                .meterSquare(advert.getMeterSquare())
                .build();
        return getAdvertByIdResponse;
        
    }

    @Override
    public Integer getNumberOfAdvert() {
        return advertRepository.getNumberOfAdvert();
    }

    public ResponseEntity<Object> addAdvert(CreateAdvertRequest createAdvertRequest) {
        // There will be error here because there is id in updateAdvertRequest but in Advert.class , there is object.
        // They cannot be mapped each other.
        Member member = memberRepository.findById(createAdvertRequest.getMemberId()).get();
        System.out.println(member.getIsActivate());
        if(member.getIsActivate() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        Neighborhood neighborhood = new Neighborhood().builder()
                .neighborhoodName(createAdvertRequest.getNeighborhoodName())
                .build();
        neighborhoodRepository.save(neighborhood);
        Neighborhood savedNeighborhood = neighborhoodRepository.findByNeighborhoodName(neighborhood.getNeighborhoodName());
        Advert advert = new Advert().builder()
                .advertTitle(createAdvertRequest.getAdvertTitle())
                .city(cityRepository.findById(createAdvertRequest.getCityId()).get())
                .fuel(fuelRepository.findById(createAdvertRequest.getFuelId()).get())
                .district(districtRepository.findById(createAdvertRequest.getDistrictId()).get())
                .member(memberRepository.findById(createAdvertRequest.getMemberId()).get())
                .neighborhood(savedNeighborhood)
                .ageOfDwelling(createAdvertRequest.getAgeOfDwelling())
                .room(roomRepository.findById(createAdvertRequest.getRoomId()).get())
                .description(createAdvertRequest.getDescription())
                .meterSquare(createAdvertRequest.getMeterSquare())
                .isActivate(0)
                .build();
        /*
        List<String> photoWays = createAdvertRequest.getPhotoWays();
        if(photoWays != null) {
            for (String photoWay : photoWays) {
                Media media = new Media();
                media.setAdvert(advert);
                media.setPhotoWay(photoWay);
                mediaRepository.save(media);
            }
        }

         */

        /*
        boolean flag = this.advertBusinessRules.checkPointBeforeUserAddAdvert(advert);
        if(flag){
            this.advertRepository.save(advert);
            return new ResponseEntity<>(HttpStatus.OK);
        }
*/
        this.advertRepository.save(advert);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
