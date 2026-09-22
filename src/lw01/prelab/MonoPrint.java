package lw01.prelab;

public class MonoPrint extends PrintJob {

    public MonoPrint(String id, int pages) {
        super(id, pages); // super digunakan untuk memanggil konstruktor dari kelas induk (PrintJob) dengan parameter id dan pages. Ini memastikan bahwa id dan pages diinisialisasi dengan benar di kelas induk.
    }

    @Override 
    public int calculateCharge() {
        return getPages() * 500;
    }

    @Override
    public String label() {
        return "Mono";
    }
    
}