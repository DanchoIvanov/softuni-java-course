import java.util.Scanner;

class GetFibonacci {

    static int fib(int n)
    {
        if (n <= 1)
            return n;

        return fib(n - 1)
                + fib(n - 2);
    }

    public static void
    main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int result = fib(n);
        System.out.println(result);
        }
    }

