package com.dermentli.projectmanagementsystem.service;

import com.dermentli.projectmanagementsystem.dao.JdbcDeveloperDAO;
import com.dermentli.projectmanagementsystem.domain.Developer;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DeveloperService {

    private final JdbcDeveloperDAO jdbcDeveloperDAO;

    public List<Developer> getListOfDevsOnProject (Long projectId) {
        return jdbcDeveloperDAO.getDevelopersByProjectID(projectId);
    }

    public List<Developer> getDevelopersByLanguage (String language) {
        return jdbcDeveloperDAO.getDevelopersByLanguage(language);
    }

    public List<Developer> getDevelopersByLevel (String level) {
        return jdbcDeveloperDAO.getDevelopersByLevel(level);
    }

}
