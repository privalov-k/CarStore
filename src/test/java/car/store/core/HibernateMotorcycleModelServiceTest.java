package car.store.core;

import car.store.model.HibernateMotorcycleModel;
import car.store.service.HibernateMotorcycleModelService;
import car.store.service.impl.HibernateMotorcycleModelServiceImpl;
import org.junit.Test;

import java.util.List;

public class HibernateMotorcycleModelServiceTest {
    HibernateMotorcycleModelService motorcycleService = new HibernateMotorcycleModelServiceImpl();

    @Test
    public void testSaveRecord() throws Exception {
        //Создаем мотоцикл для записи в БД
        HibernateMotorcycleModel moto = new HibernateMotorcycleModel();
        moto.setBrand("Kawasaki");
        moto.setId(1);
        moto.setYear(1995);

        //Записали в БД
        HibernateMotorcycleModel motorcycle = motorcycleService.add(moto);

        //Вывели записанную в БД запись
        System.out.println(moto);
    }

    @Test
    public void testDeleteRecord() throws Exception {
        //Создаем мотоцикл для записи в БД
        HibernateMotorcycleModel moto = new HibernateMotorcycleModel();
        moto.setBrand("Yamaha");
        moto.setId(2);
        moto.setYear(2003);

        //Записываем его в БД
        HibernateMotorcycleModel motorcycle = motorcycleService.add(moto);

        //Удаляем его из БД
        motorcycleService.delete(moto.getId());
    }

    @Test
    public void testSelect() throws Exception {
        //Создаем мотоцикл для записи в БД
        HibernateMotorcycleModel moto = new HibernateMotorcycleModel();
        moto.setBrand("Suzuki");
        moto.setId(3);
        moto.setYear(2015);

        //Записываем в БД
        HibernateMotorcycleModel motorcycle = motorcycleService.add(moto);

        //Получние из БД Suzuki
        HibernateMotorcycleModel motoFromBD = motorcycleService.get(moto.getId());
        System.out.println(motoFromBD);
    }

    @Test
    public void testUpdate() throws Exception {
        //Создаем мотоцикл для записи в БД
        HibernateMotorcycleModel moto = new HibernateMotorcycleModel();
        moto.setBrand("Dnepr");
        moto.setId(4);
        moto.setYear(2009);

        //Записываем в БД
        moto = motorcycleService.add(moto);

        moto.setYear(1999);

        //Обновляем
        motorcycleService.update(moto);

        //Получаем обновленую запись
        HibernateMotorcycleModel moto2 = motorcycleService.get(moto.getId());
        System.out.println(moto2);
    }

    public void testGetAll(){
        //Создаем мотоцикл для записи в БД
        HibernateMotorcycleModel moto1 = new HibernateMotorcycleModel();
        moto1.setBrand("Harley-Davidson");
        moto1.setId(5);
        moto1.setYear(2000);

        //Создаем мотоцикл для записи в БД
        HibernateMotorcycleModel moto2 = new HibernateMotorcycleModel();
        moto2.setBrand("Honda");
        moto2.setId(6);
        moto2.setYear(2002);

        //Создаем мотоцикл для записи в БД
        HibernateMotorcycleModel moto3 = new HibernateMotorcycleModel();
        moto3.setBrand("Ural");
        moto3.setId(7);
        moto3.setYear(1990);

        //Сохраняем все мотоциклы
       motorcycleService.add(moto1);
       motorcycleService.add(moto2);
       motorcycleService.add(moto3);

        //Получаем все мотоциклы с БД
        List<HibernateMotorcycleModel> motorcycles = motorcycleService.getAll();

        //Выводим полученый список мотоциклов
        for(HibernateMotorcycleModel m : motorcycles){
            System.out.println(m);
        }
    }

}
