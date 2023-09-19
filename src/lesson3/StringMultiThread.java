package lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//btvn: 4 cách xóa 1 phần tử trong vòng lặp

// xóa thế nào để cho ra lỗi

// Xóa phần tử
// xóa index
// xóa key

//btvn: viết chương trình dùng spring boot để đọc lưu dữ liệu từ database

public class StringMultiThread {
    static int num = 10;
    static int loop = 100_000;
    static String str = "1234567890";

    static int expected = num*loop*str.length();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
        testStringBuilder();
    }
    public static void testStringBuilder() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(num);
        long start = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        List<Future<StringBuffer>> futures = new ArrayList<>();

        for (int i = 0; i < num; i++){
            System.out.println("testBuffer " + i);
            futures.add(executorService.submit(() -> {
                try {
                    for (int j = 0; j < loop; j++) {
                        stringBuffer.append(str);
                    }
                }catch (Exception e){
                    System.out.println(e.toString());
                }
                return stringBuffer;
            }));
        }
        System.out.println((System.currentTimeMillis() - start) + "ms");
        for (Future<StringBuffer> item : futures) {
            item.get();
        }
        System.out.println(stringBuffer.length() + "|" + (System.currentTimeMillis()));
    }
}
