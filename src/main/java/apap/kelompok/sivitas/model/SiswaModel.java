package apap.kelompok.sivitas.model;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "siswa")
public class SiswaModel implements Serializable {
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name="uuid_user", nullable = false)
    private String uuidUser;

    @NotNull
    @Size(max = 200)
    @Column(name = "nis", nullable = false)
    private String nis;

    @NotNull
    @Size(max = 200)
    @Column(name = "tempat_lahir", nullable = false)
    private String tempatLahir;

    @NotNull
    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggalLahir;

    @NotNull
    @Size(max = 200)
    @Column(name = "alamat", nullable = false)
    private String alamat;

    @NotNull
    @Size(max = 200)
    @Column(name = "telepon", nullable = false)
    private String telepon;

    public String getUuidUser() {
        return uuidUser;
    }

    public void setUuidUser(String uuidUser) {
        this.uuidUser = uuidUser;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
