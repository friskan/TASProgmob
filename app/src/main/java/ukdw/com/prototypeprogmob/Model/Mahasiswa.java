package ukdw.com.prototypeprogmob.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mahasiswa {

    @SerializedName("nim")
    @Expose
    private String nim;

    @SerializedName("nama_mhs")
    @Expose
    private String nama_mhs;

    @SerializedName("email_mhs")
    @Expose
    private String email_mhs;

    @SerializedName("alamat_mhs")
    @Expose
    private String alamat_mhs;

    @SerializedName("foto_mhs")
    @Expose
    private String foto_mhs;

    @SerializedName("nim_progmob")
    @Expose
    private String nim_progmob;

    @SerializedName("id")
    @Expose
    private String id;

    public Mahasiswa(String nim, String nama_mhs, String email_mhs, String alamat_mhs, String foto_mhs, String nim_progmob, String id) {
        this.nim = nim;
        this.nama_mhs = nama_mhs;
        this.email_mhs = email_mhs;
        this.alamat_mhs = alamat_mhs;
        this.foto_mhs = foto_mhs;
        this.nim_progmob = nim_progmob;
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNamaMhs() { return nama_mhs; }

    public void setNamaMhs(String nama_mhs) {
        this.nama_mhs = nama_mhs;
    }

    public String getEmailMhs() {
        return email_mhs;
    }

    public void setEmailMhs(String email_mhs) {
        this.email_mhs = email_mhs;
    }

    public String getAlamatMhs() {
        return alamat_mhs;
    }

    public void setAlamatMhs(String alamat_mhs) {
        this.alamat_mhs = alamat_mhs;
    }

    public String getFotoMhs() {
        return foto_mhs;
    }

    public void setFotoMhs(String foto_mhs) {
        this.foto_mhs = foto_mhs;
    }

    public String getNimProgmob() {
        return nim_progmob;
    }

    public void setNimProgmob(String nim_progmob) {
        this.alamat_mhs = nim_progmob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
