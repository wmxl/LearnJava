package HuHomework.log;

public abstract class Log {
    protected String name;
    protected String description;
    protected String data;
    protected double size;
    protected  String type;

    public long getInternalID() {
        return internalID;
    }

    private long internalID;
    private String uniqueShortCode;

    public Log(){

    }

    public Log(String name, String description, String data) {
        this.name = name;
        this.description = description;
        this.data = data;
        this.internalID = (long)(System.currentTimeMillis() * Math.random());
        if(name.length() > 3)
            name = name.substring(0, 3);
        if(description.length() > 3)
            description = description.substring(0,3);
        this.uniqueShortCode = ShortCodeGenerator();
    }
    public String ShortCodeGenerator(){
        //Singleton pattern
        Singleton object = Singleton.getInstance();
        return object.ShortCodeGenerator(this.name, this.description, internalID);
    }

    public void read(){
        System.out.println("read log");
        System.out.println("name: " + name);
        System.out.println("description: " + description);
        System.out.println("data: " + data);
    }

    public void update(String name, String des, String data){
        this.name = name;
        this.description = des;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Log{" +
                "name='" + name + '\'' +
                ", description='" + description + '\''+
                ", type='" + type+ '\'' +
                "}";
    }
    public double getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setName(String name){
        this.name = name;
    }

}
