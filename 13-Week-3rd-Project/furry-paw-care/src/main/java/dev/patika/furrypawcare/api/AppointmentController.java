package dev.patika.furrypawcare.api;

import dev.patika.furrypawcare.business.AppointmentManager;
import dev.patika.furrypawcare.dto.request.AppointmentSaveRequest;
import dev.patika.furrypawcare.dto.request.AppointmentUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/furry-paw-care/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentManager appointmentManager;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAppointmentResponseById (@PathVariable Long id)
        {
            return new ResponseEntity<> (appointmentManager.getAppointmentResponseById (id) , HttpStatus.OK);
        }

    @GetMapping("/filter-by-pet-id-and-vet-id/{petId}/{vetId}")
    public ResponseEntity<?> getAllAppointmentResponse (
            @PathVariable Long petId ,
            @PathVariable Long vetId
    )
        {
            return new ResponseEntity<> (appointmentManager.getAllAppointmentResponsesByVetIdAndPetId (petId , vetId) , HttpStatus.OK);

        }


    @PostMapping("/vet/{vetId}/pet/{petId}")
    public ResponseEntity<?> create (
            @PathVariable Long vetId ,
            @PathVariable Long petId ,
            @Valid @RequestBody AppointmentSaveRequest appointmentSaveRequest
    )
        {
            return new ResponseEntity<> (appointmentManager.save (vetId , petId , appointmentSaveRequest) , HttpStatus.CREATED);
        }


    @PutMapping
    public ResponseEntity<?> update (@Valid @RequestBody AppointmentUpdateRequest appointmentUpdateRequest)
        {
            return new ResponseEntity<> (appointmentManager.update (appointmentUpdateRequest) , HttpStatus.ACCEPTED);
        }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id)
        {
            appointmentManager.delete (id);
            return new ResponseEntity<> (HttpStatus.ACCEPTED);
        }
}
