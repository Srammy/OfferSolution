//==============================LeetCode 剑指 Offer 43. 1～n 整数中 1 出现的次数==============
//链接：https://blog.csdn.net/u013132035/article/details/80768636
class Solution {
    public int countDigitOne(int n) {
        return numberOf1Between1AndN(n, 1);
    }

    public int numberOf1Between1AndN(int n, int x){
		if(n < 0 || x < 1 || x > 9){
			return 0;
		}
		int curr, low, temp, high = n, i = 1, total = 0;
		while(high!=0){
			high = n / (int)Math.pow(10, i); //获取第i位的高位
			temp = n % (int)Math.pow(10, i); //
			curr = temp / (int)Math.pow(10, i-1); //获取第i位
			low = temp%(int)Math.pow(10, i-1); //获取第i位的低位
			if(curr == x){ //等于x
				total += high*(int)Math.pow(10, i-1)+ low + 1;
			}else if(curr < x){ //小于x
				total += high*(int) Math.pow(10, i-1);
			}else{ //大于x
				total += (high + 1) * (int)Math.pow(10, i-1);
			}
			i++;
		}
		return total;
	}
	
}

//============================剑指offer ==================================
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        return numberOf1Between1AndN(n, 1);
    }
    
    public int numberOf1Between1AndN(int n, int x){
		if(n < 0 || x < 1 || x > 9){
			return 0;
		}
		int curr, low, temp, high = n, i = 1, total = 0;
		while(high!=0){
			high = n / (int)Math.pow(10, i); //获取第i位的高位
			temp = n % (int)Math.pow(10, i); //
			curr = temp / (int)Math.pow(10, i-1); //获取第i位
			low = temp%(int)Math.pow(10, i-1); //获取第i位的低位
			if(curr == x){ //等于x
				total += high*(int)Math.pow(10, i-1)+ low + 1;
			}else if(curr < x){ //小于x
				total += high*(int) Math.pow(10, i-1);
			}else{ //大于x
				total += (high + 1) * (int)Math.pow(10, i-1);
			}
			i++;
		}
		return total;
	}
}