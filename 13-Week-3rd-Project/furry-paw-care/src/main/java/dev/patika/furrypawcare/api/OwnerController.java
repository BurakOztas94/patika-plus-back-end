package dev.patika.furrypawcare.api;
import dev.patika.furrypawcare.business.OwnerManager;
import dev.patika.furrypawcare.dto.request.OwnerSaveRequest;
import dev.patika.furrypawcare.dto.request.OwnerUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/furry-paw-care/owner")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerManager ownerManager;

    // GET ONE BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getOwnerResponseById(@PathVariable Long id){
        return new ResponseEntity<> (ownerManager.getOwnerResponseById (id), HttpStatus.OK);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<?> getAllOwnerResponses(){
        return new ResponseEntity<> (ownerManager.getAll (),HttpStatus.OK);
    }
    // GET ONE BY NAME
    @GetMapping("/filter-by-name/{name}")
    public ResponseEntity<?> getOwnerResponseByName(@PathVariable String name){
        return new ResponseEntity<> (ownerManager.getByName (name),HttpStatus.OK);
    }

    // SAVE
    @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody OwnerSaveRequest ownerSaveRequest){

        return  new ResponseEntity<> (ownerManager.save (ownerSaveRequest),HttpStatus.CREATED);
    }

    // UPDATE
    @PutMapping
    public ResponseEntity<?> update (@Valid @RequestBody OwnerUpdateRequest ownerUpdateRequest){
        return new ResponseEntity<> (ownerManager.update (ownerUpdateRequest),HttpStatus.ACCEPTED);
    }
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        ownerManager.delete (id);
        return new ResponseEntity<> (HttpStatus.ACCEPTED);
    }

}
