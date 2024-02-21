package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import static jakarta.persistence.FetchType.EAGER;

import static jakarta.persistence.GenerationType.*;


@Table(name="district")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class District {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="district_id")
    private Long districtId;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(
                name = "city_id", // add f_ tag to show
              referencedColumnName = "city_id"
    )
    private City city;

    @Column(name="district_name")
    private String districtName;
}