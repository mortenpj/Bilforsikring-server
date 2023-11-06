package no.morten.bilforsikringserver.web.business;

import no.morten.bilforsikringserver.domain.Bilforsikring;
import no.morten.bilforsikringserver.domain.Kunde;
import no.morten.bilforsikringserver.repository.BilforsikringRepository;
import no.morten.bilforsikringserver.web.models.BilforsikringDto;
import no.morten.bilforsikringserver.web.models.KundeDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BilforsikringBusiness {

    private final BilforsikringRepository repository;

    public BilforsikringBusiness(BilforsikringRepository bilforsikringRepository) {
        this.repository = bilforsikringRepository;
    }

    public List<BilforsikringDto> getAlleBilforsikringer() {
        List<Bilforsikring> alleBilforsikringer = this.repository.getAllBilforsikring();
        List<BilforsikringDto> bilforsikringDtoListe = new ArrayList<>();
        alleBilforsikringer.forEach(bilforsikring -> {
            bilforsikringDtoListe.add(this.konverterBilforsikringTilDto(bilforsikring));
        });
        return bilforsikringDtoListe;
    }

    public BilforsikringDto getBilforsikringMedId(Long id) {
        Bilforsikring bilforsikring = this.repository.getBilforsikringById(id);
        BilforsikringDto dto = null;
        if(bilforsikring != null){
            dto = konverterBilforsikringTilDto(bilforsikring);
        }
        return dto;
    }

    public BilforsikringDto createBilforsikring(BilforsikringDto bilforsikringDto){
        Bilforsikring nyBilforsikring =  this.repository.lagNyBilforsikring(
                konverterDtoTilBilforsikring(bilforsikringDto));
        BilforsikringDto nyBilforsikringDto = null;
        if(nyBilforsikring != null){
            nyBilforsikringDto = this.konverterBilforsikringTilDto(nyBilforsikring);
        }
        return nyBilforsikringDto;
    }
    private BilforsikringDto konverterBilforsikringTilDto(Bilforsikring bilforsikring) {
        KundeDto kundeDto = this.konverterForsikringEierTilDto(bilforsikring.getKunde());
        return new BilforsikringDto(
                bilforsikring.getId(),
                bilforsikring.getRegistreringsNummer(),
                bilforsikring.getBonus(),
                kundeDto,
                bilforsikring.getAntallAar()
        );
    }

    private KundeDto konverterForsikringEierTilDto(Kunde kunde) {
        return new KundeDto(
                kunde.getId(),
                kunde.getFornavn(),
                kunde.getEtternavn(),
                kunde.getFodselsNummer(),
                kunde.getEpost()
        );
    }

    private Kunde konverterDtoTilKunde(KundeDto kundeDto){
        return new Kunde(
                kundeDto.getFornavn(),
                kundeDto.getEtternavn(),
                kundeDto.getFodselsNummer(),
                kundeDto.getEpost());
    }

    private Bilforsikring konverterDtoTilBilforsikring(BilforsikringDto bilforsikringDto){
        return new Bilforsikring(
                bilforsikringDto.getRegistreringsNummer(),
                bilforsikringDto.getBonus(),
                this.konverterDtoTilKunde(bilforsikringDto.getKundeDto()),
                bilforsikringDto.getAntallAar());
    }
}
