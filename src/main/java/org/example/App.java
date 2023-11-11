package org.example;

import org.example.service.impl.HangManServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HangManServiceImpl hangManService = new HangManServiceImpl();
        hangManService.demanderJouer();
    }
}
