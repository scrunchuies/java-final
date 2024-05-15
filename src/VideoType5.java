
public class VideoType5 extends Video {

    // always has a chance of being generated

    public VideoType5(String city, String country, int budget, int timeSpent) {
        super(city, country, budget, timeSpent);
        // TODO Auto-generated constructor stub
    }

    private String title;
    private int randomNum = (((int) Math.random()) * 20);

    public String toString() {

        title = "In " + randomNum + " Minutes This " + super.getRandNoun() + " Will Explode!";
        return title;
    }
}
