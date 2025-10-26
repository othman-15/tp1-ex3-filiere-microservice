package ma.angu.filieremicroservice.web;

import lombok.AllArgsConstructor;
import ma.angu.filieremicroservice.dtos.RequestFiliereDto;
import ma.angu.filieremicroservice.dtos.ResponseFiliereDto;
import ma.angu.filieremicroservice.services.FiliereService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/filieres")
@AllArgsConstructor
public class FiliereController {
    private FiliereService filiereService ;
    @GetMapping
    public ResponseEntity<List<ResponseFiliereDto>> getAllFiliere() {
        return ResponseEntity.ok(filiereService.getAllFilieres());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseFiliereDto>  getFiliereById(@PathVariable("id") Long id) {


        return ResponseEntity.ok(filiereService.getFiliereById(id));
    }
    @PostMapping
    public ResponseEntity<ResponseFiliereDto> createFiliere(@RequestBody RequestFiliereDto requestFiliereDto) {


        return ResponseEntity.ok(filiereService.addFiliere(requestFiliereDto));


    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseFiliereDto> updateFiliere(@PathVariable Long id, @RequestBody RequestFiliereDto requestFiliereDto) {


        return ResponseEntity.ok(filiereService.updateFiliere(id,requestFiliereDto));
    }
    @DeleteMapping("{id}")
    public ResponseEntity DeleteFiliere(@PathVariable Long id) {

        filiereService.deleteFiliere(id);
        return ResponseEntity.ok().build();
    }

}
