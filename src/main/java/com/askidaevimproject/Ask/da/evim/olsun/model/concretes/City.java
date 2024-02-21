package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import static jakarta.persistence.GenerationType.*;

@Table(name = "city")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="city_id")

    private Long cityId;

    @Column(name = "city_name")
    private String cityName;


}