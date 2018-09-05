package car.store.dao.impl;

import car.store.dao.CarModelDao;
import car.store.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CarModelDaoImpl extends JdbcDaoSupport implements CarModelDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }


    @Override
    public void insert(Car car) {
        String sql = "INSERT INTO carmodel " + "(CAR_ID, BRAND, YEAR) VALUES (?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{car.getId(), car.getBrand(), car.getYear()});
    }

    @Override
    public void insertBatch(List<Car> cars) {
        String sql = "INSERT INTO carmodel " + "(CAR_ID, BRAND, YEAR) VALUES (?, ?, ?)" ;
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Car car = cars.get(i);
                preparedStatement.setLong(1, car.getId());
                preparedStatement.setString(2, car.getBrand());
                preparedStatement.setInt(3, car.getYear());
            }

            @Override
            public int getBatchSize() {
                return cars.size();
            }
        });
    }

    @Override
    public List<Car> loadAllCars() {
        String sql = "SELECT * FROM * carmodel";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Car> result = new ArrayList<Car>();
        for(Map<String, Object> row:rows){
            Car car = new Car();
            car.setId((Long)row.get("car_id"));
            car.setBrand((String)row.get("brand"));
            car.setYear((Integer)row.get("year"));
            result.add(car);
        }
        return result;
    }

    @Override
    public Car findCarById(long id) {
        String sql = "SELECT * FROM carmodel WHERE CAR_ID = ?";
        return (Car)getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<Car>() {
            @Override
            public Car mapRow(ResultSet resultSet, int i) throws SQLException {
                Car car = new Car();
                car.setId(resultSet.getLong("car_id"));
                car.setBrand(resultSet.getString("brand"));
                car.setYear(resultSet.getInt("year"));
                return car;
            }
        });
    }

    @Override
    public String findBrandById(long id) {
        String sql = "SELECT * brand FROM carmodel WHERE car_id = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, String.class);
    }

    @Override
    public int getTotalNumberOfCars() {
        String sql = "SELECT Count(*) FROM carmodel";
        int total = getJdbcTemplate().queryForObject(sql, Integer.class);
        return total;
    }
}
