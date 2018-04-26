import java.util.Scanner;
public class DialMap2Chap9Quiz7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        s = s.toUpperCase();
        int len = s.length();
        for(int i =0; i<len; i++){
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch)){
                if(ch<='O')
                    System.out.print((ch-'A')/3 + 2);
                else if(ch<='S')
                    System.out.print('7');
                else if(ch<='V')
                    System.out.print('8');
                else
                    System.out.print('9');
            }
            else{
                System.out.print(ch);
            }
        }
    }
}