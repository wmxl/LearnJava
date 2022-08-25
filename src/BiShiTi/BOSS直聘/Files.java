package BiShiTi.BOSS直聘;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 编程题：请编写并运行Java小程序，完成如下功能： 下载,解压缩ZIP文件，内包含6个文本文件，每个文件包含工作职位描述和需要的技能，
 * 请编写程序，找出文件同时包含“Java” 和 “Database”。
 * 如果有问题请提出，可以在网上找解决方案。
 */
public class Files {

    public static boolean findKeyword(String str, String keyword){
        int i = str.toLowerCase().indexOf(keyword);
        return i >= 0? true: false;
    }

    public static boolean readTxtFile(String filePath, String keyword) {
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if(findKeyword(lineTxt, keyword)) return true;
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return false;
    }

    public static void readTextFiles(String path){
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                if(readTxtFile(tempList[i].toString(), "database") && readTxtFile(tempList[i].toString(), "java")){
                    files.add(tempList[i].toString());
                }
            }
//            if (tempList[i].isDirectory()) {
//              System.out.println("文件夹：" + tempList[i]);
//            }
        }
        for (String name : files){
            System.out.println(name);
        }
    }

    public static void main(String argv[]) {
        readTextFiles("D:\\files");
    }
}
