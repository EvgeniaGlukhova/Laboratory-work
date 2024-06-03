import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PlayerGUI  extends JFrame {

    private Player player;
    private JFrame frame;
    private JPanel panel;
    private JPanel hidePanel;
    private JButton createPlaylistButton;
    private JButton removePlaylistButton;
    private JButton playPlaylistButton;
    private JButton playPreviousSongButton;
    private JButton playNextSongButton;
    private JButton repeatCurrentSongButton;
    private JButton addSongToPlaylistButton;
    private JButton removeSongFromPlaylistButton;
    private JButton showSongListButton;
    private JButton showPlayPlaylistButton;
    private JButton saveButton;
    private JButton openButton;
    private JFileChooser fileChooser;

    private JTextArea outputArea;
    private  JTextArea outputLine;



    public PlayerGUI(Player player) {
        this.player = player;
        frame = new JFrame("Музыкальный плеер");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,560 );

        panel = new JPanel();


        hidePanel = new JPanel();
        hidePanel.setLayout(new GridLayout(3, 3));
        hidePanel.setVisible(false);


        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(150, 200));

        outputLine = new JTextArea();
        outputLine.setEditable(false);
        JScrollPane linelPane = new JScrollPane(outputLine);
        linelPane.setPreferredSize(new Dimension(150, 40));


        fileChooser = new JFileChooser();

        openButton = new JButton("Load");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String input = JOptionPane.showInputDialog(frame, "Enter playlist index to load:");
                //int currentPlaylistIndex = Integer.parseInt(input);
                player.loadPlaylistsFromFile("playlists3.txt", outputArea);

            }
        });
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //String input = JOptionPane.showInputDialog(frame, "Enter playlist index to save:");
                //int currentPlaylistIndex = Integer.parseInt(input);
                player.savePlaylistsToFile("playlists5.txt", outputArea);
            }
        });


        JButton toggleButton = new JButton("Additional");
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hidePanel.setVisible(!hidePanel.isVisible());
            }
        });


        createPlaylistButton = new JButton("Add");
        createPlaylistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playlistName = JOptionPane.showInputDialog(frame, "Введите название плейлиста: ");
                player.createPlaylist(playlistName);

            }
        });

        removePlaylistButton = new JButton("Del");
        removePlaylistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playlistName = JOptionPane.showInputDialog(frame, "Введите название плейлиста: ");
                player.removePlaylistByTitle(playlistName);
            }
        });

        playPlaylistButton = new JButton("Play");
        playPlaylistButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = JOptionPane.showInputDialog(frame, "Введите индекс плейлиста");
                    int currentPlaylistIndex = Integer.parseInt(input);
                    player.playPlaylist(currentPlaylistIndex, outputLine);
                }


        });
// вывод
        playPreviousSongButton = new JButton("<<");
        playPreviousSongButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    outputLine.setText("");
                    player.playPreviousSong(outputLine);

                }
            });
// вывод
        playNextSongButton = new JButton(">>");
        playNextSongButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    outputLine.setText("");
                    player.playNextSong(outputLine);
                }
            });
// вывод
        repeatCurrentSongButton = new JButton("()");
        repeatCurrentSongButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    outputLine.setText("");
                    player.repeatCurrentSong(outputLine);
                }
            });

        addSongToPlaylistButton = new JButton("+");
        addSongToPlaylistButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Введите индекс плейлиста: ");
                int currentPlaylistIndex = Integer.parseInt(input);
                String tit = JOptionPane.showInputDialog(frame, "Введите название песни: ");
                String titleSong = String.valueOf(tit);
                String art = JOptionPane.showInputDialog(frame, "Введите исполнителя: ");
                String artistSong = String.valueOf(art);
                String dur = JOptionPane.showInputDialog(frame, "Введите длительность трека в секундах: ");
                int durSong = Integer.parseInt(dur);
                player.addSongToPlaylist(currentPlaylistIndex, titleSong, artistSong, durSong);
            }
        });
        removeSongFromPlaylistButton = new JButton("x");
        removeSongFromPlaylistButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Введите индекс плейлиста: ");
                int currentPlaylistIndex = Integer.parseInt(input);
                String in = JOptionPane.showInputDialog(frame, "Введите индекс песни: ");
                int SongIndex = Integer.parseInt(in);
                player.removeSongFromPlaylist(currentPlaylistIndex, SongIndex);
                //outputLabel.setText("Песня удалена из плейлиста.");
            }
        });
// вывод
        showSongListButton = new JButton("All songs");
        showSongListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                player.showSongList(outputArea);
            }
        });


        // вывод
        showPlayPlaylistButton = new JButton("Playlist songs");
        showPlayPlaylistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Введите индекс плейлиста: ");
                if (input != null) {
                    int currentPlaylistIndex = Integer.parseInt(input);
                    outputArea.setText("");
                    player.showPlayPlaylist(currentPlaylistIndex, outputArea);
                }
            }
        });


        panel.add(openButton);
        panel.add(saveButton);

        panel.add(createPlaylistButton);
        panel.add(playPlaylistButton);
        panel.add(scrollPane);
        panel.add(linelPane);
        panel.add(playPreviousSongButton);
        panel.add(repeatCurrentSongButton);
        panel.add(playNextSongButton);
        panel.add(addSongToPlaylistButton);
        panel.add(removeSongFromPlaylistButton);
        hidePanel.add(removePlaylistButton);
        hidePanel.add(showSongListButton);
        hidePanel.add(showPlayPlaylistButton);


        panel.add(toggleButton);
        panel.add(hidePanel);


        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        Player player = new Player();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PlayerGUI(player);
            }
        });
    }



}


