package HuHomework.log;

public class LogFactory {
    //Factory pattern
    public Log makeLog(String attachmentType) {

        //Build pattern
        Director logDirector;
        Builder audioBuilder = new AudioLogBuilder();
        Builder videoBuilder = new VideoLogBuilder();
        Builder imageBuilder = new ImageLogBuilder();
        if(attachmentType.equalsIgnoreCase("mp3")){

            logDirector = new Director(audioBuilder);
            logDirector.construct("audioLog","audioLog description","121212",32.0, "mp3");
            return audioBuilder.build();
        }
        else if(attachmentType.equalsIgnoreCase("avi")) {
            logDirector = new Director(videoBuilder);
            logDirector.construct("videoLog","description","121212",32.0, "avi");
            return videoBuilder.build();
        }
        else if(attachmentType.equalsIgnoreCase("jpg")) {
            logDirector = new Director(imageBuilder);
            logDirector.construct("imageLog","description","121212",32.0, "jpg");
            return imageBuilder.build();
        }

        return null;
    }
}