package work.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Transactional
public interface TeacherDao extends CrudRepository<Teacher,Integer> {
    @Query("SELECT t FROM Teacher t WHERE t.name LIKE CONCAT('%', :name, '%')")
    Iterable<Teacher> findByName(@Param("name") String name);
}
