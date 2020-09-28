package com.dermentli.projectmanagementsystem.service;

import com.dermentli.projectmanagementsystem.dao.DeveloperDAOImpl;
import com.dermentli.projectmanagementsystem.domain.Developer;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperDAOImpl developerDAOImpl;

    public List<Developer> getListOfDevsOnProject (Long projectId) {
        return developerDAOImpl.getDevelopersByProjectID(projectId);
    }

    public List<Developer> getDevelopersByLanguage (String language) {
        return developerDAOImpl.getDevelopersByLanguage(language);
    }

    public List<Developer> getDevelopersByLevel (String level) {
        return developerDAOImpl.getDevelopersByLevel(level);
    }

}
