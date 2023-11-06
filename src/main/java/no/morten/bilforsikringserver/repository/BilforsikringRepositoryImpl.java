package no.morten.bilforsikringserver.repository;

import no.morten.bilforsikringserver.domain.Bilforsikring;
import no.morten.bilforsikringserver.domain.Kunde;
import no.morten.bilforsikringserver.integration.FagSystemIntegrasjon;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BilforsikringRepositoryImpl implements BilforsikringRepository{

    private final BilforsikringRepository bilforsikringRepository;
    private final FagSystemIntegrasjon fagSystemIntegrasjon;

    public BilforsikringRepositoryImpl(BilforsikringRepository bilforsikringRepository, FagSystemIntegrasjon fagSystemIntegrasjon) {
        this.bilforsikringRepository = bilforsikringRepository;
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
        long kundeNummer = this.fagSystemIntegrasjon.opprettKunde(bilforsikring.getKunde());
        long avtaleNummer = this.fagSystemIntegrasjon.opprettNyAvtale(bilforsikring);


    }
}
