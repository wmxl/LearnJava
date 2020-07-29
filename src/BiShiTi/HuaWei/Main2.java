package BiShiTi.HuaWei;

public class Main2 {
    public static void main(String[] args) {
        // TODO Auto-generated fatherMethod stub
        //Scanner sc = new Scanner(System.in);
        int[] labels = new int[]{115,112,116,97,111,121,114,101,105,112,121,114,102,115,116};
        int[] haschlid = new int[]{0,0,0,1,1,0,1,0,0,0,0,1,1,1,1};
        int[] pouds = new int[]{1,1,0,1,0,1,1,1,0,0,0,1,1,0,0};
        int[] value = new int[]{1,2,3,-1,-1,4,-1,5,6,7,8,-1,-1,-1,-1};
        int[] key = new int[]{116,114,112};
        int strlen = 15;
        int keylen = 3;
        //int strlen = sc.nextInt();
//		int[] labels = new int[strlen];
//		int[] haschlid = new int[strlen];
//		int[] pouds = new int[strlen];
//		for(int i = 0; i< strlen; i++){
//			labels[i] = sc.nextInt();
//		}
//		for(int i = 0; i< strlen; i++){
//			haschlid[i] = sc.nextInt();
//		}
//		for(int i = 0; i< strlen; i++){
//			pouds[i] = sc.nextInt();
//		}
//		int valuelen = sc.nextInt();
//		int[] value = new int[valuelen];
//		for(int i = 0; i< valuelen; i++){
//			value[i] = sc.nextInt();
//		}
//		int keylen = sc.nextInt();
//		int[] key = new int[keylen];
//		for(int i = 0; i< keylen; i++){
//			key[i] = sc.nextInt();
//		}
        int flag = search(labels, haschlid, pouds, value, 0, strlen-1, key, 0);
        System.out.println(flag);

    }
    public static int search(int[] labels, int[] haschlid, int[] pouds, int[] value, int start, int end, int[] key, int ind){
        if(ind == key.length-1){
            int fl = 0;
            int kk = start;
            while(kk<=end){
                if(labels[kk] == key[ind]){
                    fl = value[kk];
                }
                kk++;
            }
            return fl;
        }
        int temp = end;
        while(temp>=start){
            if(pouds[temp] == 1){
                break;
            }
            temp--;
        }
        //System.out.println(".....");
        //System.out.println(temp);
        boolean flag = false;
        int i;
        for(i=0; i<=end-temp; i++){
            if(labels[i+temp] == key[ind]){
                flag = true;
                break;
            }
        }
        int subtreeStart = 0;
        int subtreeEnd = 0;
        int subtreenum = 0;
        int j = start;
        boolean jj = true;
        while(j<=temp-1){
            if(haschlid[j]==0){
                if(jj){
                    subtreeStart = j;
                    jj = false;
                }
            }else{
                if(haschlid[j+1]==0 || j+1> temp-1){
                    jj = true;
                    subtreeEnd = j;
                    if(subtreenum==i){
                        break;
                    }
                    subtreenum++;
                }
            }
            j++;
        }
        if(!jj){
            subtreeEnd = temp-1;
        }
        if(!flag){
            return 0;
        }else{
            //System.out.println(subtreeStart);
            //System.out.println(subtreeEnd);
            return search(labels, haschlid, pouds, value, subtreeStart, subtreeEnd, key, ind+1);
        }
    }
}
