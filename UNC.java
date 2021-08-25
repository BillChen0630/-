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
        String[] DanWei = {"点"," ","拾","佰","仟","万","拾","百","千","亿","拾","百","千","兆"};
        int LON = this.Num.length() - 3;
        //System.out.println(LON);
        int[] Shuzi;
        //长度为Shuzi数组的维数
        Shuzi = new int[LON+3];
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
        int c = LON;
        //设定一个局部变量保存翻译的东西
        double djbbl;
        int jbbl;
        //设置是否显示零的boolean变量
        boolean dui = true;
        for(int j = LON ; j>0 ; j--){
            djbbl = num / TiQu;
            jbbl = (int)djbbl;
            Shuzi[c] = jbbl;
            if(jbbl == 0){
                if(Shuzi[c+1] == 0 || c%4 == 1){
                    dui = false;
                }
            }else{dui = true;}
            if(dui){
            OutArr[a] = Translate[jbbl];
            a ++;
            }
            if(jbbl != 0 || c%4 == 1){
            OutArr[a] = DanWei[b];
            a ++;
            }
            b--;
            if(TiQu != 1){
            num -= TiQu * jbbl;}else{num -= jbbl ;}
            TiQu /= 10;
            c--;
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