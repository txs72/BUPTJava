/**
 * Created by txs on 2016/10/17.
 */
public class Student {
    String name;
    int grade;

    @Override
    public String toString() {
        String temp = "";
        temp += "name: " + name + "\n";
        temp += "grade: " + grade + "\n";
        return temp;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        boolean r = false;
        if(obj instanceof Student){
            Student temp = (Student)obj;
            if(this.name.equals(temp.name)
                    && this.grade == temp.grade)
                r = true;
        }
        return r;
    }
}
