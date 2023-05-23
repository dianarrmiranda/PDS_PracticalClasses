package lab11.Ex5;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class SizeCalculator extends SimpleFileVisitor<Path> {
    private long totalSize;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        totalSize += attrs.size();
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println("Falha ao visitar o arquivo: " + file);
        return FileVisitResult.CONTINUE;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Uso: java SizeCalculator [-r] diretório");
            return;
        }

        boolean recursive = false;
        Path rootDir;

        if (args[0].equals("-r")) {
            if (args.length < 2) {
                System.out.println("Uso: java SizeCalculator [-r] diretório");
                return;
            }
            recursive = true;
            rootDir = Paths.get(args[1]);
        } else {
            rootDir = Paths.get(args[0]);
        }

        SizeCalculator calculator = new SizeCalculator();
        if (recursive) {
            Files.walkFileTree(rootDir, calculator);
        } else {
            Files.walkFileTree(rootDir, calculator);
        }

        System.out.println("Total: " + calculator.getTotalSize() + " bytes");
    }
}
