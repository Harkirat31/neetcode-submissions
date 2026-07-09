class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int pointer = 0;
        List<String> res = new ArrayList<>();
        while(pointer<str.length()){
           int index =  str.indexOf('#',pointer);
           int length = Integer.parseInt(str.substring(pointer,index));
           res.add(str.substring(index+1,index+1+length));
           pointer = index+1+length;
        }
        return res;
    }
}
