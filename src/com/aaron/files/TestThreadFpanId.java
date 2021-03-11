package com.aaron.files;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * 多线程读文件
 * 
 * @author Aaron
 * @date 2017年12月6日
 * @version 1.0
 * @package_type com.aaron.files.TestThreadFpanId
 */
public class TestThreadFpanId {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        long startTime = System.currentTimeMillis();
        String fpandIds = "D:\\file\\fpanId.txt";
        ArrayList<String> list = getFpanIds(fpandIds);
        final String sourceDir = "D:\\file\\fpanSplit\\";
        final String targetDir = "D:\\file\\fpanSplit\\result\\";

        final int thNum = 10;
        final String filePath1 = "TBL_AMTSM_FPAN_REL00.txt"; //
        final String filePath2 = "TBL_AMTSM_FPAN_REL01.txt"; //
        final String filePath3 = "TBL_AMTSM_FPAN_REL02.txt"; //
        final String filePath4 = "TBL_AMTSM_FPAN_REL03.txt"; //
        final String filePath5 = "TBL_AMTSM_FPAN_REL04.txt"; //
        final String filePath6 = "TBL_AMTSM_FPAN_REL05.txt"; //
        final String filePath7 = "TBL_AMTSM_FPAN_REL06.txt"; //
        final String filePath8 = "TBL_AMTSM_FPAN_REL07.txt"; //
        final String filePath9 = "TBL_AMTSM_FPAN_REL08.txt"; //
        final String filePath10 = "TBL_AMTSM_FPAN_REL09.txt"; //
        CountDownLatch doneSignal = new CountDownLatch(thNum);
        ReadFileThread2 r1 = new ReadFileThread2(doneSignal, filePath1, sourceDir, targetDir, list);
        ReadFileThread2 r2 = new ReadFileThread2(doneSignal, filePath2, sourceDir, targetDir, list);
        ReadFileThread2 r3 = new ReadFileThread2(doneSignal, filePath3, sourceDir, targetDir, list);
        ReadFileThread2 r4 = new ReadFileThread2(doneSignal, filePath4, sourceDir, targetDir, list);
        ReadFileThread2 r5 = new ReadFileThread2(doneSignal, filePath5, sourceDir, targetDir, list);

        ReadFileThread2 r6 = new ReadFileThread2(doneSignal, filePath6, sourceDir, targetDir, list);
        ReadFileThread2 r7 = new ReadFileThread2(doneSignal, filePath7, sourceDir, targetDir, list);
        ReadFileThread2 r8 = new ReadFileThread2(doneSignal, filePath8, sourceDir, targetDir, list);
        ReadFileThread2 r9 = new ReadFileThread2(doneSignal, filePath9, sourceDir, targetDir, list);
        ReadFileThread2 r10 = new ReadFileThread2(doneSignal, filePath10, sourceDir, targetDir, list);

        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();
        r6.start();
        r7.start();
        r8.start();
        r9.start();
        r10.start();
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("===============================");
        System.out.println("The totally executed time: " + (endTime - startTime));
    }

    public static ArrayList<String> getFpanIds(String path) throws IOException {
        BufferedReader readerFpandIds = new BufferedReader(new FileReader(new File(path)));
        String temp = null;
        ArrayList<String> list = new ArrayList<String>();
        while ((temp = readerFpandIds.readLine()) != null) {
            list.add(temp);
        }
        readerFpandIds.close();
        return list;
    }

}

class ReadFileThread2 extends Thread {
    private CountDownLatch doneSignal;
    private String path;
    private String sourceDir;// = "D:\\file\\test\\";
    private String targetDir;// = "D:\\file\\test\\result\\";
    private ArrayList<String> list;

    public ReadFileThread2(CountDownLatch doneSignal, String path) {
        this.doneSignal = doneSignal;
        this.path = path;
    }

    public ReadFileThread2(CountDownLatch doneSignal, String path, String sourceDir, String targetDir,
        ArrayList<String> list) {
        super();
        this.doneSignal = doneSignal;
        this.path = path;
        this.sourceDir = sourceDir;
        this.targetDir = targetDir;
        this.list = list;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(sourceDir + path)));
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(targetDir + path), true));
            String temp = null;
            int line = 0;
            while ((temp = reader.readLine()) != null) {
                String[] temps = temp.split("=");
                String fpanId = temps[1];
                if (list.contains(fpanId)) {
                    writer.write(temp);
                    writer.newLine();
                    writer.flush();
                    line++;
                }

            }
            System.out.print("Line" + line + "---->");
            reader.close();
            writer.close();
            doneSignal.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(getName() + " " + path + " total Time(ms): " + (end - start));
    }
}