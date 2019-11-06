package apap.kelompok.sivitas.service;

import apap.kelompok.sivitas.model.PegawaiModel;
import apap.kelompok.sivitas.repository.PegawaiDb;

public interface PegawaiRestService {
    PegawaiModel createPegawai(PegawaiModel pegawai);
    PegawaiModel getPegawaiByUUID(String uuid);
}
