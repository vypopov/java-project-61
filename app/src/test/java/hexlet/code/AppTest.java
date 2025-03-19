package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testApp() {
        // Arrange: Подготовка входных данных
        String input = "Alice\n"; // Имитация ввода имени пользователя
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // Перенаправляем System.in на наш поток

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        App.main(null);

        String expectedOutput = "Welcome to the Brain Games!\n"
                + "May I have your name?\n"
                + "Hello, Alice!\n";
        assertEquals(expectedOutput, out.toString());

        System.setIn(System.in);
        System.setOut(System.out);
    }
}
