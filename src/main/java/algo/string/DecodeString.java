package algo.string;

public class DecodeString {
        public String decodeString(String s) {
            return new Decoder(s).decode();
        }

        static class Decoder{
            String s;
            int n;
            int i;

            Decoder(String s){
                this.s = s;
                n = s.length();
                i = 0;
            }

            String decode(){
                StringBuilder sb = new StringBuilder();

                while(i<n && s.charAt(i)!=']'){
                    while(i<n && Character.isLetter(s.charAt(i))){
                        sb.append(s.charAt(i));
                        i++;
                    }
                    if(i>=n){
                        break;
                    }
                    var freq = getDigit();
                    i++;
                    var encoded = getEncoded();
                    sb.repeat(encoded,freq);
                }
                return sb.toString();
            }

            int getDigit(){
                int start = i;
                while(i<n && Character.isDigit(s.charAt(i))){
                    i++;
                }

                return Integer.parseInt(s.substring(start,i));
            }

            String getEncoded(){// right of brace
                StringBuilder sb = new StringBuilder();
                while(i<n && s.charAt(i)!=']'){
                    char c = s.charAt(i);
                    if(Character.isDigit(c)){
                        sb.append(decode());
                    }else if(Character.isLetter(c)){
                        sb.append(c);
                        i++;
                    }
                }
                i++;
                return sb.toString();
            }
        }
}
