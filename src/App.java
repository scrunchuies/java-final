import java.io.*;
import java.util.*;

public class App {
    static String currentLocation;
    static String[][] countryCitiesArray;
    static String finalCountry;
    static String finalCity;

    // This method displays the intro and handles the selection of the continent, country, and city.
    public static void intro(Scanner scan) {
        // Welcoming message and request for continent selection
        System.out.println("|----Welcome to the Mr. Beast Video Generator----|");
        System.out.println("|--Which continent are you interested in?--|");
        System.out.println("[North America, South America, Europe, Asia, Africa, Australia, Antarctica]");
        String selectedContinent = scan.nextLine();  // User inputs their continent choice

        String csvFileName = getCSVFileName(selectedContinent);  // Get the corresponding CSV file for the continent
        if (csvFileName == null) {
            System.out.println("Invalid continent.");
            return;
        }

        String[][] continentCitiesArray = readCSV(csvFileName);  // Read city data from the CSV
        if (continentCitiesArray == null) {
            System.out.println("Failed to read city data.");
            return;
        }

        // Request for country selection within the chosen continent
        System.out.println("|--Which country in " + selectedContinent + " are you interested in?--|");
        List<String> countries = getCountriesForContinent(continentCitiesArray);  // List available countries
        for (int i = 0; i < countries.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + countries.get(i));
        }
        System.out.print("Enter the number of the country: ");
        int countryIndex = Integer.parseInt(scan.nextLine());  // User inputs their country choice
        if (countryIndex < 1 || countryIndex > countries.size()) {
            System.out.println("Invalid country selection.");
            return;
        }
        String selectedCountry = countries.get(countryIndex - 1);
        finalCountry = selectedCountry;

        String randomCity = selectRandomCityForCountry(selectedCountry, continentCitiesArray);  // Select a random city
        finalCity = randomCity;

        if (randomCity != null) {
            System.out.println("Random city in " + selectedCountry + ": " + randomCity);
        } else {
            System.out.println("No cities found for the selected country.");
        }
    }

    // This method asks about the budget for the video production and returns a category based on the budget.
    public static int budget(Scanner scan) {
        String ender = " (Enter Y for yes and anything else for no)";
        System.out.println("Is your budget greater than $2 million?" + ender);
        String twoMil = scan.nextLine();

        if (twoMil.toUpperCase().equals("Y")) {
            System.out.println("Noted...");
            return 1;
        } else {
            System.out.println("Oh, well thats okay. Do you at least have 1 million to spend?" + ender);
            String oneMil = scan.nextLine();

            if (oneMil.toUpperCase().equals("Y")) {
                System.out.println("Noted...");
                return 2;
            } else {
                System.out.println("What?? Um... that's okay. We can work with this. Do you have 500 thousand to spend?" + ender);
                String fiveHunnidK = scan.nextLine();
                if (fiveHunnidK.toUpperCase().equals("Y")) {
                    System.out.println("Noted...");
                    return 3;
                } else {
                    System.out.println("I guess not everyone is rich. That's ok pooron. You can be a pooron. That's ok So do you have at least 100 thousand to spend?" + ender);
                    String oneHunnidK = scan.nextLine();
                    if (oneHunnidK.toUpperCase().equals("Y")) {
                        System.out.println("Noted...");
                        return 4;
                    } else {
                        System.out.println("You really have no money, huh? That is okay...");
                        return 0;
                    }
                }
            }
        }
    }

    // This method determines how long the user is willing to spend on video production.
    public static int timeSpent(Scanner scan) {
        String ender = " (Enter Y for yes and anything else for no)";

        System.out.println("Are you willing to spend a month or a few on the filming of the video?" + ender);
        String month = scan.nextLine();

        if (!(month.toUpperCase().equals("Y"))) {
            System.out.println("Are you willing to at least spend a few weeks on the filming?" + ender);
            String fewWeeks = scan.nextLine();

            if (fewWeeks.toUpperCase().equals("Y")) {
                return (int) (Math.random() * 16) + 14;  // Random time between two weeks and a month
            } else {
                return (int) (Math.random() * 14);  // Random time less than two weeks
            }
        } else {
            System.out.println("Are you willing to spend a year or more on the filming of the video?" + ender);
            String year = scan.nextLine();

            if (year.toUpperCase().equals("Y")) {
                return (int) (Math.random() * 1095) + 365;  // Random time between a year and three years
            } else {
                return (int) (Math.random() * 182) + 30;  // Random time between a month and six months
            }
        }
    }

    // This method determines the correct CSV file name based on the selected continent.
    public static String getCSVFileName(String continent) {
        String currentDirectory = System.getProperty("user.dir");
        switch (continent.toLowerCase()) {
            case "north america":
                return currentDirectory + "/src/continents/na.csv";
            case "south america":
                return currentDirectory + "/src/continents/sa.csv";
            case "europe":
                return currentDirectory + "/src/continents/eu.csv";
            case "asia":
                return currentDirectory + "/src/continents/asia.csv";
            case "africa":
                return currentDirectory + "/src/continents/africa.csv";
            case "australia":
                return currentDirectory + "/src/continents/aus.csv";
            case "antarctica":
                return currentDirectory + "/src/continents/ant.csv";
            default:
                return null;  // Return null if continent is invalid
        }
    }

    // This method compiles a list of countries from the continent's city data.
    public static List<String> getCountriesForContinent(String[][] continentCitiesArray) {
        List<String> countries = new ArrayList<>();
        for (String[] countryData : continentCitiesArray) {
            countries.add(countryData[0]);  // Extract the country name from each row
        }
        return countries;
    }

    // This method selects a random city from a given country within a continent.
    public static String selectRandomCityForCountry(String country, String[][] continentCitiesArray) {
        for (String[] countryData : continentCitiesArray) {
            if (countryData[0].equalsIgnoreCase(country)) {
                Random random = new Random();
                int randomIndex = random.nextInt(countryData.length - 1) + 1;  // Choose a city randomly, excluding the country name
                return countryData[randomIndex];
            }
        }
        return null;  // Return null if no matching country is found
    }

    // This method reads and parses city data from a CSV file.
    public static String[][] readCSV(String csvFile) {
        File file = new File(csvFile);
        if (!file.exists()) {
            System.out.println("The file " + csvFile + " does not exist.");
            return null;
        }

        List<String[]> countryCitiesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");  // Split each line by comma
                countryCitiesList.add(data);  // Add the split data to the list
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        // Convert the list to a 2D array for easier processing
        String[][] countryCitiesArray = new String[countryCitiesList.size()][];
        for (int i = 0; i < countryCitiesList.size(); i++) {
            countryCitiesArray[i] = countryCitiesList.get(i);
        }
        return countryCitiesArray;
    }

    // The main method to run the program, handles exceptions, and manages the flow of the application.
    public static void main(String[] args) throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        String csvFile = currentDirectory + "/src/continents/null.csv";
        countryCitiesArray = readCSV(csvFile);  // Initialize countryCitiesArray
        if (countryCitiesArray == null) {
            System.out.println("Failed to read CSV file.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        intro(scanner); // Call intro method with scanner
        int moneyAv = budget(scanner);
        int timeAv = timeSpent(scanner);
        int randomVidNum;
        System.out.println("Processing Information, please wait...\n\n");
        if (moneyAv != 0) {
            randomVidNum = (int) (Math.random() * 9) + 1;  // Random video type if budget is available
        } else {
            randomVidNum = (int) (Math.random() * 6) + 1;  // Limited video types if no budget
        }
        String finalOutput;
        // Depending on the random video number, create a specific type of video and display its details
        if (randomVidNum == 1) {
            VideoType1 finalVid = new VideoType1(finalCity, finalCountry, moneyAv, timeAv);
            finalOutput = finalVid.toString();
        } else if (randomVidNum == 2) {
            VideoType2 finalVid = new VideoType2(finalCity, finalCountry, moneyAv, timeAv);
            finalOutput = finalVid.toString();
        } else if (randomVidNum == 3) {
            VideoType3 finalVid = new VideoType3(finalCity, finalCountry, moneyAv, timeAv);
            finalOutput = finalVid.toString();
        } else if (randomVidNum == 4) {
            VideoType4 finalVid = new VideoType4(finalCity, finalCountry, moneyAv, timeAv);
            finalOutput = finalVid.toString();
        } else if (randomVidNum == 5) {
            VideoType5 finalVid = new VideoType5(finalCity, finalCountry, moneyAv, timeAv);
            finalOutput = finalVid.toString();
        } else if (randomVidNum == 6) {
            VideoType6 finalVid = new VideoType6(finalCity, finalCountry, moneyAv, timeAv);
            finalOutput = finalVid.toString();
        } else if (randomVidNum == 7) {
            VideoType7 finalVid = new VideoType7(finalCity, finalCountry, moneyAv, timeAv);
            finalOutput = finalVid.toString();
        } else if (randomVidNum == 8) {
            VideoType8 finalVid = new VideoType8(finalCity, finalCountry, moneyAv, timeAv);
            finalOutput = finalVid.toString();
        } else {
            VideoType9 finalVid = new VideoType9(finalCity, finalCountry, moneyAv, timeAv);
            finalOutput = finalVid.toString();
        }
        System.out.println(finalOutput + "\n\n");
    }
}
