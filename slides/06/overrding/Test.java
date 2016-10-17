/**
 * Created by txs on 2016/10/17.
 */
public class Test extends Object{

    public static void main(String argv[]){

        Student s1 = new Student();
        s1.name = "lisi";
        s1.grade = 4;

        Student s2 = new Student();
        s2.name = "lisi";
        s2.grade = 4;

        if(s1.equals(s2)){
            System.out.println("same");
        }
        else
        {
            System.out.println("not same");
        }
        System.out.println(s1);
    }
}
