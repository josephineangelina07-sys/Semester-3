class VideoAffiliate {
    int durasi;
    boolean pakaiVoiceOver;

    void checkStatus(){
        if(durasi >= 20 && durasi <= 25 && pakaiVoiceOver == false){
            System.out.println("Video siap diunggah!");
        }else{
            System.out.println("Format video tidak sesuai kriteria!");
        }
    }
}

public class ValidasiVideo {
    public static void main(String[] args){
        VideoAffiliate videoSaya = new VideoAffiliate();
        videoSaya.durasi = 22;
        videoSaya.pakaiVoiceOver = false;
        videoSaya.checkStatus();
    }

}
