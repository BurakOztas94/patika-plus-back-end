package dev.patika.furrypawcare.api;

import dev.patika.furrypawcare.business.VaccineManager;
import dev.patika.furrypawcare.dto.request.VaccineSaveRequest;
import dev.patika.furrypawcare.dto.request.VaccineUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/furry-paw-care/vaccine")
@RequiredArgsConstructor
public class VaccineController {
    private final VaccineManager vaccineManager;

    @GetMapping("/{id}")
    public ResponseEntity<?> getVaccineResponseById (@PathVariable Long id)
        {
            return new ResponseEntity<> (vaccineManager.getVaccineResponseById (id) , HttpStatus.OK);
        }


    @GetMapping("/filter-by-pet-id/{petId}")
    public ResponseEntity<?> getAllVaccineResponse(@PathVariable Long petId){
        return new ResponseEntity<> (vaccineManager.getAllVaccineResponsesByPetId (petId) ,HttpStatus.OK);

    }

    @GetMapping("/filter-by-start-and-end-dates/{start}/{end}")
    public ResponseEntity<?> filterVaccinesByStartAndEndDates(
            @PathVariable LocalDate start, @PathVariable LocalDate end) {
            return new ResponseEntity<> (vaccineManager.filterVaccinesByStartAndEndDates (start,end),HttpStatus.OK);
    }


    @PostMapping("/pet/{petId}")
    public ResponseEntity<?> create (@PathVariable Long petId, @Valid @RequestBody VaccineSaveRequest vaccineSaveRequest){
        return new ResponseEntity<> (vaccineManager.save (petId, vaccineSaveRequest),HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> update (@Valid @RequestBody VaccineUpdateRequest vaccineUpdateRequest){
        return  new ResponseEntity<> (vaccineManager.update (vaccineUpdateRequest),HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        vaccineManager.delete (id);
        return new ResponseEntity<> (HttpStatus.ACCEPTED);
    }

}
