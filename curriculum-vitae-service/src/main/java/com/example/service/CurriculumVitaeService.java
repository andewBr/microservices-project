package com.example.service;

import com.example.entity.CurriculumVitae;
import com.example.repository.CurriculumVitaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Service
public class CurriculumVitaeService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CurriculumVitaeRepository cvRepository;

    public Optional<CurriculumVitae> getCvByUuid(UUID uuid) {
        return cvRepository.findByUuid(uuid);
    }

    public String getCountryNameById(Long countryId) {
        String url = "http://localhost:8084/api/countries/" + countryId;
        return restTemplate.getForObject(url, String.class);
    }

    public String getCvDataForPdf(UUID uuid) {
        CurriculumVitae cv = cvRepository.findByUuid(uuid).get();

        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(cv.getName()).append("\n");
        sb.append("Surname: ").append(cv.getSurname()).append("\n");
        sb.append("City: ").append(cv.getCity()).append("\n");
        sb.append("Status: ").append(cv.getStatus()).append("\n");

        return sb.toString();
    }
}
