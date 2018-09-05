package car.store.core;

//TODO сделать тесты
public class MotorcycleServiceTest {
   /* MotorcycleService motorcycleService = new MotorcycleServiceImpl();

    @Test
    public void testSaveRecord() throws Exception {
        //Создаем мотоцикл для записи в БД
        Motorcycle moto = new Motorcycle();
        moto.setBrand("Kawasaki");
        moto.setId(1);
        moto.setYear(1995);

        //Записали в БД
        Motorcycle motorcycle = motorcycleService.add(moto);

        //Вывели записанную в БД запись
        System.out.println(moto);
    }

    @Test
    public void testDeleteRecord() throws Exception {
        //Создаем мотоцикл для записи в БД
        Motorcycle moto = new Motorcycle();
        moto.setBrand("Yamaha");
        moto.setId(2);
        moto.setYear(2003);

        //Записываем его в БД
        Motorcycle motorcycle = motorcycleService.add(moto);

        //Удаляем его из БД
        motorcycleService.delete(moto.getId());
    }

    @Test
    public void testSelect() throws Exception {
        //Создаем мотоцикл для записи в БД
        Motorcycle moto = new Motorcycle();
        moto.setBrand("Suzuki");
        moto.setId(3);
        moto.setYear(2015);

        //Записываем в БД
        Motorcycle motorcycle = motorcycleService.add(moto);

        //Получние из БД Suzuki
        Motorcycle motoFromBD = motorcycleService.get(moto.getId());
        System.out.println(motoFromBD);
    }

    @Test
    public void testUpdate() throws Exception {
        //Создаем мотоцикл для записи в БД
        Motorcycle moto = new Motorcycle();
        moto.setBrand("Dnepr");
        moto.setId(4);
        moto.setYear(2009);

        //Записываем в БД
        moto = motorcycleService.add(moto);

        moto.setYear(1999);

        //Обновляем
        motorcycleService.update(moto);

        //Получаем обновленую запись
        Motorcycle moto2 = motorcycleService.get(moto.getId());
        System.out.println(moto2);
    }

    public void testGetAll(){
        //Создаем мотоцикл для записи в БД
        Motorcycle moto1 = new Motorcycle();
        moto1.setBrand("Harley-Davidson");
        moto1.setId(5);
        moto1.setYear(2000);

        //Создаем мотоцикл для записи в БД
        Motorcycle moto2 = new Motorcycle();
        moto2.setBrand("Honda");
        moto2.setId(6);
        moto2.setYear(2002);

        //Создаем мотоцикл для записи в БД
        Motorcycle moto3 = new Motorcycle();
        moto3.setBrand("Ural");
        moto3.setId(7);
        moto3.setYear(1990);

        Person person = new Person();
        person.setFullName("Tom");
        person.setId(1);
        person.getMotorcycles().add(moto1);
        person.getMotorcycles().add(moto2);
        person.getMotorcycles().add(moto3);

        //Сохраняем все мотоциклы
       motorcycleService.add(moto1);
       motorcycleService.add(moto2);
       motorcycleService.add(moto3);

        //Получаем все мотоциклы с БД
        List<Motorcycle> motorcycles = motorcycleService.getAll();

        //Выводим полученый список мотоциклов
        for(Motorcycle m : motorcycles){
            System.out.println(m);
        }
    }*/

}
