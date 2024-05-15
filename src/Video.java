import java.util.ArrayList;

public class Video {
    // variables that are inputted from main
    private String country;
    private String city;
    private int budget;
    private int timeSpent;
    private String time;

    // list of random nouns that can possibly be used in video title
    private final String[] randNouns = { "Circle", "Prison", "Grocery Store", "Boat", "Dungeon", "Evil Cave", "Pyramid",
            "Pharaoh's Tomb", "Orphanage", "Evil Circle", "Homeless Shelter", "Classroom", "Basement",
            "Discord Mod's Basement", "Island",
            "Abandoned Island", "Evil Island", "Abandoned City", "Bus", "Car", "Amusement Park", "House", "Country",
            "Hotel",
            "Abandoned Hotel", "Museum", "Cave", "MrBeast Burger", "Hospital", "Mental Asylum",
            "Solitary Confinement Cell", "Walmart", "Bouncy House",
            "Car Dealership", "Ocean", "Minivan", "Shark Cage", "Crocodile Cage",
            "Shipping Container Going Across the Sea", "Among Us Lobby",
            "GTA 5 Lobby", "Minecraft SMP", "Incredibly Radioactive Wasteland", "Factory", "Magic School Bus",
            "School Bus", "Taco Bell Bathroom",
            "Fish Tank", "Aquarium", "Lion Enclosement", "Palace", "Abandoned Palace", "Evil Palace", "Castle",
            "Abandoned Castle",
            "Evil Castle", "Goblin Den", "Not Haunted House", "Haunted House", "Mansion", "Haunted Mansion",
            "Billionare's Secret Dungeon",
            "Unknowing Family of 5's House", "Apartment Complex", "Abandoned Apartment Complex", "Fortnite Lobby",
            "Closet", "Bed",
            "Mr Beast Fan's House", "Birdcage", "Warehosue", "Junkyard", "Triangle", "Rectagnle", "Square", "Pentagon",
            "Hexagon", "Septagon", "Heptagon", "Octagon",
            "Nonagon", "Decagon", "Mysterious Cube", "4th Dimentional Universe", "Podcast Episode", "River", "Beach",
            "Abandoned Beach",
            "Dangerous Beach", "Ancient Civilization", "UFO", "Mothership", "Manic State", "Airplane", "Helicopter",
            "Falling Airplane",
            "Burning Building", "Burning House", "Battleship", "Speedboat", "Forest", "Spooky Forest", "Evil Forest",
            "Jungle",
            "Rainforest", "Evil Rainforest", "Evil Jungle", "Gym", "School Cafeteria", "Undisclosed Location",
            "[Redacted]", "Interrogation Room",
            "Office Cubicle", "Office Building", "Underwater Civilization", "Cloud", "Dead-End Job", "Mr Beast Video",
            "Casino", "Abandoned Casino",
            "Kitchen", "Chef's Kitchen", "Evil Kitchen", "Soup Kitchen", "Camp", "Encampment", "Campsite",
            "Trailer Park", "Trailer", "Starship",
            "Star Destroyer", "Death Star", "Concert Hall", "Intersection", "Laboratory", "Limousine", "Bridge",
            "Courthouse",
            "Government Testing Lab", "Volcano", "Inside of a Volcano", "Universe", "Galaxy",
            "Galaxy-Traversing Vessel", "Underground City",
            "Underground Kingdom", "Silly Golbin Village", "EVIL Goblin Village", "Microwave", "Big Microwave", "Box",
            "Cardboard Box",
            "Steel Box", "Iron Box", "Boxing Ring", "Stadium", "Football Stadium", "Soccer Stadium", "Ice-Skating Rink",
            "Train", "Bullet Train", "EVIL Train",
            "Steamboat", "Cruiseship", "Ferry", "Cargo Ship", "Mailbox", "Suitcase", "Cult", "Evil Cult",
            "Alien Planet", "Extraterrestrial Land",
            "College Campus", "University", "Gamer Basement", "Furry Convention", "Abandoned Hospital", "Cardboard Box",
            "Storage Container",
            "Ziploc Bag" };

    private int randSelector = (int) (Math.random() * randNouns.length);
    public String randNoun = randNouns[randSelector];

    // constructor
    public Video(String city, String country, int budget, int timeSpent) {

        this.city = city;
        this.country = country;
        this.budget = budget;
        this.timeSpent = timeSpent;

    }

    public String moneyString() {
        String money = "";
        Integer moneyInt = 0;
        String moneyHolder = "";

        if (budget == 0) {
            moneyHolder = "0";

        } else if (budget == 1) {
            moneyInt = (int) (Math.random() * 9000000) + 2000000;
            moneyHolder = moneyInt.toString();

        } else if (budget == 2) {
            moneyHolder = "1000000";

        } else if (budget == 3) {
            moneyInt = (int) (Math.random() * 500000) + 200000;
            moneyHolder = moneyInt.toString();
        } else {
            moneyInt = (int) (Math.random() * 200000) + 100000;
            moneyHolder = moneyInt.toString();
        }
        // 56,839,445
        // 56839445
        money = moneyHolder;
        for (int i = 0; i < moneyHolder.length(); i++) {

            if ((i + 1) % 3 == 0 && (i + 1) != moneyHolder.length() - 1) {
                money = money.substring(0, i) + "," + money.substring(i, money.length());
            }
        }

        return money;
    }

    public String timeString() {
        int months = timeSpent / 30;
        int years = timeSpent / 365;

        if (timeSpent > 730) {
            time = years + " Years";
        } else if (timeSpent >= 365) {
            time = years + " Year";
        } else if (timeSpent > 61) {
            time = months + " Months";
        } else if (timeSpent >= 30) {
            time = months + " Month";
        } else if (timeSpent == 1) {
            time = timeSpent + " Day";
        } else {
            time = timeSpent + " Days";
        }
        return time;
    }

    // getter methods

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getBudget() {
        return budget;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public String getRandNoun() {
        return randNoun;
    }

    // setter methods

    private void setCity(String newCity) {
        city = newCity;
    }

    private void setCountry(String newCountry) {
        country = newCountry;
    }

    private void setBudget(int newBudget) {
        budget = newBudget;
    }

    private void setTimeSpent(int newTimeSpent) {
        timeSpent = newTimeSpent;
    }

    private void changeRandNoun() {
        randSelector = (int) Math.random() * 180;
        randNoun = randNouns[randSelector];
    }

}
