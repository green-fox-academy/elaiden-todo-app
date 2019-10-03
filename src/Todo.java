import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Todo {

  public static void main(String[] args) {

    TaskList todos = new TaskList();

    try {
      Path taskFilePath = Paths.get("C:\\Users\\Gabby\\greenfox\\elaiden-todo-app\\src\\tasks.txt");
      List<String> tasksFromList = Files.readAllLines(taskFilePath);
      for (int i = 0; i < tasksFromList.size(); i++) {
        todos.add(tasksFromList.get(i));
      }
    } catch (IOException e) {
      System.out.println("Can't find tasks.txt");
    }

    if (args.length == 0) {
      todos.info();
    } else {
      switch (args[0]) {
        case "-l":
          System.out.println();
          todos.listTasks();
          break;
        case "-a":
          if (args.length == 1) {
            System.out.println("\nUnable to add: no task provided");
          } else {
            todos.add(args[1]);
          }
          break;
        case "-r":
          if (args.length == 1) {
            System.out.println("\nUnable to remove: no index provided");
          } else {
            try {
              if ((Integer.parseInt(args[1]) > todos.size()) || (Integer.parseInt(args[1]) <= 0)) {
                System.out.println("\nUnable to remove: index is out of bound");
              } else {
                todos.remove(Integer.parseInt(args[1]));
              }
            } catch (NumberFormatException n) {
              System.out.println("\nUnable to remove: index is not a number");
            }
          }
          break;
        default:
          System.out.println("\nUnsupported argument");
          todos.info();
      }
    }
  }
}
