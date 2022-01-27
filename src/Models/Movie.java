package Models;

public class Movie {
    String name;
    boolean haveAgeLimit;
    Integer minimumAge;

    public Movie(String name, boolean haveAgeLimit, Integer minimiumAge) {
        this.name = name;
        this.haveAgeLimit = haveAgeLimit;
        this.minimumAge = minimiumAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHaveAgeLimit() {
        return haveAgeLimit;
    }

    public void setHaveAgeLimit(boolean haveAgeLimit) {
        this.haveAgeLimit = haveAgeLimit;
    }

    public Integer getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(Integer minimumAge) {
        this.minimumAge = minimumAge;
    }

    @Override
    public String toString() {
        return "Movie{" + name + ":" + (minimumAge == null ? "L" : minimumAge) + "}";
    }
}
