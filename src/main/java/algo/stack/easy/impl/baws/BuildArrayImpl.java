package algo.stack.easy.impl.baws;

import static algo.util.GeneralUtil.isEmpty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import algo.stack.easy.BuildArrayWithStack;
import algo.util.GeneralUtil;

public class BuildArrayImpl implements BuildArrayWithStack{

	@Override
	public List<String> buildArray(int[] target, int n) {
		if(isEmpty(target)) 
			return Collections.emptyList();
		
		int i=0;
		List<String> output=new ArrayList<>();
		for(int t:target) {
			output.add(PUSH);
			i++;
			for(;i<t;i++) {
				output.add(POP);
				output.add(PUSH);
			}
		}
		return output;
	}

}
