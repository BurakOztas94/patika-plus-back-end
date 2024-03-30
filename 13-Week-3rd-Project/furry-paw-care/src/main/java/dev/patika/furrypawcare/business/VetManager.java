package dev.patika.furrypawcare.business;

import dev.patika.furrypawcare.core.config.modelmapper.IModelMapperService;
import dev.patika.furrypawcare.dto.request.VetSaveRequest;
import dev.patika.furrypawcare.dto.request.VetUpdateRequest;
import dev.patika.furrypawcare.dto.response.vet.VetResponse;
import dev.patika.furrypawcare.entity.Vet;
import dev.patika.furrypawcare.repository.VetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VetManager {

    private final VetRepository vetRepository;
    private final IModelMapperService modelMapperManager;

    public Vet getById (Long id)
        {
            return vetRepository.findById(id)
                    .orElseThrow (() -> new EntityNotFoundException ("Vet with ID " + id + " not found"));
        }

    public VetResponse getVetResponseById(Long id) {
        return modelMapperManager
                .forResponse ()
                .map (getById (id), VetResponse.class);
    }

    public List<VetResponse> getAll ()
        {   
            return vetRepository
                    .findAll ()
                    .stream ()
                    .map (vet -> modelMapperManager
                            .forResponse ()
                            .map (vet, VetResponse.class))
                    .toList ();
        }



    public VetResponse save (VetSaveRequest vetSaveRequest)
        {
            Vet vetToBeSaved = modelMapperManager
                    .forRequest ()
                    .map (vetSaveRequest, Vet.class);

            return modelMapperManager
                    .forResponse ()
                    .map (vetRepository.save (vetToBeSaved),VetResponse.class);
        }

    public void delete (Long id)
        {
            vetRepository.delete (getById (id));

        }

    public VetResponse update (VetUpdateRequest vetUpdateRequest)
        {

            getById (vetUpdateRequest.getId ());
            Vet vetToBeUpdated = modelMapperManager
                    .forRequest ()
                    .map (vetUpdateRequest, Vet.class);

            return modelMapperManager
                    .forResponse ()
                    .map (vetRepository.save (vetToBeUpdated), VetResponse.class);
        }




}
