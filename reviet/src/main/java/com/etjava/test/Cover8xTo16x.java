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
//     * 音频文件频率8k转16k。必须要转，因为不转百度识别不出来，错误信息是音质太差
//     * @param sourceFile
//     * @return
//     */
//    public static File cover8xTo16x(File sourceFile){
//        String targetPath = null;
//        try {
//            File ffmpegPath = new File("E:\\project\\ffmpeg\\bin\\ffmpeg"); //存放ffmpeg程序的目录
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
//            System.out.println("录音文件8k转化16k失败"+e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//        if (!"".equals(targetPath) || targetPath!=null) {
//            return new File(targetPath);
//        }
//        System.out.println("传入的文件路径有误");
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
