/**
 *
 * 这是一个javadoc的测试例
 *
 * @author Tang Xiaosheng
 * @version 1.0
 *
 *
 * */

public class Hello{
    /** member variable. */
    int member;
    /** main method of Hello class 
     * @param argv[] 命令行参数
     * */
	public static void main(String argv[]){
		System.out.println("hello");
	}
    /**
     * add方法简述
     * <p> 这是一个测试函数 <br>
     * @param a 第一个被加数
     * @param b 第二个被加数
     * @return  a、b的和
     * */
    public int add(int a, int b){
        return a + b;
    } 
    /**
     * @deprecated 这个函数不建议使用，最好使用...
     * @see String
     * @see java.lang.StringBuffer
     * @see #main(String[])
     * @see Object#toString()
     *
     * */
    public void test(){
        System.out.println("I am a test.");
    }

}

