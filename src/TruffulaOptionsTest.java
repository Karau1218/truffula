import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class TruffulaOptionsTest {

  @Test
  void testValidDirectoryIsSet(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir(); 
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", "-h", directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertTrue(options.isShowHidden());
    assertFalse(options.isUseColor());
  }
  @Test
public void test2_showHiddenFlag() throws Exception {
    File tempDir = new File("testDir2");
    tempDir.mkdir();

    String[] args = { "-h", "testDir2" };

    TruffulaOptions options = new TruffulaOptions(args);

    assertTrue(options.isShowHidden());
    assertTrue(options.isUseColor());

    tempDir.delete();
}
@Test
public void test222_missingPath() {
    String[] args = { "-h" };

    assertThrows(IllegalArgumentException.class, () -> {
        new TruffulaOptions(args);
    });
}
@Test
public void test2_bothFlags_anyOrder() throws Exception {
    File tempDir = new File("testDir4");
    tempDir.mkdir();

    String[] args = { "-nc", "-h", "testDir4" };

    TruffulaOptions options = new TruffulaOptions(args);

    assertTrue(options.isShowHidden());
    assertFalse(options.isUseColor());

    tempDir.delete();
}
@Test
public void test2_unknownFlag() {
    String[] args = { "-x", "someDir" };

    assertThrows(IllegalArgumentException.class, () -> {
        new TruffulaOptions(args);
    });
}
@Test
public void test2_directoryDoesNotExist() {
    String[] args = { "fakeDir12345" };

    assertThrows(Exception.class, () -> {
        new TruffulaOptions(args);
    });
}
@Test
public void test2_pathIsFile() throws Exception {
    File tempFile = new File("tempFile.txt");
    tempFile.createNewFile();

    String[] args = { "tempFile.txt" };

    assertThrows(Exception.class, () -> {
        new TruffulaOptions(args);
    });

    tempFile.delete();
}
}
