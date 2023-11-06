package no.morten.bilforsikringserver.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Kunde {

    @Id
    @GeneratedValue
    private Long id;

    private String fornavn;
    private String etternavn;
    private String fodselsNummer;
    private String epost;

    public Kunde(String fornavn, String etternavn, String fodselsNummer, String epost){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsNummer = fodselsNummer;
        this.epost = epost;
    }
}
