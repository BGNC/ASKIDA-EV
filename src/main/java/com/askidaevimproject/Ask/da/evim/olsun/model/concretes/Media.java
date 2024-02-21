package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dphoto_id")
    private Long mediaId;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "advert_id",
                referencedColumnName = "advert_id")
        private Advert advert;



    @Column(name = "photo_way")
    private String photoWay;


    /* Another fields about photo !
    *  This code will be written with controller and service layers.
    *
    *
    * * */


}
