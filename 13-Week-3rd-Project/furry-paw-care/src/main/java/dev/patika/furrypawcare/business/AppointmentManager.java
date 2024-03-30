package dev.patika.furrypawcare.business;

import dev.patika.furrypawcare.core.config.modelmapper.ModelMapperService;
import dev.patika.furrypawcare.dto.request.AppointmentSaveRequest;
import dev.patika.furrypawcare.dto.request.AppointmentUpdateRequest;
import dev.patika.furrypawcare.dto.response.appointment.AppointmentResponse;
import dev.patika.furrypawcare.entity.Appointment;
import dev.patika.furrypawcare.entity.Pet;
import dev.patika.furrypawcare.entity.Vet;
import dev.patika.furrypawcare.repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentManager {
    private final AppointmentRepository appointmentRepository;
    private final ModelMapperService modelMapperManager;
    private final PetManager petManager;
    private final VetManager vetManager;
    private final WorkdayManager workdayManager;

    public Appointment getById(Long id){
        return appointmentRepository
                .findById (id)
                .orElseThrow (() -> new EntityNotFoundException ("Appointment id " + id + " not found!"));
    }

    public AppointmentResponse getAppointmentResponseById(Long id){
        return modelMapperManager.
                forResponse ().
                map (getById (id),AppointmentResponse.class);
    }

    public List<AppointmentResponse> getAllAppointmentResponsesByVetIdAndPetId ( Long petId,Long vetId){
        return appointmentRepository.findByPetIdAndVetId ( petId,vetId)
                .stream ()
                .map (appointment -> modelMapperManager.forResponse ().map (appointment, AppointmentResponse.class))
                .toList ();

    }

    public AppointmentResponse save (Long vetId, Long petId, AppointmentSaveRequest appointmentSaveRequest){


        workdayManager.getByVetIdAndWorkday (
                vetId,
                appointmentSaveRequest.getStartDateTime ().toLocalDate ()
        ).orElseThrow (() -> new RuntimeException ("Vet is not available at this date"));


        Optional<Appointment> checkIfVetIsAvailableAtThisHour = appointmentRepository.findByVetIdAndStartDateTime (
                vetId,
                appointmentSaveRequest.getStartDateTime ()
        );

        if ( checkIfVetIsAvailableAtThisHour.isPresent () )
            throw new RuntimeException ("Vet is not available at this hour");


        Vet doesVetExist = vetManager.getById (vetId);
        Pet doesPetExist = petManager.getById (petId);

        Appointment appointmentToBeCreated = modelMapperManager
                .forRequest ()
                .map (appointmentSaveRequest, Appointment.class);

        appointmentToBeCreated.setVet (doesVetExist);
        appointmentToBeCreated.setPet (doesPetExist);

        return modelMapperManager
                .forResponse ()
                .map (appointmentRepository.save (appointmentToBeCreated), AppointmentResponse.class);

    }


    public AppointmentResponse update (AppointmentUpdateRequest appointmentUpdateRequest){

        getById (appointmentUpdateRequest.getId ());
        Appointment appointmentToBeUpdated = modelMapperManager
                .forRequest ()
                .map (appointmentUpdateRequest,Appointment.class);

        return modelMapperManager
                .forResponse ()
                .map (appointmentRepository
                        .save (appointmentToBeUpdated),AppointmentResponse.class);

    }



    public  void delete (@PathVariable Long id ){
        appointmentRepository.delete (getById (id));
    }
}
