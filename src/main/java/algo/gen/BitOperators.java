package algo.gen;

public class BitOperators implements Complement {

	@Override
	public int bitwiseComplement(int n) {
		int complement = 0;
		for (int i = 0; n > 0; n /= 2, i++) {
			int bit = (n % 2) ^ 1;
			if (bit == 1) {
				complement += (1 << i);
			}
		}
		return complement;
	}

}
