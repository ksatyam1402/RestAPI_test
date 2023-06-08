package com.api.demo.mycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.demo.entities.SATResult;
import com.api.demo.repo.SATResultRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sat-results")
public class SATResultsController {

    @Autowired
    private SATResultRepository satResultRepository;
    
    
    @GetMapping("/home")
    public void home()
    {
    	System.out.println("MENU");
    	System.out.println("1.INSERT (use json raw to POST in POSTMAN)");
    	System.out.println("2.VIEW ALL (displays in JSON in POSTMAN)");
    	System.out.println("3.GET RANK (use json raw to GET name in POSTMAN)");
    	System.out.println("4. UPDATE SCORE(use json raw to PUT in POSTMAN)");
    	System.out.println("1.INSERT (use json raw to DELETE in POSTMAN)");
    	
    }
 

    // Insert data - POST /sat-results
    @PostMapping
    public ResponseEntity<String> insertData(@RequestBody SATResult satResult) {
        // Calculate pass/fail
        satResult.setPassed(satResult.getSatScore() > 30);

        satResultRepository.save(satResult);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // View all data - GET /sat-results
    @GetMapping
    public List<SATResult> getAllData() {
        return satResultRepository.findAll();
    }

    // Get rank - GET /sat-results/rank/{name}
    @GetMapping("/rank/{name}")
    public ResponseEntity<Integer> getRank(@PathVariable String name) {
        List<SATResult> sortedResults = satResultRepository.findAllByOrderBySatScoreDesc();

        for (int i = 0; i < sortedResults.size(); i++) {
            if (sortedResults.get(i).getName().equalsIgnoreCase(name)) {
                return ResponseEntity.ok(i + 1);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // Update score - PUT /sat-results/{id}
    @PutMapping("/{name}")
    public ResponseEntity<String> updateScore(@PathVariable String name, @RequestParam int score) {
        Optional<SATResult> optionalSATResult = Optional.of(satResultRepository.findByName(name));

        if (optionalSATResult.isPresent()) {
            SATResult satResult = optionalSATResult.get();
            satResult.setSatScore(score);
            satResult.setPassed(score > 30);

            satResultRepository.save(satResult);
            return ResponseEntity.ok("Score updated successfully");
        }

        return ResponseEntity.notFound().build();
    }

    // Delete one record - DELETE /sat-results/{id}
    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteRecord(@PathVariable String name) {
    	SATResult satResult = satResultRepository.findByName(name);
        if (satResult != null) {
            satResultRepository.delete(satResult);
            return ResponseEntity.ok("Record deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}
