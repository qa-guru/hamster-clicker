package utils;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.InputStreamReader;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import com.google.api.gax.longrunning.OperationFuture;
//import com.google.cloud.speech.v1.*;
//import com.google.protobuf.ByteString;

public class YoutubeUtils {
//
//    public static void main(String[] args) {
//        String url = "https://www.youtube.com/watch?v=mFGOW304-8I";
//        String audioFilePath = "video_audio.wav";
//
//        try {
//            downloadAudioFromYouTube(url, audioFilePath);
//            String transcription = transcribeAudio(audioFilePath);
//            System.out.println("Transcription: " + transcription);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void downloadAudioFromYouTube(String url, String outputFilePath) throws Exception {
//        ProcessBuilder builder = new ProcessBuilder("youtube-dl", "--extract-audio", "--audio-format", "wav", "-o", outputFilePath, url);
//        executeProcess(builder);
//    }
//
//    private static String transcribeAudio(String audioFilePath) throws Exception {
//        byte[] audioData = Files.readAllBytes(Paths.get(audioFilePath));
//        ByteString audioBytes = ByteString.copyFrom(audioData);
//
//        try (SpeechClient speechClient = SpeechClient.create()) {
//            RecognitionConfig config = RecognitionConfig.newBuilder()
//                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
//                    .setSampleRateHertz(16000)
//                    .setLanguageCode("en-US")
//                    .build();
//            RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();
//
//            RecognizeResponse response = speechClient.recognize(config, audio);
//            return response.getResultsList().stream()
//                    .map(result -> result.getAlternativesList().get(0).getTranscript())
//                    .collect(Collectors.joining("\n"));
//        }
//    }
//
//    private static void executeProcess(ProcessBuilder builder) throws Exception {
//        builder.redirectErrorStream(true);
//        Process process = builder.start();
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//        if (process.waitFor() != 0) {
//            throw new RuntimeException("Process failed: " + process.exitValue());
//        }
//    }
}