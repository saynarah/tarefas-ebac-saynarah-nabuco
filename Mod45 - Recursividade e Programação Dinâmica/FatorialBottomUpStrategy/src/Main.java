public class Main {

    private static final int MAX_ELEMENTS = 101;

    public static double fatorial(int n){
        if(n <= 1) return 1;

        double[] dp = new double[MAX_ELEMENTS];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i<= n;i++){
            dp[i] = i * dp[i-1];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 100;
        System.out.println("O fatorial de " + n + " é: " + fatorial(n));
    }
}