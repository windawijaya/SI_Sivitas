package apap.kelompok.sivitas.service;

import apap.kelompok.sivitas.model.PegawaiModel;
import apap.kelompok.sivitas.repository.PegawaiDb;

import java.util.List;

public interface PegawaiRestService {
    PegawaiModel createPegawai(PegawaiModel pegawai);
    PegawaiModel getPegawaiByUUID(String uuid);
    List<PegawaiModel> getAllPegawai();
    PegawaiModel changePegawai(String uuid, PegawaiModel pegawaiUpdate);
}
