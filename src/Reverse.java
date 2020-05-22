/**
 * 2020年5月22日 14:36:25
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int reverse2(int x) {
        String str = String.valueOf(x);
        boolean neg = false;
        if (str.startsWith("-")) {
            neg = true;
            str = str.substring(1);
        }
        StringBuilder sb = new StringBuilder(str).reverse();
        Integer rev = 0;
        try {
            rev = Integer.valueOf(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        if (neg) return rev * -1;
        else return rev;
    }


    public static void main(String args[]) {
        long startTime = System.currentTimeMillis(); //获取开始时间

        Reverse d = new Reverse();
        int a = d.reverse2(-255600000);
        System.out.println(a);

        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间


    }
}
