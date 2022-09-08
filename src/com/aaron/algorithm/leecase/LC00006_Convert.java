package com.aaron.algorithm.leecase;

import java.util.ArrayList;
import java.util.List;

/**
 * lc6. Z 字形变换
 * 
 * @author huangbo
 * @date 2021/10/13
 */
public class LC00006_Convert {
    public static void main(String[] args) {
        LC00006_Convert convert = new LC00006_Convert();
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String result = convert.convert(s, numRows);
        System.out.println(result);

    }

    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        System.out.println(rows);
        int curRow = 0;
        boolean goingDown = false;

        // PAYPALISHIRING
        for (char c : s.toCharArray()) {
            System.out.println(curRow + "=" + goingDown + "=" + rows.get(curRow));
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // 先判断goingDown是不是的真假，如果为true则式子为curRow+=1,为false的话式子就为curRow+=-1
            curRow += goingDown ? 1 : -1;
        }
        System.out.println(rows);
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

}
