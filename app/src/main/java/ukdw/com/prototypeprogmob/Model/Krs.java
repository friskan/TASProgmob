package ukdw.com.prototypeprogmob.Model;

public class Krs {
    private String kode_matkul;
    private String matkul;
    private String dosen;

    public Krs(String kode_matkul, String matkul, String dosen) {
        this.kode_matkul = kode_matkul;
        this.matkul = matkul;
        this.dosen = dosen;
    }

    public String getKode_matkul() {
        return kode_matkul;
    }

    public void setKode_matkul(String kode_matkul) {
        this.kode_matkul = kode_matkul;
    }

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

}
