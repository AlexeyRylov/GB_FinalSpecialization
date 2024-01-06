package Models.Abstract.Animals;

import Models.Animals.Type;

import java.util.Date;

public abstract class Pet extends HumanFriend {
    private String whoIsHePlayingWith;
    private int loves;
    private String favoriteFood;
    private String favoriteToy;

    public Pet(String whoIsHePlayingWith, int loves, String favoriteFood, String favoriteToy) {
        this.whoIsHePlayingWith = whoIsHePlayingWith;
        this.loves = loves;
        this.favoriteFood = favoriteFood;
        this.favoriteToy = favoriteToy;
    }

    public Pet(String key, String name, Date birthDay, int energy, int weight, Type type, String whoIsHePlayingWith, int loves, String favoriteFood, String favoriteToy) {
        super(key, name, birthDay, energy, weight, type);
        this.whoIsHePlayingWith = whoIsHePlayingWith;
        this.loves = loves;
        this.favoriteFood = favoriteFood;
        this.favoriteToy = favoriteToy;
    }

    public String getWhoIsHePlayingWith() {
        return whoIsHePlayingWith;
    }

    public void setWhoIsHePlayingWith(String whoIsHePlayingWith) {
        this.whoIsHePlayingWith = whoIsHePlayingWith;
    }

    public int getLoves() {
        return loves;
    }

    public void setLoves(int loves) {
        this.loves = loves;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getFavoriteToy() {
        return favoriteToy;
    }

    public void setFavoriteToy(String favoriteToy) {
        this.favoriteToy = favoriteToy;
    }

    public abstract void toPlay();

    @Override
    public String toString() {
        return super.toString().replace("}","") + ", " +
                "whoIsHePlayingWith='" + whoIsHePlayingWith + '\'' +
                ", loves=" + loves +
                ", favoriteFood='" + favoriteFood + '\'' +
                ", favoriteToy='" + favoriteToy + '\'' +
                '}';
    }
}