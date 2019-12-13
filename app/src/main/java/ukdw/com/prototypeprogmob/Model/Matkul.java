package ukdw.com.prototypeprogmob.Model;

public class Matkul {
    private String kode;
    private String nama_matkul;
    private String hari;
    private String sesi;
    private String sks;

    public Matkul(String kode, String nama_matkul, String hari, String sesi, String sks) {
        this.kode = kode;
        this.nama_matkul = nama_matkul;
        this.hari = hari;
        this.sesi = sesi;
        this.sks = sks;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNamaMatkul() {
        return nama_matkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.nama_matkul = namaMatkul;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getSesi() {
        return sesi;
    }

    public void setSesi(String sesi) {
        this.sesi = sesi;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) { this.sks = sks;
    }
}
