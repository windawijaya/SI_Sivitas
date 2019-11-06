package apap.kelompok.sivitas.controller;

import apap.kelompok.sivitas.model.PegawaiModel;
import apap.kelompok.sivitas.rest.BaseResponse;
import apap.kelompok.sivitas.service.PegawaiRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class PegawaiRestController {
    @Autowired
    private PegawaiRestService pegawaiRestService;

    @PostMapping(value= "/pegawai")
    public BaseResponse<PegawaiModel> addPegawai(@Valid @RequestBody PegawaiModel pegawai, BindingResult bindingResult){
        BaseResponse<PegawaiModel> response = new BaseResponse<PegawaiModel>();

        if(bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else {
            String nip = pegawai.getNip();

            Date tanggalLahir = pegawai.getTanggalLahir();
            DateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            String tanggal = sdf.format(tanggalLahir);

            if(!nip.substring(0,1).equals("P") ||
                !nip.substring(1,9).equals(tanggal)||
                !nip.substring(14).equals(pegawai.getUuid_user())) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "NIP in request body is invalid");
            }
            else {
                pegawaiRestService.createPegawai(pegawai);
                response.setStatus(200);
                response.setMessage("success");
                response.setResult(pegawai);
            }
        }
        return response;
    }
}
