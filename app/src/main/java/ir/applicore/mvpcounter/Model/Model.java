package ir.applicore.mvpcounter.Model;


public class Model {
    private int count = 0;

    public String getCount() {
        count++;
        return String.valueOf(count);
    }

}
