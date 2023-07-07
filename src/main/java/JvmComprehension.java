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
1 - загрузчик классов для JvmComprehension, int, создаётся фрейм main в стеке, а в нем int i = 1. В метаспейс -
JvmComprehension.class.
2 - загрузчик классов для Object, в куче - Object, в фрейме main obj.
3 - загрузчик классов для Integer, в куче - Integer, в фрейме main Integer ii = 2.
4 - создаётся фрейм в стеке printAll. В этом фрейме появляются Object o, int i, Integer ii.
5 - в фрейме printAll  Integer uselessVar = 700.
6 - Создастся новый фрейм в стеке, куда передадим ссылку на o, i, i1. Сборщик мусора для uselessVar.
7 - Создастся новый фрейм в стеке. Сборщик мусора для o, i, i1.
 */