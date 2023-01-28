package model;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class Keluhan {

    private long id;
    private long tanggalKeluhan;
    private String namaAplikasi;
    private String JenisKeluhan;
    private String deskripsiKeluhan;
    private String statusKeluhan;

    public Keluhan(long id, long tanggalKeluhan, String namaAplikasi, String JenisKeluhan, String deskripsiKeluhan, String statusKeluhan) {
        this.id = id;
        this.tanggalKeluhan = tanggalKeluhan;
        this.namaAplikasi = namaAplikasi;
        this.JenisKeluhan = JenisKeluhan;
        this.deskripsiKeluhan = deskripsiKeluhan;
        this.statusKeluhan = statusKeluhan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTanggalKeluhan() {
        return tanggalKeluhan;
    }

    public void setTanggalKeluhan(long tanggalKeluhan) {
        this.tanggalKeluhan = tanggalKeluhan;
    }

    public String getNamaAplikasi() {
        return namaAplikasi;
    }

    public void setNamaAplikasi(String namaAplikasi) {
        this.namaAplikasi = namaAplikasi;
    }

    public String getJenisKeluhan() {
        return JenisKeluhan;
    }

    public void setJenisKeluhan(String JenisKeluhan) {
        this.JenisKeluhan = JenisKeluhan;
    }

    public String getDeskripsiKeluhan() {
        return deskripsiKeluhan;
    }

    public void setDeskripsiKeluhan(String deskripsiKeluhan) {
        this.deskripsiKeluhan = deskripsiKeluhan;
    }

    public String getStatusKeluhan() {
        return statusKeluhan;
    }

    public void setStatusKeluhan(String statusKeluhan) {
        this.statusKeluhan = statusKeluhan;
    }

}
