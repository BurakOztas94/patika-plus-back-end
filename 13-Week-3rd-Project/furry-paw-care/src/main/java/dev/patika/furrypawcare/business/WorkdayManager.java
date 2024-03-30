package dev.patika.furrypawcare.business;

import dev.patika.furrypawcare.core.config.modelmapper.ModelMapperService;
import dev.patika.furrypawcare.dto.request.WorkdaySaveRequest;
import dev.patika.furrypawcare.dto.request.WorkdayUpdateRequest;
import dev.patika.furrypawcare.dto.response.workday.WorkdayResponse;
import dev.patika.furrypawcare.entity.Vet;
import dev.patika.furrypawcare.entity.Workday;
import dev.patika.furrypawcare.repository.WorkdayRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkdayManager {

    private final WorkdayRepository workdayRepository;
    private final ModelMapperService modelMapperManager;
    private final VetManager vetManager;

    public Workday getById(Long id){
        return workdayRepository
                .findById (id)
                .orElseThrow (() -> new EntityNotFoundException ("Workday id " + id + " not found!"));
    }

    public WorkdayResponse getWorkdayResponseById(Long id){
        return modelMapperManager.
                forResponse ().
                map (getById (id),WorkdayResponse.class);
    }

    public List<WorkdayResponse> getAllWorkdayResponsesByVetId (Long vetId){
        return workdayRepository.findByVetId (vetId)
                .stream ()
                .map (workday -> modelMapperManager.forResponse ().map (workday, WorkdayResponse.class))
                .toList ();

    }

    public Optional<Workday> getByVetIdAndWorkday(Long vetId, LocalDate workday) {
        return workdayRepository.findByVetIdAndWorkday (vetId, workday);
    }

    public WorkdayResponse save (Long vetId, WorkdaySaveRequest workdaySaveRequest){
        Vet doesVetExist = vetManager.getById (vetId);

        Workday workdayToBeCreated = modelMapperManager
                .forRequest ()
                .map (workdaySaveRequest, Workday.class);

        workdayToBeCreated.setVet (doesVetExist);

        return modelMapperManager
                .forResponse ()
                .map (workdayRepository.save (workdayToBeCreated), WorkdayResponse.class);

    }


    public WorkdayResponse update (WorkdayUpdateRequest workdayUpdateRequest){

        getById (workdayUpdateRequest.getId ());
        Workday workdayToBeUpdated = modelMapperManager
                .forRequest ()
                .map (workdayUpdateRequest, Workday.class);

        return modelMapperManager
                .forResponse ()
                .map (workdayRepository
                        .save (workdayToBeUpdated),WorkdayResponse.class);

    }



    public  void delete (Long id ){
        workdayRepository.delete (getById (id));
    }
}
