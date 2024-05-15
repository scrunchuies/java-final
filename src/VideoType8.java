
public class VideoType8 extends Video {

    // will only generate if a certain money threshold is broken

    public VideoType8(String city, String country, int budget, int timeSpent) {
        super(city, country, budget, timeSpent);
        // TODO Auto-generated constructor stub
    }

    private String title;
    private int randomNum = (int) (Math.random() * 99) + 1;

    public String toString() {

        title = "I built " + randomNum + " Wells in " + super.getCountry();
        return title;
    }
}
