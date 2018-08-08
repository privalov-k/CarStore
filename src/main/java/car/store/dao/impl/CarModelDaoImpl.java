package car.store.dao.impl;

import car.store.dao.CarModelDao;
import car.store.model.CarModel;
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
    public void insert(CarModel car) {
        String sql = "INSERT INTO carmodel " + "(CAR_ID, BRAND, YEAR) VALUES (?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{car.getCarId(), car.getBrand(), car.getYear()});
    }

    @Override
    public void insertBatch(List<CarModel> cars) {
        String sql = "INSERT INTO carmodel " + "(CAR_ID, BRAND, YEAR) VALUES (?, ?, ?)" ;
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                CarModel carModel = cars.get(i);
                preparedStatement.setLong(1, carModel.getCarId());
                preparedStatement.setString(2, carModel.getBrand());
                preparedStatement.setInt(3, carModel.getYear());
            }

            @Override
            public int getBatchSize() {
                return cars.size();
            }
        });
    }

    @Override
    public List<CarModel> loadAllCars() {
        String sql = "SELECT * FROM * carmodel";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<CarModel> result = new ArrayList<CarModel>();
        for(Map<String, Object> row:rows){
            CarModel car = new CarModel();
            car.setCarId((Long)row.get("car_id"));
            car.setBrand((String)row.get("brand"));
            car.setYear((Integer)row.get("year"));
            result.add(car);
        }
        return result;
    }

    @Override
    public CarModel findCarById(long car_id) {
        String sql = "SELECT * FROM carmodel WHERE CAR_ID = ?";
        return (CarModel)getJdbcTemplate().queryForObject(sql, new Object[]{car_id}, new RowMapper<CarModel>() {
            @Override
            public CarModel mapRow(ResultSet resultSet, int i) throws SQLException {
                CarModel car = new CarModel();
                car.setCarId(resultSet.getLong("car_id"));
                car.setBrand(resultSet.getString("brand"));
                car.setYear(resultSet.getInt("year"));
                return car;
            }
        });
    }

    @Override
    public String findBrandById(long car_id) {
        String sql = "SELECT * brand FROM carmodel WHERE car_id = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{car_id}, String.class);
    }

    @Override
    public int getTotalNumberOfCars() {
        String sql = "SELECT Count(*) FROM carmodel";
        int total = getJdbcTemplate().queryForObject(sql, Integer.class);
        return total;
    }

    @Override
    public void deleteCarById(long car_id) {
    }
}
