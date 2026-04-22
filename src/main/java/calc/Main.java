package calc;
import java.io.PrintWriter;
public class Main {

        public static void main(String[] args) {
            // Create a PrintWriter that sends output to the console
            PrintWriter writer = new PrintWriter(System.out);

            writer.println("Hello from PrintWriter!");

            // Essential: PrintWriter buffers data, so you must flush or close it to see output
            writer.flush();
        }
}
