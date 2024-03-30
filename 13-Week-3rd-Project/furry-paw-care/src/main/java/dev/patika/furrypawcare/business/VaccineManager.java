package dev.patika.furrypawcare.business;

import dev.patika.furrypawcare.core.config.modelmapper.ModelMapperService;
import dev.patika.furrypawcare.dto.request.VaccineSaveRequest;
import dev.patika.furrypawcare.dto.request.VaccineUpdateRequest;
import dev.patika.furrypawcare.dto.response.vaccine.VaccineResponse;
import dev.patika.furrypawcare.entity.Pet;
import dev.patika.furrypawcare.entity.Vaccine;
import dev.patika.furrypawcare.repository.VaccineRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VaccineManager {
    private final VaccineRepository vaccineRepository;
    private final ModelMapperService modelMapperManager;
    private final PetManager petManager;

    public Vaccine getById(Long id){
        return vaccineRepository
                .findById (id)
                .orElseThrow (() -> new EntityNotFoundException ("Vaccine id " + id + " not found!"));
    }

    public VaccineResponse getVaccineResponseById(Long id){
        return modelMapperManager.
                forResponse ().
                map (getById (id),VaccineResponse.class);
    }

    public List<VaccineResponse> getAllVaccineResponsesByPetId (Long petId){
        return vaccineRepository.findByPetId (petId)
                .stream ()
                .map (vaccine -> modelMapperManager.forResponse ().map (vaccine, VaccineResponse.class))
                .toList ();

    }

    public List<VaccineResponse> filterVaccinesByStartAndEndDates(LocalDate start, LocalDate end) {
        return vaccineRepository.filterVaccinesByInputtedStartAndEndDates (start, end)
                .stream ().map (vaccine -> modelMapperManager
                .forResponse ()
                .map (vaccine, VaccineResponse.class))
                .toList ();
    }


    // CREATE

    public VaccineResponse save (Long petId, VaccineSaveRequest vaccineSaveRequest){
        Optional<Vaccine> checkVaccine = vaccineRepository.checkVaccineConflict (
                petId,
                vaccineSaveRequest.getCode(),
                vaccineSaveRequest.getProtectionStartDate ()
        );

        if ( checkVaccine.isPresent () )
            throw new RuntimeException ("Vaccine is still in effect");


        Pet doesPetExist = petManager.getById (petId);

       Vaccine vaccineToBeCreated = modelMapperManager
               .forRequest ()
               .map (vaccineSaveRequest, Vaccine.class);

       vaccineToBeCreated.setPet (doesPetExist);

       return modelMapperManager
               .forResponse ()
               .map (vaccineRepository.save (vaccineToBeCreated), VaccineResponse.class);

    }

  // UPDATE
    public VaccineResponse update (VaccineUpdateRequest vaccineUpdateRequest){

        getById (vaccineUpdateRequest.getId ());
        Vaccine vaccineToBeUpdated = modelMapperManager
                .forRequest ()
                .map (vaccineUpdateRequest,Vaccine.class);
        return modelMapperManager
                .forResponse ()
                .map (vaccineRepository
                        .save (vaccineToBeUpdated),VaccineResponse.class);

    }

 // DELETE

    public  void delete (Long id ){
        vaccineRepository.delete (getById (id));
    }
}
