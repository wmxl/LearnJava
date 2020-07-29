package HuHomework.log;

public class ImageLog extends Log implements trigger {
    private double size;
    public ImageLog(){

    }

    public ImageLog(String name, String description, String data, double size, String type) {
        super(name, description, data);
        this.size = size;
        this.type = type;
    }

    @Override
    public void action() {
        System.out.println("photo's annotate");
    }

    @Override
    public boolean isLegal() {
        if(size < 1000 ){
            if(type.equals("jpg") || type.equals("png") || type.equals("tif") || type.equals("jepg") || type.equals("bmp")){
                return true;
            }
        }
        return false;
    }
}
