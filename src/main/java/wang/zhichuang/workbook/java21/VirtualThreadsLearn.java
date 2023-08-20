package wang.zhichuang.workbook.java21;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

// https://openjdk.org/jeps/444
public class VirtualThreadsLearn {
    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10_000).forEach(i -> executor.submit(() -> {
                Thread.sleep(Duration.ofSeconds(1));
                System.out.println("print: " + i);
                return i;
            }));
        }  // executor.close() is called implicitly, and waits
    }
}
