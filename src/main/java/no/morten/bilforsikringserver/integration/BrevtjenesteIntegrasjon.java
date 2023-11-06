package no.morten.bilforsikringserver.integration;

import no.morten.bilforsikringserver.domain.Avtale;
import no.morten.bilforsikringserver.domain.Kunde;
import org.springframework.stereotype.Repository;
@Repository
public class BrevtjenesteIntegrasjon {

    public long sendAvtaleTilKunde(Kunde kunde, Avtale avtale){
        //Send kunde og avtale informasjon til Brevtjenesten
        return 0;
    }
}
