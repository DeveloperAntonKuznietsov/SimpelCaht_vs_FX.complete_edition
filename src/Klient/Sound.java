package Klient;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;



public class Sound {
    public void play() {

        try {
            File soundFile = new File("src/Klient/wav/klank.WAV"); //Звуковой файл

            //Получаем AudioInputStream
            //Вот тут могут полететь IOException и UnsupportedAudioFileException
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);

            //Получаем реализацию интерфейса Clip
            //Может выкинуть LineUnavailableException
            Clip clip = AudioSystem.getClip();

            //Загружаем наш звуковой поток в Clip
            //Может выкинуть IOException и LineUnavailableException
            clip.open(ais);

            clip.setFramePosition(0); //устанавливаем указатель на старт
            clip.start(); //Поехали!!!

            //Если не запущено других потоков, то стоит подождать, пока клип не закончится
            //В GUI-приложениях следующие 3 строчки не понадобятся
//           Thread.sleep(clip.getMicrosecondLength()/1000);
//            clip.stop(); //Останавливаем
//            clip.close(); //Закрываем
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}