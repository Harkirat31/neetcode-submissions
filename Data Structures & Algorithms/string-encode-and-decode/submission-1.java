class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            int length = s.length();
            sb.append(length);
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    // 7#qwertyu2#we
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int pointer = 0 ;
        while(pointer < str.length()){
            int index = str.indexOf("#",pointer);
            int l = Integer.parseInt(str.substring(pointer,index));
            res.add(str.substring(index+1,index+1+l));
            pointer = index+1+l;
        }
        return res;

    }
}
