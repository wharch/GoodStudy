package com.goodstudy.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102500758612";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCpdKKixYk9gHQvMPGqg7xLW0WxxnWNYL50GF6J4FkhDNFN3U34epDtWFJxKXgum6dtPZFWhHedKqiceRrTRFc9FRxgRMH3TQ3ebrM4WLnT8hi5pgMtp2UmUvu32YNJZgntdH1J6MDT3D8SY7ZklK2a61/60VWOsuoRLS1WrJQr4Z1b58RM1ZaNIHILzN7Mtn+ezCFNMwDnpCrkskxexVkvqQXTsYvaIqG7na/6GsKUZzX6ls75hM8TxBzAEW6iOBxTiSP5Hez6YaZfMmqdtwdvWzfk0xc6B031LBaStE1MeRKgBw+oN8/JRkQyvkTdHHgshyzQKWi7QFK9fHjEly2pAgMBAAECggEACNR6EQ9ICntiEn9zaFY6/pY/+HaF85sB8Zy/eGHHYzB+y5bnlDYWzTdX/GuTxqH3xHp7001NylPJu3WYD0A1Z4ptExsiHFfYjCmqjxoYfNHVtf7PlZZub+PNGBRugemeRNBYIvzM531HkBbAD1esADGZq8Eyux/ZkJGRFj4h7nNaTmVRjOx9vbSRBM1EigVgpm3JFfAuWr1bZPmwtLPEHLhLXQvPSQcs9B0VblQUPNX+AUnRyeZwVN26UKChkCmdwjbi5oCykDhO5uvhJpmY5wL13SYGWVEqzzMnUBYrSGcNYV/Ir/xC8MdaTV99dAYgFec18MSfjRxlBs9VdJngMQKBgQDupaE9ToXQC6Z4G39rloQKhxuIo7JTKwD1n+fvofT99NUg7D66t8q2uRlgH8JmNUuPw5WB+kF/vGIX6dhtQQ/YDPHcL/g/7KQwfgYuxR8yn/9Fv9HlVjYIp89uKV6bdxlBwbzBIvyXyUsg7BuGvAuUUlYwkx6buBitjkgFuae29QKBgQC1xwU8/IJmnOPYZwXozsD8ynHja9zcmE1KO8nchU4729GQZRL9JlteIcYWxl3dnWKmyyVaNjGtGQJG7YpTjgwC65yrTtZI6KSQP94xA/DZoxDqtwqtjcu2xO5sWQgUcUXlE5Ow9vRiRrl2uxHGyVDAKuebnLpqh8TofHcSa3ajZQKBgHFuDFuFbRjb0L4Z49CRdCVE3pNtqx7Yu9YDsUw3IKlsq7jAUXiSTynWhPcpYU8PWeD1R6TF/EfolH9lSNd1K0C3tmW/7zEDG29pFys3yoJXhg/zAqMM/RXUHUXxJ+ShEUIuAbeTF5hVtv3o+5Ro4OAY2pqv8sZ1FFW54QXHnq3ZAoGBALO0m5MdN3VmaUIJJ6hurg+7vDfO7LwQvWhED145U4yN1nHf2pP2FaHL1d+yIB31eA/ZCYZTyWyNKtkgAP51kZ5Ze7tH50SQ6g/JdEoU0Uj3ksPYTXAinGCF9AedRQWgri632ey7WALIVJXyfrJ9V52DTRFkMk8bBimo0radEt6ZAoGAE8pArFJT+YcZoQpxpViwTBs4uAgw7MxmcFekE5ULn+vAFDLlR7AKZFMREnX6KKdQVRitDQZzYwPiv4KNBsykjnTsLoAK7k4Tfa4ximRTCaZ2pxTMieR8NEwdu3LugHApjN0VS74p7lTGchM+J0TOkufWjwaLzz5/mzWZNGPlzjI=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhq9KNn+YMpU9J0X4V68RjCoMco2sdR+mUNN3cbc6Kmotmb7ozVbFNjDCXAiNdm6G4r5c7CdSzYGiMD5cNNwPS8HlvCnq6KfnbYPVgSBLTq/xxpV22KOD5CBY6cIcK6FFO6/YdM1AaWlMgQJ8wxcHdreMA5tb1XghgA0HStqxQnVrCQHmSHEfR2hYH5cImUvY3NbAyPbNKUQMdArw8oTxKePaDGmqTCTqGtlDblrOlgSvVkasyNvUEpK1kP7SCBLEayZMU/mb/Y3nWPEr2i0bB0HW9XmbC4a1kEjFExnRpWw/2eVo8Q1ur/Ns0N8sy/vtD5fBMIooV1LIJHPVECrMcQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "http://localhost:8080/goodStudy/front/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/GoodStudy/order";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "https://openapi.alipaydev.com/gateway.do";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}