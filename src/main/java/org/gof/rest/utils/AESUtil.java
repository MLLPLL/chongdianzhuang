package org.gof.rest.utils;



import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/*******************************************************************************
 * AES加解密算法
 * 2016.07.22
 * @author  王学明 
 * aes 128位 cbc 算法
 * HTML的&lt; &gt;&amp;&quot;&copy;&nbsp;分别是<，>，&，"，©;空格的转义字符
 */

public class AESUtil {

    // 加密
    public static String Encrypt(String sSrc, String sKey) throws Exception {


        return  Encrypt(sSrc,sKey,"1234567890abcdef");
    }
    
 // 加密
    public static String Encrypt(String sSrc, String sKey,String ivStr) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
        IvParameterSpec iv = new IvParameterSpec(ivStr.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度1234567890123456 
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
       // sSrc= escapeChar(sSrc);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
        
        String str=new BASE64Encoder().encode(encrypted);
        str=str.replaceAll("\r\n", "");
        

        return str;//new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {
    	return Decrypt(sSrc,sKey,"1234567890abcdef");
    }
    
    // 解密
    public static String Decrypt(String sSrc, String sKey,String ivStr) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivStr.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
               // originalString= unEscapeChar(originalString);
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    
  
    /*
     * escapeChar 字符转换 
     * 加密前分别把<，>，&，"，© 的转义字符 转换成 &lt; &gt;&amp;&quot;&copy;
     * 
     
    private static String  escapeChar(String beforeEncryptString ){
    	String escapeStr=beforeEncryptString;
    	escapeStr=escapeStr.replaceAll("<", "&lt;");
    	escapeStr=escapeStr.replaceAll(">", "&gt;");
    	escapeStr=escapeStr.replaceAll("&", "&amp;");
    	escapeStr=escapeStr.replaceAll("\"", "&quot;");
    	escapeStr=escapeStr.replaceAll("©", "&copy;");
    	escapeStr=escapeStr.replaceAll(" ", "&nbsp;");
    	
		return escapeStr;
    	
    }
    * */
    /*
     * unEscapeChar 反向字符转换 
     * 解密后分别把&lt; &gt;&amp;&quot;&copy; 的转义字符 转换成  <，>，&，"，©
     *  
    
    private static String  unEscapeChar(String beforeDecryptString ){
    	String unEscapeStr=beforeDecryptString;
    	unEscapeStr=unEscapeStr.replaceAll( "&lt;","<");
    	unEscapeStr=unEscapeStr.replaceAll( "&gt;",">");
    	unEscapeStr=unEscapeStr.replaceAll( "&amp;","&");
    	unEscapeStr=unEscapeStr.replaceAll( "&quot;","\"");
    	unEscapeStr=unEscapeStr.replaceAll( "&copy;","©");
    	unEscapeStr=unEscapeStr.replaceAll( "&nbsp;"," ");
    	
		return unEscapeStr;
    	
    }
 * */
    public static void main(String[] args) throws Exception {
        /*
         * 加密用的Key 可以用26个字母和数字组成，最好不要用保留字符，虽然不会错，至于怎么裁决，个人看情况而定
         * 此处使用AES-128-CBC加密模式，key需要为16位。
         */
        String cKey = "1234567890abcdef";
        // 需要加密的字串
        String cSrc = "1234567890'[]:";
        cSrc="{\"LastQueryTime\":\"\",\"PageNo\":\"1\",\"PageSize\":\"1\"}";
//        cSrc="{\"total\":1,\"stationStatusInfo\":{\"operationID\":\"123456789\",\"stationID\":\"111111111111111\",\"connectorStatusInfos\":{\"connectorID\":1,\"equipmentID\":\"10000000000000000000001\",\"status\":4,\"currentA\":0,\"currentB\":0,\"currentC\":0,\"voltageA\":0,\"voltageB\":0,\"voltageC\":0,\"soc\":10,}}}";
        System.out.println(cSrc);
        // 加密
        long lStart = System.currentTimeMillis();
        String enString = AESUtil.Encrypt(cSrc, cKey);
        System.out.println("加密后的字串是：" + enString);

        long lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("加密耗时：" + lUseTime + "毫秒");
        // 解密
        lStart = System.currentTimeMillis();
        //AESUtil.Decrypt("DHVWF+8xRIfU7nUCNQdLaGF15VaMZWtNcwaqeumUPe/ok9zgSkR0pbOJUmYYQs7ZFMN7GhLB1ywEN3kb1gH4z+Mc2Z4rQe8Xa42LrmkDRvwwosmVMuR+mbLFCG+Xf5unkRO6JJx1PiTAxAB6oyWqUmbOKskK81LqpWBU5fKnBZwXo3jv2hnKItwCODYw+B+Pg+0IzZ5ye5cKcwz99NO5//H2gU0scZhn+rl8Jcktbm42TVklnxdzG/aw200H2z9ugpB1q2X0sGAi55SQH3DbLpWb5oQE5vy0As7lje4e+4dE8vbLIR0dMw8/lA9cBPYRO2WOkH6SFwFUyi+IishP8j+mzEcfoyAOIUSh5G/5VYqlYu1zlVUsYCHWu7MTE1Gr55SicHZQxl5KHgmgFBw8OQl8DerA++D8vswR8eiRNcXR2MQmNXYarCmZ7Kuc6mRSbrSk2cImOZAywVIo6MpBSu/u0BINysS3S7Ni1LB6zqAu3Ly0yNbbxzz+ZpHjmAM+MMsx4/K6LtG1rhiW8iE3bbGOLJqu9njLFVLQtKXrVsUnF4b1FWuIADG3FBCXqcdyTTTj5vNwI2xxFm/zq5lvJUKUlcFPvYSwBQFsjKHZnl8=", cKey);
        String DeString = AESUtil.Decrypt("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", cKey);
        System.out.println("解密后的字串是：" + DeString);
        lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("解密耗时：" + lUseTime + "毫秒");
    }
}