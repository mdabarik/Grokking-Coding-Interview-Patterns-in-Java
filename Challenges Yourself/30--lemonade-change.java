/*
https://leetcode.com/problems/lemonade-change/description/
*/


class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[2];
        for (int bill : bills) {
            if (bill == 5) {
                money[0]++;
            }
            if (bill == 10) {
                if (money[0] > 0) {
                    money[1]++;
                    money[0]--;
                } else {
                    return false;
                }
            }
            if (bill == 20) {
                if (money[1] > 0 && money[0] > 0) {
                    money[0]--;
                    money[1]--;
                } else if (money[0] >= 3) {
                    money[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}




class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill: bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}