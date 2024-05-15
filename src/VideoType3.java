
public class VideoType3 extends Video {

    // always has a chance of being generated

    public VideoType3(String city, String country, int budget, int timeSpent) {
        super(city, country, budget, timeSpent);
        // TODO Auto-generated constructor stub
    }

    private String title;

    public String toString() {

        title = "Last Person to Leave the " + super.getRandNoun() + " Wins $" + super.moneyString();
        return title;
    }
}
