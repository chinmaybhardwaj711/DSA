class Solution {
    public String simplifyPath(String path) {
        String []parts = path.split("/");
        Stack<String> s = new Stack<>();

        for(int i=0;i<parts.length;i++){
            String part = parts[i];
            if(part.equals("") || part.equals(".")){
                continue;
            }else if(part.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }else{
                s.push(part);
            }
        }

        String result = "";
        for(String dir : s){
            result += "/" +dir;
        }

        return result.isEmpty()? "/":result;
    }
}