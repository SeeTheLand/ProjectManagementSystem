package com.dermentli.projectmanagementsystemhibernate.service;

import com.dermentli.projectmanagementsystemhibernate.dao.DeveloperDAO;
import com.dermentli.projectmanagementsystemhibernate.domain.Developer;
import com.dermentli.projectmanagementsystemhibernate.domain.Project;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperDAO developerDAO;

    public Developer findDeveloperById(Long id) {
        return developerDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Developere not found for id " + id));
    }

    public List<Developer> getDevsByLanguage(String language) {
        return developerDAO.getDevsByLanguage(language);
    }

}
