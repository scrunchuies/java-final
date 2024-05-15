
public class VideoType4 extends Video {

    // always has a chance of being generated

    public VideoType4(String city, String country, int budget, int timeSpent) {
        super(city, country, budget, timeSpent);
        // TODO Auto-generated constructor stub
    }

    private String title;

    public String toString() {

        title = "World's Most Dangerous " + super.getRandNoun();
        return title;
    }
}
