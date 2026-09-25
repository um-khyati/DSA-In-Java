class Solution {
    int i;
    public List<String> braceExpansionII(String ex) {
        List<String> ans= solve(ex);
        List<String> ret=new ArrayList<>();
        Set<String> aa=new HashSet<>();
        for(String kk:ans)
        {
            if(!aa.contains(kk))
            {
                ret.add(kk);
                aa.add(kk);
            }
        }
        Collections.sort(ret);
        return ret;
    }
    List<String> solve(String ex)
    {
        int n=ex.length();
        List<String> sex=new ArrayList<>();
        StringBuffer cur=new StringBuffer(); 
        while(i<n)
        {
            if(ex.charAt(i)=='}')
            {
                if(cur.length()>0)
                {
                    if(sex.size()==0)
                    {
                        sex.add(cur.toString());
                    }
                    else
                    {
                         String pre=cur.toString();
                         List<String> nsex=new ArrayList<>();
                         for(String exx:sex)
                         {
                            nsex.add(exx+pre);   
                         }
                         sex=nsex;
                    }
                    cur=new StringBuffer();
                } 
                return sex;
            }
            else if(ex.charAt(i)>='a' && ex.charAt(i)<='z')
            {  
                cur.append(ex.charAt(i));
            }
            else if(ex.charAt(i)==',')
            {
                i++;
                List<String> nee=solve(ex);
                if(cur.length()>0)
                {
                    if(sex.size()==0)
                    {
                        sex.add(cur.toString());
                    }
                    else
                    {
                         String pre=cur.toString();
                         List<String> nsex=new ArrayList<>();
                         for(String exx:sex)
                         {
                            nsex.add(exx+pre);   
                         }
                         sex=nsex;
                    }
                    cur=new StringBuffer();
                }
                for(String ne:nee)
                {
                    sex.add(ne);
                }
                if(ex.charAt(i)=='}')
                {
                    return sex;
                }
            }
            else 
            {
                i++;
                List<String> nee=solve(ex);
                 if(cur.length()>0)
                {
                    if(sex.size()==0)
                    {
                        sex.add(cur.toString());
                    }
                    else
                    {
                         String pre=cur.toString();
                         List<String> nsex=new ArrayList<>();
                         for(String exx:sex)
                         {
                            nsex.add(exx+pre);   
                         }
                         sex=nsex;
                    }
                    cur=new StringBuffer();
                }
                if(sex.size()==0)
                {
                    sex=nee;
                }
                else
                { 
                    List<String> nsex=new ArrayList<>();
                    for(String se:sex)
                    {
                        for(String ne:nee)
                        {
                            nsex.add(se+ne);
                        }
                    }
                    sex=nsex;
                }
            }
            i++;
        }
        if(cur.length()>0)
                {
                    if(sex.size()==0)
                    {
                        sex.add(cur.toString());
                    }
                    else
                    {
                         String pre=cur.toString();
                         List<String> nsex=new ArrayList<>();
                         for(String exx:sex)
                         {
                            nsex.add(exx+pre);   
                         }
                         sex=nsex;
                    }
                    cur=new StringBuffer();
                }
        return sex;
    }
}