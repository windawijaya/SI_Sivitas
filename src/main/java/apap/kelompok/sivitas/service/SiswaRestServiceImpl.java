package apap.kelompok.sivitas.service;

import apap.kelompok.sivitas.model.SiswaModel;
import apap.kelompok.sivitas.repository.SiswaDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class SiswaRestServiceImpl implements SiswaRestService {
    @Autowired
    private SiswaDb siswaDb;

    @Override
    public SiswaModel createSiswa(SiswaModel siswa) {
        return siswaDb.save(siswa);
    }

    @Override
    public SiswaModel getSiswaByUUID(String uuid) {
        Optional<SiswaModel> siswa = siswaDb.findById(uuid);
        if(siswa.isPresent()){
            return siswa.get();
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<SiswaModel> getAllSiswa() {
        return siswaDb.findAll();
    }

    @Override
    public SiswaModel changeSiswa(String uuid, SiswaModel siswaUpdate) {
        SiswaModel siswa = getSiswaByUUID(uuid);
        siswa.setNis(siswaUpdate.getNis());
        siswa.setNama(siswaUpdate.getNama());
        siswa.setTempatLahir(siswaUpdate.getTempatLahir());
        siswa.setTanggalLahir(siswaUpdate.getTanggalLahir());
        siswa.setAlamat(siswaUpdate.getAlamat());
        siswa.setTelepon(siswaUpdate.getTelepon());

        return siswaDb.save(siswa);
    }
}
