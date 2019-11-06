package apap.kelompok.sivitas.repository;

import apap.kelompok.sivitas.model.SiswaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaDb extends JpaRepository<SiswaModel, String> {
}
