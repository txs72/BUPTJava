import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("MyInteger类相关测试")
public class MyIntegerTest {
    int even[] = {
            2, 4, 6, 8, 20, 32, 46, 108, 200, 1004
    };
    int odd[] = {
            1, 3, 5, 7, 31, 47, 69, 77, 107, 309
    };
    int prime[] = {
            2, 3, 5, 7, 11, 373, 1103, 1721, 3491, 9619
    };

    MyInteger miEven[];
    MyInteger miOdd[];
    MyInteger miPrime[];

    char[] c;
    @BeforeEach
    void initAll() {
        miEven = new MyInteger[even.length];
        for (int i = 0; i < miEven.length; i++) {
            miEven[i] = new MyInteger(even[i]);
        }
        miOdd = new MyInteger[odd.length];
        for (int i = 0; i < miOdd.length; i++) {
            miOdd[i] = new MyInteger(odd[i]);
        }
        miPrime = new MyInteger[prime.length];
        for (int i = 0; i < miPrime.length; i++) {
            miPrime[i] = new MyInteger(prime[i]);
        }
    }

    @Test
    @DisplayName("测试isEven()普通成员函数")
    void testIsEvenVoid() {
        for (MyInteger mi : miEven) {
            assertTrue(mi.isEven());
        }
    }

    @Test
    @DisplayName("测试isOdd()普通成员函数")
    void testIsOddVoid() {
        for (MyInteger mi : miOdd) {
            assertTrue(mi.isOdd());
        }
    }

    @Test
    @DisplayName("测试isPrime()普通成员函数")
    void testIsPrimeVoid() {
        for (MyInteger mi : miPrime) {
            assertTrue(mi.isPrime());
        }
    }

    // 测试静态方法isEven(int), isOdd(int), isPrime(int)
    @Test
    @DisplayName("测试isEven(int)静态成员函数")
    void testIsEvenInt() {
        for (int e : even) {
            assertTrue(MyInteger.isEven(e));
        }
    }

    @Test
    @DisplayName("测试isOdd(int)静态成员函数")
    void testIsOddInt() {
        for (int o : odd) {
            assertTrue(MyInteger.isOdd(o));
        }
    }

    @Test
    @DisplayName("测试isPrime(int)静态成员函数")
    void testIsPrimeInt() {
        for (int p : prime) {
            assertTrue(MyInteger.isPrime(p));
        }
    }

    // 测试静态方法IsEven(MyInteger), isOdd(MyInteger), isPrime(MyInteger)
    @Test
    @DisplayName("测试isEven(MyInteger)静态成员函数")
    void testIsEvenMI(){
        for(MyInteger mi: miEven){
            assertTrue(MyInteger.isEven(mi));
        }
    }

    @Test
    @DisplayName("测试isOdd(MyInteger)静态成员函数")
    void testIsOddMI(){
        for(MyInteger mi: miOdd){
            assertTrue(MyInteger.isOdd(mi));
        }
    }

    @Test
    @DisplayName("测试isPrime(MyInteger)静态成员函数")
    void testIsPrimeMI(){
        for(MyInteger mi: miPrime){
            assertTrue(MyInteger.isPrime(mi));
        }
    }

    // 测试equals函数的各个版本
    @Test
    @DisplayName("测试equals函数的各个版本")
    void testEquals(){
        assertTrue(new MyInteger(10).equals(10));
        assertTrue(new MyInteger(20).equals(new MyInteger(20)));
    }

    // 测试parseInt函数的各个版本
    @Test
    @DisplayName("测试parseInt静态成员函数的各个版本")
    void testParseInt(){
        assertEquals(23464, MyInteger.parseInt("23464"));
        assertEquals(2732923, MyInteger.parseInt(new String("2732923")));
        c = new char[8];
        for(int i=0; i<c.length; i++){
            c[i] = (char)(i + '1');
        }
        // c = "12345"
        assertEquals(12345678, MyInteger.parseInt(c));
    }
}
