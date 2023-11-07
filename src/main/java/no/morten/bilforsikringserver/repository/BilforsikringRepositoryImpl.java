package no.morten.bilforsikringserver.repository;

import no.morten.bilforsikringserver.domain.Bilforsikring;
import no.morten.bilforsikringserver.domain.Kunde;
import no.morten.bilforsikringserver.integration.FagSystemIntegrasjon;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BilforsikringRepositoryImpl implements BilforsikringRepository{

    private final FagSystemIntegrasjon fagSystemIntegrasjon;

    public BilforsikringRepositoryImpl(FagSystemIntegrasjon fagSystemIntegrasjon) {
        this.fagSystemIntegrasjon = fagSystemIntegrasjon;
    }


    @Override
    public List<Bilforsikring> getAllBilforsikring() {
        return null;
    }

    @Override
    public Bilforsikring getBilforsikringById(long id) {
        return null;
    }

    @Override
    public Bilforsikring lagNyBilforsikring(Bilforsikring bilforsikring) {
        /**
         * Dette vet jeg ikke er den optimale måten å gjøre det på da objektet ikke er immutable,
         * noe som er spesielt viktig med en domenemodell.
         */
        long kundeNummer = this.fagSystemIntegrasjon.opprettKunde(bilforsikring.getKunde());
        long avtaleNummer = this.fagSystemIntegrasjon.opprettNyAvtale(bilforsikring);
        bilforsikring.setKundeNummer(kundeNummer);
        bilforsikring.setAvtaleNummer(avtaleNummer);
        return bilforsikring;


    }
}
