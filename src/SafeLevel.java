import java.util.Date;

class Type{
    String base;
    String specific;
}

public class SafeLevel {

     char safetyRating(Type type, float speed, Date time){
        char[][][] ASIL = new char[4][4][5]; //ASIL安全等级判定表
        int S, C, E; //严重度S，可控性C，暴露率E
        int[] res = new int[3];
        switch (type.base){
            case "Action": //行为类
                res = actionSafty(type, speed, time); //调用行为类安全事件分级函数
                break;
            case "Info": //信息类安全事件
                res = infoSafty(type); //调用信息类安全事件分级函数
                break;
        }
        S = res[0];
        C = res[1];
        E = res[2];
        return ASIL[S][C][E];
    }
    int[] actionSafty(Type type, float speed, Date time){
         int S, C, E; //严重度S，可控性C，暴露率E
         if(type.specific == "fatigueDriving"){//如果具体类型是疲劳驾驶
             S = fatigueCount(speed, time);
         }else {
             S = severityCount(type, speed);//根据具体类型和速度确定严重度
         }
         C = controlCount(type); // 可控性确定
         E = ExpoCount(type); //暴露率确定
        int[] res = {S,C,E};
        return res;
    }

    int[] infoSafty(Type type){
        int S, C, E; //严重度S，可控性C，暴露率E
        int[][] R1 = b(type); //安全事件具体类型对应的严重度隶属矩阵
        int[] W1 = a(type); //安全事件具体类型对应的严重度模糊权向量
        int[] E1 =  multi(R1, W1);  //严重度隶属度向量
        float Q = uniformization(E1); //单值化处理
        S = mapS(Q);  // Q映射的严重度S分类值

        int[][] R2 = b(type); //安全事件具体类型对应的可控性隶属矩阵
        int[] W2 = a(type); //安全事件具体类型对应的可控性模糊权向量
        int[] E2 =  multi(R2, W2);//可控性隶属度分向量
        Q = uniformization(E1); //单值化处理
        C = mapS(Q);  // Q映射的严重度S分类值

        E = ExpoCount(type); //根据信息安全类型确定暴露率
        int[] res = {S,C,E};
        return res;

    }


    int mapS (float a){
        return 5;
    }
    int uniformization (int[] E1){
        return 5;
    }
    int[] multi(int[][] E1, int[] W1){
        return new int [3];
    }
    int[] a(Type type){
         return new int[3];
    }
    int[][] b(Type type){
        return new int[3][];
    }
    int[] c(Type type){
        return new int[3];
    }
    int[] d(Type type){
        return new int[3];
    }
    int severityCount(Type type, float speed){

        return 0;
    }
    int controlCount(Type type){

        return 0;
    }
    int ExpoCount(Type type){

        return 0;
    }
    int fatigueCount(float speed, Date time){
         int a = 3;
         return 0;
    }


    public static void main(String[] args) {

    }
}
