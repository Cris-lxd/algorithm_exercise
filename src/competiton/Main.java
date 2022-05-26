package competiton;
import java.util.Scanner;
/**
 * competiton
 * Date： 2021/12/12 11:09 上午
 * User： cris
 * Description：
 **/
public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Integer num = sc.nextInt();
//        while(num <200000){
//            String reverse = "";
//            String num1 = num.toString();
//            for (int i = num1.length()-1; i >=0; i--) {
//                reverse += num1.charAt(i);
//            }
//            if((num + Integer.valueOf(reverse) < 200000) && (num + Integer.valueOf(reverse) > 100000)){
//                System.out.println(num);
//                break;
//            }
//            num++;
//        }
//        if(num > 200000) System.out.println("F");
//    }













//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        String[] people = new String[num];
//        for (int i = 0; i < num; i++) {
//            people[i] = sc.next();
//        }
//        int A = 0;
//        int B = 0;
//        for (int i = 0; i < people.length; i++) {
//            boolean b = (people[i].charAt(1) == 'G') || (people[i].charAt(1) != 'G' && people[i].charAt(3) == 'N' && Integer.valueOf(people[i].charAt(4)) < 3);
//            if(people[i].charAt(0) == 'L'){     //local
//                if(people[i].charAt(2) == 'D'){
//                    if(b){
//                        A++;
//                    }
//                }else if(people[i].charAt(2) == 'E'){
//                    if(b){
//                        B++;
//                    }
//                }
//            }else if(people[i].charAt(0) == 'T'){
//                if(people[i].charAt(2) == 'E'){
//                    if(b){
//                        B++;
//                    }
//                }
//            }
//        }
//        System.out.println(A + " " + B);
//    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();      //serial
        int L = scanner.nextInt();      //people
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int[] num = new int[N];
        num[x*y*z] = 5;

        int sum =0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
            continue;
        }
        System.out.println(sum);

    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int[][] circlePoint = new int[N][2];
//        for (int i = 0; i < N; i++) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//            circlePoint[i][0] = x;
//            circlePoint[i][1] = x;
//        }
//    }








































}
