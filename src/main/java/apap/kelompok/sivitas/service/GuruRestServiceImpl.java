package apap.kelompok.sivitas.service;

import apap.kelompok.sivitas.model.GuruModel;
import apap.kelompok.sivitas.repository.GuruDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class GuruRestServiceImpl implements GuruRestService {
    @Autowired
    private GuruDb guruDb;

    @Override
    public GuruModel createGuru(GuruModel guru) {
        return guruDb.save(guru);
    }
}
