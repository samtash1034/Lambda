package com.sam.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class File {

    public static void main(String[] args) throws IOException {

        Path filePath = Paths.get("c:/temp", "data.txt");

        Stream<String> lines;
        Stream<String> lines2;//重新建一個流，line 這個流用完就會關閉了

        {
            try {
                lines = Files.lines(filePath);
                lines.forEach(System.out::println);// today is monday

                lines2 = Files.lines(filePath);

                List<String> list = lines2.filter(s -> s.contains("today"))
                        .collect(Collectors.toList());
                list.forEach(System.out::println);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // java 7 之前的版本

//        File file = new File("c:/temp/data.txt");
//        FileReader fr = new FileReader(filePath);
//        BufferedReader br = new BufferedReader(fr);
//
//        String line;
//        while((line = br.readLine()) != null)
//        {
//            if(line.contains("password")){
//                System.out.println(line);
//            }
//        }
//        br.close();
//        fr.close();
    }
}
