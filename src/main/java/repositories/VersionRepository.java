package repositories;

import model.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionRepository extends JpaRepository<Version,Integer> {
    List<Version> findAll();
    Version findById(int id);
}
