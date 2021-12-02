package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode
 * Date： 2021/12/2 4:41 下午
 * User： cris
 * Description： https://leetcode-cn.com/problems/find-duplicate-file-in-system/
 **/
public class 在系统中查找重复文件_609 {
    public static List<List<String>> findDuplicate(String[] paths) {
        if(paths == null) return new ArrayList<List<String>>();
        List list = new ArrayList();
        for(String path : paths){
            String[] s = path.split(" ");
            for (int i = 1; i < s.length; i++) {
                String file = s[0];
                file += "/" + s[i];
                list.add(file);
            }
        }
        List<List<String>> res = new ArrayList<>();
        Map map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).toString();
            int index = s.indexOf("(");
            String substring = s.substring(index+1,s.length()-1);
            if(!map.containsKey(substring)){
                map.put(substring,String.valueOf(i));
            }else{
                map.replace(substring,map.get(substring) + "," + String.valueOf(i));
            }
        }
        for (Object key : map.keySet()){
            List list1 = new ArrayList();
            String[] split = map.get(key).toString().split(",");
            if(split.length <2){
                continue;
            }
            for (int i = 0; i < split.length; i++) {
                String s = list.get(Integer.valueOf(split[i])).toString();
                String substring = s.substring(0, s.indexOf("("));
                list1.add(substring);
            }
            res.add(list1);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] path = new String[]{"root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"};
        List<List<String>> duplicate = findDuplicate(path);
        System.out.println(duplicate);
    }
}
