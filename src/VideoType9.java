
public class VideoType9 extends Video {

    // will only generate if a certain money threshold is broken

    public VideoType9(String city, String country, int budget, int timeSpent) {
        super(city, country, budget, timeSpent);
        // TODO Auto-generated constructor stub
    }

    private String title;

    public String toString() {

        title = "$" + super.moneyString() + " Every Day You Survive in a " + super.getRandNoun();
        return title;
    }
}
