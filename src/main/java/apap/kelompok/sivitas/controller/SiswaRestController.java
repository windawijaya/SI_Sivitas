package apap.kelompok.sivitas.controller;

import apap.kelompok.sivitas.model.SiswaModel;
import apap.kelompok.sivitas.rest.BaseResponse;
import apap.kelompok.sivitas.service.SiswaRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/students")
public class SiswaRestController {
    @Autowired
    private SiswaRestService siswaRestService;

    private boolean isNISMatchData(SiswaModel siswa){
        String nis = siswa.getNis();

        Date tanggalLahir = siswa.getTanggalLahir();
        DateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String tanggal = sdf.format(tanggalLahir);

        if(!nis.substring(0,1).equals("S") ||
                !nis.substring(1,9).equals(tanggal)||
                !nis.substring(14).equals(siswa.getUuidUser())) {
            return false;
        }
        else return true;
    }

    @PostMapping(value= "")
    private BaseResponse<SiswaModel> addSiswa(@Valid @RequestBody SiswaModel siswa, BindingResult bindingResult){
        BaseResponse<SiswaModel> response = new BaseResponse<>();

        if(bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else {
            if(isNISMatchData(siswa)) {
                siswaRestService.createSiswa(siswa);

                response.setStatus(200);
                response.setMessage("success");
                response.setResult(siswa);
            }
            else {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "NIS in request body is invalid");
            }
        }
        return response;
    }

    @GetMapping(value = "/{uuid_user}")
    private BaseResponse<SiswaModel> getSiswa(@PathVariable("uuid_user") String uuid){
        BaseResponse<SiswaModel> response = new BaseResponse<>();

        try{
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(siswaRestService.getSiswaByUUID(uuid));

            return response;
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Siswa with uuid "+ uuid + " not found"
            );
        }
    }

    @GetMapping(value = "")
    private BaseResponse<List<SiswaModel>> getAllSiswa(){
        BaseResponse<List<SiswaModel>> response = new BaseResponse<>();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(siswaRestService.getAllSiswa());

        return response;
    }

    @PutMapping(value = "/{uuid_user}")
    private BaseResponse<SiswaModel>  updateSiswa(
            @PathVariable (value="uuid_user") String uuid,
            @RequestBody SiswaModel siswa
    ){
        BaseResponse<SiswaModel> response = new BaseResponse<>();
        try {
            if(isNISMatchData(siswa)) {
                siswaRestService.changeSiswa(uuid, siswa);

                response.setStatus(200);
                response.setMessage("success");
                response.setResult(siswa);

                return response;
            }
            else {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "NIS in request body is invalid");
            }
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Siswa with uuid "+ uuid + " not found"
            );
        }
    }
}
