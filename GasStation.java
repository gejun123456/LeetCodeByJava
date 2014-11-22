/**
 * Created by bruce on 14-11-22.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] sub = new int[2 * len - 1];
        for (int i = 0; i < len; i++) {
            sub[i] = gas[i] - cost[i];
        }
        if(len==1&&sub[0]<0) {
            return -1;
        }
        for (int i = 0; i < len - 1; i++) {
            sub[i + len] = gas[i] - cost[i];
        }
        int curMax = 0;
        int max = 0;
        int min = 0;
        for (int i = 0; i < 2 * len - 1; i++) {
            if (curMax > 0) {
                curMax = curMax + sub[i];
            } else {
                curMax = sub[i];
                min = i;
            }
        }
        min = min%len;
        int s = 0;
        for (int i = min; i < min + len-1; i++) {
            s += sub[i];
            if (s < 0) {
                return -1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int a[] = {67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66};
        int b[] = {27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        GasStation ga = new GasStation();
        int result = ga.canCompleteCircuit(a,b);
        System.out.println(result);
    }
}
