package com.designPattern.structural.adapter;

// MP3용
interface MediaPlayer {
    void play(String fileName);
}

// MPV, MP4용
interface MediaPackage{
    void play(String fileName);
}

class MP3 implements  MediaPlayer{
    @Override
    public void play(String fileName) {
        System.out.println("MP3 file " + fileName + " is being played");
    }
}

class MPV implements  MediaPackage{
    @Override
    public void play(String fileName) {
        System.out.println(fileName + ".MPV is being played");
    }
}

class MP4 implements MediaPackage{
    @Override
    public void play(String fileName) {
        System.out.println(fileName + ".MP4 is being played");
    }
}

// MediaPlayer를 구현하여 해당 인터페이스를 기반으로 사용
// 다른 인터페이스 객체를 내부에서 받아 Adapt 시킬 수 있게 됨
class FormatAdapter implements MediaPlayer{
    private MediaPackage mediaPackage;

    public FormatAdapter(MediaPackage mp){
        mediaPackage = mp;
    }

    @Override
    public void play(String fileName) {
        System.out.print("Using Adapter -> ");
        mediaPackage.play(fileName);
    }
}

public class SimpleAdapterExample {
    public static void main(String[] args){
        MediaPlayer player = new MP3();
        player.play("file.mp3");

        player = new FormatAdapter(new MP4());
        player.play("file.mp4");

        player = new FormatAdapter(new MPV());
        player.play("file.mpv");
    }
}
