package com.askidaevimproject.Ask.da.evim.olsun.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long advert_id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(
            name="member_id",
            referencedColumnName = "member_id")
    private Member member;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "fk_dwelling_id",
    referencedColumnName = "dwelling_id")
    private Dwelling dwelling;

    private String advert_title;




}
