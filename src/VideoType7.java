
public class VideoType7 extends Video {

    // will only generate if a certian money threshold is broken

    public VideoType7(String city, String country, int budget, int timeSpent) {
        super(city, country, budget, timeSpent);
        // TODO Auto-generated constructor stub
    }

    private String title;

    public String toString() {

        title = "$1 vs $" + super.moneyString() + super.getRandNoun() + "!";
        return title;
    }
}
