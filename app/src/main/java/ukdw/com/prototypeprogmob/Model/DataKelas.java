package ukdw.com.prototypeprogmob.Model;

public class DataKelas {
    private String kode_kelas;
    private String matkul_kelas;
    private String hari_kelas;
    private String sesi_kelas;
    private String dosen_kelas;
    private String jum_mhs;

    public DataKelas(String kode_kelas, String matkul_kelas, String hari_kelas, String sesi_kelas,
                     String dosen_kelas, String jum_mhs) {
        this.kode_kelas = kode_kelas;
        this.matkul_kelas = matkul_kelas;
        this.hari_kelas = hari_kelas;
        this.sesi_kelas = sesi_kelas;
        this.dosen_kelas = dosen_kelas;
        this.jum_mhs = jum_mhs;
    }

    public String getKodeKelas() {
        return kode_kelas;
    }

    public void setKodeKelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    public String getMatkulKelas() {
        return matkul_kelas;
    }

    public void setMatkulKelas(String matkul_kelas) {
        this.matkul_kelas = matkul_kelas;
    }

    public String getHariKelas() {
        return hari_kelas;
    }

    public void setHariKelas(String hari_kelas) { this.hari_kelas = hari_kelas; }

    public String getSesiKelas() {
        return sesi_kelas;
    }

    public void setSesiKelas(String sesi_kelas) {
        this.sesi_kelas = sesi_kelas;
    }

    public String getDosenKelas() {
        return dosen_kelas;
    }

    public void setDosenKelas(String dosen_kelas) { this.dosen_kelas = dosen_kelas; }

    public String getJumMhs() {
        return jum_mhs;
    }

    public void setJumMhs(String jum_mhs) { this.jum_mhs = jum_mhs; }
}
