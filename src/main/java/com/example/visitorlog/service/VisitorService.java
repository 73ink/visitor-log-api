package com.example.visitorlog.service;

import com.example.visitorlog.model.Visitor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class VisitorService {

    private final List<Visitor> visitors = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Visitor> getAllVisitors(String purpose) {
        if (purpose == null || purpose.isBlank()) {
            return visitors;
        }

        return visitors.stream()
                .filter(visitor -> visitor.getPurpose() != null &&
                        visitor.getPurpose().equalsIgnoreCase(purpose))
                .toList();
    }

    public Visitor getVisitorById(Long id) {
        return visitors.stream()
                .filter(visitor -> visitor.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Visitor not found with id: " + id
                ));
    }

    public Visitor addVisitor(Visitor visitor) {
        visitor.setId(idCounter.getAndIncrement());
        visitors.add(visitor);
        return visitor;
    }

    public Visitor updateVisitor(Long id, Visitor updatedVisitor) {
        Visitor existingVisitor = getVisitorById(id);

        existingVisitor.setName(updatedVisitor.getName());
        existingVisitor.setCompany(updatedVisitor.getCompany());
        existingVisitor.setPurpose(updatedVisitor.getPurpose());

        return existingVisitor;
    }

    public void deleteVisitor(Long id) {
        Visitor visitor = getVisitorById(id);
        visitors.remove(visitor);
    }

    public long countVisitors() {
        return visitors.size();
    }
}