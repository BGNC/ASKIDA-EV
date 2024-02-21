package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.*;


@Entity
@Table(name = "neighborhood")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Neighborhood {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="neighborhood_id")
    private Long neighborhoodId;

    @Column(name = "neighborhood_name")
    private String neighborhoodName;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(
            name = "district_id",
            referencedColumnName = "district_id"
    )
    private District district;

    @Column(name="zip_code")

    private String zipCode;
}