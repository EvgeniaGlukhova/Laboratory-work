
import java.util.Scanner;


class Main {
    private static final Player Player = new Player();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Меню:");
            System.out.println("1. Создать плейлист");
            System.out.println("2. Удалить плейлист");
            System.out.println("3. Воспроизвести плейлист");
            System.out.println("4. Воспроизвести предедущию песню");
            System.out.println("5. Воспроизвести следующую песню");
            System.out.println("6. Повтор текущей песни");
            System.out.println("7. Добавить песню в плейлиста");
            System.out.println("8. Удалить песню из плейлиста");
            System.out.println("9. Показать все песни");
            System.out.println("10. Показать песни из плейлиста");
            System.out.println("11. Сохранить плейлист");
            System.out.println("12. Загрузить плейлист");
            System.out.println("0. Выйти из приложения");

            System.out.print("Выберите действие: ");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    System.out.print("Введите название плейлиста: ");
                    String playlistName = scanner.next();
                    Player.createPlaylist(playlistName);
                    break;
                case 2:
                    System.out.print("Введите название плейлиста: ");
                    String playlistToDelete = scanner.next();
                    Player.removePlaylistByTitle(playlistToDelete);
                    break;

                case 3:
                    System.out.print("Введите индекс плейлиста: ");
                    int playlistIndex = scanner.nextInt();
                    Player.playPlaylist(playlistIndex);
                    break;
                case 4:
                    Player.playPreviousSong();
                    break;
                case 5:
                    Player.playNextSong();
                    break;
                case 6:
                    Player.repeatCurrentSong();
                    break;
                case 7:
                    System.out.print("Введите индекс плейлиста: ");
                    int playlistIndexToAddSong = scanner.nextInt();
                    System.out.print("Введите название песни: ");
                    String songTitle = scanner.next();
                    System.out.print("Введите исполнителя: ");
                    String songArtist = scanner.next();
                    System.out.print("Введите длительность трека в секундах: ");
                    int songDuration = scanner.nextInt();
                    Player.addSongToPlaylist(playlistIndexToAddSong, songTitle, songArtist, songDuration);
                    break;
                case 8:
                    System.out.print("Введите индекс плейлиста: ");
                    int playlistIndexToRemoveSong = scanner.nextInt();
                    System.out.print("Введите индекс песни: ");
                    int songIndexToRemove = scanner.nextInt();
                    Player.removeSongFromPlaylist(playlistIndexToRemoveSong, songIndexToRemove);
                    break;
                case 9:
                    Player.showSongList();
                    break;
                case 10:
                    System.out.print("Введите индекс плейлиста: ");
                    int playlistIndexX = scanner.nextInt();
                    Player.showPlayPlaylist(playlistIndexX);
                    break;

                case 11:
                    Player.savePlaylistsToFile("playlists3.txt");
                    break;
                case 12:
                    Player.loadPlaylistsFromFile("playlists3.txt");
                    break;

                case 0:
                    running = false;
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Некорректный выбор");
                    break;
            }
        }
        scanner.close();
    }
}
