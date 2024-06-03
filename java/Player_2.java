import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


public class Player
{
    private final ArrayList<Playlist> playlists;

    private int currentPlaylistIndex ;
    private int currentSongIndex ;



    public Player()
    {
        this.playlists = new ArrayList<>();
    }

    public ArrayList<Playlist> getPlaylists() {
        return new ArrayList<>(playlists);
    }
    public ArrayList<Song> GetPlaylists(int currentPlaylistIndex) {
        return null;
    }

    public int getCurrentPlaylistIndex(){
        return this.currentPlaylistIndex;
    }

    public int getCurrentSongIndex(){
        return this.currentSongIndex;
    }

    //создать плейлист по имени
    public void createPlaylist(String name)
    {
        this.playlists.add(new Playlist(name));
    }

    //Удалить плейлист по имени
    public void removePlaylistByTitle(String name){
        for (int i = 0; i < playlists.size(); i++){
            if (playlists.get(i).getPlName().equals(name)){
                playlists.remove(i);
            }
        }
    }



//Включить текущий песни
    public void playCurrentSong(JTextArea outputLine){
        outputLine.setText("");
        Song cSong = playlists.get(currentPlaylistIndex).getSong().get(currentSongIndex);
        outputLine.append(cSong.getName() + "'" + " - " + cSong.getAuthor() + " - " + cSong.getLength() + " секунд");
    }


// Воспроизвести плейлист
    public void playPlaylist(int index, JTextArea outputLine) {
        if (index >= 0 && index < playlists.size()) {

            currentPlaylistIndex = index;

            if (playlists.get(currentPlaylistIndex).getSong().isEmpty()) {
                System.out.println("Плейлист пуст");
            } else {
                currentSongIndex = 0;
                System.out.println("Воспроизведение плейлиста " + playlists.get(currentPlaylistIndex).getPlName() + ":");
                playCurrentSong(outputLine);
            }
        } else {
            System.out.println("Ошибка: неправильный индекс плейлиста");
        }
    }


    //Включить предыдущий песни
    public void playPreviousSong(JTextArea outputLine){
        if (currentSongIndex > 0){
            currentSongIndex--;
            playCurrentSong(outputLine);
        } else{
            outputLine.setText("ошибка");
        }
    }

    // Включить следующий песни
    public void playNextSong(JTextArea outputLine){
        if (currentSongIndex < playlists.get(currentPlaylistIndex).getSong().size() - 1){
            currentSongIndex++;
            playCurrentSong(outputLine);
        } else{
            outputLine.setText("ошибка");
        }
    }

    // Повторить текущей песни
    public void repeatCurrentSong(JTextArea outputLine){
        if (playlists.get(currentPlaylistIndex) != null){
            outputLine.setText("");
            playCurrentSong(outputLine);
        } else{
            outputLine.setText("Текущий трек не может быть включен");
        }
    }

    // показать все песни

    public void showSongList(JTextArea outputArea) {
        outputArea.setText("");
        for (Playlist playlist : playlists) {
            outputArea.append("Плейлист " + playlist.getPlName() + ":\n");
            for (Song song : playlist.getSong()) {
                outputArea.append("'" + song.getName() + "'" + " - " + song.getAuthor() + " - " + song.getLength() + " секунд\n");
            }
            outputArea.append("\n");
        }
    }

    /*public void showSongList() {
        for (Playlist playlist : playlists) {
            System.out.println("Плейлист " + playlist.getPlName() + ":");
            for (Song song : playlist.getSong()) {
                System.out.println("'"+ song.getName() +"'"+ " - " + song.getAuthor() + " - " + song.getLength() + " секунд");
            }

        }
    }*/
    // показать песни из плейлиста




    public void showPlayPlaylist(int index, JTextArea outputArea) {
        if (index >= 0 && index < playlists.size()) {
            Playlist playlist = playlists.get(index);
            if (playlist.getPlName().isEmpty()) {
                outputArea.setText("Плейлист пуст");
            } else {
                outputArea.setText("Воспроизведение плейлиста " + playlist.getPlName() + ":\n");
                for (Song song : playlist.getSong()) {
                    outputArea.append("'" + song.getName() + "'" + " - " + song.getAuthor() + " - " + song.getLength() + " секунд\n");
                }
            }
        } else {
            outputArea.setText("Ошибка: неправильный индекс плейлиста");
        }
    }


    /*public void showPlayPlaylist(int index) {
        if (index >= 0 && index < playlists.size()) {
            Playlist playlist = playlists.get(index);
            if (playlist.getPlName().isEmpty()) {
                System.out.println("Плейлист пуст");
            } else {
                System.out.println("Воспроизведение плейлиста " + playlist.getPlName() + ":");
                for (Song song : playlist.getSong()) {
                    System.out.println("'"+ song.getName() +"'"+ " - " + song.getAuthor() + " - " + song.getLength() + " секунд");
                }}
        } else {
            System.out.println("Ошибка: неправильный индекс плейлиста");
        }
    }*/

    // добавить песню в плейлист
    public void addSongToPlaylist(int playlistIndex, String name, String author, int length) {
        if (playlistIndex >= 0 && playlistIndex < playlists.size()) {
            Playlist playlist = playlists.get(playlistIndex);
            playlist.addSong(new Song(name, author, length));
        } else {
            System.out.println("Ошибка: неправильный индекс плейлиста");
        }
    }
    // удалить песню из плейлиста
    public void removeSongFromPlaylist(int playlistIndex, int songIndex) {
        if (playlistIndex >= 0 && playlistIndex < playlists.size()) {
            Playlist playlist = playlists.get(playlistIndex);
            playlist.removeSong(songIndex);
        } else {
            System.out.println("Ошибка: неправильный индекс плейлиста");
        }
    }

//сохранение плейлист
    public void savePlaylistsToFile(String filePath, JTextArea outputArea) {
        try {
            File file = new File(filePath);
            file.createNewFile();

            StringBuilder content = new StringBuilder();
            for (Playlist playlist : playlists) {
                content.append(playlist.getPlName()).append("\n");
                for (Song song : playlist.getSong()) {
                    content.append(song.getName()).append(",")
                            .append(song.getAuthor()).append(",")
                            .append(song.getLength()).append("\n");
                }
                content.append("\n");
            }

            Files.write(Paths.get(filePath), content.toString().getBytes(), StandardOpenOption.WRITE);
            outputArea.setText("Плейлисты успешно сохранены в файл: " + filePath);
        } catch (IOException e) {
            outputArea.setText("Ошибка при сохранении плейлистов: " + e.getMessage());
        }
    }

    // загрузка плейлиста
    public void loadPlaylistsFromFile(String filePath, JTextArea outputArea) {
        try {

            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] lines = content.split("\n");

            Playlist currentPlaylist = null;
            for (String line : lines) {
                if (!line.isEmpty()) {
                    if (currentPlaylist == null || currentPlaylist.getPlName().equals(line)) {
                        currentPlaylist = new Playlist(line);
                        playlists.add(currentPlaylist);
                    } else {
                        String[] songInfo = line.split(",");
                        if (songInfo.length == 3) {
                            String name = songInfo[0];
                            String author = songInfo[1];
                            int length = Integer.parseInt(songInfo[2]);
                            currentPlaylist.addSong(new Song(name, author, length));
                        }
                    }
                }
            }

            outputArea.setText("Плейлисты успешно загружены из файла: " + filePath);
        } catch (IOException e) {
            outputArea.setText("Ошибка при загрузке плейлистов: " + e.getMessage());
        }
    }
}
