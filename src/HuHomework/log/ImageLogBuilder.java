package HuHomework.log;

public class ImageLogBuilder extends Builder {

    private Log mLog = new ImageLog();

    @Override
    void buildName(String name) {
        mLog.setName(name);
    }

    @Override
    void buildDescription(String description) {
        mLog.setDescription(description);
    }

    @Override
    void buildData(String data) {
        mLog.setData(data);
    }

    @Override
    void buildSize(double size) {
        mLog.setSize(size);
    }

    void buildType(String type){
        mLog.type = type;
    }

    @Override
    Log build() {
        return mLog;
    }
}
