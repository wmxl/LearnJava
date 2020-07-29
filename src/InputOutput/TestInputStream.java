package InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestInputStream {
    public static void main(String[] args) throws IOException {
        // 第1步、使用File类找到一个文件
        File f= new File("D:\\IDEACodes\\LearnJava\\src\\Testlog\\log.properties") ;    // 声明File对象
        // 第2步、通过子类实例化父类对象
        InputStream input = new FileInputStream(f) ;    // 通过对象多态性，进行实例化
        // 第3步、进行读操作
        byte b[] = new byte[1024] ;        // 所有的内容都读到此数组之中
        input.read(b) ;        // 读取内容   网络编程中 read 方法会阻塞
        // 第4步、关闭输出流
        input.close() ;                        // 关闭输出流
        System.out.println("内容为：" + new String(b)) ;    // 把byte数组变为字符串输出
    }

}
