package songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] information = scanner.nextLine().split("_");
            String typeList = information[0];
            String name = information[1];
            String duration = information[2];

            Song song = new Song();
            song.setDuration(duration);
            song.setName(name);
            song.setTypeList(typeList);

            songs.add(song);
        }
        String typeList = scanner.nextLine();

        if (typeList.equals("all")){
            for (Song song : songs){
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs){
                if (typeList.equals(song.getTypeList())){
                    System.out.println(song.getName());
                }
            }
        }
    }
}
