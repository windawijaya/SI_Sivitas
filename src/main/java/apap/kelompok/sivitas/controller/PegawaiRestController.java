package apap.kelompok.sivitas.controller;

import apap.kelompok.sivitas.model.PegawaiModel;
import apap.kelompok.sivitas.rest.BaseResponse;
import apap.kelompok.sivitas.service.PegawaiRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class PegawaiRestController {
    @Autowired
    private PegawaiRestService pegawaiRestService;

    private boolean isNIPMatchData(PegawaiModel pegawai){
        String nip = pegawai.getNip();

        Date tanggalLahir = pegawai.getTanggalLahir();
        DateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String tanggal = sdf.format(tanggalLahir);

        if(!nip.substring(0,1).equals("P") ||
                !nip.substring(1,9).equals(tanggal)||
                !nip.substring(14).equals(pegawai.getUuidUser())) {
            return false;
        }
        else return true;
    }

    @PostMapping(value= "/pegawai")
    private BaseResponse<PegawaiModel> addPegawai(@Valid @RequestBody PegawaiModel pegawai, BindingResult bindingResult){
        BaseResponse<PegawaiModel> response = new BaseResponse<PegawaiModel>();

        if(bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else {
            if(isNIPMatchData(pegawai)) {
                pegawaiRestService.createPegawai(pegawai);

                response.setStatus(200);
                response.setMessage("success");
                response.setResult(pegawai);
            }
            else {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "NIP in request body is invalid");
            }
        }
        return response;
    }

    @GetMapping(value = "/pegawai/{uuid_user}")
    private BaseResponse<PegawaiModel> getPegawai(@PathVariable("uuid_user") String uuid){
        BaseResponse<PegawaiModel> response = new BaseResponse<PegawaiModel>();

        try{
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(pegawaiRestService.getPegawaiByUUID(uuid));

            return response;
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Pegawai with uuid "+ uuid + " not found"
            );
        }
    }

    @GetMapping(value = "/pegawai")
    private BaseResponse<List<PegawaiModel>> getAllPegawai(){
        BaseResponse<List<PegawaiModel>> response = new BaseResponse<List<PegawaiModel>>();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(pegawaiRestService.getAllPegawai());

        return response;
    }

    @PutMapping(value = "/pegawai/{uuid_user}")
    private BaseResponse<PegawaiModel>  updatePegawai(
            @PathVariable (value="uuid_user") String uuid,
            @RequestBody PegawaiModel pegawai
    ){
        BaseResponse<PegawaiModel> response = new BaseResponse<PegawaiModel>();
        try {
            if(isNIPMatchData(pegawai)) {
                pegawaiRestService.changePegawai(uuid, pegawai);

                response.setStatus(200);
                response.setMessage("success");
                response.setResult(pegawai);

                return response;
            }
            else {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "NIP in request body is invalid");
            }
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Pegawai with uuid "+ uuid + " not found"
            );
        }
    }
}
