package apap.kelompok.sivitas.service;

import apap.kelompok.sivitas.model.PegawaiModel;
import apap.kelompok.sivitas.repository.PegawaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class PegawaiRestServiceImpl implements PegawaiRestService {
    @Autowired
    private PegawaiDb pegawaiDb;

    @Override
    public PegawaiModel createPegawai(PegawaiModel pegawai) {
        return pegawaiDb.save(pegawai);
    }

    @Override
    public PegawaiModel getPegawaiByUUID(String uuid) {
        Optional<PegawaiModel> pegawai = pegawaiDb.findById(uuid);
        if(pegawai.isPresent()){
            return pegawai.get();
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<PegawaiModel> getAllPegawai() {
        return pegawaiDb.findAll();
    }

    @Override
    public PegawaiModel changePegawai(String uuid, PegawaiModel pegawaiUpdate) {
        PegawaiModel pegawai = getPegawaiByUUID(uuid);
        pegawai.setNip(pegawaiUpdate.getNip());
        pegawai.setNama(pegawaiUpdate.getNama());
        pegawai.setTempatLahir(pegawaiUpdate.getTempatLahir());
        pegawai.setTanggalLahir(pegawaiUpdate.getTanggalLahir());
        pegawai.setAlamat(pegawaiUpdate.getAlamat());
        pegawai.setTelepon(pegawaiUpdate.getTelepon());

        return pegawaiDb.save(pegawai);
    }
}
