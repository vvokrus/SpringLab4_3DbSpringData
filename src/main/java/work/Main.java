package work;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import work.dao.Teacher;
import work.dao.TeacherDao;
import work.dao.TeacherDaoConfig;

import java.util.Optional;

import static java.lang.System.out;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(TeacherDaoConfig.class)) {
            TeacherDao teacherDao = context.getBean(TeacherDao.class);

            //findAll
            System.out.println("Find All" + teacherDao.findAll());

//          Find by Id
            Optional<Teacher> teacherOptional = teacherDao.findById(1);
            out.println("Find by id:");
            teacherOptional.ifPresentOrElse( out::println, ()->out.println("Курс не найден"));

//          Save new teacher
            out.println("Find all:");
            teacherDao.findAll().forEach(out::println);

            Teacher teacherNew = new Teacher();
            teacherNew.setId(6);
            teacherNew.setName("Петров Алексей Петрович");
            teacherNew.setAddress("Москва, Римская ул., д.1");
            teacherNew.setPhone("125-32-22");
            teacherDao.save(teacherNew);

            out.println("Find all:");
            teacherDao.findAll().forEach(out::println);

//          Delete teacher
            teacherDao.deleteById(6);

            out.println("Find all:");
            teacherDao.findAll().forEach(out::println);

//          FindByName = 'дор'
            out.println("Find by name = дор");
            Iterable<Teacher> teacherOptional1Name = teacherDao.findByName("дор");
            teacherOptional1Name.forEach(out::println);
        }
    }
}