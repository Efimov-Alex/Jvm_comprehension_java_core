public class JvmComprehension {

    public static void main(String[] args) {
        int i = 1;                      // 1
        Object o = new Object();        // 2
        Integer ii = 2;                 // 3
        printAll(o, i, ii);             // 4
        System.out.println("finished"); // 7
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5
        System.out.println(o.toString() + i + ii);  // 6
    }
}
/*
Сначала создаётся фрейм main в Stack Memory
1 - в фрейме main int i = 1. В Metaspace - JvmComprehension.class.
2 - в Heap - Object, в фрейме main o.
3 - в Heap - Integer, в фрейме main Integer ii = 2.
4 - создаётся фрейм в Stack Memory printAll. В этом фрейме появляются Object o, int i, Integer ii.
5 - в фрейме printAll  Integer uselessVar = 700.
6 - Создастся новый фрейм в Stack Memory, куда передадим ссылку на o, i, i1. Сборщик мусора для uselessVar.
7 - Создастся новый фрейм в Stack Memory.
 */