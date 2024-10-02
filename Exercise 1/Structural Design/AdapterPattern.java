///Use Case: Media Player Compatibility



// Target Interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Existing Advanced Media Player Interface
interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}

// Concrete Advanced Media Players
class VlcPlayer implements AdvancedMediaPlayer {
    public void playVlc(String fileName) { System.out.println("Playing vlc file: " + fileName); }

    public void playMp4(String fileName) { /* Do nothing */ }
}

class Mp4Player implements AdvancedMediaPlayer {
    public void playVlc(String fileName) { /* Do nothing */ }

    public void playMp4(String fileName) { System.out.println("Playing mp4 file: " + fileName); }
}

// Adapter
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) { advancedMusicPlayer = new VlcPlayer(); }
        else if (audioType.equalsIgnoreCase("mp4")) { advancedMusicPlayer = new Mp4Player(); }
    }

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) { advancedMusicPlayer.playVlc(fileName); }
        else if (audioType.equalsIgnoreCase("mp4")) { advancedMusicPlayer.playMp4(fileName); }
    }
}

// Concrete Media Player
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        }
        else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else { System.out.println("Invalid media. " + audioType + " format not supported."); }
    }
}

// Client
public class AdapterPattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "video.mp4");
        audioPlayer.play("vlc", "movie.vlc");
        audioPlayer.play("avi", "animation.avi");
    }
}
