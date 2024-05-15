
public class VideoType2 extends Video {

    // always has a chance of being generated

    public VideoType2(String city, String country, int budget, int timeSpent) {
        super(city, country, budget, timeSpent);
        // TODO Auto-generated constructor stub
    }

    private String title;

    public String toString() {

        title = "I Spent " + super.timeString() + " in " + super.getCity() + ", " + super.getCountry();
        return title;
    }

}