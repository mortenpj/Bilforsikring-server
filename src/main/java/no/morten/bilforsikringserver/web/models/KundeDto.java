package no.morten.bilforsikringserver.web.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class KundeDto {

    private Long id;
    private String fornavn;
    private String etternavn;
    private String fodselsNummer;
    private String epost;
}
