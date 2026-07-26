class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int n = s.length();

        //count xeroes 
        int z =0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '0'){
                z++;
            }
        }

        //count position 
        List<Integer> p = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '0'){
                p.add(i);
            }
        }

       boolean[] ans  = new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            char t[] = strs[i].toCharArray();

            int questions =0;
            int currzeroes = 0;

            for(char c : t){
                if(c== '?'){
                    questions++;
                }else if(c== '0'){
                    currzeroes++;
                }

            }


            //impossible case 
            if(currzeroes > z || questions+currzeroes <z){
                ans[i] = false;
                continue;
            }


            int need = z-currzeroes;

            for(int j =0;j<n;j++){
                if(t[j] == '?'){
                    if(need > 0){
                        t[j] = '0';
                        need--;
                    }else{
                        t[j] = '1';
                    }
                }
            }

            List<Integer> q = new ArrayList<>();
            //collect zeroes 
            for(int j=0;j<n;j++){
                if(t[j] == '0'){
                    q.add(j);
                }
            }

            boolean ok = true;

            for(int k=0;k<z;k++){
                if(p.get(k) < q.get(k)){
                    ok = false;
                    break;
                }
            }
            ans[i] = ok;




        }
        return ans;

    }
}