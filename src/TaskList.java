import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskList {

  private ArrayList<String> tasks;

  public TaskList() {
    this.tasks = new ArrayList<>();
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
    this.tasks.add(task);
    try {
      Path taskFilePath = Paths.get("C:\\Users\\Gabby\\greenfox\\elaiden-todo-app\\src\\tasks.txt");
      Files.write(taskFilePath, tasks);
    } catch (IOException e) {
      System.out.println("Couldn't write the tasks file.");
    }
  }
}
