import java.util.ArrayList;
import java.util.List;

/**
 * User: Caroline.Han
 * Date: 2016-12-29
 * Time: 下午4:49
 */
public class sorting  {
    public static String sortingCustom(String customIds, String customId) throws Exception{
        StringBuilder resultCustomId = new StringBuilder();
        String result = "";
        String[] s = customIds.split(",");
        List<Integer> indexs = new ArrayList<Integer>();
        //取出原始id到ids中
        for (int i = 0; i < s.length; i++) {
            indexs.add(Integer.parseInt(s[i].substring(0, s[i].indexOf("_"))));
        }
        int position = customId.indexOf("_");
        // customId _ 前面的数字
        int newIndex = Integer.parseInt(customId.substring(0,position));
        // 最大index的字符串里的index值
        int csMaxIndex = indexs.get(indexs.size()-1);

        if (newIndex < 0 || indexs.contains(newIndex)) {
            //第一种情况
            if (indexs.get(0) > 0) {
                resultCustomId.append("0").append(customId.substring(position)).append(",").append(customIds);
                return resultCustomId.toString();
            }
            int tempIndex = -1;
            for (int i = 0; i < indexs.size() - 1;i++){
                if ((indexs.get(i) + 1) < indexs.get(i + 1)) {
                    tempIndex = i;
                    break;
                }
            }
            //没找到空隙,放到最后
            if (tempIndex == -1) {
                resultCustomId.append(customIds).append(",").append(csMaxIndex + 1).append(customId.substring(position));
            }else {
                int insertIndex = indexs.get(tempIndex) + 1;
                for (int i = 0; i < indexs.size(); ++i) {
                    resultCustomId.append(s[i]).append(",");
                    if (i == tempIndex) {
                        resultCustomId.append(newIndex).append(customId.substring(position)).append(",");
                    }
                }
                //去除最后一位的逗号
                result = resultCustomId.substring(0, resultCustomId.length() - 1);
            }
        }else if (newIndex > csMaxIndex) {
            //第二种情况
            resultCustomId.append(customIds).append(",").append(customId);
        }else if (newIndex >= 0 && newIndex <= csMaxIndex && !indexs.contains(newIndex)){
            //第三种情况
            //找到空隙,插入空隙中
            int tempIndex = -1;
            for (int i = 0; i < indexs.size() - 1; ++i){
                if (indexs.get(i) < newIndex && indexs.get(i + 1) > newIndex) {
                    tempIndex = i;
                    break;
                }
            }
            if (tempIndex == -1) {
                if (newIndex < indexs.get(0)) {
                    resultCustomId.append(customId).append(",").append(customIds);
                }else if (newIndex > indexs.get(indexs.size()) - 1) {
                    resultCustomId.append(customIds).append(",").append(customId);
                }else {
                    //抛异常
                    throw new Exception("未知错误");
                }
            }else {
                for (int i = 0; i < indexs.size(); ++i) {
                    resultCustomId.append(s[i]).append(",");
                    if (i == tempIndex) {
                        resultCustomId.append(customId).append(",");
                    }
                }
                //去除最后一位的逗号
                result = resultCustomId.substring(0, resultCustomId.length()-1);
            }
        }

        if ("".equals(result)){
            result = resultCustomId.toString();
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        String s = sortingCustom("4_1111,5_1100000032235,13_1100000000279", "6_1100000083223333");
        System.out.println(s);
    }
}
