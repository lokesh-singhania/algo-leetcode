package algo.random.open.lock;

public class OpenLockBacktrack implements OpenLock{
    @Override
    public int openLock(String[] deadends, String target) {
        return new Backtrack(Integer.parseInt(target),deadends).compute();
    }

    class Backtrack{
        int steps;
        int target;
        boolean[] visited;

        Backtrack(int target,String[] deadends){
            steps = -1;
            this.target = target;
            visited = new boolean[10000];
            for(var d:deadends){
                visited[Integer.parseInt(d)]=true;
            }
        }

        int compute(){
            backtrack(0,0);
            return steps;
        }

        void backtrack(int num, int depth){
            if(visited[num] || (steps>-1 && steps<depth)){
                return;
            }
            visited[num] = true;
            if(num==target){
                steps = steps==-1?depth:Math.min(steps, depth);
                return;
            }
            for(int i=0,place = 1;i<4;i++,place*=10){
                // digit
                int digit = (num/place)%10;
                //up
                int change = digit==9 ? -9 : 1;
                backtrack(num + change*place,depth+1);
                // going down
                change = digit==0 ? 9 : -1;
                backtrack(num+change*place,depth+1);
            }
            visited[num] = false;
        }
    }
}
