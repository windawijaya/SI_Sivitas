package apap.kelompok.sivitas.service;

import apap.kelompok.sivitas.model.GuruModel;
import apap.kelompok.sivitas.repository.GuruDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class GuruRestServiceImpl implements GuruRestService {
    @Autowired
    private GuruDb guruDb;

    @Override
    public GuruModel createGuru(GuruModel guru) {
        return guruDb.save(guru);
    }

    @Override
    public GuruModel getGuruByUUID(String uuid) {
        Optional<GuruModel> guru = guruDb.findById(uuid);
        if(guru.isPresent()){
            return guru.get();
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<GuruModel> getAllGuru() {
        return guruDb.findAll();
    }

    @Override
    public GuruModel changeGuru(String uuid, GuruModel guruUpdate) {
        GuruModel guru = getGuruByUUID(uuid);
        guru.setNig(guruUpdate.getNig());
        guru.setNama(guruUpdate.getNama());
        guru.setTempatLahir(guruUpdate.getTempatLahir());
        guru.setTanggalLahir(guruUpdate.getTanggalLahir());
        guru.setAlamat(guruUpdate.getAlamat());
        guru.setTelepon(guruUpdate.getTelepon());

        return guruDb.save(guru);
    }
}
