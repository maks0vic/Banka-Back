package racun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import racun.enums.RacunType;
import racun.model.Racun;
import racun.repository.RacunRepository;

import java.util.UUID;


@Service
public class RacunService {

    private RacunRepository racunRepository;
    private final SredstvaKapitalService sredstvaKapitalService;

    @Autowired
    public RacunService(RacunRepository racunRepository, SredstvaKapitalService sredstvaKapitalService){
        this.racunRepository = racunRepository;
        this.sredstvaKapitalService = sredstvaKapitalService;
    }

    public Racun createRacun(){
        Racun racun = new Racun();
        racun.setBrojRacuna(UUID.randomUUID());
        racun.setTipRacuna(RacunType.KES);
        racunRepository.save(racun);
        sredstvaKapitalService.updateStanje(racun.getBrojRacuna(),1000,0,0,"RSD",0); //Pocetno stanje za testiranje

        return racun;
    }



}
