package dev.patika.furrypawcare.api;

import dev.patika.furrypawcare.business.VetManager;
import dev.patika.furrypawcare.dto.request.VetSaveRequest;
import dev.patika.furrypawcare.dto.request.VetUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/furry-paw-care/vet")
@RequiredArgsConstructor
public class VetController {
    private final VetManager vetManager;



    @GetMapping("/{id}")
    public ResponseEntity<?> getVetResponseById(@PathVariable Long id){
        return new ResponseEntity<> (vetManager.getVetResponseById (id), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<?> getAllVetResponses(){
        return new ResponseEntity<> (vetManager.getAll (),HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody VetSaveRequest vetSaveRequest){

        return  new ResponseEntity<> (vetManager.save (vetSaveRequest),HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> update (@Valid @RequestBody VetUpdateRequest vetUpdateRequest){
        return new ResponseEntity<> (vetManager.update (vetUpdateRequest),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        vetManager.delete (id);
        return new ResponseEntity<> (HttpStatus.ACCEPTED);
    }

}
