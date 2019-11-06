package apap.kelompok.sivitas.service;

import apap.kelompok.sivitas.model.PegawaiModel;
import apap.kelompok.sivitas.repository.PegawaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PegawaiRestServiceImpl implements PegawaiRestService {
    @Autowired
    private PegawaiDb pegawaiDb;

    @Override
    public PegawaiModel createPegawai(PegawaiModel pegawai) {
        return pegawaiDb.save(pegawai);
    }
}
