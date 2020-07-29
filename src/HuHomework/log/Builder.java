package HuHomework.log;

public abstract class Builder {

    abstract void buildName(String Name);
    abstract void buildDescription(String description);
    abstract void buildData(String data);
    abstract void buildSize(double size);
    abstract void buildType(String size);
    abstract Log build();

}