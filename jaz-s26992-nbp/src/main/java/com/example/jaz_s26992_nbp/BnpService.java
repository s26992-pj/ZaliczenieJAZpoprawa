package com.example.jaz_s26992_nbp;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class BnpService {
    private BnPRepozitory bnPRepozitory;
    private final String url = "http://api.nbp.pl/api/cenyzlota/{startDate}/{endDate}";

    private final RestTemplate restTemplate;

    public BnpService(BnPRepozitory bnPRepozitory, RestTemplate restTemplate) {
        this.bnPRepozitory = bnPRepozitory;
        this.restTemplate = restTemplate;
    }

    public ZlotoSrednia kurs(Long days){
        LocalDate localDate = LocalDate.now();
        LocalDate startDate = localDate.minusDays(days);
        ZlotoSrednia zlotoSrednia = restTemplate.getForObject(url, ZlotoSrednia.class, startDate, localDate);
        Double sum = 0.0;
        for(ZlotoCena cena : zlotoSrednia.getZlotoCena()) {
            sum+= cena.getMid();
        }
        Double avgSum = sum/zlotoSrednia.getZlotoCena().size();
        BnpBaza bnpBaza = new BnpBaza();
        bnpBaza.setKurs(sum);
        bnpBaza.setCzas(LocalDateTime.now());
        bnpBaza.setZloto(Zloto.ZLOTO);
        bnpBaza.setData_end(startDate);
        bnpBaza.setData_start(localDate);

        bnPRepozitory.save(bnpBaza);
        return zlotoSrednia;
    }
}
