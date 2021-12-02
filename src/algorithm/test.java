package algorithm;

/**
 * PACKAGE_NAME
 * Date： 2021/10/15 1:57 下午
 * User： cris
 * Description： 快排
 **/
public class test{


    public static void main(String[] args){
        int[] a = {2,5,1,7,10,6,9,4,3,8};
        quickSort(a,0,a.length-1);
        System.out.print("end");
    }

    public static void quickSort(int[] a,int begin,int end){
        if(end > begin){
            int mark = a[begin];
            int beginSource = begin;
            int endSource = end;
            while(begin < end){

                while(a[end] > mark && end > begin){			//找到从后往前第一个小于mark的数
                    end-- ;
                }
                if(end > begin){
                    a[begin] = a[end];
                    begin++;
                }

                while(a[begin] <= mark && end >begin){
                    begin++;
                }
                if(end > begin){
                    a[end] = a[begin];
                    end--;
                }
            }
            a[begin] = mark;
            quickSort(a,beginSource,begin-1);
            quickSort(a,begin+1,endSource);
        }

    }
}
