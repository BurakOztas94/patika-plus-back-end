package dev.patika.furrypawcare.api;

import dev.patika.furrypawcare.business.WorkdayManager;
import dev.patika.furrypawcare.dto.request.WorkdaySaveRequest;
import dev.patika.furrypawcare.dto.request.WorkdayUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/furry-paw-care/workday")
@RequiredArgsConstructor
public class WorkdayController {
    private final WorkdayManager workdayManager;

    @GetMapping("/{id}")
    public ResponseEntity<?> getWorkdayResponseById (@PathVariable Long id)
        {
            return new ResponseEntity<> (workdayManager.getWorkdayResponseById (id) , HttpStatus.OK);
        }


    @GetMapping("/filter-by-vet-id/{vetId}")
    public ResponseEntity<?> getAllWorkdayResponse(@PathVariable Long vetId){
        return new ResponseEntity<> (workdayManager.getAllWorkdayResponsesByVetId (vetId) ,HttpStatus.OK);

    }


    @PostMapping("/vet/{vetId}")
    public ResponseEntity<?> create (@PathVariable Long vetId, @Valid @RequestBody WorkdaySaveRequest workdaySaveRequest){
        return new ResponseEntity<> (workdayManager.save (vetId, workdaySaveRequest),HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> update (@Valid @RequestBody WorkdayUpdateRequest workdayUpdateRequest){
        return  new ResponseEntity<> (workdayManager.update (workdayUpdateRequest),HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        workdayManager.delete (id);
        return new ResponseEntity<> (HttpStatus.ACCEPTED);
    }

}

