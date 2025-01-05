class Solution {
    public int solution(int a, int b, int c) {
        int sum = a + b + c;
        int squareSum = a * a + b * b + c * c;
        int cubeSum = a * a * a + b * b * b + c * c * c;
        
        if (a == b && b == c) {
            // 세 숫자가 모두 같은 경우
            return sum * squareSum * cubeSum;
        } else if (a == b || b == c || a == c) {
            // 두 숫자가 같은 경우
            return sum * squareSum;
        } else {
            // 모든 숫자가 다른 경우
            return sum;
        }
    }
}