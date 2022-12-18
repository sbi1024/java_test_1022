package utilPackage;

import logicPackage.Etc;
import logicPackage.logicClass.LogicClass;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UtilLogic {
    /**
     * ch15/IOEx1
     * 875 Page
     */
    public static void utilLogic1() {
        // 바이트 배열 선언_1 (in)
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 바이트 배열 선언_2 (out)
        byte[] outSrc = null;

        // 바이트 기반 Input Stream 생성
        ByteArrayInputStream input = null;
        // 바이트 기반 Output Stream 생성
        ByteArrayOutputStream output = null;

        // 초기화 작업 진행_1
        input = new ByteArrayInputStream(inSrc);
        // 초기화 작업 진행_2
        output = new ByteArrayOutputStream();

        // input 변수에서 읽어온 데이터를 담을 변수 선언
        int data = 0;

        // while 문을 통해 , input 변수에서 읽어옴 ,
        // 값이 -1인 경우는 더이상 읽어올 데이터가 없다는 뜻 .
        while ((data = input.read()) != -1) {
            // output에 읽어온 데이터를 작성 (write)
            output.write(data);
        }

        // output 변수의 데이터를 , 바이트 배열기반으로 형변환 진행.
        outSrc = output.toByteArray();

        // 값 출력_1 (입력 스트림 값)
        System.out.println("Arrays.toString(inSrc) = " + Arrays.toString(inSrc));
        // 값 출력_2 (출력 스트림 값)
        System.out.println("Arrays.toString(outSrc) = " + Arrays.toString(outSrc));
    }

    /**
     * ch15/IOEx2
     * 876 Page
     */
    public static void utilLogic2() {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[10];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        input.read(temp, 0, temp.length);
        output.write(temp, 5, 5);

        outSrc = output.toByteArray();

        System.out.println("inSrc = " + Arrays.toString(inSrc));
        System.out.println("temp = " + Arrays.toString(temp));
        System.out.println("outSrc = " + Arrays.toString(outSrc));

    }

    /**
     * ch15/IOEx3
     * 877 Page
     */
    public static void utilLogic3() {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        System.out.println("Input Soruce  :" + Arrays.toString(inSrc));

        try {
            while (input.available() > 0) {
                input.read(temp);
                output.write(temp);
                System.out.println("temp : " + Arrays.toString(temp));
                outSrc = output.toByteArray();
                System.out.println("Arrays.toString(temp) = " + Arrays.toString(temp));
                System.out.println("Arrays.toString(outSrc) = " + Arrays.toString(outSrc));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    /**
     * ch15/IOEx4
     * 878 Page
     */
    public static void utilLogic4() {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        try {
            while (input.available() > 0) {
                int len = input.read(temp);
                output.write(temp, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }

        outSrc = output.toByteArray();
        System.out.println("Arrays.toString(outSrc) = " + Arrays.toString(outSrc));
        System.out.println("Arrays.toString(temp) = " + Arrays.toString(temp));
        System.out.println("Arrays.toString(inSrc) = " + Arrays.toString(inSrc));

    }

    /**
     * ch15/IOEx4
     * 884 Page
     */
    public static void utilLogic5() {
        try {
            FileOutputStream fos = new FileOutputStream("123.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
            for (int i = '1'; i <= '9'; i++) {
                bos.write(i);
            }
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    /**
     * ch15-8
     * 887 Page
     */
    public static void utilLogic6() {
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fos = new FileOutputStream("sample.dat");
            dos = new DataOutputStream(fos);

            dos.writeInt(10);
            dos.writeFloat(20.0f);
            dos.writeBoolean(true);

            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public static void utilLogic7() {
        try {
            FileInputStream fis = new FileInputStream("sample.dat");
            DataInputStream dis = new DataInputStream(fis);

            System.out.println("dis.readInt() = " + dis.readInt());
            System.out.println("dis.readInt() = " + dis.readFloat());
            System.out.println("dis.readInt() = " + dis.readBoolean());

            dis.close();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public static void utilLogic8() {
        int[] score = {100, 90, 95, 85, 50};
        try {
            FileOutputStream fos = new FileOutputStream("score.dat");
            DataOutputStream dos = new DataOutputStream(fos);

            for (int i = 0; i < score.length; i++) {
                dos.writeInt(score[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public static void utilLogic9() {
        int sum = 0;
        int score = 0;

        FileInputStream fis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream("score.dat");
            dis = new DataInputStream(fis);

            while (true) {
                score = dis.readInt();
                System.out.println("score = " + score);
                sum += score;
            }
        } catch (Exception e) {
            System.out.println("sum = " + sum);
            e.printStackTrace();
            e.getMessage();
        }

    }

    public static void utilLogic10() {
        int sum = 0;
        int score = 0;

        try (FileInputStream fis = new FileInputStream("score.dat");
             DataInputStream dis = new DataInputStream(fis)) {
            while (true) {
                score = dis.readInt();
                System.out.println("score = " + score);
                sum += score;
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }

        System.out.println("sum = " + sum);
    }

    public static void utilLogic11() {
        byte[] arr1 = {0, 1, 2};
        byte[] arr2 = {3, 4, 5};
        byte[] arr3 = {6, 7, 8};
        byte[] outSrc = null;

        Vector v = new Vector();
        v.add(new ByteArrayInputStream(arr1));
        v.add(new ByteArrayInputStream(arr2));
        v.add(new ByteArrayInputStream(arr3));

        SequenceInputStream input = new SequenceInputStream(v.elements());
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;
        try {
            while ((data = input.read()) != -1) {
                output.write(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }

        outSrc = output.toByteArray();
        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));
        System.out.println("arr3 = " + Arrays.toString(arr3));
        System.out.println("outSrc = " + Arrays.toString(outSrc));
    }

    public static void utilLogic12() {
        try {
            String fileName = "123.txt";
            FileReader fr = new FileReader(fileName);
            int data = 0;
            while ((data = fr.read()) != -1) {
                System.out.println("data = " + data);
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public static void utilLogic13() {
        File f = new File("/Users/seoboin/java/java_test_1022/out/production/java_test_1022/logicPackage");
        String fileName = f.getName();
        int pos = fileName.indexOf(".");

        System.out.println("경로를 제외한 파일 이름 : " + f.getName());

        if (f.isDirectory()) {
            System.out.println("f.getParent() = " + f.getParent());
        }
    }


    public static void utilLogic14() {
        int a = 1;
        int b = 2 ;
        int c = 3;
        int d = 4;

        switch (a){
            case 1 :
                System.out.println("a = " + a);
                break;
            case 2 :
                System.out.println("b = " + b);
                break;
            case 3:
                break;
            default:
                System.out.println("d = " + d);
        }

    }

    public static void utilLogic15(){
        String testStr = "123456789";
        String testDelim = "1329999";
        StringTokenizer st = new StringTokenizer(testStr,testDelim);
        while (st.hasMoreTokens()){
            System.out.println("st = " + st.nextToken());
        }
    }

    public static void utilLogic16(){
        String number = "010-8433-9624가";
        String regex = "^[가-힣]*$";

        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(number);
        boolean matches = matcher.matches();
        System.out.println("matches = " + matches);
    }

    public static void utilLogic17(){
        Etc etc1 = Etc.createEtc();
        etc1.setCity("산본");
        etc1.setName("서보인");
        etc1.setCountry("한국");
        int i1 = etc1.hashCode();
        System.out.println("i1 = " + i1);

        Etc etc2 = Etc.createEtc();
        etc2.setCity("인천");
        etc2.setName("이종현");
        etc2.setCountry("한국");
        int i2 = etc2.hashCode();
        System.out.println("i2 = " + i2);

        Etc etc3 = Etc.createEtc();
        etc3.setCity("안산");
        etc3.setName("유제광");
        etc3.setCountry("한국");

        Etc etc4 = Etc.createEtc();
        etc4.setCity("안산");
        etc4.setName("안진형");
        etc4.setCountry("한국");

        Etc etc5 = Etc.createEtc();
        etc5.setCity("인천");
        etc5.setName("박현규");
        etc5.setCountry("한국");

        List<Etc> resultEtc = new ArrayList<>();
        resultEtc.add(etc1);
        resultEtc.add(etc2);
        resultEtc.add(etc3);
        resultEtc.add(etc4);
        resultEtc.add(etc5);

        Map<String, Map<String, List<Etc>>> collect = resultEtc.stream()
                .collect(Collectors.groupingBy(Etc::getCity,
                Collectors.groupingBy(Etc::getCountry)));



        List<Etc> etcs1 = collect.get("인천").get("한국");
        List<Etc> etcs2 = collect.get("안산").get("한국");
        List<Etc> etcs3 = collect.get("산본").get("한국");

        for(Etc etc : etcs1) System.out.println(etc);
        System.out.println("");
        for(Etc etc : etcs2) System.out.println(etc);
        System.out.println("");
        for(Etc etc : etcs3) System.out.println(etc);

    }

    public void utilLogic18(){
        LogicClass.logic18();
    }

    public void utilLogic19(){
        LogicClass.logic19();
    }
}
