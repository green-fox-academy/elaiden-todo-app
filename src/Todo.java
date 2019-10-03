public class Todo {

  public static void main(String[] args) {

    TaskList todos = new TaskList();
    todos.add("Walk the dog");
    todos.add("Buy milk");
    todos.add("Do homework");

    if (args.length == 0) {
      System.out.println();
      System.out.println("Command Line Todo application");
      System.out.println("=============================");
      System.out.println();
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
    }
  }
}
