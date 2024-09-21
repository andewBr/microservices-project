package com.example.controller;

import com.example.entity.CurriculumVitae;
import com.example.service.CurriculumVitaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class CvController {

    @Autowired
    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    private CurriculumVitaeService cvService;

    @GetMapping("/api/country/{countryId}")
    public ResponseEntity<String> getCvByUuid(@PathVariable(value = "countryId") long countryId) {
        String countryName = cvService.getCountryNameById(countryId);

        if (countryName != null) {
            return ResponseEntity.ok(countryName);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/cv/{uuid}")
    public ResponseEntity<CurriculumVitae> getCvOfUser(@PathVariable UUID uuid) {
        Optional<CurriculumVitae> cv = curriculumVitaeService.getCvByUuid(uuid);
        System.out.println(cv);
        return cv.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
