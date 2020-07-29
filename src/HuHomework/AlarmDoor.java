package HuHomework;

interface Door {
    void door();
}

public class AlarmDoor implements Door {
    public void open() {
        System.out.println("open");
    }

    public void close() {
        System.out.println("close");
    }

    public void door() {
        System.out.println("door");
    }

    public static void main(String[] args) {
        AlarmDoor al = new AlarmDoor();
        al.door();

    }
}
