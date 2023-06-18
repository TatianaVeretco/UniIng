package com.gmail.tveretco.UniIng.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Remont {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameSE;
    private String groupSE;
    private Integer Or1;//Ор - опробование приводов оборудования и УРЗА
    private Integer O;//О - опробование приводов оборудования
    private Integer T;//Т - текущий ремонт п/ст
    private Integer T1;//Т1 - текущий ремонт п/ст
    private Integer T2;//Т2 - текущий ремонт п/ст
    private Integer K;//К  - комплексный ремонт
    private Integer I;//И - испытание оборудования
    private Integer P;//Р - релейная защита
    private Integer Ktr;//К тр - кап. ремонт силового трансформатора
}
