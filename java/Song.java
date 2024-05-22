
public class Song {

    private String name;
    private String author;
    private int length;



    public Song(String name, String author, int length) {

        this.name = name;
        this.author = author;
        this.length = length;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getLength(){
        return this.length;
    }


}

