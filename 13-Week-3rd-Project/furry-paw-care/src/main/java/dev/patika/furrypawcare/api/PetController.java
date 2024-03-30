package dev.patika.furrypawcare.api;

import dev.patika.furrypawcare.business.PetManager;
import dev.patika.furrypawcare.dto.request.PetSaveRequest;
import dev.patika.furrypawcare.dto.request.PetUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/furry-paw-care/pet")
@RequiredArgsConstructor
public class PetController {
    private final PetManager petManager;


    // GET ONE BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPetResponseById(@PathVariable Long id){
        return new ResponseEntity<> (petManager.getPetResponseById (id), HttpStatus.OK);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<?> getAllPetResponses(){
        return new ResponseEntity<> (petManager.getAll (),HttpStatus.OK);
    }
    // GET ONE BY NAME
    @GetMapping("/filter-by-name/{name}")
    public ResponseEntity<?> getPetResponseByName(@PathVariable String name){
        return new ResponseEntity<> (petManager.getByName (name),HttpStatus.OK);
    }

    // SAVE
    @PostMapping("/owner/{ownerId}")
    public ResponseEntity<?> create (@PathVariable Long ownerId, @Valid @RequestBody PetSaveRequest petSaveRequest){

        return  new ResponseEntity<> (petManager.save (ownerId, petSaveRequest),HttpStatus.CREATED);
    }

    // UPDATE
    @PutMapping
    public ResponseEntity<?> update (@Valid @RequestBody PetUpdateRequest petUpdateRequest){
        return new ResponseEntity<> (petManager.update (petUpdateRequest),HttpStatus.ACCEPTED);
    }
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        petManager.delete (id);
        return new ResponseEntity<> (HttpStatus.ACCEPTED);
    }}
