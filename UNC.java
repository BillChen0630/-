import java.util.Scanner;
class NumIn{
    //定义输出数组
    public String[] OutArr;
    //定义输入变量
    static String Num;
    //定义整数位数
    int zheng;
    //输入方法
    public NumIn(){
    Scanner InNum = new Scanner(System.in);
    String num = InNum.next();
    this.Num = num;
    }
    //解析输入的数
    public void PreasNum(){
        //初始化输出数组
        OutArr = new String [100];
        for(int q = 0 ; q<100 ; q++){
            OutArr[q] = " ";
        }
        //定义并初始化翻译数组
        String[] Translate = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        String[] DanWei = {"点"," ","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟","兆","拾","佰","仟","京"};
        int LON = this.Num.length() - 3;
        //System.out.println(LON);
        int[] Shuzi;
        //长度为Shuzi数组的维数
        Shuzi = new int[LON+1];
        //解析String型变量num为int型
        double num = Double.parseDouble(this.Num);
        //定义并初始化分离数字的变量TiQu
        double TiQu = 1;
        if(LON != 1 ){
        for(int i = LON;i>1 ; i-- ){
            TiQu *= 10.00 ;
        }
        }
        //只翻译整数
        //OutArr数组赋值变量
        int a = 0;
        //单位输入变量
        int b = LON;
        //记录次数的变量
        int c = 0;
        //判别是否加单位的变量
        int p = LON;
        //设定一个局部变量保存翻译的东西
        double djbbl;
        int jbbl;
        //设置是否显示零的boolean变量
        boolean dui = true;
        //解析数字
        for(int m = 0 ; m<LON ; m++){
            djbbl = num / TiQu;
            jbbl = (int)djbbl;
            Shuzi[m] = jbbl;
            if(TiQu != 1){
            num -= TiQu * jbbl;
            }else{
            num -= jbbl ;
            }
            TiQu /= 10;
        }
        for(int j = 0; j<LON ; j++){
            if(Shuzi[c] == 0){
                if(Shuzi[c+1] == 0 || b%4 == 1){
                    dui = false;
                }else{dui = true;}
            }else{dui = true;}
            if(dui){
            OutArr[a] = Translate[Shuzi[c]];
            a ++;
            }
            if(Shuzi[c] != 0 || b%4 == 1){
            OutArr[a] = DanWei[b];
            a ++;
            }
            if(Shuzi[0] == 0){
                 OutArr[0] = Translate[0];
            a +=1;
            break;
            }
            if(b%4 == 1 && Shuzi[c] == 0){
                if(Shuzi[c-3]+Shuzi[c-2]+Shuzi[c-1]+Shuzi[c] == 0)
                a--;
            }
            b--;
            c++;
            }
        //计算整数所占位数
        this.zheng = a-1;
        num +=0.001;
        num *= 100;
        int Xnum = (int)num;
        if(Xnum != 0){
        OutArr[this.zheng] = DanWei[0];
        OutArr[this.zheng+1] = Translate[Xnum/10];
        OutArr[this.zheng+2] = Translate[Xnum%10];
        }
    }
}
public class UNC{
    public static void main(String[] args){
        System.out.println("请以xxxx.xx的形式输入\n若为整数请带上.00\n最大支持到兆位");
        NumIn NI = new NumIn();
        NI.PreasNum();
        for(String thing : NI.OutArr){
            System.out.print(thing);
        }
        System.out.println();
    }
}