package ac.id.atmaluhur.mhs.uas19si056;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DosenPost {
    @SerializedName("nidn")
    @Expose
    private Integer nidn;
    @SerializedName("nama_dosen")
    @Expose
    private String namaDosen;
    @SerializedName("jabatan")
    @Expose
    private String jabatan;
    @SerializedName("gol_pang")
    @Expose
    private String golPang;
    @SerializedName("keahlian")
    @Expose
    private String keahlian;
    @SerializedName("program_studi")
    @Expose
    private String prodi;
    public Integer getNidn(){
        return nidn;
    }
    public void setNidn(Integer nidn){
        this.nidn = nidn;
    }
    public String getNamaDosen(){
        return namaDosen;
    }
    public String getJabatan(){
        return jabatan;
    }
    public String getGolPang(){
        return golPang;
    }
    public String getKeahlian(){
        return keahlian;
    }
    public String getProdi(){
        return prodi;
    }

}
