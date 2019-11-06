package apap.kelompok.sivitas.service;

import apap.kelompok.sivitas.model.SiswaModel;

import java.util.List;

public interface SiswaRestService {
    SiswaModel createSiswa(SiswaModel siswa);
    SiswaModel getSiswaByUUID(String uuid);
    List<SiswaModel> getAllSiswa();
    SiswaModel changeSiswa(String uuid, SiswaModel siswaUpdate);
}
