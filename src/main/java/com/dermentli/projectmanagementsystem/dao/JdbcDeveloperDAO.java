package com.dermentli.projectmanagementsystem.dao;

import com.dermentli.projectmanagementsystem.domain.Developer;
import lombok.RequiredArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RequiredArgsConstructor
public class JdbcDeveloperDAO implements DeveloperDAO {
    private static final Logger logger = LogManager.getLogger();
    private final DataSource dataSource = new DataSource();


    @Override
    public void add(Developer developer) throws SQLException {
        try(final Connection connection = dataSource.getConnection();
            final PreparedStatement statement = connection.prepareStatement(INSERT)) {
            logger.debug("Adding {} to table", developer);
            statement.setString(1, developer.getName());
            statement.setInt(2, developer.getAge());
            statement.setString(3, developer.getGender());
            statement.setInt(4, developer.getSalary());
            statement.executeUpdate();
            logger.debug("Developer {} added to table {}", developer, TABLE_NAME);
        } catch (SQLException e) {
            throw new ExceptionDAO("Error while adding element", e);
        }
    }

    @Override
    public void remove(Developer developer) {
        removeById(developer.getId());
    }

    @Override
    public void removeById(long id) {
        try(final Connection connection = dataSource.getConnection();
            final PreparedStatement statement = connection.prepareStatement(REMOVE_BY_ID)) {
            logger.debug("Remove developer by id: {}", id);
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
    public Optional<Developer> findById(long id) {
        try (final Connection connection = dataSource.getConnection();
             final PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            logger.debug("Get developer by id: {}", id);
            statement.setLong(1, id);
            try (final ResultSet res = statement.executeQuery()) {
                if (res.next()) {
                    final String name = res.getString("name");
                    final int age = res.getInt("age");
                    final String gender = res.getString("gender");
                    final int salary = res.getInt("salary");
                    logger.debug("Developer with id: {} returned", id);
                    return Optional.of(new Developer(id, name, age, gender, salary));
                } else {
                    logger.warn("Developer with id: {} doesn't exist", id);
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Error while finding element", e);
        }
    }

    @Override
    public List<Developer> findAll() {
        logger.debug("Trying to get all elements from table: {}", TABLE_NAME);
        try (final Connection connection = dataSource.getConnection();
             final Statement stmt = connection.createStatement();
             final ResultSet rs = stmt.executeQuery(FIND_ALL)) {
                final List<Developer> developers = new ArrayList<>();
                while (rs.next()) {
                    final Long id = rs.getLong("id");
                    final String name = rs.getString("name");
                    final int age = rs.getInt("age");
                    final String gender = rs.getString("gender");
                    final int salary = rs.getInt("salary");
                    developers.add(new Developer(id, name, age, gender, salary));
            }

            if (developers.size() > 0) {
                logger.debug("Return {} rows after get all queries for table {}", developers.size(), TABLE_NAME);
            } else {
                logger.debug("Empty list after get all queries for table {}", TABLE_NAME);
            }
            return developers;
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
    public void addAll(List<Developer> developers) throws SQLException {
        logger.debug("Trying to add elements {} to the table {}", developers, TABLE_NAME);
        for (Developer developer : developers) {
            add(developer);
        }
        logger.debug("Added all elements: {}, to the table {}", developers, TABLE_NAME);
    }
}