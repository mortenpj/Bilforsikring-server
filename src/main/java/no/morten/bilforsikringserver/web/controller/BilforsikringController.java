package no.morten.bilforsikringserver.web.controller;

import no.morten.bilforsikringserver.web.business.BilforsikringBusiness;
import no.morten.bilforsikringserver.web.models.BilforsikringDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BilforsikringController {

    private final BilforsikringBusiness bilforsikringBusiness;

    BilforsikringController(BilforsikringBusiness bilforsikringBusiness){
        this.bilforsikringBusiness = bilforsikringBusiness;
    }

    @GetMapping("/bilforsikring/")
    public List<BilforsikringDto> getAllBilforsikringer(){
        return this.bilforsikringBusiness.getAlleBilforsikringer();
    }

    @GetMapping("/bilforsikring/{id}")
    public BilforsikringDto getBilforsikringMedId(@PathVariable Long id){
        return this.bilforsikringBusiness.getBilforsikringMedId(id);
    }

    @PostMapping("/bilforsikring/")
    public BilforsikringDto createBilforsikring(@ModelAttribute BilforsikringDto bilforsikringDto){
        return this.bilforsikringBusiness.createBilforsikring(bilforsikringDto);
    }


}
