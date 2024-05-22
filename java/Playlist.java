import java.util.ArrayList;


public class Playlist{

    private String PlName;
    private final ArrayList<Song> song;

    public Playlist(String PlName)
    {
        this.PlName=PlName;
        this.song = new ArrayList<>();
    }


    public String getPlName() // брать
    {
        return this.PlName;
    }

    public ArrayList<Song> getSong()
    {
        return song;
    }

// добавить трек
    public void addSong(Song newSong)
    {
        this.song.add(newSong);
    }

// показать песни
public void showSongs() {
    for (int i = 0; i < song.size(); i++) {
        System.out.println((i+1) + ". " + song.get(i));
    }
}
    public void removeSong(int index) {
        if (index >= 0 && index < song.size()) {
            song.remove(index);
        } else {
            System.out.println("Ошибка: неправильный индекс песни");
        }
    }




}




