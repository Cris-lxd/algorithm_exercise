package competiton;

/**
 * competiton
 * Date： 2021/10/31 9:06 上午
 * User： cris
 * Description： 小Y同学是ap剑圣时期就入坑lol的玩家，同时他也喜欢看lpl。  但是最近的他看比赛发生了一件奇怪的事情，某位著名解说总能把比分说对，但是胜负说反，在完成了上次五杀的预测之后，这次这位解说又在季后赛大放异彩，完成不少著作《死局》《止步于此》《打野小优》。据他在评论区的观察，这位解说开始了他的登神长阶。  假设该解说在第 0 0分钟位于第 0 0阶梯，第 1 , 2 , 3 1,2,3分钟时位于第 1 1阶梯，之后每一分钟处在的阶梯都是前三分钟的阶梯数之和，如第 4 4分钟位于第 3 3阶梯，第 5 5分钟位于第 5 5阶梯，第 6 6分钟位于第 9 9阶梯，注意他只会在整数分钟才会登上更高的阶梯，比如当他在 3.5 3.5分钟时，他仍位于第 1 1阶梯。小Y同学想知道该解说在第 x x秒时的神力如何，所以请你告诉他第 x x秒时该解说位于哪一级阶梯，为了防止他的神力过大，输出的答案对于 425 425
 **/
class dscj {
    public static int getStep(int x){
        if(x == 0) return 0;
        if(x == 1) return 1;
        if(x == 2) return 1;
        if(x == 3) return 1;
        int res =  getStep(x-1) + getStep(x-2) + getStep(x-3);
        return res%425;
    }

    public static void main(String[] args) {
        int step = getStep(5)%425;
        System.out.println(step);
    }
}
