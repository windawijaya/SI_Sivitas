package apap.kelompok.sivitas.controller;

import apap.kelompok.sivitas.model.GuruModel;
import apap.kelompok.sivitas.rest.BaseResponse;
import apap.kelompok.sivitas.service.GuruRestService;
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
@RequestMapping("/api/teachers")
public class GuruRestController {
    @Autowired
    private GuruRestService guruRestService;

    private boolean isNIGMatchData(GuruModel guru){
        String nig = guru.getNig();

        Date tanggalLahir = guru.getTanggalLahir();
        DateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String tanggal = sdf.format(tanggalLahir);

        if(!nig.substring(0,1).equals("G") ||
                !nig.substring(1,9).equals(tanggal)||
                !nig.substring(14).equals(guru.getUuidUser())) {
            return false;
        }
        else return true;
    }

    @PostMapping(value= "")
    private BaseResponse<GuruModel> addGuru(@Valid @RequestBody GuruModel guru, BindingResult bindingResult){
        BaseResponse<GuruModel> response;
        response = new BaseResponse<>();

        if (!bindingResult.hasFieldErrors()) {
            if(isNIGMatchData(guru)) {
                guruRestService.createGuru(guru);

                response.setStatus(200);
                response.setMessage("success");
                response.setResult(guru);
            }
            else {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "NIG in request body is invalid");
            }
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        return response;
    }

    @GetMapping(value = "/{uuid_user}")
    private BaseResponse<GuruModel> getGuru(@PathVariable("uuid_user") String uuid){
        BaseResponse<GuruModel> response = new BaseResponse<>();

        try{
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(guruRestService.getGuruByUUID(uuid));

            return response;
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Guru with uuid "+ uuid + " not found"
            );
        }
    }

    @GetMapping(value = "")
    private BaseResponse<List<GuruModel>> getAllGuru(){
        BaseResponse<List<GuruModel>> response = new BaseResponse<>();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(guruRestService.getAllGuru());

        return response;
    }

    @PutMapping(value = "/{uuid_user}")
    private BaseResponse<GuruModel>  updateGuru(
            @PathVariable (value="uuid_user") String uuid,
            @RequestBody GuruModel guru
    ){
        BaseResponse<GuruModel> response = new BaseResponse<>();
        try {
            if(isNIGMatchData(guru)) {
                guruRestService.changeGuru(uuid, guru);

                response.setStatus(200);
                response.setMessage("success");
                response.setResult(guru);

                return response;
            }
            else {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "NIG in request body is invalid");
            }
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Guru with uuid "+ uuid + " not found"
            );
        }
    }
}
