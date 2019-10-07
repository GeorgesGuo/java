package com.guo;

public class o {
    public static void main(String[] args) {
    }
    public int StrToInt(String str) {
        if(str.equals(""))
            return 0;
        char[] s = str.toCharArray();
        long res = 0;
        boolean flag = true;
        int i = 0;
        if(s[0] == '-'){
            flag = false;
            i++;
        }
        if(s[0] == '+'){
            flag = true;
            i++;
        }
        for(i = i;i < s.length; ++i){

            if(s[i]>'0' && s[i]<'9'){
                res*=10;
                res+=(s[i]-'0');
            }else
                return 0;
        }
        if(flag == true)
            return (int)res;
        else
            return (0-(int)res);
    }
}
