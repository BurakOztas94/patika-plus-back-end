package dev.patika.furrypawcare.business;

import dev.patika.furrypawcare.core.config.modelmapper.IModelMapperService;
import dev.patika.furrypawcare.dto.request.OwnerSaveRequest;
import dev.patika.furrypawcare.dto.request.OwnerUpdateRequest;
import dev.patika.furrypawcare.dto.response.owner.OwnerResponse;
import dev.patika.furrypawcare.entity.Owner;
import dev.patika.furrypawcare.repository.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerManager  {
    private final OwnerRepository ownerRepository;
    private final IModelMapperService modelMapperManager;

    public Owner getById (Long id)
        {
            return ownerRepository.findById(id)
                    .orElseThrow (() -> new EntityNotFoundException ("Owner with ID " + id + " not found"));
        }

    public OwnerResponse getOwnerResponseById(Long id) {
        return modelMapperManager
                .forResponse ()
                .map (getById (id), OwnerResponse.class);
    }

    public List<OwnerResponse> getAll ()
        {   // List<Owner> -> List<OwnerResponse>
            // List<Owner> ownerList = ownerRepository.findAll ();
            //  List<OwnerResponse> ownerResponseList = new ArrayList<> ();

            //  for (Owner owner : ownerList )
            //    ownerResponseList.add (modelMapperService.forResponse ().map(owner, OwnerResponse.class));
            return ownerRepository
                    .findAll ()
                    .stream ()
                    .map (owner -> modelMapperManager
                            .forResponse ()
                            .map (owner, OwnerResponse.class))
                    .toList ();
        }

    public List<OwnerResponse> getByName (String name)
        {
            return ownerRepository
                    .findAllByName (name)
                    .stream ()
                    .map (owner -> modelMapperManager.forResponse ()
                            .map (owner, OwnerResponse.class))
                    .toList ();
        }

    public OwnerResponse save (OwnerSaveRequest ownerSaveRequest)
        {

            Owner ownerToBeSaved = modelMapperManager
                    .forRequest ()
                    .map (ownerSaveRequest, Owner.class);

           return modelMapperManager
                   .forResponse ()
                   .map (ownerRepository.save (ownerToBeSaved),OwnerResponse.class);
        }

    public void delete (Long id)
        {
            ownerRepository.delete (getById (id));

        }

    public OwnerResponse update (OwnerUpdateRequest ownerUpdateRequest)
        {
            getById (ownerUpdateRequest.getId ());

            Owner ownerToBeUpdated = modelMapperManager
                    .forRequest ()
                    .map (ownerUpdateRequest, Owner.class);

            return modelMapperManager
                    .forResponse ()
                    .map (ownerRepository.save (ownerToBeUpdated), OwnerResponse.class);
        }






}
