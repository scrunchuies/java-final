
public class VideoType1 extends Video {

    // always has a chance of being generated

    public VideoType1(String city, String country, int budget, int timeSpent) {
        super(city, country, budget, timeSpent);
        // TODO Auto-generated constructor stub
    }

    private String title;

    public String toString() {

        title = "I Spent " + super.timeString() + " in ";
        String[] vowels = { "a", "e", "i", "o", "u" };
        boolean vowel = false;
        for (int i = 0; i < vowels.length; i++) {
            if (super.randNoun.substring(0, 1).toUpperCase().equals(vowels[i].toUpperCase())) {
                vowel = true;
                break;
            }
        }

        if (vowel) {
            title += "an";
        } else {
            title += "a";
        }

        title += " " + super.randNoun;
        return title;
    }

}