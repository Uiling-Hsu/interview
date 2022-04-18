import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChange {
    Map<Integer, List<Integer>> memo = new HashMap();

    public List<Integer> coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return null;
        }
        List<Integer> result = change(coins, amount);

        if (result == null) {
            return null;
        }
        return result;
    }

    public List<Integer> change(int[] coins, int amount) {
        if (memo.get(amount) != null) {
            if (memo.get(amount).size() == 0) {
                return null;
            } else {
                return new ArrayList(memo.get(amount));
            }
        }
        List<Integer> currentMin = null;
        int coin = 0;
        for (int c : coins) {
            int remain = amount - c;
            if (remain == 0) {
                currentMin = new ArrayList();
                currentMin.add(c);
                return currentMin;
            }
            if (remain > 0) {
                List<Integer> result = change(coins, remain);
                if (currentMin == null) {
                    currentMin = result;
                    coin = c;
                }
                if (currentMin != null && result != null && result.size() < currentMin.size()) {
                    currentMin = result;
                    coin = c;
                }
            }
        }
        if (currentMin == null) {
            memo.put(amount, new ArrayList());
            return null;
        }
        currentMin.add(coin);
        memo.put(amount, new ArrayList(currentMin));
        return currentMin;

    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        List<Integer> result = coinChange.change(new int[]{186,419,83,408}, 6249);
        System.out.println(result.toString());
    }
}
