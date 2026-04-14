import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ColorPrinterTest {

  @Test
  void testPrintlnWithRedColorAndReset() {
    // Arrange: Capture the printed output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.RED);

    // Act: Print the message
    String message = "I speak for the trees";
    printer.println(message);


    String expectedOutput = ConsoleColor.RED + "I speak for the trees" + System.lineSeparator() + ConsoleColor.RESET;

    // Assert: Verify the printed output
    assertEquals(expectedOutput, outputStream.toString());
  }
  @Test
public void test_colorApplied() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(outContent);

    ColorPrinter printer = new ColorPrinter(ps);
    printer.setCurrentColor(ConsoleColor.RED);

    printer.print("Test", true);

    String output = outContent.toString();

    assertTrue(output.contains(ConsoleColor.RED.toString()));
}
@Test
public void test_noReset() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(outContent);

    ColorPrinter printer = new ColorPrinter(ps);
    printer.setCurrentColor(ConsoleColor.BLUE);

    printer.print("NoReset", false);

    String output = outContent.toString();

    assertFalse(output.contains(ConsoleColor.RESET.toString()));
}
@Test
public void test_printlnAddsNewLine() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(outContent);

    ColorPrinter printer = new ColorPrinter(ps);

    printer.println("Line");

    String output = outContent.toString();

    assertTrue(output.contains(System.lineSeparator()));
}
@Test
public void test111_basicPrint() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(outContent);

    ColorPrinter printer = new ColorPrinter(ps);
    printer.setCurrentColor(ConsoleColor.WHITE);

    printer.print("Hello", true);

    String output = outContent.toString();

    assertTrue(output.contains("Hello"));
}
}
