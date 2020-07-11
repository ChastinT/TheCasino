package com.codedifferently.casino.Games;

import java.util.InputMismatchException;
import java.util.Scanner;

//Class that uses a scan to catch errors, use the names of scan methods that we'll use
public class ScanCatcher 
{
     Scanner scan = new Scanner(System.in);

    public ScanCatcher()
    {

    }

    public int nextInt() 
    {
        int result = 0;
        boolean notValid = false;
        while(!notValid)
    {
        scan = new Scanner(System.in);
        try
        {
            if (scan.hasNextInt())
            {
                result = scan.nextInt();
            }
            notValid = true;

        }
        catch (InputMismatchException e) 
       { 
            System.out.println("This is not an int, try again");
            scan.nextLine();

           
       }
    }
       return result;
     
    }

    public String next()//Universal
    {
       return scan.next();
    }

    public void close()
    {
        scan.close();
    }

    public String nextLine()//Universal
    {
       return scan.nextLine();
    }

    public double nextDouble() 
    {
        double result = 0;
        boolean notValid = false;
        while(!notValid)
    {
        scan = new Scanner(System.in);
        try
        {
            if (scan.hasNextDouble())
            {
                result = scan.nextDouble();
            }
            notValid = true;

        }
        catch (InputMismatchException e) 
       { 
            System.out.println("This is not a double, try again");
            scan.nextLine();

           
       }
    }
       return result;
     
    }
    
}