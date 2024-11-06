package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String path = sc.next();

        Map<String, Integer> map = new TreeMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while(line != null){
                String[] vect = line.split(",");
                String name = vect[0];
                int count = Integer.parseInt(vect[1]);

                if(map.containsKey(name)){

                    map.put(name, count + map.get(name));
                }
                else {

                    map.put(name, count);
                }

                line = br.readLine();
            }
        }
        catch (IOException e){

            System.out.println("Erro: "+e.getMessage());

        }


        for (String key: map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }
        sc.close();
    }
}