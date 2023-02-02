package com.etjava.test;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) {
//        readStr("��ð���");

    	System.out.println(textToStr("D:/ceshi.txt"));
        textToSpeechIO("��������ת������");

//        textToStr("D:/����.txt");
    }

    /**
     * �ַ����ı��Ķ�
     * @param str Ҫ���������ַ���
     */
    public static void readStr(String str){
        ActiveXComponent ax = new ActiveXComponent("Sapi.SpVoice");
        //����ʱ�����������
        Dispatch spVoice = ax.getObject();
        //�������� 0 ~ 100
        ax.setProperty("Volume",new Variant(100));
        //�����ʶ��ٶ� -10 ~ +10
        ax.setProperty("Rate",new Variant(0));
        //ִ���ʶ�
        Dispatch.call(spVoice,"Speak",new Variant(str));
    }

    /**
     * �ַ����ı�ת wav��ʽ �����ļ�
     * @param text Ҫ���������ַ���
     */
    public static void textToSpeechIO(String text){
        ActiveXComponent ax = null;
        Dispatch spFileStream = null;
        Dispatch spAudioFormat = null;
        Dispatch spVoice = null;
        try{
            ax = new ActiveXComponent("Sapi.SpFileStream");
            spFileStream = ax.getObject();

            ax = new ActiveXComponent("Sapi.SpAudioFormat");
            spAudioFormat = ax.getObject();

            spVoice = new ActiveXComponent("Sapi.SpVoice").getObject();
            // ������Ƶ����ʽ
            Dispatch.put(spAudioFormat, "Type", new Variant(22));
            // �����ļ��������ʽ
            Dispatch.putRef(spFileStream, "Format", spAudioFormat);
            // ������� �ļ����򿪷���������һ��.wav�ļ�
            Dispatch.call(spFileStream, "Open", new Variant("D:/voice.wav"), new Variant(3), new Variant(true));
            // ���������������Ƶ�����Ϊ����ļ�����
            Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
            // ��������  0 ~ 100
            Dispatch.put(spVoice, "Volume", new Variant(100));
            // �����ʶ��ٶ�  -10 ~ +10
            Dispatch.put(spVoice, "Rate", new Variant(0));

            Dispatch.call(spVoice, "Speak", new Variant(text));
            
            System.out.println("��������ļ��ɹ���");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            // �ر�����ļ�
            Dispatch.call(Objects.requireNonNull(spFileStream), "Close");
            Dispatch.putRef(Objects.requireNonNull(spVoice), "AudioOutputStream", null);

            Objects.requireNonNull(spAudioFormat).safeRelease();
            spFileStream.safeRelease();
            spVoice.safeRelease();
            ax.safeRelease();
        }
    }

    /**
     * txt�ļ�ת�ַ���
     * @param fileName txt�ļ�����λ��
     * @return txt�ļ��е��ַ���
     */
    public static String textToStr(String fileName){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line=reader.readLine()) != null){
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }finally {
            try {
                Objects.requireNonNull(reader).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
