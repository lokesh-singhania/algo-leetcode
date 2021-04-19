package algo.april.impl.is;

import algo.april.IsomorphicStrings;
//Caveat: Won't work for all characters
public class Array implements IsomorphicStrings {

    public static void main(String[] args) {
        new Array().isIsomorphic("foo","bar");
    }

    @Override
    public boolean isIsomorphic(String a, String b) {
        CharMapping mapping=new CharMappingImpl();
        boolean[] encountered=new boolean[256];
        for (int i = 0; i < a.length(); i++) {
            char ca=a.charAt(i);
            char cb=b.charAt(i);
            if(mapping.has(ca)){
                if(mapping.get(ca)!=cb){
                    return false;
                }
            }else{
                if(encountered[cb]){
                    return false;
                }
                encountered[cb]=true;
                mapping.add(ca,cb);
            }
        }
        return true;
    }



    static interface CharMapping {
        void add(char a, char b);
        boolean has(char a);
        char get(char a);
    }

    static class CharMappingImpl implements CharMapping{

        private final int[] mapping;

        public CharMappingImpl() {
            mapping =new int[256];
        }

        @Override
        public void add(char a, char b) {
            mapping[toInt(a)]=toInt(b);
        }

        @Override
        public boolean has(char a) {
            return mapping[toInt(a)]!=0;
        }

        @Override
        public char get(char a) {
            return toChar(mapping[toInt(a)]);
        }

        private int toInt(char c){
            return c;
        }

        private char toChar(int i){
            return (char)(i);
        }

    }
}