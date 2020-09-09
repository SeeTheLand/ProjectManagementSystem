package com.dermentli.projectmanagementsystem.dao;

import com.dermentli.projectmanagementsystem.domain.Project;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JdbcProjectDAO implements ProjectDAO {
    private static final Logger logger = LogManager.getLogger();
    private final DataSource dataSource = new DataSource();


    @Override
    public void add(Project project) throws SQLException {
        try(final Connection connection = dataSource.getConnection();
            final PreparedStatement statement = connection.prepareStatement(INSERT)) {
            logger.debug("Adding {} to table", project);
            statement.setString(1, project.getName());
            statement.setInt(2, project.getLatestReleaseDate());
            statement.setInt(3, project.getCost());
            statement.executeUpdate();
            logger.debug("Developer {} added to table {}", project, TABLE_NAME);
        } catch (SQLException e) {
            throw new ExceptionDAO("Error while adding element", e);
        }
    }

    @Override
    public void remove(Project project) { removeById(project.getId()); }

    @Override
    public void removeById(long id) {
        try(final Connection connection = dataSource.getConnection();
            final PreparedStatement statement = connection.prepareStatement(REMOVE_BY_ID)) {
            logger.debug("Remove project by id: {}", id);
            statement.setLong(1, id);
            if (statement.executeUpdate()>0) {
                logger.debug("Element with id {} removed from {} table", id, TABLE_NAME);
            } else {
                logger.error("Can't remove element with id {} from {} table", id, TABLE_NAME);
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Error while removing element", e);
        }
    }

    @Override
    public Optional<Project> findById(long id) {
        try (final Connection connection = dataSource.getConnection();
             final PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            logger.debug("Get project by id: {}", id);
            statement.setLong(1, id);
            try (final ResultSet res = statement.executeQuery()) {
                if (res.next()) {
                    final String name = res.getString("name");
                    final int latest_release_date = res.getInt("latest_release_date");
                    final int cost = res.getInt("cost");
                    logger.debug("Developer with id: {} returned", id);
                    return Optional.of(new Project(id, name, latest_release_date, cost));
                } else {
                    logger.warn("Project with id: {} doesn't exist", id);
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Error while finding element", e);
        }
    }

    @Override
    public List<Project> findAll() {
        logger.debug("Trying to get all elements from table: {}", TABLE_NAME);
        try (final Connection connection = dataSource.getConnection();
             final Statement stmt = connection.createStatement();
             final ResultSet rs = stmt.executeQuery(FIND_ALL)) {
            final List<Project> projects = new ArrayList<>();
            while (rs.next()) {
                final Long id = rs.getLong("id");
                final String name = rs.getString("name");
                final int latest_release_date = rs.getInt("latest_release_date");
                final int cost = rs.getInt("cost");
                projects.add(new Project(id, name, latest_release_date, cost));
            }

            if (projects.size() > 0) {
                logger.debug("Return {} rows after get all queries for table {}", projects.size(), TABLE_NAME);
            } else {
                logger.debug("Empty list after get all queries for table {}", TABLE_NAME);
            }
            return projects;
        } catch (SQLException e) {
            throw new ExceptionDAO("Error while executing findAll", e);
        }
    }

    @Override
    public void removeAll() {
        logger.debug("Trying to remove all records from table {}", TABLE_NAME);
        try (final Connection connection = dataSource.getConnection();
             final Statement statement = connection.createStatement()) {
            final int numOfRows = statement.executeUpdate(CLEAR_TABLE);
            logger.debug("Table {} cleared, removed {} rows.", TABLE_NAME, numOfRows);
        } catch (SQLException e) {
            throw new ExceptionDAO("Error while executing removeAll", e);
        }
    }

    @Override
    public void addAll(List<Project> projects) throws SQLException {
        logger.debug("Trying to add elements {} to the table {}", projects, TABLE_NAME);
        for (Project project : projects) {
            add(project);
        }
        logger.debug("Added all elements: {}, to the table {}", projects, TABLE_NAME);
    }
}
