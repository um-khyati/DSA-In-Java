class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] par = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=0;i<n;i++){
            rank[i]=1;
            par[i]=i;
        }

        for(int[] e :edges){
            int x=findpar(e[0],par);
            int y=findpar(e[1],par);

            if(x!=y){
                union(x,y,par,rank);
            }
        }

        if(findpar(source,par)==findpar(destination,par)){
            return true;
        }
        return false;
    }

    public int findpar(int x ,int[] par){
        if(x==par[x]){
            return x;
        }

        return par[x]=findpar(par[x],par);
    }

    public void union(int x,int y,int[] par,int[] rank){
        if(rank[x]<rank[y]){
            par[x]=y;
        }
        else if(rank[x]>rank[y]){
            par[y]=x;
        }else{
            par[x]=y;
            rank[y]++;
        }
    }
}