package lw01.prelab;

public abstract class PrintJob implements Chargeable {
    private String id;
    private int pages;

    protected PrintJob(String id, int pages) {
        if (pages < 0) {
            throw new IllegalArgumentException("Number of pages are not valid");
        }

        this.id = id;
        this.pages = pages;
    }

    public String getId() {
        return this.id;
    }

    public int getPages() {
        return this.pages;
    }

    public abstract int calculateCharge();

    public int calculateCharge(int copies) {
        if (copies <= 0) {
           throw new IllegalArgumentException("Number of copies are not valid");
        }

        return copies * calculateCharge();
    }

    public String label() {
        return "Print";
    }

    public String summary() {
        return this.id + " | " + label() + " | " + calculateCharge();
    } 
    
}