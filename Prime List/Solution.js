

class Solution {
    Node primeList(Node head) {
        Node current = head;
        while (current != null) {
            current.val = nearestPrime(current.val);
            current = current.next;
        }
        return head;
    }

    private int nearestPrime(int n) {
        if (n <= 1) return 2;

        int lower = n, upper = n;
        while (lower >= 2 && !isPrime(lower)) lower--;
        while (!isPrime(upper)) upper++;

        if (n - lower <= upper - n) return lower;
        return upper;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        }
        return true;
    }
        
}