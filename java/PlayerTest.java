import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();

    }

    //создать плейлист по имени
    @Test
    void createPlaylist() {
        player.createPlaylist("Playlist 1");
        assertEquals(1, player.getPlaylists().size());
        assertEquals("Playlist 1", player.getPlaylists().get(0).getPlName());
    }
    //Удалить плейлист по имени
    @Test
    void removePlaylistByTitle() {
        player.createPlaylist("Playlist 1");
        player.createPlaylist("Playlist 2");
        assertEquals(2, player.getPlaylists().size());

        player.removePlaylistByTitle("Playlist 1");
        assertEquals(1, player.getPlaylists().size());
        assertEquals("Playlist 2", player.getPlaylists().get(0).getPlName());
    }
    //Включить текущий песни
    @Test
    void playCurrentSong() {
        player.createPlaylist("Playlist 1");
        player.getPlaylists().get(0).addSong(new Song("Song 1", "Artist 1", 11));
        player.getPlaylists().get(0).addSong(new Song("Song 2", "Artist 2", 22));

        //player.playPlaylist(0);
        player.playCurrentSong();
        // проверка в консоли

    }

    // Воспроизвести плейлист
    @Test
    void playPlaylist() {
        player.createPlaylist("Playlist 1");
        player.getPlaylists().get(0).addSong(new Song("Song 1", "Artist 1", 11));


        player.playPlaylist(0);
        assertEquals(0, player.getCurrentPlaylistIndex());
        assertEquals(0, player.getCurrentSongIndex());
    }
    //Включить предыдущий песни
    @Test
    void playPreviousSong() {
        player.createPlaylist("Playlist 1");
        player.getPlaylists().get(0).addSong(new Song("Song 1", "Artist 1", 11));
        player.getPlaylists().get(0).addSong(new Song("Song 2", "Artist 2", 22));

        player.playPlaylist(0);
        player.playNextSong();
        player.playPreviousSong();
        assertEquals(0, player.getCurrentSongIndex());
    }
    // Включить следующий песни
    @Test
    void playNextSong() {
        player.createPlaylist("Playlist 1");
        player.getPlaylists().get(0).addSong(new Song("Song 1", "Artist 1", 11));
        player.getPlaylists().get(0).addSong(new Song("Song 2", "Artist 2", 22));

        player.playPlaylist(0);
        player.playNextSong();
        assertEquals(1, player.getCurrentSongIndex());
    }

    // показать все песни
    @Test
    void showSongList() {
        player.createPlaylist("Playlist 1");
        player.createPlaylist("Playlist 2");
        player.getPlaylists().get(0).addSong(new Song("Song 1", "Artist 1", 11));
        player.getPlaylists().get(0).addSong(new Song("Song 2", "Artist 2", 22));
        player.getPlaylists().get(1).addSong(new Song("Song 1", "Artist 1", 11));

        player.showSongList();
        // проверка в консоли
    }
    // показать песни из плейлиста
    @Test
    void showPlayPlaylist() {
        player.createPlaylist("Playlist 1");
        player.createPlaylist("Playlist 2");
        player.getPlaylists().get(0).addSong(new Song("Song 1", "Artist 1", 11));
        player.getPlaylists().get(0).addSong(new Song("Song 2", "Artist 2", 22));
        player.getPlaylists().get(1).addSong(new Song("Song 1", "Artist 1", 11));

        player.showPlayPlaylist(0);
        // проверка в консоли
    }
    // добавить песню в плейлист
    @Test
    void addSongToPlaylist() {
        player.createPlaylist("Playlist 1");
        player.addSongToPlaylist(0, "Song 1", "Artist 1", 11);
        assertEquals(1, player.getPlaylists().size());
        assertEquals("Playlist 1", player.getPlaylists().get(0).getPlName());

    }
    // удалить песню из плейлиста
    @Test
    void removeSongFromPlaylist() {
        player.createPlaylist("Playlist 1");
        player.addSongToPlaylist(0, "Song 1", "Artist 1", 11);
        player.removeSongFromPlaylist(0,0);
        assertEquals(1, player.getPlaylists().size());
        assertEquals("Playlist 1", player.getPlaylists().get(0).getPlName());

    }
    //сохранение плейлист
    @Test
    void savePlaylistsToFile() {
        player.createPlaylist("Playlist 1");
        player.createPlaylist("Playlist 2");
        player.getPlaylists().get(0).addSong(new Song("Song 1", "Artist 1", 11));
        player.getPlaylists().get(0).addSong(new Song("Song 2", "Artist 2", 22));
        player.getPlaylists().get(1).addSong(new Song("Song 1", "Artist 1", 11));
        player.savePlaylistsToFile("Playlist4.txt");


    }
    // загрузка плейлиста
    @Test
    void loadPlaylistsFromFile() {
        player.loadPlaylistsFromFile("Playlist4.txt");
        player.showPlayPlaylist(0);
        //player.showPlayPlaylist(1);
        // проверка в консоли


    }
}
