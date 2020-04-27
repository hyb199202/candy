package com.candymanage.candy.service.test;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.img.Img;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.swing.clipboard.ClipboardUtil;
import cn.hutool.core.text.StrSpliter;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.*;
import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.candymanage.candy.bean.province.City;
import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.json.JSONArray;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StringUtils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.io.OutputStream;
import java.sql.Array;
import java.sql.Struct;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @Author hyb
 * @Description candy
 * @Date 2019/09/21 23:29
 * @Dec
 */
public class DataTest {

   /* public static void main(String[] args) {
        String object = "0~success~0~3~4467500~5312400~46165031~5037811一计75兆~503841199计278兆~4491100~46165114G上网流量30元可选包（2014版）~53122110兆~5312311500兆~4616511新飞享58套餐（2018版）内含国内流量~53122110兆~5312311一计~4616511新飞享58套餐（2018版）赠送国内流量~5312211一计75兆~5312311949兆~4616511大流量40元包（2018版）~53122110兆~531231195计376兆~4616511上月结转流量 国内移动数据流量~53122110兆~5312311一计500兆~46165032~4616511新飞享58套餐（2018版） 国内通话~5312003300~4465800~53121030~4465800~46165033~4616511短信6元套餐（09版） 短信累计~53120038~4465900~531210380~4465900~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        String[] split = object.split("~");

        StringBuilder resutlVoice = new StringBuilder();
        StringBuilder tempName = new StringBuilder();
        String tempVoice1 = "";
        String tempVoice2 = "";
        String tempVoice3 = "";
        String tempVoice4 = "";
        String tempVoice5 = "";
        String tempVoice6 = "";

        if ("4467500".equals(split[4])) {
            tempVoice1 = split[4].replace("4467500", "您好");
        }
        if ("5312400".equals(split[5])) {
            tempVoice2 = split[5].replace("5312400", "您各项套餐当前消费情况如下");
        }
        if (split[7].contains("5037811")) {
            String substring = split[7].substring(7);
            tempVoice3 = "您已使用的移动数据总流量为" + substring;
        }
        if (split[8].contains("5038411")) {
            String substring = split[8].substring(7);
            tempVoice4 = "剩余的总流量为" + substring;
        }
        if ("4491100".equals(split[9])) {
            tempVoice6 = split[9].replace("4491100", "其中");
        }

        for (int i = 10; i < split.length; i++) {
            if (!"".equals(split[i])) {
                //--套餐名称
                if (split[i].contains("4616511")) {
                    tempName.append(split[i].substring(7));
                }
                //流量使用情况
                if (split[i].contains("5312211")) {
                    tempName.append(split[i].replace("5312211", "已使用流量"));
                }
                if (split[i].contains("5312311")) {
                    tempName.append(split[i].replace("5312311", "剩余流量"));
                }
                if (split[i].contains("5312003")) {
                    tempName.append(split[i].replace("5312003", "已使用"));
                }
                //短信使用情况
                if ("4465900".equals(split[i])) {
                    tempName.append(split[i].replace("4465900", "条"));
                }
                if (split[i].contains("5312103")) {
                    tempName.append(split[i].replace("5312103", "剩余"));
                }
                //通话使用情况
                if ("4465800".equals(split[i])) {
                    tempName.append(split[i].replace("4465800", "分钟"));
                }

                tempVoice6 = tempName.toString();
            }

        }
        resutlVoice.append(tempVoice1).
                append(tempVoice2).
                append(tempVoice3).
                append(tempVoice4).
                append(tempVoice6);

    }*/


  /*  public static void main(String[] args) {
        String object = "0~success~0~460220309~50043060~1元~1元~1元~1元";
        String substring = object.substring(0, object.indexOf("460220309"));
        String substring1 = object.substring(object.indexOf("460220309"), object.lastIndexOf("元"));
        System.out.println(substring);
        System.out.println(substring1);
    }*/


    /*public static void main(String[] args) {

        String userMoblie = "13203971860";

        StringBuilder result = new StringBuilder();
        String[] split = userMoblie.split("");
        for (int i = 0; i < split.length; i++) {
            if ("1".equals(split[i])) {
                result.append("V0044.wav|AF,");
            }
            if ("2".equals(split[i])) {
                result.append("V0045.wav|AF,");
            }
            if ("3".equals(split[i])) {
                result.append("V0046.wav|AF,");
            }
            if ("4".equals(split[i])) {
                result.append("V0047.wav|AF,");
            }
            if ("5".equals(split[i])) {
                result.append("V0048.wav|AF,");
            }
            if ("6".equals(split[i])) {
                result.append("V0049.wav|AF,");
            }
            if ("7".equals(split[i])) {
                result.append("V0050.wav|AF,");
            }
            if ("8".equals(split[i])) {
                result.append("V0051.wav|AF,");
            }
            if ("9".equals(split[i])) {
                result.append("V0052.wav|AF,");
            }
            if ("0".equals(split[i])) {
                result.append("V0043.wav|AF,");
            }
        }

        System.out.println(result.toString().substring(0,result.toString().lastIndexOf("|AF,")));
        //result.toString().replace(result.lastIndexOf("|AF,"),"");
     *//*   String s = result.toString();
        s.substring(0, s.lastIndexOf("|AF,"));
        System.out.println(s.substring(0, s.lastIndexOf("|AF,")));*//*
    }*/


  /*  public static void main(String[] args) {
        String obejct = "0~success~66666~~~~~~~您网龄送10G流量包已使用流量0兆剩余流量9计1024元。~~~~~";


       *//* String substring1 = obejct.substring(obejct.indexOf("您"), obejct.lastIndexOf("元"));
        String[] split = obejct.split("-", -1);
        for (int i = 0; i <split.length ; i++) {
            System.out.println(split[i]);
        }*//*
        System.out.println(obejct.replace("~","")+"5555");

    }*/

/*
    public static String getInterface(String input) {

        JSONObject resultMap = new JSONObject();
        resultMap.put("name", "john");
        resultMap.put("age", "18");
        resultMap.put("sex", "man");
        resultMap.put("worker", "coder");
        conllectDate(resultMap);
        return resultMap.toString();
    }

    public static void conllectDate(JSONObject json) {
        System.out.println(json);
    }

    public static void main(String[] args) {
       // JSONObject json =new JSONObject();
        String input = "";
        getInterface(input);
    }*/


    /*  public static void main(String[] args) {
     *//* JSONObject param = new JSONObject();
        JSONObject object = new JSONObject();
        object.put("rtnCode", "0");
        object.put("rtnMsg", "success");
        param.put("param", object);*//*
//        String objecct ="{\"param\":{\"rtnCode\":\"0\",\"rtnMsg\":\"success\"}}";
//        System.out.println(objecct);
//        String replace = objecct.replace("\"", "\\\"");
//        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
//        String format1 = format.format(new Date());
//        int tt = (int) ((Math.random() * 9 + 1) * 10000);
//
//
//        System.out.println(format1+tt);

    }
*/

  /*  public static void main(String[] args) {

        LocalDate localDate = LocalDate.now(); //获取年月日
        LocalDate localDate1 = LocalDate.of(2019, 6, 4); //年月日转换
        LocalTime localTime = LocalTime.now(); //获取时间
        LocalTime localTime1 = LocalTime.of(23, 2, 2); //时间转换

        LocalDateTime localDateTime = LocalDateTime.now();//获取年月日时分秒
//        LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.JULY, 10, 12, 00, 00);//获取年月日时分秒
//        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);//获取年月日时分秒

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //加5分钟
        LocalDateTime localDateTime1 = localDateTime.plusMinutes(5);
        //加一个小时
        LocalDateTime localDateTime2 = localDateTime.plusHours(1);

        //加一天
        LocalDateTime localDateTime3 = localDateTime.plusDays(1);
        //加一月
        LocalDateTime localDateTime4 = localDateTime.plusMonths(1);
        //加一年
        LocalDateTime localDateTime5 = localDateTime.plusYears(1);

        LocalDateTime date = localDateTime.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));

        System.out.println(formatter.format(date));


    }
*/

 /*   public static void main(String[] args) {

        String sql = "DELETE  FROM  t_sce_targetcustomers WHERE id =data";
        for (int i = 19702; i <= 29601; i++) {
           String sql1 = sql.replace("data", i+";");
            System.out.println(sql1);
        }


    }
*/

  /*  public static void main(String[] args) {
        Map reslutMap = new HashMap();
        reslutMap.put("code", "-1");
        reslutMap.put("message", "fail");
        reslutMap.put("flag", "");
        String offerList = "A-B-C-D-E-F-G";
        String[] split = offerList.split("-");
        if (!StringUtils.isEmpty(split)) {
            reslutMap.put("flag", "1");
            for (int i = 0; i < split.length; i++) {
                if ("A".equals(split[i])) {
                    reslutMap.put("flag", "0");
                    break;
                }
            }
        }
        reslutMap.put("code", "0");
        reslutMap.put("message", "success");
        System.out.println(reslutMap);
    }*/


   /* public static void main(String[] args) {
        String send = MailUtil.send("729764703@qq.com", "测试邮件", "this is test mail,thank you", false);
        System.out.println(send);
    }*/

   /* public static void main(String[] args) {
        //当前时间
        DateTime date = DateUtil.date();
        //当前时间
        DateTime date2 = DateUtil.date(Calendar.getInstance());

        Date date3 = DateUtil.date(System.currentTimeMillis());
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        //当前日期字符串，格式：yyyy-MM-dd
        String today= DateUtil.today();
        System.out.println("date--->"+date);
        System.out.println("date2--->"+date2);
        System.out.println("date3--->"+date3);
        System.out.println("now--->"+now);
        System.out.println("today--->"+today);
    }*/

   /* public static void main(String[] args) {
        //定义图形验证码的长度和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        //图形验证码写出，可以洗出到文件，也可以写出到流
        lineCaptcha.write("d:/line.png");
        //输出code
        Console.log(lineCaptcha.getCode());
        //输入图形验证码的有效性，返回boolean值
        lineCaptcha.verify("1234");

        //重新生成验证码
        lineCaptcha.createCode();
        lineCaptcha.write("d:/line.png");
        lineCaptcha.verify("1234");

    }*/

  /*  public static void main(String[] args) {
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 45, 4, 4);
        // 自定义验证码内容为四则运算方式
        captcha.setGenerator(new MathGenerator());
        // 重新生成code
        captcha.createCode();
        Console.log(captcha.getCode());
    }*/

 /*   public static void main(String[] args) {
        String s = StrUtil.removeSuffix("123123.jpg", ".jpg");
        System.out.println(s);
    }

}*/

   /* public static void main(String[] args) {
        String template = "{}爱{}，就像老鼠爱{}";
        String str = StrUtil.format(template, "我", "你","大米"); //str -> 我爱你，就像老鼠爱大米
        System.out.println(str);
    }*/

/*
    public static void main(String[] args) {

        int[] ints = PageUtil.transToStartEnd(1, 10);

        int totalPage = PageUtil.totalPage(22, 10);//7
        int[] rainbow = PageUtil.rainbow(5, 20, 6);
        System.out.println(ints[0] + "--" + ints[1]);
        System.out.println(totalPage);
        for (int i : rainbow) {
            System.out.println(i);
        }
    }*/


  /*  public static void main(String[] args) {
        String className = ClassUtil.getClassName(StrUtil.class, true);

        System.out.println( TestEnum.Test1.getValue());
    }


    public enum TestEnum {
        Test1("A"), Test2("B"), Test3("C"), Test4("D");

        private TestEnum(String type) {
            this.type = type;
        }

        private String type;

        public String getValue() {
            return this.type;
        }

    }
*/


  /*  public static void main(String[] args) {
        // QrCodeUtil.generate("http://www.heyabin.cn/", 300, 300, FileUtil.file("D:/ewmCode.png"));
        QrCodeUtil.generate("http://www.heyabin.cn/",
                QrConfig.create().setImg("D:/logoE.png"),
                FileUtil.file("D:/ewmCode.png")
        );


    }*/

/*
    public static void main(String[] args) {
        String ID_18 = "410823199202070070";
      //  boolean s = IdcardUtil.isValidCard(ID_18);
        String birth = IdcardUtil.getBirth(ID_18);//获取生日
        int age = IdcardUtil.getAgeByIdCard(ID_18);//获取年龄
        int year = IdcardUtil.getYearByIdCard(ID_18);//获取生日年
        int month = IdcardUtil.getMonthByIdCard(ID_18);//获取生日月
        int day= IdcardUtil.getDayByIdCard(ID_18);//获取生日天
        int gender= IdcardUtil.getGenderByIdCard(ID_18);//获取性别
        String province= IdcardUtil.getProvinceByIdCard(ID_18);//获取省份




        System.out.println("生日："+birth);
        System.out.println("年龄："+age);
        System.out.println("生日年："+year);
        System.out.println("生日月："+month);
        System.out.println("生日天："+day);
        System.out.println("性别："+gender);
        System.out.println("省份："+province);

    }*/


   /* public static void main(String[] args) {
       // String uuid = IdUtil.randomUUID();
        //System.out.println(uuid);
        *//*String next = ObjectId.next();
        String objectId = IdUtil.objectId();
        System.out.println(next);
        System.out.println(objectId);*//*
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        long id = snowflake.nextId();
        DateTime parse = DateUtil.parse(String.valueOf(id));

        System.out.println(parse);


    }*/

   /* public static void main(String[] args) {
        String s = "Base64编码解码";
        String encode = Base64.encode(s);
        System.out.println(encode);
        String decodeStr = Base64.decodeStr(encode);
        System.out.println(decodeStr);
    }*/


    /*public static void main(String[] args) {
        CsvReader reader = CsvUtil.getReader();
        //从文件读取CSV数据
        CsvData data = reader.read(FileUtil.file("D:/test.csv"));
        List<CsvRow> rows = data.getRows();
        rows.forEach(str ->
                {
                    String s = str.get(1);
                    System.out.println(s);
                }
        );
    }*/

    /*public static void main(String[] args) {
        String str = "abc,efg,ssa , sda ";
        List<String> split = StrSpliter.split(str, ",", 0, true, true);
        for (int i = 0; i < split.size(); i++) {
            System.out.println(split.get(i));
        }

    }*/

    /*public static void main(String[] args) {
        Img.from(FileUtil.file("D:/ewmCode.png"))
                .cut(0, 0, 200)
                .write(FileUtil.file("D:/ewmCode.jpg"));

    }*/

    /*public static void main(String[] args) {
        Img.from(FileUtil.file("D:/ewmCode.png"))
                .setQuality(0.5)
                .write(FileUtil.file("D:/ewmCode.jpg"));

    }*/

/*
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Map<String, Object> param = new HashMap<>();
        map.put("name","json");
        map.put("age","10");
        map.put("work","coder");
        param.put("param", param);

        JSONObject json = JSONUtil.parseObj(param);
        System.out.println(json);


    }*/

/*
    public static void main(String[] args) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("city", "北京");
        String result = HttpUtil.post("https://www.baidu.com",map);

        System.out.println(result);
    }*/

/*
    public static void main(String[] args) {
        HttpResponse execute = HttpRequest.post("www.heyabin.cn").execute();
//        System.out.println(execute.getStatus());
        execute.header(Header.CONTENT_ENCODING);
        String header = execute.header("Content-Disposition");
        System.out.println(header);
    }
*/

    /*public static void main(String[] args) {
        runCron();

    }*/

    /*@Scheduled(cron = "* * * * * ? *")
    private static void runCron(){
        System.out.println("=======I'm cron task=======");
    }*/
   /* public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));
    }
*/
  /*  private static List<Integer> addItems;
    private static Stream<Integer> stream;
    private static Stream<Integer> parallelStream;

    static {
        addItems = new ArrayList<>(100);
        for (int i = 0; i <10 ; i++) {
            addItems.add(i);
        }
        stream = addItems.stream();
        parallelStream = addItems.parallelStream();
    }

    public static void main(String[] args) {

        streamDisplay();
    }

    public static void parallelStreamDisplay() {
        parallelStream.forEach(item -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(item);
        });

        System.out.println("parallel stream display end ------");
    }
    public static void streamDisplay() {

        addItems.forEach(System.out::println);

        System.out.println("stream display end ------");
    }*/















}

