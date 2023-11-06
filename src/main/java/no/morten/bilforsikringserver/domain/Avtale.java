package no.morten.bilforsikringserver.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Avtale {

    @Id
    private Long id;


}
