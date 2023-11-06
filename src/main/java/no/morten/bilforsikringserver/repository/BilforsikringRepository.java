package no.morten.bilforsikringserver.repository;

import no.morten.bilforsikringserver.domain.Bilforsikring;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface BilforsikringRepository extends Repository<Bilforsikring, Long> {
    List<Bilforsikring> getAllBilforsikring();
    Bilforsikring getBilforsikringById(long id);
    Bilforsikring lagNyBilforsikring(Bilforsikring bilforsikring);
}
