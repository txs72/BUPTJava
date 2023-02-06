
public class Student {
    static String school= "BUPT";
    String name;
    int grade;
    float score;
    int temp1;
    int temp2;
    int temp3;

    static void test(){
        school = "Xitucheng Professional Technology School"; // ok
        //this.score = 10; Error, can't access instance variable
    }

    static { // statick initialize block
        school = "BUPT"; // ok
        System.out.println("Now in static init block...");
    }

    { // initialize block
        temp1 = 100;
        temp2 = 200;
        temp3 = 300;
        this.score = 100;
        this.school = "TS";
        System.out.println("Now in init block...");
    }

    public Student(String name, int grade, float score){
        this.name = name;
        this.grade = grade;
        this.score = score;
        System.out.println("Now in ctor..."); // deconstructor -> dtor
    }

    public Student(String name, int grade){
        this(name, grade, 60);
    }

    public Student(String name){
        this(name, 4, 60);
    }

}

