//package com.etjava.test;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.apache.log4j.spi.LoggerFactory;
//import org.json.JSONObject;
//
//import com.baidu.aip.speech.AipSpeech;
// 
///**
// * Created by liuzhonghua on 2018/8/14.
// */
//public class Cover8xTo16x {
// 
//    /**
//     * ��Ƶ�ļ�Ƶ��8kת16k������Ҫת����Ϊ��ת�ٶ�ʶ�𲻳�����������Ϣ������̫��
//     * @param sourceFile
//     * @return
//     */
//    public static File cover8xTo16x(File sourceFile){
//        String targetPath = null;
//        try {
//            File ffmpegPath = new File("E:\\project\\ffmpeg\\bin\\ffmpeg"); //���ffmpeg�����Ŀ¼
//            targetPath = sourceFile.getAbsolutePath().replaceAll(".wav" , "_16x.wav");
//            // ffmpeg.exe -i source.wav -ar 16000 target.wav
//            List<String> wavToPcm = new ArrayList<String>();
//            wavToPcm.add(ffmpegPath.getAbsolutePath());
//            wavToPcm.add("-i");
//            wavToPcm.add(sourceFile.getAbsolutePath());
//            wavToPcm.add("-ar");
//            wavToPcm.add("16000");
//            wavToPcm.add(targetPath);
//            ProcessBuilder builder = new ProcessBuilder();
//            builder.command(wavToPcm);
//            builder.redirectErrorStream(true);
//            Process process = builder.start();
//            process.waitFor();
//        } catch (Exception e) {
//            System.out.println("¼���ļ�8kת��16kʧ��"+e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//        if (!"".equals(targetPath) || targetPath!=null) {
//            return new File(targetPath);
//        }
//        System.out.println("������ļ�·������");
//        return null;
//    }
//    
//    public static void main(String[] args) {
////    	AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
////        client.setConnectionTimeoutInMillis(2000);
////        client.setSocketTimeoutInMillis(60000);
////        JSONObject res = client.asr("D:\\websites\\upload\\vox\\vns\\389_37\\4.6.1.ai1_16x.wav", "wav", 16000, null);
////        System.out.println(res);
//	}
//}
