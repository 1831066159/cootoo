package com.webull.service;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


/**
 * @Author: Zhaoxiang
 * @Date: 2021/4/17
 */
public class IdCardService {

    /**
     * 生成身份证信息
     *
     * @param cardNo
     * @return 返回身份证信息
     * @throws UnsupportedEncodingException
     */
    public static String getIdCardDetail(String cardNo) throws UnsupportedEncodingException {
        // 获取身份证信息
        IdCard idcard = getIdCardInfo(cardNo);

        // 存储文本信息
        StringBuffer news = new StringBuffer();

        if (idcard != null) {
            news.append("所属地区:" + idcard.getAtt()).append("\n");
            news.append("出生日期:" + idcard.getBorn()).append("\n");
            news.append("性别:" + idcard.getSex()).append("\n");
        }

        if (news.length() == 0) {
            news.append("身份证号码").append(cardNo).append("不存在,请重新输入!");
        }

        return news.toString();
    }

    public static String getAtt(String cardNo) {
        // 获取身份证信息
        IdCard idcard = getIdCardInfo(cardNo);
        return idcard.getAtt();
    }

    /**
     * 获取身份证信息
     *
     * @param cardNo
     * @return 返回身份证信息
     */
    public static IdCard getIdCardInfo(String cardNo) {
        URL url = null;
        IdCard idCard = new IdCard();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            url = new URL("http://api.k780.com:88/?app=idcard.get&idcard=" + cardNo + "&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=xml");
//            System.out.println(url);
            Document doc = builder.parse(url.openStream());
            NodeList node = doc.getElementsByTagName("result");
            for (int i = 0; i < node.getLength(); i++) {
                String idcard = "";
                String born = "";
                String sex = "";
                String att = "";
                if (doc.getElementsByTagName("idcard").item(i).getFirstChild() != null) {
                    idcard = doc.getElementsByTagName("idcard").item(i).getFirstChild().getNodeValue();
                }
                if (doc.getElementsByTagName("born").item(i).getFirstChild() != null) {
                    born = doc.getElementsByTagName("born").item(i).getFirstChild().getNodeValue();
                }
                if (doc.getElementsByTagName("sex").item(i).getFirstChild() != null) {
                    sex = doc.getElementsByTagName("sex").item(i).getFirstChild().getNodeValue();
                }
                if (doc.getElementsByTagName("att").item(i).getFirstChild() != null) {
                    att = doc.getElementsByTagName("att").item(i).getFirstChild().getNodeValue();
                }
                idCard.setIdCard(idcard);
                idCard.setBorn(born);
                idCard.setSex(sex);
                idCard.setAtt(att);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return idCard;
    }


    // 获取详细地址： https://www.youbianku.com/
    public static String getAddrDetail(String param) {
        String key = param.replaceAll(" ", "");
        String uri = "https://www.youbianku.com/api.php?action=opensearch&format=json&formatversion=2&namespace=0&limit=10&suggest=true&search=" + key;
        String result1 = HttpRequest.get(uri)
                .header("Host", "www.youbianku.com")
                .header("Accept", "application/json, text/javascript, */*; q=0.01")
                .header("X-Requested-With", "XMLHttpRequest")
                .header("sec-ch-ua-mobile", "?0")
                .header("Sec-Fetch-Site", "same-origin")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Dest", "empty")
                .header("Referer", "https://www.youbianku.com/")
                .header("Cookie", "_ga=GA1.2.885284543.1618641589; __gads=ID=2897ab95e8a61782-228c010d70c70064:T=1618641588:RT=1618641588:S=ALNI_MZSkrzuaBwmva1ScfJqgDnHFC9eXg; _gid=GA1.2.981927469.1618796913; Hm_lvt_855d4c8eddca4a78f37ebe6b005dbd95=1618641588,1618796913,1618796927; Hm_lpvt_855d4c8eddca4a78f37ebe6b005dbd95=1618796927")
                .timeout(20000)
                .execute().body();
        System.out.println(result1);
        return getAddDetail(result1);
    }

    public static String getAddDetail(String result) {
        JSONArray jsonArray = JSON.parseArray(result);
        if (jsonArray.size() > 1) {
            String[] adds = jsonArray.get(1).toString().split(",");
            int n = 0;
            int max = 0;
            for (int i = 0; i < adds.length; i++) {
                if (max < adds[i].length()) {
                    max = adds[i].length();
                    n = i;
                }
            }
            String res = filtration(adds[n]);
//            System.out.println(res);
            return res;
        }
        return null;
    }

    public static final String regEx = "[`~!@#$%^&*()+=|{}:;\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？']";
    public static Pattern pattern = Pattern.compile(regEx);

    public static String filtration(String str) {
        str = pattern.matcher(str).replaceAll("").trim();
        return str;
    }


    public static void main(String[] args) {
        try {
            List<String> list = Arrays.asList(
                    "赵祥,15010319820214201X",
                    "赵翔,310110198109241017",
                    "赵翔,420106197310144012"
//                    "赵翔,61052519800909001X",
//                    "赵翔,310113198401154833",
//                    "赵翔,321321198403256810",
//                    "赵祥,152824198610096616",
//                    "赵翔,110103197407201210",
//                    "赵翔,420111198002094194",
//                    "赵翔,360103198807214118",
//                    "张磊,330621198207316334",
//                    "张磊,130323197806044232",
//                    "张雷,310110197010206815",
//                    "张磊,310110198408213796",
//                    "张磊,320681198308014639",
//                    "张磊,310225198603075413",
//                    "张磊,320902198302263037",
//                    "张磊,210105198405134633",
//                    "张磊,310101198007031215",
//                    "张磊,130303198005090326",
//                    "魏玉龙,362532197310090915",
//                    "魏玉龙,410423198812171032",
//                    "魏玉龙,320830198702031438",
//                    "魏玉龙,370784198309015514",
//                    "魏雨龙,370502198907161612",
//                    "魏玉龙,320114196402152118",
//                    "魏玉龙,152827195807060014",
//                    "魏玉龙,370103197403255551",
//                    "赵嫄,320102198007312429",
//                    "赵媛,330105198212151047",
//                    "赵原,370685198410075811",
//                    "赵元,610326198411062231",
//                    "赵源,321182198801170010",
//                    "赵媛,320103198212131762",
//                    "赵远,44010219840313262X",
//                    "赵媛,612301197403010925",
//                    "赵源,110106197704064813"
            );

            for (String idd : list) {
                String[] d = idd.split(",");
                IdCard idCard = getIdCardInfo(d[1]);
                String detail = getAddrDetail(idCard.getAtt());
                System.out.println(d[0] + " " + d[1] + " " + idCard.getAtt() + " " + detail);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
