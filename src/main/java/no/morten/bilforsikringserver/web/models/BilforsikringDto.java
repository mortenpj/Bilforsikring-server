package no.morten.bilforsikringserver.web.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class BilforsikringDto {

    private Long id;
    private String registreringsNummer;
    private int bonus;
    private KundeDto kundeDto;
    private int antallAar;
}
