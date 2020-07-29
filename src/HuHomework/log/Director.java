package HuHomework.log;

public class Director {
    Builder mBuilder = null;

    public Director(Builder builder) {
        this.mBuilder = builder;
    }


    public void construct(String name,String description, String data, double size, String type){
        mBuilder.buildName(name);
        mBuilder.buildDescription(description);
        mBuilder.buildData(data);
        mBuilder.buildSize(size);
        mBuilder.buildType(type);
    }
}
