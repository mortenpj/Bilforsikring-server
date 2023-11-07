package no.morten.bilforsikringserver.domain;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Bilforsikring {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long kundeNummer;
    private Long avtaleNummer;

    private String registreringsNummer;

    private int bonus;

    @Embedded
    private Kunde kunde;

    private int antallAar;

    public Bilforsikring(String registreringsNummer, int bonus, Kunde kunde, int antallAar){
        this.registreringsNummer = registreringsNummer;
        this.bonus = bonus;
        this.kunde = kunde;
        this.antallAar = antallAar;
    }
}
