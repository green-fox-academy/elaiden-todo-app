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

    String stringNumber;
    if (args.length == 0) {
      System.out.println("\nCommand Line Todo application");
      System.out.println("=============================\n");
      System.out.println("Command line arguments:");
      System.out.println("    -l   Lists all the tasks");
      System.out.println("    -a   Adds a new task");
      System.out.println("    -r   Removes an task");
      System.out.println("    -c   Completes an task");
    } else if (args[0].equals("-l")) {
      System.out.println();
      todos.listTasks();
    } else if (args[0].equals("-a") && args.length == 1) {
      System.out.println("\nUnable to add: no task provided");
    } else if (args[0].equals("-a") && !args[1].isEmpty()) {
      todos.add(args[1]);
    } else if (args[0].equals("-r") && args.length == 1) {
      System.out.println("\nUnable to remove: no index provided");
    } else if (args[0].equals("-r") && !args[1].isEmpty()) {
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
  }
}
