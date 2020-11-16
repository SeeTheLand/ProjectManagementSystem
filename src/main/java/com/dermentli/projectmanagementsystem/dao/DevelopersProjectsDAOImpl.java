package com.dermentli.projectmanagementsystem.dao;

import com.dermentli.projectmanagementsystem.datasource.MyDataSourceFactory;
import com.dermentli.projectmanagementsystem.domain.DeveloperProjectKey;
import com.dermentli.projectmanagementsystem.domain.DevelopersProjects;
import com.dermentli.projectmanagementsystem.error.DaoException;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DevelopersProjectsDAOImpl implements DevelopersProjectsDAO {
    private static final Logger logger = LogManager.getLogger();
    private final DataSource dataSource = MyDataSourceFactory.getMyPostrgresDataSource();

    @Override
    public void add(DevelopersProjects developersProjects) {
        try(final Connection connection = dataSource.getConnection();
            final PreparedStatement statement = connection.prepareStatement(INSERT)) {
            logger.debug("Adding {} to table", developersProjects);
            statement.setLong(1, developersProjects.getProjectID());
            statement.setLong(2, developersProjects.getDeveloperID());
            statement.executeUpdate();
            logger.debug("Developer {} added to table {}", developersProjects, TABLE_NAME);
        } catch (SQLException e) {
            logger.error("" + e.getMessage());
            throw new DaoException("Error while adding element. Cause: " + e.getMessage());
        }
    }

    @Override
    public void remove(DevelopersProjects developersProjects) { removeById(developersProjects.getDeveloperProjectID()); }

    @Override
    public void removeById(DeveloperProjectKey id) {
        try(final Connection connection = dataSource.getConnection();
            final PreparedStatement statement = connection.prepareStatement(REMOVE_BY_ID)) {
            logger.debug("Remove developersProjects by id: {}", id);
            statement.setLong(1, id.getDeveloperID());
            statement.setLong(1, id.getProjectID());
            if (statement.executeUpdate()>0) {
                logger.debug("Element with id {} removed from {} table", id, TABLE_NAME);
            } else {
                logger.error("Can't remove element with id {} from {} table", id, TABLE_NAME);
            }
        } catch (SQLException e) {
            logger.error("" + e.getMessage());
            throw new DaoException("Error while removing element. Cause: " + e.getMessage());
        }
    }

    @Override
    public Optional<DevelopersProjects> findById(DeveloperProjectKey id) {
        try (final Connection connection = dataSource.getConnection();
             final PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            logger.debug("Get developer by id: {}", id);
            statement.setLong(1, id.getDeveloperID());
            statement.setLong(1, id.getProjectID());
            try (final ResultSet res = statement.executeQuery()) {
                if (res.next()) {
                    final Long project_id = res.getLong("project_id");
                    final Long developer_id = res.getLong("developer_id");
                    logger.debug("DevelopersProjects with id: {} returned", id);
                    return Optional.of(new DevelopersProjects(project_id, developer_id));
                } else {
                    logger.warn("Developer with id: {} doesn't exist", id);
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            logger.error("" + e.getMessage());
            throw new DaoException("Error while finding element. Cause: " + e.getMessage());
        }
    }

    @Override
    public List<DevelopersProjects> findAll() {
        logger.debug("Trying to get all elements from table: {}", TABLE_NAME);
        try (final Connection connection = dataSource.getConnection();
             final Statement stmt = connection.createStatement();
             final ResultSet rs = stmt.executeQuery(FIND_ALL)) {
            final List<DevelopersProjects> developersProjectsList = new ArrayList<>();
            while (rs.next()) {
                final Long project_id = rs.getLong("project_id");
                final Long developer_id = rs.getLong("developer_id");
                developersProjectsList.add(new DevelopersProjects(project_id, developer_id));
            }

            if (developersProjectsList.size() > 0) {
                logger.debug("Return {} rows after get all queries for table {}", developersProjectsList.size(), TABLE_NAME);
            } else {
                logger.debug("Empty list after get all queries for table {}", TABLE_NAME);
            }
            return developersProjectsList;
        } catch (SQLException e) {
            logger.error("" + e.getMessage());
            throw new DaoException("Error while executing findAll. Cause: " + e.getMessage());
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
            logger.error("Error while executing removeAll. Cause: " + e.getMessage());
            throw new DaoException("Error while executing removeAll. Cause: " + e.getMessage());
        }
    }

    @Override
    public void addAll(List<DevelopersProjects> developersProjects) {
        logger.debug("Trying to add elements {} to the table {}", developersProjects, TABLE_NAME);
        for (DevelopersProjects developersProject : developersProjects) {
            add(developersProject);
        }
        logger.debug("Added all elements: {}, to the table {}", developersProjects, TABLE_NAME);
    }
}
