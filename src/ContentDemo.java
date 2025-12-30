import java.util.ArrayList;
import java.util.List;
abstract class ContentItem {
    private int id;
    private static int idGen = 1;
    private String title;
    private int year;
    private int durationMinutes;
    public ContentItem(String title, int year, int durationMinutes) {
        this.id = idGen++;
        this.title = title;
        this.year = year;
        this.durationMinutes = durationMinutes;
    }
    public int getAge(int currentYear) {
        return currentYear - year;
    }
    public abstract double getLicenseCost(int currentYear);
    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Year: " + year +
                ", Duration: " + durationMinutes + " min";
    }
    public int getDurationMinutes() {
        return durationMinutes;
    }
}
interface Downloadable {
    void download();
    int getMaxDownloadsPerDay();
}
class VideoLecture extends ContentItem implements Downloadable {
    private String quality;
    public VideoLecture(String title, int year, int durationMinutes, String quality) {
        super(title, year, durationMinutes);
        this.quality = quality;
    }
    @Override
    public double getLicenseCost(int currentYear) {
        int age = getAge(currentYear);
        int ageFactor;
        if (age <= 2) {
            ageFactor = 5;
        } else {
            ageFactor = 2;
        }
        return 0.05 * getDurationMinutes() + ageFactor;
    }
    @Override
    public String toString() {
        return super.toString() + ", Quality: " + quality;
    }
    @Override
    public void download() {
        System.out.println("Downloading video in " + quality + "...");
    }
    @Override
    public int getMaxDownloadsPerDay() {
        return 3;
    }
}
class PodcastEpisode extends ContentItem implements Downloadable {
    private String hostName;
    public PodcastEpisode(String title, int year, int durationMinutes, String hostName) {
        super(title, year, durationMinutes);
        this.hostName = hostName;
    }
    @Override
    public double getLicenseCost(int currentYear) {
        int age = getAge(currentYear);
        int ageFactor;
        if (age <= 2) {
            ageFactor = 3;
        } else {
            ageFactor = 1;
        }
        return 0.03 * getDurationMinutes() + ageFactor;
    }
    @Override
    public String toString() {
        return super.toString() + ", Host: " + hostName;
    }
    @Override
    public void download() {
        System.out.println("Downloading podcast hosted by " + hostName + "...");
    }
    @Override
    public int getMaxDownloadsPerDay() {
        return 10;
    }
}
public class ContentDemo {
    public static void main(String[] args) {
        List<ContentItem> items = new ArrayList<>();

        items.add(new VideoLecture("Java Basics", 2023, 120, "HD"));
        items.add(new VideoLecture("Assembly Intro", 2024, 90, "4K"));
        items.add(new PodcastEpisode("Tech Talk", 2022, 45, "Alice"));
        items.add(new PodcastEpisode("Code Stories", 2025, 60, "Bob"));

        int currentYear = java.time.Year.now().getValue();

        for (ContentItem item : items) {
            System.out.println(item.toString() + " | licenseCost=" + item.getLicenseCost(currentYear));

            if (item instanceof Downloadable) {
                Downloadable d = (Downloadable) item;
                d.download();
                System.out.println("Max downloads per day: " + d.getMaxDownloadsPerDay());
            }

            System.out.println();
        }
    }
}
