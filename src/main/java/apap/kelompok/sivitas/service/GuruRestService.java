package apap.kelompok.sivitas.service;

import apap.kelompok.sivitas.model.GuruModel;

import java.util.List;

public interface GuruRestService {
    GuruModel createGuru(GuruModel guru);
    GuruModel getGuruByUUID(String uuid);
    List<GuruModel> getAllGuru();
}
