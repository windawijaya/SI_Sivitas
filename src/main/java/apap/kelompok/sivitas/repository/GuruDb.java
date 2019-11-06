package apap.kelompok.sivitas.repository;

import apap.kelompok.sivitas.model.GuruModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuruDb extends JpaRepository<GuruModel, String> {
}
