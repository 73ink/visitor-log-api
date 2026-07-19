package com.example.visitorlog.controller;

import com.example.visitorlog.model.Visitor;
import com.example.visitorlog.service.VisitorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(
                Map.of(
                        "status", "UP",
                        "developer", "Aaisha"
                )
        );
    }

    @GetMapping("/visitors")
    public ResponseEntity<List<Visitor>> getAllVisitors(
            @RequestParam(required = false) String purpose
    ) {
        return ResponseEntity.ok(visitorService.getAllVisitors(purpose));
    }

    @GetMapping("/visitors/{id}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable Long id) {
        return ResponseEntity.ok(visitorService.getVisitorById(id));
    }

    @PostMapping("/visitors")
    public ResponseEntity<Visitor> addVisitor(@RequestBody Visitor visitor) {
        Visitor savedVisitor = visitorService.addVisitor(visitor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVisitor);
    }

    @PutMapping("/visitors/{id}")
    public ResponseEntity<Visitor> updateVisitor(
            @PathVariable Long id,
            @RequestBody Visitor visitor
    ) {
        return ResponseEntity.ok(visitorService.updateVisitor(id, visitor));
    }

    @DeleteMapping("/visitors/{id}")
    public ResponseEntity<Void> deleteVisitor(@PathVariable Long id) {
        visitorService.deleteVisitor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/visitors/count")
    public ResponseEntity<Map<String, Long>> countVisitors() {
        return ResponseEntity.ok(
                Map.of("total", visitorService.countVisitors())
        );
    }
}