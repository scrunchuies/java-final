
public class VideoType8 extends Video {

    // will only generate if a certain money threshold is broken

    public VideoType8(String city, String country, int budget, int timeSpent) {
        super(city, country, budget, timeSpent);
        // TODO Auto-generated constructor stub
    }

    private String title;

    public String toString() {

        title = "I built " + ((int) Math.random() * 100) + " Wells in " + super.getCountry();
        return title;
    }
}
