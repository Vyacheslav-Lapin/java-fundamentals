package com.epam.courses.java.fundamentals.io.practice.task4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DeserializeFilm {
  public static void main(String[] args) throws IOException, ClassCastException, ClassNotFoundException {
    try(FileInputStream fileInputStream = new FileInputStream("actors.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
      List<Film> filmList = (List<Film>)objectInputStream.readObject();
    } catch (ClassNotFoundException e){
      System.out.println("Can't find a class");
      e.printStackTrace();
    } catch (ClassCastException e){
      System.out.println("Can't cast class");
      e.printStackTrace();
    } catch (IOException e){
      System.out.println("Can't find a file");
      e.printStackTrace();
    }
  }
}
