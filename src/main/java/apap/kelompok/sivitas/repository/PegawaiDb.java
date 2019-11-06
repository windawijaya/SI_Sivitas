package apap.kelompok.sivitas.repository;

import apap.kelompok.sivitas.model.PegawaiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PegawaiDb  extends JpaRepository<PegawaiModel, String> {
    @Override
    Optional<PegawaiModel> findById(String s);
}
