package HuHomework.log;

public class AudioLog extends Log implements trigger{

    public AudioLog(){

    }

    public AudioLog(String name, String description, String data, double size, String type) {
        super(name, description, data);
        this.size = size;
        this.type = type;
    }

    @Override
    public void action() {
        System.out.println("audio transcode");
    }
    @Override
    public boolean isLegal() {
        if(size < 800 ){
            if(type.equals("mp3") || type.equals("wav") || type.equals("flc")){
                return true;
            }
        }
        return false;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
