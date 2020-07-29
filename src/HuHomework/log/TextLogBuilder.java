package HuHomework.log;

public class TextLogBuilder extends Builder {

    private Log mLog = new TextLog();

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

    @Override
    void buildType(String size) {

    }

    @Override
    Log build() {
        return mLog;
    }
}
