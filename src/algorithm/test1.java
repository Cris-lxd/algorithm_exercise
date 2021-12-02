package algorithm;

/**
 * algorithm.test
 * Date： 2021/10/26 2:36 下午
 * User： cris
 * Description： tt
 **/
public class test1 {
    public static int sq(int a[],int s,int t,int k){
        int tmp;
        int i=s,j=t;
        if(s!=t && s < t){
            tmp=a[s];
            while(j >i){
                while(j>i && a[j]>=tmp) {
                    j--;
                }
                if(j > i){
                    a[i]=a[j];
                }
                while(i<j&&a[i]<=tmp){
                    i++;
                }
                if(j >i){
                    a[j]=a[i];
                }
            }
            a[i]=tmp;
            sq(a,s,i-1,k);
            sq(a,i+1,t,k);

        }
        return a[k-1];
    }

    public static void main(String[] args) {
        int a[]={4,7,2,3,5,1,10,8,6};
        int sq = sq(a, 0, a.length - 1, 3);
        System.out.println(sq);

    }
}
