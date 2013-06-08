package org.ddocumentor.system;

import com.google.common.collect.Lists;
import org.ddocumentor.source.JavaSource;
import org.ddocumentor.source.JavaSourceRepository;

import static java.nio.file.FileVisitResult.*;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class FileJavaSourceRepository implements JavaSourceRepository {
    private final Path filePath;


    public FileJavaSourceRepository(Path tests) {
        this.filePath = tests;
    }

    @Override
    public List<JavaSource> getJavaSources() {

        List<JavaSource> javaSources = Lists.newArrayList();

        class GatherFiles
                extends SimpleFileVisitor<Path> {

            // Print information about
            // each type of file.
            @Override
            public FileVisitResult visitFile(Path file,
                                             BasicFileAttributes attr) {
                if (attr.isRegularFile()) {
                    System.out.format("Regular file: %s ", file);
                }
                return CONTINUE;
            }
        }
        try {
            Files.walkFileTree(filePath, new GatherFiles());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return javaSources;
    }


}
