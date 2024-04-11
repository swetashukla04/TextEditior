import java.util.Scanner;

import notepad.Notepad;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Text Editor");

        Scanner scan = new Scanner(System.in);

        Notepad notepad = new Notepad(5);

        do {
            System.out.println("Choose your option");
            System.out.println("1. Display the test");
            System.out.println("2. Display the text from the given lines");
            System.out.println("3. Insert the text");
            System.out.println("4. Delete the text");
            System.out.println("5. Delete from the given lines");
            System.out.println("6. copy the text");
            System.out.println("7. Paste the text");
            System.out.println("8. undo the action");
            System.out.println("9. redo the action");
            System.out.println("10. exit");

            System.out.println("Enter the choice");
            int choice = scan.nextInt();
            int lineNumber, startline, endline;
            switch (choice) {
                case 1:
                    notepad.display();
                    break;
                case 2:
                    System.out.println("enter the startline line and the endline line values: ");
                    startline = scan.nextInt();
                    endline = scan.nextInt();
                    notepad.display(startline, endline);
                    break;
                case 3:
                    System.out.println("Enter the text: ");
                    String text = scan.next();
                    System.out.println("Enter the line number");
                    lineNumber = scan.nextInt();
                    notepad.insertLine(lineNumber, text);
                    break;
                case 4:
                    System.out.println("Enter the line number");
                    lineNumber = scan.nextInt();
                    notepad.delete(lineNumber);
                    break;
                case 5:
                    System.out.println("enter the startline line and the endline line values: ");
                    startline = scan.nextInt();
                    endline = scan.nextInt();
                    notepad.delete(startline, endline);
                    break;

                case 6:
                    System.out.println("enter the startline line and the endline line values: ");
                    startline = scan.nextInt();
                    endline = scan.nextInt();
                    notepad.copy(startline, endline);
                    break;

                case 7:
                    System.out.println("Enter the line number");
                    lineNumber = scan.nextInt();
                    notepad.paste(lineNumber);
                    break;
                case 8:
                    notepad.undo();
                    break;
                case 9:
                    notepad.redo();
                    break;
                case 10:
                    System.exit(0);

                    break;
                default:
                    System.out.println("Invalid choice");

            }

        } while (true);
    }
}
