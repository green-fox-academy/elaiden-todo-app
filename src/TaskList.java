import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskList {

  private ArrayList<String> tasks;

  public TaskList() {
    tasks = new ArrayList<>();
  }

  public int size() {
    return tasks.size();
  }

  public void remove(int numberOfTask) {
    tasks.remove(numberOfTask - 1);
    try {
      Path taskFilePath = Paths.get("C:\\Users\\Gabby\\greenfox\\elaiden-todo-app\\src\\tasks.txt");
      Files.write(taskFilePath, tasks);
    } catch (IOException e) {
      System.out.println("Can't write the file.");
    }
  }

  public void listTasks() {
    try {
      Path taskFilePath = Paths.get("C:\\Users\\Gabby\\greenfox\\elaiden-todo-app\\src\\tasks.txt");
      List<String> tasks = Files.readAllLines(taskFilePath);
      if (tasks.size() == 0) {
        System.out.println("No todos for today! :)");
      } else {
        for (int i = 0; i < tasks.size(); i++) {
          System.out.println((i + 1) + " - " + tasks.get(i));
        }
      }
    } catch (IOException e) {
      System.out.println("Couldn't read the file.");
    }
  }

  public void add(String task) {
    tasks.add(task);
    try {
      Path taskFilePath = Paths.get("C:\\Users\\Gabby\\greenfox\\elaiden-todo-app\\src\\tasks.txt");
      Files.write(taskFilePath, tasks);
    } catch (IOException e) {
      System.out.println("Couldn't write the tasks file.");
    }
  }
}