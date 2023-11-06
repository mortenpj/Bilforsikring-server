package no.morten.bilforsikringserver.integration;

import no.morten.bilforsikringserver.domain.Bilforsikring;
import no.morten.bilforsikringserver.domain.Kunde;
import org.springframework.stereotype.Repository;

@Repository
public class FagSystemIntegrasjon {

    public long opprettKunde(Kunde nyKunde){
        //Kaller Fagsystemet for å opprette ny kunde
        return 0;
    }

    public long opprettNyAvtale(Bilforsikring bilforsikring){
        //Kaller fagsystemet for å opprette ny avtale
        return 0;
    }


}
