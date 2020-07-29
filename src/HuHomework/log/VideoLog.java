package HuHomework.log;

public class VideoLog extends Log implements trigger {
    private double size;
    public VideoLog(){}

    public VideoLog(String name, String description, String data, double size, String type) {
        super(name, description, data);
        this.size = size;
        this.type = type;
    }

    @Override
    public void action() {
        System.out.println("this file has been close caption by AWS");
    }
    @Override
    public boolean isLegal() {
        if(size < 1000 ){
            if(type.equals("mp4") || type.equals("avi") || type.equals("mkv") ){
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
