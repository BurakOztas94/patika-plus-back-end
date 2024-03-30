package dev.patika.furrypawcare.business;

import dev.patika.furrypawcare.core.config.modelmapper.ModelMapperService;
import dev.patika.furrypawcare.dto.request.PetSaveRequest;
import dev.patika.furrypawcare.dto.request.PetUpdateRequest;
import dev.patika.furrypawcare.dto.response.pet.PetResponse;
import dev.patika.furrypawcare.entity.Owner;
import dev.patika.furrypawcare.entity.Pet;
import dev.patika.furrypawcare.repository.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetManager {
    private final PetRepository petRepository;
    private final ModelMapperService modelMapperManager;
    private final OwnerManager ownerManager;

    public Pet getById (Long id)
        {
            return petRepository.findById (id)
                    .orElseThrow (() -> new EntityNotFoundException ("Pet with ID " + id + " not found"));
        }

    public PetResponse getPetResponseById (Long id)
        {
            return modelMapperManager
                    .forResponse ()
                    .map (getById (id) , PetResponse.class);
        }

    public List<PetResponse> getAll ()
        {
            return petRepository
                    .findAll ()
                    .stream ()
                    .map (pet -> modelMapperManager
                            .forResponse ()
                            .map (pet , PetResponse.class))
                    .toList ();
        }

    public List<PetResponse> getByName (String name)
        {
            return petRepository
                    .findAllByName (name)
                .stream ()
                    .map (pet -> modelMapperManager.forResponse ()
                            .map (pet , PetResponse.class))
                    .toList ();
        }

    public PetResponse save (Long ownerId, PetSaveRequest petSaveRequest)
        {
            Owner doesOwnerExist = ownerManager.getById (ownerId);

            Pet petToBeSaved = modelMapperManager
                    .forRequest ()
                    .map (petSaveRequest , Pet.class);

            petToBeSaved.setOwner (doesOwnerExist);

            return modelMapperManager
                    .forResponse ()
                    .map (petRepository.save (petToBeSaved) , PetResponse.class);
        }

    public void delete (Long id)
        {
            petRepository.delete (getById (id));

        }

    public PetResponse update (PetUpdateRequest petUpdateRequest)
        {

            getById (petUpdateRequest.getId ());
            Pet petToBeUpdated = modelMapperManager
                    .forRequest ()
                    .map (petUpdateRequest , Pet.class);

            return modelMapperManager
                    .forResponse ()
                    .map (petRepository.save (petToBeUpdated) , PetResponse.class);
        }

}
