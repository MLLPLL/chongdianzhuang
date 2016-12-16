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

        System.out.println(cSrc);
        // 加密
        long lStart = System.currentTimeMillis();
        String enString = AESUtil.Encrypt(cSrc, cKey);
        System.out.println("加密后的字串是：" + enString);

        long lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("加密耗时：" + lUseTime + "毫秒");
        // 解密
        lStart = System.currentTimeMillis();
        //AESUtil.Decrypt("DHVWF+8xRIfU7nUCNQdLaGF15VaMZWtNcwaqeumUPe
//        System.out.println("解密后的字串是：" + DeString);
        lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("解密耗时：" + lUseTime + "毫秒");
    }
}