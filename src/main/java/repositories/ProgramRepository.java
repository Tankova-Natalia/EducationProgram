package repositories;

import model.Program;
import model.Chair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
    List<Program> findAll();
    Program findById(int id);
    @Query("SELECT DISTINCT p.year FROM Program as p")
    List<Integer> findYears();
    @Query("SELECT DISTINCT c.name FROM Chair as c")
    List<String> findChairNames();
    @Query("SELECT DISTINCT s.name FROM Subject as s")
    List<String> findSubjectNames();
    @Query("SELECT DISTINCT s.name FROM Specialty as s")
    List<String> findSpecialtyNames();
    @Query("SELECT DISTINCT p.degree FROM Program as p")
    List<String> findDegrees();

}